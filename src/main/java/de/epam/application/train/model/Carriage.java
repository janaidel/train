package de.epam.application.train.model;

public class Carriage {

	private final String carriageNumber;

	public Carriage() {
		this.carriageNumber = "";
	}

	public Carriage(String carriageNumber) {
		this.carriageNumber = carriageNumber;
	}

	public String getCarriageNumber() {
		return carriageNumber;
	}

}
