package de.epam.application.train;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.epam.application.train.services.TrainService;
import de.epam.application.train.services.TrainStorage;

@Configuration
public class TrainConfiguration {

	@Bean
	public TrainStorage getTrainStorage() {
		return new TrainStorage();
	}

	@Bean
	public TrainService getTrainService() {
		return new TrainService();
	}
}
