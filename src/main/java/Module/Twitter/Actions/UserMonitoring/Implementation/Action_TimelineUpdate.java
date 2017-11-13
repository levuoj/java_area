package Module.Twitter.Actions.UserMonitoring.Implementation;

import Module.Twitter.Actions.Commons.ActionData.ActionData_NewTweet;
import Module.Twitter.Actions.UserMonitoring.Action_TwitterStream_User;
import Module.Twitter.Actions.UserMonitoring.TwitterListener_User;
import Module.Twitter.TwitterModule;
import Module.Twitter.TwitterModuleException;
import twitter4j.Status;
import twitter4j.TwitterStream;

public class Action_TimelineUpdate extends Action_TwitterStream_User {
    private class TwitterAdapter_TimelineUpdate extends TwitterListener_User {
        private Action_TimelineUpdate _action;

        TwitterAdapter_TimelineUpdate(Action_TimelineUpdate action) {
            _action = action;
        }

        @Override
        public void onStatus(Status status) {
            _action.SendDataToLinked(new ActionData_NewTweet(status, _action));
        }
    }

    public Action_TimelineUpdate() {
        SetName("Action_TimelineUpdated");
        SetDescription("Send the new tweet in your timeLine");
    }

    public Action_TimelineUpdate init(TwitterModule module) throws TwitterModuleException {
        super.init(module, new TwitterAdapter_TimelineUpdate(this));
        return (this);
    }
}
