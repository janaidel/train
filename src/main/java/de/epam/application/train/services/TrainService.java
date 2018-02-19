package de.epam.application.train.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import de.epam.application.train.exceptions.CarriageNotFoundException;
import de.epam.application.train.exceptions.DuplicatedCarriageException;
import de.epam.application.train.exceptions.DuplicatedTrainException;
import de.epam.application.train.exceptions.TrainNotFoundException;
import de.epam.application.train.model.Carriage;
import de.epam.application.train.model.Train;

public class TrainService {

	private static final TrainService instance = new TrainService();

	@Autowired
	private TrainStorage storage;

	public TrainService() {
	}

	public static final TrainService get() {
		return instance;
	}

	public void fillInitialTrains() {
		Train t1 = new Train(String.valueOf(938));
		Train t2 = new Train(String.valueOf(278));

		t1.addCarriage(String.valueOf(1));
		t1.addCarriage(String.valueOf(2));

		t2.addCarriage(String.valueOf(3));
		t2.addCarriage(String.valueOf(4));

		storage.add(t1);
		storage.add(t2);
	}

	public Train addTrain(Train trainToCreate) {
		if (storage.hasTrain(trainToCreate)) {
			throw new DuplicatedTrainException(trainToCreate.getTrainNumber());
		} else {
			storage.add(trainToCreate);
			return trainToCreate;
		}
	}

	public Collection<Train> getAllTrains() {
		return storage.getAllTrains();
	}

	public Train getTrainForId(String id) {
		Train trainForId = storage.getTrainForId(id);
		if (trainForId == null) {
			throw new TrainNotFoundException(id);
		}
		return trainForId;
	}

	public Train addCarriageToTrain(String trainId, Carriage carriageToAdd) {
		Train train = getTrainForId(trainId);
		if (train.hasCarriage(carriageToAdd.getCarriageNumber())) {
			throw new DuplicatedCarriageException(trainId, carriageToAdd.getCarriageNumber());
		}
		train.addCarriage(carriageToAdd);
		return train;
	}

	public Train removeCarriageFromTrain(String trainId, String carriageId) {
		Train train = getTrainForId(trainId);
		if (!train.hasCarriage(carriageId)) {
			throw new CarriageNotFoundException(trainId, carriageId);
		}
		train.removeCarriage(carriageId);
		return train;
	}
}
