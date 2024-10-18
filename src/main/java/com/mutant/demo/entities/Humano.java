package com.mutant.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Table(name = "humano")
public class Humano extends Base{

    private List<String> dna;

    private Boolean isMutant;




}
