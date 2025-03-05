package com.careerit.iplstats.controller;


import com.careerit.iplstats.dto.SendEmailDto;
import com.careerit.iplstats.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/email")
@RequiredArgsConstructor
public class EmailServiceController {

    private final EmailService emailService;
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody SendEmailDto sendEmailDto, @RequestParam(value = "isHtml",
            defaultValue = "true") boolean isHtml) {
        emailService.sendEmail(sendEmailDto,isHtml);
        return ResponseEntity.ok("Email sent ");
    }



}
