package detector;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Cron {

	public Cron(Website website, int i) throws HttpRequestDetectorException  {
		URL url;
		
			System.out.println(website);
			try {
				url = new URL(website.getUrl());
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setReadTimeout(5000);
				con.setInstanceFollowRedirects(false);
				int status = con.getResponseCode();
				con.disconnect();
				throw new HttpRequestDetectorException("[" + status + "]", i);
			} catch (MalformedURLException e) {
				throw new HttpRequestDetectorException("[" + e.getClass().getSimpleName() + "]", i);
			} catch (IOException e) {
				throw new HttpRequestDetectorException("[" + e.getClass().getSimpleName() + "]", i);
			}
	}

}
