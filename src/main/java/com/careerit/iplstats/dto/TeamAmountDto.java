package com.careerit.iplstats.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString
public class TeamAmountDto {
    private String label;
    private Double totalAmount;
}
