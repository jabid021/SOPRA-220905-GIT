package exception;

public class PatientException extends RuntimeException{
	public PatientException(String message) {
		super(message);
	}
	
	public PatientException() {
		super();
	}
}
