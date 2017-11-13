package Module.Interfaces;

import Module.Exception.ModuleException;

import java.util.ArrayList;

public class IAction extends IItem {
    /**
     * Contains all the IReaction linked to this IAction
     */
    ArrayList<IReaction>    _linked;

    public IAction() {
        _linked = new ArrayList<IReaction>();
    }

    /**
     *  Link to this IAction an IReaction
     *  @param reaction The Reaction to be linked to this action
     *
     *  @throws ModuleException Trowed if the reaction can't be added to the list
     */
    public void LinkTo(IReaction reaction) throws ModuleException {
        if (!_linked.add(reaction))
            throw new ModuleException(this.toString() + ": Can't link :" + reaction.toString());
        if (_linked.size() == 1)
            Activate();
    }

    /**
     * Activate the module once someone is listening
     * @throws ModuleException Throw if not implemented
     */
    protected void Activate() throws ModuleException {
        throw new ModuleException("No overload of: Activate() in " + this.toString());
    }

    /**
     * Unlink from this IAction an IReaction
     *  @param reaction The Reaction to be unlinked to this action
     *
     *  @throws ModuleException Throw if the reaction can't be removed from the list
     */
    public void UnlinkFrom(IReaction reaction) throws ModuleException {
        if (_linked.size() == 0)
            return ;

        if (!_linked.remove(reaction))
            throw new ModuleException(this.toString() + ": Can't unlink :" + reaction.toString());
        if (_linked.size() == 0)
            Desactivate();
    }

    /**
     * Deactivate the module once everyone is unlinked
     * @throws ModuleException Throw if not implemented
     */
    protected void Desactivate() throws ModuleException {
        throw new ModuleException("No overload of: Desactivate() in " + this.toString());
    }

    /**
     *  @param data The data to give to to the linked reaction
     *  @see IReaction
     */
    protected void SendDataToLinked(IActionData data) {
        for (IReaction reaction : _linked) {
            try {
                reaction.ReceiveAction(data);
            } catch (Exception e) {
                System.err.println("SendDataToLinked throw a exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
