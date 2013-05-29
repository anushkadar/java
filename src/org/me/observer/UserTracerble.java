package org.me.observer;

public interface UserTracerble {

	// call back methods
	void onCreate(String apId);

	void onLogon(String userName, String logginID);

	void logOff(String logginID);

}
