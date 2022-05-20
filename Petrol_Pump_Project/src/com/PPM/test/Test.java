package com.PPM.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
		String sd = "1-08-2020";
		String ed = "3-08-2020";

		// convert String to LocalDate
		LocalDate start = LocalDate.parse(sd,formatter);
		LocalDate end = LocalDate.parse(ed,formatter);

		
		List<LocalDate> totalDates = new ArrayList<>();

		while (!start.isAfter(end)) {
			start = start.plusDays(1);
            totalDates.add(start);
		}
			System.out.println(totalDates.toString());
		
	}
	
	
}
