// ChatController.java
package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.example.demo.helper.ContextHelper;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/chatbot")
public class ChatController {

    private final RestTemplate restTemplate;

    public ChatController() {
        this.restTemplate = new RestTemplate();
        this.restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:11434"));
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> ask(@RequestBody Map<String, String> body) {
        String conversation = body.getOrDefault("question", "");
        String language = body.getOrDefault("language", "eng");

        String prompt = ContextHelper.getPrompt(language, conversation);

        Map<String, Object> payload = new HashMap<>();
        payload.put("model", "gemma3:12b-it-qat");
        payload.put("prompt", prompt);
        payload.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(payload, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("/api/generate", request, Map.class);
        String answer = ((String) response.getBody().getOrDefault("response", "")).trim();

        Map<String, String> result = new HashMap<>();
        result.put("answer", answer);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        responseHeaders.set("charset", "UTF-8");

        return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
    }
}

