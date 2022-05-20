package com.PPM.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.PPM.model.FuelModel;

/*Service Class*/
public class FuelManagerService {

	public float TOTAL_PETROL_QUANTITY=200;
	public float TOTAL_DIESEL_QUANTITY;
	public float TOTAL_GAS_QUANTITY;
	public List<Map<String, Map<String, Float>>> LOGS = new ArrayList<>();

	FuelModel fuelModel = new FuelModel();

	/* Add fuel Quantity method */
	public Boolean addQuantity(Character fuelType, Float fuelQuantity) {
		TOTAL_PETROL_QUANTITY = fuelModel.getTOTAL_PETROL_QUANTITY();
		TOTAL_DIESEL_QUANTITY = fuelModel.getTOTAL_DIESEL_QUANTITY();
		TOTAL_GAS_QUANTITY = fuelModel.getTOTAL_GAS_QUANTITY();

		if (fuelType == 'p' || fuelType == 'P') {
			TOTAL_PETROL_QUANTITY = TOTAL_PETROL_QUANTITY + fuelQuantity;
			fuelModel.setTOTAL_PETROL_QUANTITY(TOTAL_PETROL_QUANTITY);
			return true;
		} else if (fuelType == 'd' || fuelType == 'D') {
			TOTAL_DIESEL_QUANTITY = TOTAL_DIESEL_QUANTITY + fuelQuantity;
			fuelModel.setTOTAL_DIESEL_QUANTITY(TOTAL_DIESEL_QUANTITY);
			return true;
		} else if (fuelType == 'g' || fuelType == 'G') {
			TOTAL_GAS_QUANTITY = TOTAL_GAS_QUANTITY + fuelQuantity;
			fuelModel.setTOTAL_GAS_QUANTITY(TOTAL_GAS_QUANTITY);
			return true;
		} else
			return false;
	}

	/* Request Fuel method */
	public Boolean fuelRequest(Character fuelType, Float requestedAmmount) {
		if (fuelType == 'p' || fuelType == 'P') {
			TOTAL_PETROL_QUANTITY = TOTAL_PETROL_QUANTITY - requestedAmmount;
			return true;
		} else if (fuelType == 'd' || fuelType == 'D') {
			TOTAL_DIESEL_QUANTITY = TOTAL_DIESEL_QUANTITY - requestedAmmount;
			return true;
		} else if (fuelType == 'g' || fuelType == 'G') {
			TOTAL_GAS_QUANTITY = TOTAL_GAS_QUANTITY - requestedAmmount;
			return true;
		} else
			return false;
	}

	/* Check Fuel Quantity */
	public float checkFuelQuantity(Character fuelType) {
		if (fuelType == 'p' || fuelType == 'P') {
			return TOTAL_PETROL_QUANTITY;
		} else if (fuelType == 'd' || fuelType == 'D') {
			return TOTAL_DIESEL_QUANTITY;
		} else if (fuelType == 'g' || fuelType == 'G') {
			return TOTAL_GAS_QUANTITY;
		} else
			return 0;
	}

	/* Generate Fuel Logs */
	public void generateFuelLogs(Integer day, Integer month, Integer year, Character fuelType, Float fuelQuantity) {
		Map<String, Map<String, Float>> log = new HashMap<>();
		Map<String, Float> transaction = new HashMap<>();
		String fuelTypeStr = null;
		if (fuelType == 'p' || fuelType == 'P')
			fuelTypeStr = "PETROL";
		else if (fuelType == 'd' || fuelType == 'D')
			fuelTypeStr = "DIESEL";
		else if (fuelType == 'g' || fuelType == 'G')
			fuelTypeStr = "GAS";
		transaction.put(fuelTypeStr, fuelQuantity);
		String date = day + "-" + month + "-" + year;
		log.put(date, transaction);
		LOGS.add(log);
	}

	/* Get All Logs about whole transaction */
	public void getAllTransactionLog() {
		System.out.println("-----------------------------------------------");
		System.out.println("|    DATE    | FULE TYPE |  FULE QUANTITY  |");
		System.out.println("-----------------------------------------------");
		for (int i = 0; i < LOGS.size(); i++) {
			LOGS.get(i).forEach((k, v) -> {
				System.out.print("|  " + k);
				v.forEach((k1, v1) -> {
					System.out.print("  |  " + k1 + "  |  " + v1 + "  |");
				});
			});
			System.out.println("\n-----------------------------------------------");
		}
	}

	public void getLogBasedOnDates(Integer sDay, Integer sMonth, Integer sYear, Integer eDay, Integer eMonth,
			Integer eYear) throws ParseException {
		String sDateStr = sDay + "-" + sMonth + "-" + sYear;
		String eDateStr = eDay + "-" + eMonth + "-" + eYear;

		// Convert String to date time format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");

		// convert String to LocalDate
		LocalDate start = LocalDate.parse(sDateStr, formatter);
		LocalDate end = LocalDate.parse(eDateStr, formatter);

		// List of date between start date and end date
		List<LocalDate> totalDates = new ArrayList<>();

		// logic for add dates on list
		while (!start.isAfter(end)) {
			start = start.plusDays(1);
			totalDates.add(start);
		}

		System.out.println("Tatal dates :- " + totalDates);

//		// logic for print data between dates
//		for (int i = 0; i < totalDates.size(); i++) {
//			String date = totalDates.get(i).toString();
//			for (int j = 0; j < LOGS.size(); j++) {
//				String key = LOGS.get(j).entrySet().iterator().next().getKey();
//				if (key.equals(date)) {
//					System.out.println("Record Found...");
//				}
//			}
//		}

	}

}
