package com.daylight.genderdetector;

import java.io.IOException;

public interface GenderDetector {

	Gender findGender(String name) throws IOException;
	
}
