package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.SendEmailDto;

public interface EmailService {

    void sendEmail(SendEmailDto sendEmailDto,boolean isHtml);
}
