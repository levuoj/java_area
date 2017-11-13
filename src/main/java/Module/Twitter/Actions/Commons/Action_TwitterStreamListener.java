package Module.Twitter.Actions.Commons;

import Module.Interfaces.IAction;
import Module.Twitter.Actions.UserMonitoring.TwitterListener_User;
import Module.Twitter.TwitterModule;
import Module.Twitter.TwitterModuleException;

public class Action_TwitterStreamListener extends IAction {
    protected TwitterModule             _module;
    protected TwitterListener_User      _listener;

    public Action_TwitterStreamListener init(TwitterModule module, TwitterListener_User listener) throws TwitterModuleException {
        _module = module;
        _listener = listener;
        return (this);
    }
}
