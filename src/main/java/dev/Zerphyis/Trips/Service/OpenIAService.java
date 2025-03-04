package dev.Zerphyis.Trips.Service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OpenIAService {
    @Value("${openai.api.key}")
    private String apiKey;

    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";

    public String gerarDescricaoDestino(String destino) {
        String prompt = "Faça um resumo sobre " + destino + " enfatizando o porquê este lugar é incrível. "
                + "Utilize uma linguagem informal e até 100 caracteres no máximo em cada parágrafo. "
                + "Crie 2 parágrafos neste resumo.";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4",
                "messages", new Object[]{
                        Map.of("role", "system", "content", "Você é um assistente especializado em turismo."),
                        Map.of("role", "user", "content", prompt)
                }
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_URL, request, Map.class);

        try {
            return (String) ((Map<String, Object>) ((Map<String, Object>) response.getBody().get("choices")).get(0)).get("message");
        } catch (Exception e) {
            return "Este destino é incrível, cheio de cultura e experiências únicas! 🌍✈️";
        }
    }
}
