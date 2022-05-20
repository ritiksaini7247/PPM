package com.PPM.presentation;

import java.text.ParseException;
import java.util.Scanner;

import com.PPM.model.FuelModel;
import com.PPM.service.FuelManagerService;

public class PPMMainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		boolean exitChoice = false;
		FuelManagerService fuelManagerService = new FuelManagerService();
		FuelModel fuelModel = new FuelModel();
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n\n--------------------------------------------------------------");
			System.out.print(
					"What You Want...\n\t\tFor Add Fuel Press : 1\n\t\tFor Request Fuel Press : 2\n\t\tFor Check Fuel Quantity Press : 3\n\t\tFor check all transaction log press : 4\n\t\tFor get logs between two dates press 5\n\t\t\tPlease Press : ");
			Integer choice = scanner.nextInt();

			switch (choice) {
			// For add fuel quantity
			case 1: {
				System.out.print(
						"What type of Fuel you want to add...for petrol press 'p' / 'P'\n\t\tfor diesel press 'd' / 'D'\n\t\tfor gas press 'g' / 'G'\n\t\t\tPlease press key..:- ");
				Character fuelType = scanner.next().charAt(0);
				System.out.print("Please enter fuel quantity : ");
				float fuelQuantity = scanner.nextFloat();
				fuelManagerService.addQuantity(fuelType, fuelQuantity);
				System.out.println("Successfully added fuel....! !");
				System.out.println("Added Quantity : " + fuelQuantity);
				break;
			}
			// Request for fuel
			case 2: {
				System.out.print(
						"What type of fuel you get...for petrol press 'p' / 'P'\n\t\tfor diesel press 'd' / 'D'\n\t\tfor gas press 'g' / 'G'\n\t\t\tPlease press key..:- ");
				Character fuelType = scanner.next().charAt(0);
				System.out.print("Please enter fuel quantity : ");
				float fuelQuantity = scanner.nextFloat();
				if (fuelQuantity <= fuelManagerService.TOTAL_PETROL_QUANTITY) {
					fuelManagerService.fuelRequest(fuelType, fuelQuantity);
					System.out.println("(From Requested User) Thanku you..! ! I got " + fuelQuantity
							+ "ltr fuel successfully...! !");
					System.out.print("\t\tPlease provide date (numeric form)...\n\t\t\tEnter Day :-");
					Integer day = scanner.nextInt();
					System.out.print("\t\t\tEnter month :- ");
					Integer month = scanner.nextInt();
					System.out.print("\t\t\tEnter year :- ");
					Integer year = scanner.nextInt();
					fuelManagerService.generateFuelLogs(day, month, year, fuelType, fuelQuantity);
				} else
					System.err.println("Sorry out of storage...! !");
				break;
			}
			/* Check Fuel Quantity */
			case 3: {
				System.out.println("\n\t| Fuel Type | Fuel Quantity |");
				System.out.println("\t-----------------------------");
				System.out.println("\t|   PETROL  |      " + fuelManagerService.checkFuelQuantity('P') + "    |");
				System.out.println("\t|   DIESEL  |      " + fuelManagerService.checkFuelQuantity('D') + "    |");
				System.out.println("\t|    GAS    |      " + fuelManagerService.checkFuelQuantity('G') + "    |");
				System.out.println("\t-----------------------------");
				break;
			}
			/* Check All Logs */
			case 4: {
				fuelManagerService.getAllTransactionLog();
				break;
			}
			case 5: {
				System.out.print("\t\tPlease provide start date (numeric form)...\n\t\t\tEnter Day :-");
				Integer sDay = scanner.nextInt();
				System.out.print("\t\t\tEnter month :- ");
				Integer sMonth = scanner.nextInt();
				System.out.print("\t\t\tEnter year :- ");
				Integer sYear = scanner.nextInt();
				System.out.print("\t\tPlease provide end date (numeric form)...\n\t\t\tEnter Day :-");
				Integer eDay = scanner.nextInt();
				System.out.print("\t\t\tEnter month :- ");
				Integer eMonth = scanner.nextInt();
				System.out.print("\t\t\tEnter year :- ");
				Integer eYear = scanner.nextInt();
				fuelManagerService.getLogBasedOnDates(sDay, sMonth, sYear, eDay, eMonth, eYear);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			System.out.println("\n\n\n# # # # # # # # # # # # # # # # # # # # # # # # # # # # ");
			System.out.print("\nAre you want to exit if yess press 'y' / 'Y'\n\t\tif not press any key....Press :- ");
			Character userChoice = scanner.next().charAt(0);
			if (userChoice == 'y' || userChoice == 'Y')
				exitChoice = true;
		} while (!exitChoice);
	}

}
