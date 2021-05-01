package com.gitlab.stse;

import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.ApplicationShutdownEvent;
import io.micronaut.runtime.event.ApplicationStartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Singleton;

@Singleton
public class Service {
	private static final Logger LOGGER = LogManager.getLogger(Service.class);
	
	public static void main(final String... args) {
		Micronaut.run(Service.class, args);
	}
	
	@EventListener
	void start(final ApplicationStartupEvent event) {
		LOGGER.info("Starting...");
		LOGGER.info("Started");
	}
	
	@EventListener
	void stop(final ApplicationShutdownEvent event) {
		LOGGER.info("Stopping...");
		LOGGER.info("Stopped");
	}
}
