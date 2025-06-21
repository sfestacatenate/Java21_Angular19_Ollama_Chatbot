import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { TranslateModule, TranslateService } from '@ngx-translate/core';

interface Message {
  role: 'user' | 'assistant';
  content: string;
}

@Component({
  selector: 'app-root',
  imports: [CommonModule, FormsModule, TranslateModule],
  templateUrl: './app.component.html',
})
export class AppComponent {
  question = '';
  messages: Message[] = [];
  loading = false;
  language: 'en' | 'it' = 'en';

  serverUrl = 'http://localhost:8080';

  constructor(private http: HttpClient, private translate: TranslateService) {
    this.translate.setDefaultLang(this.language);
    this.translate.use(this.language);
  }

  onLanguageChange() {
    this.translate.use(this.language);
    this.messages = [];
    this.question = '';
    this.loading = false;
  }

  formatConversation(msgs: Message[]): string {
    return msgs
      .map((m) => `${m.role === 'user' ? this.translate.instant('user') : this.translate.instant('assistant')}: ${m.content}`)
      .join('\n');
  }

  askQuestion(event: Event) {
    event.preventDefault();
    const q = this.question.trim();
    if (!q) return;

    const newUserMsg: Message = { role: 'user', content: q };
    const updatedMessages = [...this.messages, newUserMsg];
    this.messages = updatedMessages;
    this.question = '';
    this.loading = true;

    const conversationText = this.formatConversation(updatedMessages);

    this.http
      .post<{ answer: string }>(`${this.serverUrl}/chatbot`, {
        question: conversationText,
        language: this.language,
      })
      .subscribe({
        next: (res) => {
          const answer: Message = { role: 'assistant', content: res.answer };
          this.messages = [...this.messages, answer];
        },
        error: () => {
          const errMsg: Message = {
            role: 'assistant',
            content: 'Errore nel contattare il server.',
          };
          this.messages = [...this.messages, errMsg];
        },
        complete: () => (this.loading = false),
      });
  }
}
