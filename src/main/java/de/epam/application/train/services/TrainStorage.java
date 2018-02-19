package de.epam.application.train.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.epam.application.train.model.Train;

public class TrainStorage {

	private Map<String, Train> trainStorage = new HashMap<>();

	public void add(Train train) {
		this.trainStorage.put(train.getTrainNumber(), train);
	}

	public boolean hasTrain(Train train) {
		return this.trainStorage.containsKey(train.getTrainNumber());
	}

	public Collection<Train> getAllTrains() {
		return this.trainStorage.values();
	}

	public Train getTrainForId(String id) {
		return this.trainStorage.get(id);
	}

}
