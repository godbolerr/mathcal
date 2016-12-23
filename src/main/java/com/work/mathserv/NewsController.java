package com.work.mathserv;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.work.mathserv.domain.News;
import com.work.mathserv.repository.NewsRepository;

@RestController
public class NewsController {

	private static final Logger log = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	NewsRepository newsRepo;

	@RequestMapping(value = "/getNews/{count}", method = RequestMethod.GET, produces = "application/json")
	String add(@PathVariable("count") Long count) {

		String result = "SUCCESS : ";

		try {

			String https_url = "https://content.guardianapis.com/search?api-key=d9998498-a427-4939-82a3-484580c37b1a";
			URL url;

			url = new URL(https_url);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			String jsonString = Util.getContent(https_url);

			JSONObject obj = new JSONObject(jsonString);

			JSONArray rArray = obj.getJSONObject("response").getJSONArray("results");

			long id = 0;
			for (int k = 0; k < count; k++) {

				for (int i = 0; i < rArray.length(); i++) {
					String newsItem = rArray.get(i).toString();
					News news = new News();
					news.setContent(newsItem);
					news = newsRepo.save(news);
					log.debug("News Item : {} : {}   ", news.getId(), newsItem);
					id = news.getId();
				}

			}
			result += id + " count = " + count;

		} catch (Exception e) {

			log.error("Error : left = {} , right = {}  , error = {}  ", "", "", e.getMessage());

		}

		return result;
	}

}
