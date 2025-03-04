package dev.Zerphyis.Trips.Repositorys;

import dev.Zerphyis.Trips.Entitys.Destiny.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryDestiny extends JpaRepository<Destiny,Long> {
    List<Destiny> findByNameContainingIgnoreCase(String name);
}
