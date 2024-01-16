package com.fit.parqueadero.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "VEHICULO_INFO")
public class VehiculoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @JsonProperty(value = "PATENTE")
    @Column(name = "PATENTE")
    String patente;

    @JsonProperty(value = "COLOR")
    @Column(name = "COLOR")
    String color;

    @JsonProperty(value = "MARCA")
    @Column(name = "MARCA")
    String marca;

    @JsonProperty(value = "DUEÑO")
    @Column(name = "DUEÑO")
    String dueño;

    @JsonProperty(value = "MODELO")
    @Column(name = "MODELO")
    String modelo;

    @JsonProperty(value = "HORA_ENTRADA")
    @Column(name = "HORA_ENTRADA")
    LocalDateTime horaEntrada;


}
