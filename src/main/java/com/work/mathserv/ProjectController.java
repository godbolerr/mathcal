package com.work.mathserv;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.work.mathserv.domain.Project;
import com.work.mathserv.repository.ProjectRepository;

@RestController
public class ProjectController {

	private static final Logger log = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectRepository projectRepo;

	@RequestMapping(value = "/project", method = RequestMethod.GET, produces = "application/json")
	AddExpression add(WebRequest webRequest) {
		Map<String, String[]> params = webRequest.getParameterMap();
		int ileft = 0;
		int iright = 0;


		String left = params.get("left")[0];
		String right = params.get("right")[0];
		
		if ( left != null ){
			ileft = Integer.parseInt(left);
		}
		
		
		AddExpression expr = new AddExpression();
		expr.setLeft(ileft);
		expr.setRight(iright);

		try {
			
			Project proj = null;

			if ( ileft > 0 ) {
				
				for (int i = 0; i < ileft; i++) {
					
					proj = new Project();
					
					proj.setDescription("desc");
					proj.setName("Proj" + System.currentTimeMillis() + i );
					proj.setStatus("Active");
					proj = projectRepo.save(proj);
				}
				

				
			}

			
			
			
			if ( proj != null ) {
				expr.setAnswer(proj.getId().intValue());
			}
			
			log.debug("Result : {} + {}  =  {}  ", expr.getLeft(), expr.getRight(), expr.getAnswer());
		} catch (Exception e) {

			log.error("Error : left = {} , right = {}  , error = {}  ", "", "", e.getMessage());

		}

		return expr;
	}

}
