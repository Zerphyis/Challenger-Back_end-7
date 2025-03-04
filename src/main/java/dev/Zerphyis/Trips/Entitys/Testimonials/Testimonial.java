package dev.Zerphyis.Trips.Entitys.Testimonials;

import dev.Zerphyis.Trips.Entitys.Dtos.DadosTestimonial;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Tb_Depoimentos")
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String photo;
    @NotBlank
    private  String testimonial;
    @NotBlank
    private String namePersonTestimonial;

    public Testimonial(){

    }
    public  Testimonial(DadosTestimonial dados){
        this.photo= dados.photo();
        this.testimonial= dados.testimonial();
        this.namePersonTestimonial= dados.namePersonTestimonial();
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTestimonial() {
        return testimonial;
    }

    public void setTestimonial(String testimonial) {
        this.testimonial = testimonial;
    }

    public String getNamePersonTestimonial() {
        return namePersonTestimonial;
    }

    public void setNamePersonTestimonial(String namePersonTestimonial) {
        this.namePersonTestimonial = namePersonTestimonial;
    }
}
