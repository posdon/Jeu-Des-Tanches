package model.exception;

public class OutOfRangeException extends Exception {

	private String message;
	
	public OutOfRangeException(String m){
		message="OutOfRangeException : "+m;
	}
	
	public String message(){
		return message;
	}
}
