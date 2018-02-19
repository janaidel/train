package de.epam.application.train.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Train {

	private final String trainNumber;
	private List<Carriage> carriages;

	public Train() {
		this.trainNumber = "";
	}

	public Train(String trainNumber) {
		this.trainNumber = trainNumber;
		this.carriages = new ArrayList<>();
	}

	public void addCarriage(Carriage carriage) {
		this.carriages.add(carriage);
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void addCarriage(String carriageId) {
		this.carriages.add(new Carriage(carriageId));
	}

	public boolean hasCarriage(String carriageId) {
		return carriages.stream().map(Carriage::getCarriageNumber).anyMatch(id -> Objects.equals(id, carriageId));
	}

	public void removeCarriage(String carriageId) {
		this.carriages = carriages.stream().filter(c -> !Objects.equals(c.getCarriageNumber(), carriageId))
				.collect(Collectors.toList());
	}
}
