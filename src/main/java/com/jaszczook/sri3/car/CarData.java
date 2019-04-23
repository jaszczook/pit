package com.jaszczook.sri3.car;

public class CarData {

	private double oilTemperature;
	private double tiresTemperature;
	private double fuelLevel;

	public CarData() {
		super();
	}

	public CarData(double oilTemperature, double tiresTemperature, double fuelLevel) {
		this.oilTemperature = oilTemperature;
		this.tiresTemperature = tiresTemperature;
		this.fuelLevel = fuelLevel;
	}

	public double getOilTemperature() {
		return oilTemperature;
	}

	public void setOilTemperature(double oilTemperature) {
		this.oilTemperature = oilTemperature;
	}

	public double getTiresTemperature() {
		return tiresTemperature;
	}

	public void setTiresTemperature(double tiresTemperature) {
		this.tiresTemperature = tiresTemperature;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	@Override
	public String toString() {
		return "\nCarData {" +
				"\n\tOil Temperature = " + String.format("%.2f", oilTemperature) + " C" +
				"\n\tTires Temperature = " + String.format("%.2f", tiresTemperature) + " C" +
				"\n\tFuelLevel = " + String.format("%.2f", fuelLevel) + " lit." +
				"\n}";
	}
}
