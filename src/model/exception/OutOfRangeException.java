package model.exception;

public class OutOfRangeException extends Exception {

	public OutOfRangeException(String m){
		System.out.println("OutOfRangeException : "+m);
	}
}
