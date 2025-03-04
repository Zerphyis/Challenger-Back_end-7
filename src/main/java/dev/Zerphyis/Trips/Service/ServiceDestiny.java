package dev.Zerphyis.Trips.Service;

import dev.Zerphyis.Trips.Entitys.Destiny.Destiny;
import dev.Zerphyis.Trips.Entitys.Dtos.DadosDestiny;
import dev.Zerphyis.Trips.Entitys.Dtos.DadosTestimonial;
import dev.Zerphyis.Trips.Entitys.Testimonials.Testimonial;
import dev.Zerphyis.Trips.Repositorys.RepositoryDestiny;
import dev.Zerphyis.Trips.Repositorys.RepositoryTestimonial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceDestiny {
    @Autowired
    RepositoryDestiny repository;

    @Transient
    public Destiny registerDestiny(DadosDestiny dados) {
        var destiny = new Destiny(dados);
        return repository.save(destiny);
    }

    @Transient
    public Destiny atualizationDestiny(Long id, DadosDestiny dados) {
        Optional<Destiny> attDestiny = repository.findById(id);
        if (attDestiny.isPresent()) {
            Destiny newDestiny =attDestiny.get();
            newDestiny.setName(dados.name());
            newDestiny.setPhoto(dados.photo());
            newDestiny.setPrice(dados.price());
            return  repository.save(newDestiny);
        }else {
            throw new RuntimeException("Destino  não encontrado com o ID: " + id);
        }
    }


    @Transient
    public void deleteDestiny(Long id){
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
}
