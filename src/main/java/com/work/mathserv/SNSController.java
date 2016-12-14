package com.work.mathserv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNSController {

	private static final Logger log = LoggerFactory.getLogger(SNSController.class);

	@RequestMapping(value = "/sns", method = RequestMethod.POST, produces = "application/json")
	int add(@RequestBody String requestBody) {

		int length = -1;

		log.debug("Request body received : {} ", requestBody);

		if (requestBody != null) {
			length = requestBody.length();
		}

		return length;
	}

}
