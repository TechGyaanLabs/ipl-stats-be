package com.careerit.iplstats.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerCountDto {
    private String label;
    private Long roleCount;
}
