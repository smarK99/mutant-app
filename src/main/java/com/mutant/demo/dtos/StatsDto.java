package com.mutant.demo.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatsDto {

    private int count_mutant_dna;
    private int count_human_dna;
    private float ratio;

}
