package Module.Twitter;

import Module.Exception.ModuleException;

public class TwitterModuleException extends ModuleException {

    public TwitterModuleException(String msg) {
        _message = "TwitterModule Exception: " + msg;
    }
}
