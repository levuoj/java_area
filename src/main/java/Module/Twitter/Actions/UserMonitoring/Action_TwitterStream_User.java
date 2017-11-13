package Module.Twitter.Actions.UserMonitoring;

import Module.Exception.ModuleException;
import Module.Twitter.Actions.Commons.Action_TwitterStreamListener;
import Module.Twitter.TwitterModule;
import Module.Twitter.TwitterModuleException;
import twitter4j.TwitterStream;
import twitter4j.User;

public class Action_TwitterStream_User extends Action_TwitterStreamListener {
    private TwitterStream   _stream;
    protected User          userToMonitor;

    public Action_TwitterStreamListener init(TwitterModule module, TwitterListener_User listener) throws TwitterModuleException {
        super.init(module, listener);

        userToMonitor = module.GetUser();
        return (this);
    }


    /**
     * Activate the module once someone is listening
     */
    @Override
    protected void Activate() throws ModuleException {
        _stream = _module.requireANewStream(_listener);
    }

    /**
     * Deactivate the module once everyone is unlinked
     */
    @Override
    protected void Desactivate() {
        _stream = null;
        _module.freeHoldOfAStream(_listener);
    }

}
