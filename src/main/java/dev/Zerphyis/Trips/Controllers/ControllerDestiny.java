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
    private ServiceDestiny service;

    @PostMapping
    public ResponseEntity<Destiny> register(@RequestBody DadosDestiny dados) {
        Destiny destiny = service.registerDestiny(dados);
        return ResponseEntity.ok(destiny);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destiny> update(@PathVariable Long id, @RequestBody DadosDestiny dados) {
        Destiny updatedDestiny = service.atualizationDestiny(id, dados);
        return ResponseEntity.ok(updatedDestiny);
    }

    @GetMapping
    public ResponseEntity<List<Destiny>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destiny> listById(@PathVariable Long id) {
        Optional<Destiny> destiny = service.listByid(id);
        return destiny.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteDestiny(id);
        return ResponseEntity.noContent().build();
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




