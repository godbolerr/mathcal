package com.work.mathserv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Util {

	public static final String getContent(String https_url) {

		StringBuffer sb = new StringBuffer();

		try {

			URL url = new URL(https_url);

			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			if (con != null) {

				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String input;

				while ((input = br.readLine()) != null) {
					sb.append(input);
				}
				br.close();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return sb.toString();

	}

}
