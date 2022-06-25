package detector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class File {

	private String path = "";

	public File(String path) {
		this.path = path;
	}
	
	public ArrayList<Website> getWebsites() throws IOException {
		FileInputStream fstream = new FileInputStream(this.path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		ArrayList<Website> websites = new ArrayList<Website>();

		String line;
		while ((line = br.readLine()) != null)   {
			Website website = new Website(line);
			websites.add(website);
		}

		fstream.close();
		return websites;
	}
	
	public void save(Website[] urls) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(this.path);
		for(int i = 0; i < urls.length; i++) {
			writer.println(urls[i].toFileString());
		}
		writer.close();
	}

}
