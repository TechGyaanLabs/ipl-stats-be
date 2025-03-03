package com.careerit.iplstats.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class CountryPlayerCountDto {
    private String countryName;
    private Long playerCount;
}
