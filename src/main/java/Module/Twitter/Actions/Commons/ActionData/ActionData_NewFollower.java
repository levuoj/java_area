package Module.Twitter.Actions.Commons.ActionData;

import Module.Interfaces.IAction;
import Module.Interfaces.IActionData;
import twitter4j.DirectMessage;
import twitter4j.User;

public class ActionData_NewFollower extends IActionData {
    private String          _text;
    private String          _destination;

    public ActionData_NewFollower(User follower, User following, IAction action) {
        super(action);
        _text = follower.getName() + " follow now: " + following.getName();
        _destination = follower.getName();
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
     * @return Contains the followers
     */
    @Override public String       getDestination() { return (_destination); }
}
