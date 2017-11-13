package Module.Twitter.Actions.Commons.ActionData;

import Module.Interfaces.IAction;
import Module.Interfaces.IActionData;
import twitter4j.DirectMessage;
import twitter4j.Status;

public class ActionData_NewMessage extends IActionData {
    private String          _text;
    private String          _destination;

    public ActionData_NewMessage(DirectMessage message, IAction action) {
        super(action);
        _text = message.getSender().getName() + " send you: " + message.getText();
        _destination = message.getSender().getName();
    }

    /**
     * Get the data in string
     * @return Contains the string
     */
    @Override public String       getString() {
        return (_text);
    }

    /**
     * Get the destination of this action
     * @return Contains the sender
     */
    @Override public String       getDestination() { return (_destination); }
}
