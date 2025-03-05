package com.careerit.iplstats.service;

import com.careerit.iplstats.dto.SendEmailDto;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${email.from.mail:techgyaanlabs@gmail.com}")
    private String fromEmail;

    @Override
    public void sendEmail(SendEmailDto sendEmailDto,boolean isHtml) {
        sendMail(sendEmailDto, isHtml);
    }

    private void sendMail(SendEmailDto sendEmailDto, boolean isHtml) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isHtml, "UTF-8");
            message.setFrom(fromEmail);
            message.setTo(getToEmailArray(sendEmailDto.getToEmail()));
            message.setSubject(sendEmailDto.getSubject());
            message.setText(sendEmailDto.getBody(), isHtml);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            // Log the exception (use a proper logging framework in a real application)
           log.error("Error while sending email ",e);
        }
    }

    private String[] getToEmailArray(List<String> toEmail) {
        return toEmail.toArray(new String[0]);
    }
}