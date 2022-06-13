package ajuda.sms.plugins;

import com.telegramsms.TelegramSMSSender;

import ajuda.sms.EnviadoresSMS;

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
