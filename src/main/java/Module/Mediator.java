package Module;

import Module.FB.FaceBook;
import Module.Interfaces.IAction;
import Module.Interfaces.IModule;
import Module.Interfaces.IReaction;
import Module.Twitter.TwitterModule;

import java.util.ArrayList;
import java.util.Map;

public class Mediator {
    public ArrayList<IModule>   modules = new ArrayList<IModule>();
    private TwitterModule       twitterModule;
    private FaceBook            facebookModule;

    private boolean             twitterBool = false;
    private boolean             FBBool = false;

    private ArrayList<IAction>      _actions = new ArrayList<IAction>();
    private ArrayList<IReaction>    _reactions = new ArrayList<IReaction>();
    private ArrayList<String>       _reactName = new ArrayList<String>();
    private ArrayList<String>       _actName = new ArrayList<String>();

    public Mediator() throws Exception {
        twitterModule = new TwitterModule();
        facebookModule = new FaceBook();
        modules.add(twitterModule.init());
        modules.add(facebookModule.init());
    }

    public void addReactName(String name)
    {
        _reactName.add(name);
    }

    public void addActName(String name)
    {
        _actName.add(name);
    }

    public ArrayList<String> getReactName()
    {
        return _reactName;
    }

    public ArrayList<String> getActName()
    {
        return _actName;
    }

    public void initList()
    {
        initActionsList();
        initReactionsList();
    }

    private void initActionsList()
    {
        int x;
        for (IModule module : modules)
        {
            x = 0;
            for (IAction action : module.getActions())
            {
                _actions.add(action);
                x++;
            }
        }
    }

    private void initReactionsList()
    {
        int x;
        for (IModule module : modules)
        {
            x = 0;
            for (IReaction reaction : module.getReactions())
            {
                _reactions.add(reaction);
                x++;
            }
        }
    }

    public ArrayList<IAction> getActions()
    {
        return _actions;
    }

    public ArrayList<IReaction> getReactions()
    {
        return _reactions;
    }

    public void AddNewModule(IModule module) {
        try {
            modules.add(module.init());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean initModule(String module, Map<String, String[]> param)
    {
        try {
            switch (module) {
                case ("Twitter"):
                        return (twitterModule.OAuthLogin(param.get("oauth_verifier")[0]));

                case ("Facebook"):
                    return (facebookModule.OAuthLogin(param.get("accessToken")[0]));
                    default:
                        return (false);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return (false);
        }
    }

    public boolean isTwitterBool() {
        return twitterBool;
    }

    public void setTwitterBool(boolean twitterBool) {
        this.twitterBool = twitterBool;
    }

    public boolean isFBBool() {
        return FBBool;
    }

    public void setFBBool(boolean FBBool) {
        this.FBBool = FBBool;
    }

    public boolean checkBools() {
        return (this.FBBool && this.twitterBool);
    }

    public ArrayList<IModule> getModules() {
        return modules;
    }

    public TwitterModule getTwitterModule() {
        return twitterModule;
    }

    public FaceBook getFacebookModule() {
        return facebookModule;
    }
}