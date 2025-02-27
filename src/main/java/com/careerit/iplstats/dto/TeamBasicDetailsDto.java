package com.careerit.iplstats.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamBasicDetailsDto {
    private UUID teamId;
    private String teamName;
    private String teamLabel;
}
