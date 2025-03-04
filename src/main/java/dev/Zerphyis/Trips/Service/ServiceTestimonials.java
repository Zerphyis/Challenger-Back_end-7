package dev.Zerphyis.Trips.Service;

import dev.Zerphyis.Trips.Entitys.Dtos.DadosTestimonial;
import dev.Zerphyis.Trips.Repositorys.RepositoryTestimonial;
import dev.Zerphyis.Trips.Entitys.Testimonials.Testimonial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceTestimonials {
    @Autowired
    RepositoryTestimonial repository;

    @Transient
    public Testimonial registerTestimonial(DadosTestimonial dados) {
        var testimonial = new Testimonial(dados);
        return repository.save(testimonial);
    }

    @Transient
    public Testimonial atualizationTestimonial(Long id, DadosTestimonial dados) {
        Optional<Testimonial> attTestimonial = repository.findById(id);
        if (attTestimonial.isPresent()) {
            Testimonial testimonial = attTestimonial.get();
            testimonial.setTestimonial(dados.testimonial());
            testimonial.setPhoto(dados.photo());
            testimonial.setNamePersonTestimonial(dados.namePersonTestimonial());
                return  repository.save(testimonial);
        }else {
            throw new RuntimeException("Depoimento não encontrado com o ID: " + id);
        }
    }


    @Transient
    public void deleteTestimonial(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Depoimento não encontrado com o ID: " + id);
        }
    }

    public List<Testimonial> listAll() {
        return repository.findAll();
    }


    public Optional<Testimonial> listByid(Long id) {
        return repository.findById(id);
    }
    public List<Testimonial> getRandomTestimonials(int count) {
        List<Testimonial> allTestimonials = repository.findAll();
        Collections.shuffle(allTestimonials);
        return allTestimonials.stream().limit(count).collect(Collectors.toList());
    }

}
