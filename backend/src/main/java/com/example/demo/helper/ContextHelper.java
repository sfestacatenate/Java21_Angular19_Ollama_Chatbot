package com.example.demo.helper;

public class ContextHelper {

    private static String getBasilicaContext(String lang) {
        return switch (lang) {
            case "en" -> """
                    The Basilica of Saint Paul Outside the Walls is one of the four papal basilicas in Rome and the second largest after St. Peter’s. It stands along the Via Ostiense, about two kilometers outside the Aurelian Walls, which gives it the name “Outside the Walls.” It was built on the site where, according to tradition, the Apostle Paul was buried after his martyrdom in Rome around 67 AD.

                    The original basilica was erected by Emperor Constantine in the 4th century above the apostle’s tomb and was consecrated in 324. However, the building was significantly expanded during the pontificate of Pope Siricius and subsequently by other popes. The result was a grand five-nave basilica with Corinthian colonnades, a large atrium, and a raised presbytery area.

                    Over the centuries, the basilica was enriched with mosaics, frescoes, and works of art, becoming an important center of pilgrimage. In 1823, a terrible fire caused by roof repairs almost completely destroyed the original structure. Pope Leo XII ordered its reconstruction, which, while respecting the original architectural lines, introduced neoclassical elements.

                    The 13th-century cloister, created by the Cosmati marble workers, is considered one of the finest examples of Cosmatesque art. The basilica’s interior houses an iconic series of medallions with portraits of all the popes, from Saint Peter to the current pontiff—a unique work that continues to be updated.

                    The basilica is also known for its imposing 14th-century Gothic baldachin above the papal altar, created by Arnolfo di Cambio, and for the apse mosaic depicting Christ with the saints. Beneath the main altar lies the confessio, the area that preserves the tomb of the Apostle Paul, visible through a grate.

                    Today, Saint Paul Outside the Walls hosts religious events and concerts and remains a point of reference for the faithful. Its location outside the historic center, yet easily accessible, makes it a serene and majestic place, less crowded than other Roman basilicas.

                    Over the centuries, the basilica has undergone restorations and improvements but has always maintained a deep spiritual significance tied to the figure of the Apostle Paul and the spread of Christianity. Every year on June 29th, the feast of Saints Peter and Paul, solemn liturgical celebrations are held, and during the Jubilee Year, it is possible to pass through the Holy Door located in the narthex.

                    Thanks to the support of various sovereigns and popes, the basilica is also an extraordinary example of the history of Christian architecture, with Roman, medieval, and neoclassical influences. Its artistic, spiritual, and cultural heritage makes it an essential stop for anyone wishing to understand the history of faith and art in Rome.
                    """;
            case "it" -> """
                    La Basilica di San Paolo fuori le mura è una delle quattro basiliche papali di Roma ed è la seconda per grandezza dopo San Pietro. Sorge lungo la via Ostiense, a circa due chilometri fuori dalle mura aureliane, da cui deriva il nome "fuori le mura". È costruita sul luogo dove, secondo la tradizione, fu sepolto l'apostolo Paolo dopo il suo martirio avvenuto a Roma intorno al 67 d.C.

                    La basilica originale fu edificata dall'imperatore Costantino nel IV secolo, sopra la tomba dell'apostolo, e fu consacrata nel 324. Tuttavia, l’edificio fu notevolmente ampliato durante il pontificato di papa Siricio e successivamente da altri pontefici. Il risultato fu una grandiosa basilica a cinque navate con colonnati corinzi, un grande atrio e un’area presbiteriale sopraelevata.

                    Nel corso dei secoli la basilica fu arricchita con mosaici, affreschi e opere d’arte, diventando un importante centro di pellegrinaggio. Nel 1823, un terribile incendio, causato da lavori di riparazione del tetto, distrusse quasi completamente la struttura originaria. Papa Leone XII ordinò la sua ricostruzione che, pur rispettando le linee architettoniche originali, vide l’introduzione di elementi neoclassici.

                    Il chiostro del XIII secolo, realizzato dai marmorari Cosmati, è considerato uno dei più raffinati esempi di arte cosmatesca. L’interno della basilica ospita un’iconica serie di medaglioni con i ritratti di tutti i papi, da San Pietro fino all’attuale pontefice, un'opera unica che continua a essere aggiornata.

                    La basilica è nota anche per il suo imponente baldacchino gotico del XIV secolo sopra l'altare papale, realizzato da Arnolfo di Cambio, e per il mosaico absidale che rappresenta Cristo con i santi. Sotto l'altare maggiore si trova la confessione, ovvero l'area che conserva la tomba dell'apostolo Paolo, visibile attraverso una grata.

                    Oggi San Paolo fuori le mura è sede di eventi religiosi e concerti, e continua a essere un punto di riferimento per i fedeli. La sua posizione al di fuori del centro storico, ma facilmente raggiungibile, la rende un luogo tranquillo e maestoso, meno affollato rispetto ad altre basiliche romane.

                    Nel corso dei secoli la basilica ha subito restauri e migliorie, ma ha sempre mantenuto un profondo significato spirituale, legato alla figura dell’apostolo Paolo e alla diffusione del cristianesimo. Ogni anno il 29 giugno, festa dei santi Pietro e Paolo, si tengono solenni celebrazioni liturgiche, e durante l’anno giubilare è possibile attraversare la Porta Santa, situata nel nartece.

                    Grazie al sostegno di vari sovrani e pontefici, la basilica è anche uno straordinario esempio della storia dell'architettura cristiana, con influenze romane, medievali e neoclassiche. Il suo patrimonio artistico, spirituale e culturale la rende una tappa essenziale per chiunque voglia comprendere la storia della fede e dell'arte a Roma.
                    """;
            default -> "";
        };
    }

    public static String getPrompt(String lang, String conversation) {
        String context = getBasilicaContext(lang);
        return switch (lang) {
            case "en" -> """
                    Historical context:
                    %s
                    Answer only in English to questions related to the provided context (The Basilica of Saint Paul Outside the Walls in Rome).
                    Conversation: %s
                    """.formatted(context, conversation);
            case "it" -> """
                    Contesto storico:
                    %s
                    Rispondi solo in italiano a domande collegate con il contesto fornito (La Basilica di San Paolo fuori le mura a Roma).
                    Conversazione: %s
                    """.formatted(context, conversation);
            default -> "";
        };
    }
}

