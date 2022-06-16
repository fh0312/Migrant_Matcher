package com.projeto2.sistema.ajuda.sms;

import java.util.List;
import java.util.Random;

public class ConfirmaSms {

	private List<EnviadoresSMS> pluginsSms;
	private String cod;
	
	public ConfirmaSms(List<EnviadoresSMS> plugins) {
		this.pluginsSms =plugins;
	}

	public void sendCod(String num) {
		if(num.equals("999999999")) { //Caso padrão para scripts
			this.cod="123456";
		}
		else {
		int codigo = (new Random()).nextInt(999999);
		this.cod= String.format("%06d", codigo);
		}
		for( EnviadoresSMS sender : pluginsSms) {
			sender.send(cod, num);
			break;
		}
	}

	public boolean estahConfirmado(String codigo) {
		return codigo.equals(cod);
	}
	
	

}
