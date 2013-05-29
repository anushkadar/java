package org.me.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class UserApplication implements UserTracerble {

	ObservableLogon oblog = new ObservableLogon();

	@Override
	public void onCreate(String appID) {
		System.out.println("Creating Application for ; " + appID);

	}

	@Override
	public void onLogon(String userName, String logginID) {
		oblog.logon(userName, logginID);
		System.out.println("Logging to Applicaion by : " + logginID);

	}

	@Override
	public void logOff(String logginID) {
		oblog.logoff(logginID);
		System.out.println("Logging Off from Applicaion by : " + logginID);

	}

	public void addLogonObserver(Observer observer) {
		oblog.addObserver(observer);
	}

	private static class ObservableLogon extends Observable {

		private Map<String, String> map = new HashMap<String, String>();

		public void logon(String username, String password) {
			if (map.containsKey(username)) {
				map.put(username, password);
				setChanged();
				notifyObservers(password);
				clearChanged();
				System.out.println("comming to observeblelogon");
			} else {
				System.out.println("Login Fail.try again now");
				if (username != null)
					map.put(username, password);
			}
		}

		public void logoff(String logginID) {
			map.remove(logginID);
			setChanged();
			notifyObservers(logginID);
			clearChanged();
			System.out.println("comming to observeblelogOff");
		}
	}

}
