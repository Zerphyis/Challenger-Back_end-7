package dev.Zerphyis.Trips.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.Zerphyis.Trips.Entitys.Destiny.Destiny;
import dev.Zerphyis.Trips.Entitys.Dtos.DadosDestiny;
import dev.Zerphyis.Trips.Repositorys.RepositoryDestiny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDestiny {
        @Autowired
        RepositoryDestiny repository;

        private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
        private final String OPENAI_API_KEY = "CHAVE_DA_OPENAI_AQUI";

        public Destiny registerDestiny(DadosDestiny dados) {
            String description = (dados.description() == null || dados.description().isBlank())
                    ? generateDescription(dados.name())
                    : dados.description();

            var destiny = new Destiny(dados);
            return repository.save(destiny);
        }

        public Destiny atualizationDestiny(Long id, DadosDestiny dados) {
            Optional<Destiny> attDestiny = repository.findById(id);
            if (attDestiny.isPresent()) {
                Destiny newDestiny = attDestiny.get();
                newDestiny.setName(dados.name());
                newDestiny.setPhoto(dados.photo());
                newDestiny.setPhoto2(dados.photo2());
                newDestiny.setMeta(dados.meta());

                String description = (dados.description() == null || dados.description().isBlank())
                        ? generateDescription(dados.name())
                        : dados.description();
                newDestiny.setDescription(description);

                return repository.save(newDestiny);
            } else {
                throw new RuntimeException("Destino não encontrado com o ID: " + id);
            }
        }

        public void deleteDestiny(Long id) {
            if (repository.existsById(id)) {
                repository.deleteById(id);
            } else {
                throw new RuntimeException("Destino não encontrado com o ID: " + id);
            }
        }

        public List<Destiny> listAll() {
            return repository.findAll();
        }

        public Optional<Destiny> listByid(Long id) {
            return repository.findById(id);
        }
    public List<Destiny> searchDestinyByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

        private String generateDescription(String placeName) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer " + OPENAI_API_KEY);
                headers.set("Content-Type", "application/json");

                String prompt = "Faça um resumo sobre " + placeName +
                        " enfatizando o porquê este lugar é incrível. " +
                        "Utilize uma linguagem informal e até 100 caracteres no máximo em cada parágrafo. " +
                        "Crie 2 parágrafos neste resumo.";

                String requestBody = "{ \"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"system\", \"content\": \"" + prompt + "\"}], \"temperature\": 0.7 }";

                HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
                ResponseEntity<String> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, String.class);

                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(response.getBody());
                return jsonNode.get("choices").get(0).get("message").get("content").asText();
            } catch (Exception e) {
                e.printStackTrace();
                return "Descubra um destino incrível cheio de experiências inesquecíveis!";
            }
        }



    }


