package dev.Zerphyis.Trips.Controllers;

import dev.Zerphyis.Trips.Entitys.Destiny.Destiny;
import dev.Zerphyis.Trips.Entitys.Dtos.DadosDestiny;
import dev.Zerphyis.Trips.Service.ServiceDestiny;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/destinos")
public class ControllerDestiny {
        @Autowired
        ServiceDestiny service;

        @PostMapping
        public ResponseEntity<Destiny> register(@RequestBody DadosDestiny dadosDestiny) {
            Destiny saveDestiny = service.registerDestiny(dadosDestiny);
            return ResponseEntity.status(201).body(saveDestiny);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Destiny> update(@PathVariable Long id, @RequestBody DadosDestiny dadosDestiny) {
            Destiny updatedDestiny = service.atualizationDestiny(id, dadosDestiny);
            return ResponseEntity.status(200).body(updatedDestiny);
        }

        @GetMapping
        public ResponseEntity<List<Destiny>> listAll() {
            return ResponseEntity.ok(service.listAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Destiny> getById(@PathVariable Long id) {
            Optional<Destiny> destiny = service.listByid(id);
            return destiny.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id) {
            try {
                service.deleteDestiny(id);
                return ResponseEntity.noContent().build();
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/search")
        public ResponseEntity<?> searchDestiny(@RequestParam String nome) {
            List<Destiny> destinos = service.searchDestinyByName(nome);
            if (destinos.isEmpty()) {
                return ResponseEntity.status(404).body("{\"mensagem\": \"Nenhum destino foi encontrado\"}");
            }
            return ResponseEntity.ok(destinos);
        }
    }


