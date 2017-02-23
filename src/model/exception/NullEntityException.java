package model.exception;

public class NullEntityException extends Exception {

	public NullEntityException(String m){
		System.out.println("NullEntityException : "+m);
	}
}
