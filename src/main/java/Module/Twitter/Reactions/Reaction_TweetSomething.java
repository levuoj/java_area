package Module.Twitter.Reactions;

import Module.Interfaces.IActionData;
import Module.Interfaces.IReaction;
import twitter4j.Status;
import twitter4j.Twitter;

public class Reaction_TweetSomething extends IReaction {

    public Reaction_TweetSomething() {
        SetName("Reaction_PostTweet");
        SetDescription("Send a tweet in reaction to something");
    }

    private Twitter twitter;

    public Reaction_TweetSomething init(Twitter newTwitter) {
        twitter = newTwitter;
        return (this);
    }

    /**
     * Function treating the action of a IAction
     * @param data The data that contains the info to be transmitted
     */
    public void ReceiveAction(IActionData data) {
        try {
            Status status = twitter.updateStatus(data.getString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
