package model.exception;

public class NullEntityException extends Exception {

	private String message="";
	
	public NullEntityException(String m){
		message="NullEntityException : "+m;
	}
	
	public String message(){
		return message;
	}
}
