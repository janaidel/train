package de.epam.application.train.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.epam.application.train.model.Carriage;
import de.epam.application.train.model.Train;
import de.epam.application.train.services.TrainService;

@RestController
public class TrainController {

	@Autowired
	private TrainService trainService;

	@RequestMapping(method = RequestMethod.GET, value = "/init")
	public ResponseEntity<HttpStatus> initTrains() {
		trainService.fillInitialTrains();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/train")
	@ResponseBody
	public ResponseEntity<Collection<Train>> getTrains() {
		Collection<Train> trains = trainService.getAllTrains();
		if (trains.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(trains, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/train/{id}")
	@ResponseBody
	public ResponseEntity<Train> getTrain(@PathVariable("id") String trainId) {
		Train train = trainService.getTrainForId(trainId);
		return new ResponseEntity<>(train, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/train")
	@ResponseBody
	public ResponseEntity<Train> addTrain(Train trainToCreate) {
		Train newTrain = trainService.addTrain(trainToCreate);
		return new ResponseEntity<>(newTrain, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/train/{id}/carriage/{carriageId}")
	@ResponseBody
	public ResponseEntity<Train> modifyTrain(@PathVariable("id") String trainId,
			@PathVariable("carriageId") String carriageId) {
		Train newTrain = trainService.removeCarriageFromTrain(trainId, carriageId);
		return new ResponseEntity<>(newTrain, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/train")
	@ResponseBody
	public ResponseEntity<Train> modifyTrain(@PathVariable String trainId, Carriage carriageToAdd) {
		Train newTrain = trainService.addCarriageToTrain(trainId, carriageToAdd);
		return new ResponseEntity<>(newTrain, HttpStatus.OK);
	}

}