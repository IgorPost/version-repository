package nalyvaiko.versionrepository.exeption;

public class VersionAlreadyExistsException extends RuntimeException {
	
	private static final long serialVersionUID = -641827392958278213L;

	public VersionAlreadyExistsException() {
        super();
    }
	
    public VersionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public VersionAlreadyExistsException(String message) {
        super(message);
    }
    
    public VersionAlreadyExistsException(Throwable cause) {
        super(cause);
    }
	
}
