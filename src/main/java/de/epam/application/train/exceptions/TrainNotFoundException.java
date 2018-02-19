package de.epam.application.train.exceptions;

public class TrainNotFoundException extends IllegalArgumentException {
	private static final long serialVersionUID = 5187159486197954603L;
	private String idNotFound;

	public TrainNotFoundException(String idNotFound) {
		this.idNotFound = idNotFound;
	}

	public String getIdNotFound() {
		return idNotFound;
	}
}
