package com.ibw.skylab.loyaltybackend.core.utilities.email.concretes;

import com.ibw.skylab.loyaltybackend.core.utilities.email.abstracts.EmailHelper;
import com.ibw.skylab.loyaltybackend.core.utilities.email.constants.EmailHelperMessages;
import com.ibw.skylab.loyaltybackend.core.utilities.results.ErrorResult;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.core.utilities.results.SuccessResult;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JavaMailSenderHelper implements EmailHelper {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public Result sendEmail(String to, String subject, String body) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);

            javaMailSender.send(mimeMessage);
            return new SuccessResult(EmailHelperMessages.emailSentSuccessfully);
        } catch (MessagingException e) {
            return new ErrorResult(EmailHelperMessages.emailNotSent);
        }
    }
}
