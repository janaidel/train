package de.epam.application.train.exceptions;

public class DuplicatedCarriageException extends IllegalArgumentException {

	private static final long serialVersionUID = -7566394724064952723L;
	private String trainId;
	private String carriageId;

	public DuplicatedCarriageException(String trainId, String carriageId) {
		this.trainId = trainId;
		this.carriageId = carriageId;
	}

	public String getTrainId() {
		return trainId;
	}

	public String getCarriageId() {
		return carriageId;
	}

}
