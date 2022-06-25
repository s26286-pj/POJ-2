package detector;

public class HttpRequestDetectorException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int id = 0;
	private String status = "[Undefined]";

	public HttpRequestDetectorException(String status, int id) {
		super(status);
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	
	public String getStatus() {
		return this.status;
	}

}
