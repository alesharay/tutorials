package com.aleshamray.expensetracker;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class ExpensetrackerApplication {

	private static final Logger log = LoggerFactory.getLogger(ExpensetrackerApplication.class);

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ExpensetrackerApplication.class);
		app.run(args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void postStartup() {

		String protocol = env.getProperty("server.ssl.key-store") != null ? "https" : "http";
		String serverPort = env.getProperty("server.port");

		String contextPath = env.getProperty("server.servlet.context-path");
		if (contextPath.isBlank()) { contextPath = "/"; }

		String hostAddress = "localhost";

		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}

		String ANSI_PURPLE = "\u001B[35m";
		String ANSI_RESET = "\u001B[0m";
		String ANSI_BLUE = "\u001B[34m";

		StringBuffer consoleMsg = new StringBuffer();
		consoleMsg.append(ANSI_PURPLE + "\n\t ----------------------------------------------------------------------" + ANSI_RESET);
		consoleMsg.append(ANSI_BLUE + "\n\t Application is running! Access URLs:");
		consoleMsg.append("\n\t".concat(String.format(" Local: \t%s://localhost:%s%s", protocol, serverPort, contextPath)));
		consoleMsg.append("\n\t".concat(String.format(" External: \t%s://%s:%s%s", protocol, hostAddress, serverPort, contextPath)));
		consoleMsg.append("\n\t".concat(String.format(" Profile(s): \t%s", Arrays.toString(env.getActiveProfiles()) + ANSI_RESET)));
		consoleMsg.append(ANSI_PURPLE + "\n\t ----------------------------------------------------------------------" + ANSI_RESET);

		log.info(consoleMsg.toString());

	}
}