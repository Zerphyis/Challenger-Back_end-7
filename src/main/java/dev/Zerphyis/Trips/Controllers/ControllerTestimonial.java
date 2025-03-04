package dev.Zerphyis.Trips.Controllers;

import dev.Zerphyis.Trips.Entitys.Dtos.DadosTestimonial;
import dev.Zerphyis.Trips.Service.ServiceTestimonials;
import dev.Zerphyis.Trips.Entitys.Testimonials.Testimonial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/depoimentos")
@CrossOrigin(origins = "*")
public class ControllerTestimonial {
    @Autowired
    ServiceTestimonials service;


    @PostMapping
    public ResponseEntity<Testimonial> register(@RequestBody DadosTestimonial dadosTestimonial) {
        Testimonial saveTestimonial = service.registerTestimonial(dadosTestimonial);
        return ResponseEntity.status(201).body(saveTestimonial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Testimonial> atulization(@PathVariable Long id, @RequestBody DadosTestimonial dados) {
        Testimonial attTestimonial = service.atualizationTestimonial(id, dados);
        return ResponseEntity.status(201).body(attTestimonial);
    }

    @GetMapping
    public ResponseEntity<List<Testimonial>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/depoimentos-home")
    public ResponseEntity<List<Testimonial>> getRandomTestimonials() {
        List<Testimonial> randomTestimonials = service.getRandomTestimonials(3);
        return ResponseEntity.ok(randomTestimonials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Testimonial> searchById(@PathVariable Long id) {
        Optional<Testimonial> testimonial = service.listByid(id);
        return testimonial.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            service.deleteTestimonial(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
