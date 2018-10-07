package com.techipster.siscomercial.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.techipster.siscomercial.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	/**
	 * A implementacao deste metodo poderia ser uma chamada para um 
	 * webservice que gera o boleto. Pesquisar se e a ideia de microservico.
	 */
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagto, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		pagto.setDataVencimento(cal.getTime());
	}
}
