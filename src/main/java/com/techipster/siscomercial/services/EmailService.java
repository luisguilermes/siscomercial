package com.techipster.siscomercial.services;

import org.springframework.mail.SimpleMailMessage;

import com.techipster.siscomercial.domain.Pedido;

public interface EmailService {

	void sendOrderComfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
