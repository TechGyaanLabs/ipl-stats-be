package com.careerit.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDto {
    private UUID id;
    private String name;
    private String role;
    private String country;
    private String team;
    private double price;
}
