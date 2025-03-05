package com.careerit.iplstats.dto;

import lombok.Data;

import java.util.List;


@Data
public class SendEmailDto {

        private List<String> toEmail;
        private String subject;
        private String body;

}
