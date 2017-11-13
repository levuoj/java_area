package Module.Twitter.Actions.Commons.ActionData;

import Module.Interfaces.IAction;
import Module.Interfaces.IActionData;
import twitter4j.Status;

public class ActionData_NewTweet extends IActionData {
    private String          _text;
    private String          _destination;
    private String          _iaction;

    public ActionData_NewTweet(Status tweet, IAction action) {
        super(action);
        _text = tweet.getUser().getName() + " tweeted: " + tweet.getText();
        _destination = tweet.getUser().getName();
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
     * @return Contains the tweetos
     */
    @Override public String       getDestination() { return (_destination); }
}
