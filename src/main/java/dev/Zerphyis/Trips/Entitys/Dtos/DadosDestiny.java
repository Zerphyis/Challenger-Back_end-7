package dev.Zerphyis.Trips.Entitys.Dtos;

import jakarta.validation.constraints.Size;

public record DadosDestiny(  String name,
                             String photo,
                             String photo2,
                             @Size(max = 160, message = "Meta deve ter no máximo 160 caracteres") String meta,
                            String description) {
}
