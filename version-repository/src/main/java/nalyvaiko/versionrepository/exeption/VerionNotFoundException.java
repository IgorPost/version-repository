package nalyvaiko.versionrepository.exeption;

public class VerionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9164941088825811720L;
	
	public VerionNotFoundException() {
        super();
    }
	
    public VerionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public VerionNotFoundException(String message) {
        super(message);
    }
    
    public VerionNotFoundException(Throwable cause) {
        super(cause);
    }

}
