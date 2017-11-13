package Module.Interfaces;

import Module.Exception.ModuleException;

public class IReaction extends IItem {
    /**
     * Function treating the action of a IAction
     * @param data The data that contains the info to be transmitted
     * @throws ModuleException Throw if it's not implemented
     */
    public void ReceiveAction(IActionData data) throws ModuleException {
        throw new ModuleException("No overload of: ReceiveAction(IActionData) in " + this.toString());
    }
}
