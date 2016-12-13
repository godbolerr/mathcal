package com.work.mathserv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	private static final Logger log = LoggerFactory.getLogger(HealthController.class);

	@RequestMapping(value = "/health", method = RequestMethod.GET, produces = "application/json")
	int getHealth() {
		return 100;
	}

}
