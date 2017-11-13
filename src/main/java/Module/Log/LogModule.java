package Module.Log;

import Module.Interfaces.IModule;
import Module.Log.Reaction.Reaction_WriteInLog;

public class LogModule extends IModule {
    public LogModule() {
        _type = AuthenticatorType.Nothing;
    }

    /**
     * Init the inner variable from this module
     *  Keep in constructor the value commons to all IModule
     * @return Contains this
     */
    public IModule init() throws Exception {
        _reactions.add(new Reaction_WriteInLog());
        return (this);
    }
}
