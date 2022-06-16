package com.projeto2.sistema.ajuda.sms.plugins;

import com.projeto2.sistema.ajuda.sms.EnviadoresSMS;
import com.telegramsms.TelegramSMSSender;

public class AdaptadorTelegramSMS implements EnviadoresSMS {

	public AdaptadorTelegramSMS() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String sms, String num) {
		TelegramSMSSender telegram = new TelegramSMSSender();
		telegram.setNumber(num);
		telegram.setText(sms);
		telegram.send();
	}

}
