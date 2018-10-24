package com.daylight.genderdetector;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class GenderParser {

	private final String filename = "nam_dict.utf8.txt";
	
	private Map<String, Gender> table = new HashMap<String, Gender>();
	
	private static GenderParser instance = new GenderParser();
	private GenderParser() {
	}
	public static GenderParser getInstance() {
		if (instance == null) instance = new GenderParser();
		return instance;
	}
	
	public void parseFile() throws IOException {
		if (table.isEmpty()) fillTable();
		
	}

	private void fillTable() throws IOException {
		String filePath = getClass().getClassLoader().getResource(filename).getFile();
		List<String> lines = FileUtils.readLines(new File(filePath), Charset.forName("UTF-8"));
		for (String l: lines) {
			if (!l.startsWith("#")) {
				
				String[] parts = l.split("\\s+");
				String gender = parts[0];
				String name = parts[1].toLowerCase();
				
				if ("M".equals(gender)) table.put(name, Gender.MALE);
				else if ("1M".equals(gender) || "?M".equals(gender)) table.put(name, Gender.MOSTLY_MALE);
				else if ("F".equals(gender)) table.put(name, Gender.FEMALE);
				else if ("1F".equals(gender) || "?F".equals(gender)) table.put(name, Gender.MOSTLY_FEMALE);
				else if ("?".equals(gender)) table.put(name, Gender.UNISEX);
			}
		}
	}

	public Gender lookup(String name) {
		if (table.containsKey(name)) {
			return table.get(name);
		}
		return Gender.UNKNOWN;
	}
	
}
