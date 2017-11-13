package Module.FB;

import Module.Exception.ModuleException;
import Module.FB.Reactions.PostPhoto;
import Module.FB.Reactions.GoogleSearch;
import Module.FB.Reactions.PublishStatus;
import Module.Interfaces.IModule;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

public class FaceBook extends IModule {

    Facebook _instance;
    String _token;

    public FaceBook() {
        _type = AuthenticatorType.OAuth;
    }

    @Override
    public IModule init() {
        _instance = new FacebookFactory().getInstance();

        _instance.setOAuthAppId("1464343446996105", "dec3cc47f07a3c047abb08fc44cc862b");
        _instance.setOAuthPermissions("email,user_friends");


        _token = "";
        return (this);
    }

    @Override
    protected boolean _OAuthLogin(String pin) throws ModuleException {
        _instance.setOAuthAccessToken(new AccessToken(pin, null));
        _reactions.add(new PublishStatus().init(this));
        _reactions.add(new GoogleSearch().init(this));
        _reactions.add(new PostPhoto().init(this));

        return (true);
    }

    public Facebook get_instance() {
        return _instance;
    }

    public void set_instance(Facebook _instance) {
        this._instance = _instance;
    }

    public String get_token() {
        return _token;
    }

    public void set_token(String _token) {
        this._token = _token;
    }
}
