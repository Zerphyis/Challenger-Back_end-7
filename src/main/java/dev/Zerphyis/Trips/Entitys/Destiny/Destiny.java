package dev.Zerphyis.Trips.Entitys.Destiny;

import dev.Zerphyis.Trips.Entitys.Dtos.DadosDestiny;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Tb_Destino")
public class Destiny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotBlank
    private  String name;
    @NotBlank
    private  String photo;
    @NotBlank
    private String photo2;

    @NotBlank
    @Size(max = 160, message = "Meta deve ter no máximo 160 caracteres")
    private String meta;

    private String description;
    public  Destiny(){

    }
    public Destiny(DadosDestiny data) {
        this.name = data.name();
        this.photo = data.photo();
        this.photo2 = data.photo2();
        this.meta = data.meta();
        this.description = data.description();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
