package com.ibw.skylab.loyaltybackend.core.utilities.email.concretes;

import com.ibw.skylab.loyaltybackend.core.utilities.email.abstracts.EmailHelper;
import com.ibw.skylab.loyaltybackend.core.utilities.email.constants.EmailHelperMessages;
import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;
import com.ibw.skylab.loyaltybackend.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JavaMailSenderHelper implements EmailHelper {
    @Override
    public Result sendEmail(String to, String subject, String text) {

        //will be written
        return new SuccessResult(EmailHelperMessages.emailSentSuccessfully);
    }
}
