package detector;

public class Website {
	String url = "";
	String label = "";
	String status = "[Undefined]";

	public Website(String input) {
		String[] data = input.split(" ");
		this.url = data[0];
		if (data.length > 1) {
			StringBuffer sb = new StringBuffer();
		      for(int i = 1; i < data.length; i++) {
		         sb.append(data[i] + " ");
		      }
			this.label = sb.toString();
		} else {
			this.url = input;
			this.label = "";
		}
	}
	
	public Website(String url, Number interval, String label) {
		this.url = url;
		this.label = label;
	}
	
	public String toFileString() {
		return this.url + " " + this.label;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return this.status + this.url + " " + this.label;
	}

}
