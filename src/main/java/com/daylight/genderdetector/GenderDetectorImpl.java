package com.daylight.genderdetector;

import java.io.IOException;

public class GenderDetectorImpl implements GenderDetector {

	public Gender findGender(String name) throws IOException {
		GenderParser gp = GenderParser.getInstance();
		
		gp.parseFile();
		return gp.lookup(name.toLowerCase());
	}

}
