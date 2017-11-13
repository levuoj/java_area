package Module.Twitter.Actions.UserMonitoring.Implementation;

import Module.Twitter.Actions.Commons.ActionData.ActionData_NewFollower;
import Module.Twitter.Actions.UserMonitoring.Action_TwitterStream_User;
import Module.Twitter.Actions.UserMonitoring.TwitterListener_User;
import Module.Twitter.TwitterModule;
import Module.Twitter.TwitterModuleException;
import twitter4j.TwitterStream;
import twitter4j.User;

public class Action_NewFollower extends Action_TwitterStream_User {
    private class TwitterAdapter_NewFollower extends TwitterListener_User {
        private Action_NewFollower _action;

        TwitterAdapter_NewFollower(Action_NewFollower action) {
            _action = action;
        }

        @Override
        public void onFollow(User user, User user1) {
            if (user1.getId() == _action.userToMonitor.getId()) {
                _action.SendDataToLinked(new ActionData_NewFollower(user, user1, _action));
            }
        }
    }

    public Action_NewFollower() {
        SetName("Action_NewFollower");
        SetDescription("Send you a notification when a new followers");
    }

    public Action_NewFollower init(TwitterModule module) throws TwitterModuleException {
        super.init(module, new TwitterAdapter_NewFollower(this));
        return (this);
    }
}
