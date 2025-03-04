package dev.Zerphyis.Trips.Repositorys;

import dev.Zerphyis.Trips.Entitys.Testimonials.Testimonial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTestimonial extends JpaRepository<Testimonial,Long> {
}
