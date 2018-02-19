package de.epam.application.train.exceptions;

public class CarriageNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 6007429897897743899L;

	private String trainId;
	private String carriageId;

	public CarriageNotFoundException(String trainId, String carriageId) {
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
