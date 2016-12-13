package com.work.mathserv;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class MathController {

	private static final Logger log = LoggerFactory.getLogger(MathController.class);

	@RequestMapping(value = "/calc", method = RequestMethod.GET, produces = "application/json")
	AddExpression add(WebRequest webRequest) {
		Map<String, String[]> params = webRequest.getParameterMap();
		int ileft = 0;
		int iright = 0;

		String left = params.get("left")[0];
		String right = params.get("right")[0];

		AddExpression expr = new AddExpression();
		expr.setLeft(ileft);
		expr.setRight(iright);

		try {

			ileft = Integer.parseInt(left);
			iright = Integer.parseInt(right);
			expr.setLeft(ileft);
			expr.setRight(iright);
			expr.setAnswer(ileft + iright);
			log.debug("Result : {} + {}  =  {}  ", expr.getLeft(), expr.getRight(), expr.getAnswer());
		} catch (Exception e) {

			log.error("Error : left = {} , right = {}  , error = {}  ", left, right, e.getMessage());

		}

		return expr;
	}

}
