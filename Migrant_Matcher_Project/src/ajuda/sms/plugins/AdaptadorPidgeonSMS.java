package ajuda.sms.plugins;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import ajuda.sms.EnviadoresSMS;

public class AdaptadorPidgeonSMS implements EnviadoresSMS {

	public AdaptadorPidgeonSMS() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String sms, String num) {
		new PidgeonSMSSender().send(sms, num);
		System.out.println(sms);
	}

}
