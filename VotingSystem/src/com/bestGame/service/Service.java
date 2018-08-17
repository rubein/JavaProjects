package com.bestGame.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bestGame.constants.Constants;
import com.bestGame.servlet.FrontController;

public class Service {

	/**
	 * Compares the time of last vote to current time.
	 * @param date
	 * @return
	 */
	public boolean dateComparer(String date) {
		String currentDateAndTime = getCurrentDateAndTime();

		boolean valid = false;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Date previousDate = sdf.parse(date);
			Date presentDate = sdf.parse(currentDateAndTime);
			System.out.println(presentDate + " and previous date is " + previousDate);

			long timeDifference = presentDate.getTime() - previousDate.getTime();
 		//  long secondsDifference = timeDifference / 1000 % 60;
		//	long minutesdifference = timeDifference/ (60 * 1000) % 60;
		//  long hoursdifference = timeDifference/ (60 * 60 * 1000) % 24;
			long daysDifference = timeDifference / (Constants.hoursToStall * 60 * 60 * 1000);

			if (daysDifference > 1) {
				valid = true;
				return valid;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return valid;
	}

	/**
	 * This method increments counter by 1 for selected game.
	 * 
	 * @param votedFor
	 *            votedGame
	 */
	public void incrementCounter(String votedFor) {
		System.out.println("Voted For: " + votedFor);
		if (votedFor.equals("Overwatch"))
			FrontController.game1++;
		else if (votedFor.equals("warcraft"))
			FrontController.game2++;
		else if (votedFor.equals("PUBG"))
			FrontController.game3++;
		else
			FrontController.game4++;
	}

	/**
	 * 
	 * @return current date and time 
	 */
	public String getCurrentDateAndTime() {
		Date dt = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		return currentTime;
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date presentDate = sdf.parse(new Service().getCurrentDateAndTime());
		System.out.println(new Service().dateComparer(presentDate.toString()));
	}
}
