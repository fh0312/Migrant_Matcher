package com.projeto2.sistema.ajuda.sms.plugins;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;
import com.projeto2.sistema.ajuda.sms.EnviadoresSMS;

public class AdaptadorPidgeonSMS implements EnviadoresSMS {

	public AdaptadorPidgeonSMS() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String sms, String num) {
		new PidgeonSMSSender().send(sms, num);
	}

}
