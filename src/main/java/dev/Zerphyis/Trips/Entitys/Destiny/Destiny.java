package dev.Zerphyis.Trips.Entitys.Destiny;

import dev.Zerphyis.Trips.Entitys.Dtos.DadosDestiny;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

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
    private  String price;
    public  Destiny(){

    }
    public  Destiny(DadosDestiny data){
        this.name= data.name();
        this.photo= data.photo();
        this.price= data.price();
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
