package org.me.observer;

import java.awt.EventQueue;

public class Test {

	public static void main(String[] args) {

		UserApplication app = new UserApplication();

		final LoginPanel lp = new LoginPanel(app);				
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				lp.setVisible(true);
			}
		});

	}

}
