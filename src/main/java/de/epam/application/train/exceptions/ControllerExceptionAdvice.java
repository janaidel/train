package de.epam.application.train.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { DuplicatedTrainException.class })
	protected ResponseEntity<Object> handleConflict(DuplicatedTrainException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getTrainId(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { TrainNotFoundException.class })
	protected ResponseEntity<Object> handleNotFound(TrainNotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getIdNotFound(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler(value = { DuplicatedCarriageException.class })
	protected ResponseEntity<Object> handleDuplicatedCarriage(DuplicatedCarriageException ex, WebRequest request) {
		StringBuilder msg = new StringBuilder();
		msg.append("train ");
		msg.append(ex.getTrainId());
		msg.append(" carriage ");
		msg.append(ex.getCarriageId());
		return handleExceptionInternal(ex, msg.toString(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { CarriageNotFoundException.class })
	protected ResponseEntity<Object> handleCarriageNotFound(CarriageNotFoundException ex, WebRequest request) {
		StringBuilder msg = new StringBuilder();
		msg.append("train ");
		msg.append(ex.getTrainId());
		msg.append(" carriage ");
		msg.append(ex.getCarriageId());
		return handleExceptionInternal(ex, msg.toString(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
