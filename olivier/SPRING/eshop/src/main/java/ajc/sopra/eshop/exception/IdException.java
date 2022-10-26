package ajc.sopra.eshop.exception;

public class IdException extends RuntimeException{
	public IdException() {
		super("id inconnu");
	}
}
