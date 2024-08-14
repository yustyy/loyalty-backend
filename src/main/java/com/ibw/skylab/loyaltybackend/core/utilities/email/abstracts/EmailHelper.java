package com.ibw.skylab.loyaltybackend.core.utilities.email.abstracts;

import com.ibw.skylab.loyaltybackend.core.utilities.results.Result;

public interface EmailHelper {

    Result sendEmail(String to, String subject, String body);


}
