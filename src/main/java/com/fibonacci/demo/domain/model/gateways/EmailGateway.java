package com.fibonacci.demo.domain.model.gateways;

import com.fibonacci.demo.domain.model.EmailDetails;

public interface EmailGateway {

    void sendEmail(EmailDetails details);
}
