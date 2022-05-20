package com.PPM.model;

import java.util.Map;

public class FuelModel {

	public float TOTAL_PETROL_QUANTITY;
	public float TOTAL_DIESEL_QUANTITY;
	public float TOTAL_GAS_QUANTITY;
	public Map<String, Map<String, Integer>> FUEL_LOGS;

	public float getTOTAL_PETROL_QUANTITY() {
		return TOTAL_PETROL_QUANTITY;
	}

	public void setTOTAL_PETROL_QUANTITY(float tOTAL_PETROL_QUANTITY) {
		TOTAL_PETROL_QUANTITY = tOTAL_PETROL_QUANTITY;
	}

	public float getTOTAL_DIESEL_QUANTITY() {
		return TOTAL_DIESEL_QUANTITY;
	}

	public void setTOTAL_DIESEL_QUANTITY(float tOTAL_DIESEL_QUANTITY) {
		TOTAL_DIESEL_QUANTITY = tOTAL_DIESEL_QUANTITY;
	}

	public float getTOTAL_GAS_QUANTITY() {
		return TOTAL_GAS_QUANTITY;
	}

	public void setTOTAL_GAS_QUANTITY(float tOTAL_GAS_QUANTITY) {
		TOTAL_GAS_QUANTITY = tOTAL_GAS_QUANTITY;
	}

	public Map<String, Map<String, Integer>> getFUEL_LOGS() {
		return FUEL_LOGS;
	}

	public void setFUEL_LOGS(Map<String, Map<String, Integer>> fUEL_LOGS) {
		FUEL_LOGS = fUEL_LOGS;
	}

}
