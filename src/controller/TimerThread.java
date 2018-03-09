package controller;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class TimerThread implements Runnable {

	private Label text;
	private int minutes, seconds;
	private boolean timerOn;

	public TimerThread(Label text, int minutes, int seconds) {
		this.text = text;
		this.minutes = minutes;
		this.seconds = seconds;
		timerOn = true;
	}

	@Override
	public void run() {
		 while (timerOn) {
			changeText();
			if (seconds < 59) {
				seconds++;
			} else {
				seconds = 0;
				minutes++;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void changeText() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				String min2digit = String.format("%02d", minutes);
				String sec2digit = String.format("%02d", seconds);
				text.setText(min2digit + " : " + sec2digit);
			}
		});
	}

	public void stopTimer() {
		timerOn = false;
	}

	public int getMin() {
		return minutes;
	}

	public int getsec() {
		return seconds;
	}

}
