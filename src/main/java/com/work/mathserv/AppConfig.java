package com.work.mathserv;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ PersistenceContext.class })
public class AppConfig {
	

}