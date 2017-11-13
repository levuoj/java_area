package Module.Exception;

public class ModuleException extends Exception {
    /**
     * Contains the string of the message
     */
    protected String _message;
    public ModuleException(String msg) { _message = msg; }
    protected ModuleException() {}

    /**
     * Get the message of this exception
     * @return Contains the message of this exception
     */
    @Override
    public String getMessage() {
        return (_message);
    }
}
