package com.daylight.genderdetector;

import java.io.IOException;

public class GenderMain {

	public static void main(String[] args) throws IOException {
		GenderDetector gd = new GenderDetectorImpl();
		System.out.println(gd.findGender("Marie"));
	}

}
