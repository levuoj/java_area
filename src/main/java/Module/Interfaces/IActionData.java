package Module.Interfaces;

import Module.Exception.ModuleException;

public class IActionData {
    private String _iactionName;

    public IActionData(IAction action) {
        _iactionName = action.Name();
    }

    /**
     * Get the IAction original
     * @return Contains the kind of IAction
     */
    public String       getIAction() {
        return (_iactionName);
    }

    /**
     * Get the data in string
     * @return Contains the string
     * @throws ModuleException Throw if the function is not implemented
     */
    public String       getString() throws ModuleException {
        throw new ModuleException("No overload of: getString() in " + this.toString());
    }

    /**
     * Get the destination of this action
     * @return Contains the destination in string
     * @throws ModuleException Throw if the function is not implemented
     */
    public String       getDestination() throws ModuleException {
        throw new ModuleException("No overload of: getDestination() in " + this.toString());
    }
}
