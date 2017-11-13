package Module.Twitter.Actions.UserMonitoring.Implementation;

import Module.Twitter.Actions.Commons.ActionData.ActionData_NewTweet;
import Module.Twitter.Actions.UserMonitoring.Action_TwitterStream_User;
import Module.Twitter.Actions.UserMonitoring.TwitterListener_User;
import Module.Twitter.TwitterModule;
import Module.Twitter.TwitterModuleException;
import twitter4j.*;

public class Action_HaveTweeted extends Action_TwitterStream_User {
    private class TwitterAdapter_ReceiveTweet extends TwitterListener_User {
        private Action_HaveTweeted _action;

        TwitterAdapter_ReceiveTweet(Action_HaveTweeted action) {
            _action = action;
        }

        @Override
        public void onStatus(Status status) {
            if (_action.userToMonitor.getId() == status.getUser().getId()) {
                _action.SendDataToLinked(new ActionData_NewTweet(status, _action));
            }
        }
    }

    public Action_HaveTweeted() {
        SetName("Action_YouTweeted");
        SetDescription("Send your new tweet");
    }

    public Action_HaveTweeted init(TwitterModule module) throws TwitterModuleException {
        super.init(module, new TwitterAdapter_ReceiveTweet(this));
        return (this);
    }
}
