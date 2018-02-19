package de.epam.application.train.exceptions;

public class DuplicatedTrainException extends IllegalArgumentException {

	private static final long serialVersionUID = 6883517726399263900L;
	private String trainId;

	public DuplicatedTrainException(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainId() {
		return trainId;
	}

}
