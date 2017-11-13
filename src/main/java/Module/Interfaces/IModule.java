package Module.Interfaces;

import Module.Exception.ModuleException;

import java.util.ArrayList;
import java.util.List;

public class IModule {

    /**
     * Contains all the IAction of this module
     *  Must be filled by your implementation
     */
    protected ArrayList<IAction>      _actions;

    /**
     * Contains all the IReaction of this module
     *  Must be filled by your implementation
     */
    protected ArrayList<IReaction>    _reactions;
    private boolean                   _logged = false;

    public IModule()
    {
        _actions = new ArrayList<IAction>();
        _reactions = new ArrayList<IReaction>();
        _logged = false;
    }

    /**
     * Init the inner variable from this module
     *  Keep in constructor the value commons to all IModule
     * @return Contains this
     * @throws ModuleException Trowed if init is not implemented
     */
    public IModule init() throws Exception {
        throw new ModuleException("No overload of: init() in " + this.toString());
    }
    /**
     * Get the actions list
     *  @return Get the list of actions of this module
     */
    public List<IAction> getActions() { return (_actions); }

    /**
     * Get the reactions list
     *  @return Get the list of reactions of this module
     */
    public List<IReaction> getReactions() { return (_reactions); }

    /**
     * Define the type of Authenfication needed for this module
     */
    public enum AuthenticatorType {
        OAuth,
        Classical,
        Nothing
    }

    /**
     * Value to be fill in your implementation
     */
    protected AuthenticatorType         _type;

    /**
     * Get the Authenticator type of the module
     * @return Contains the Authenticator
     */
    public AuthenticatorType AuthenticatorType() { return (_type); }

    /**
     * Get the status of connections
     *  @return Return if the Module is connected to a accounts
     */
    public boolean isLogged() { return (_type.equals(AuthenticatorType.Nothing) || _logged); }

    /**
     * Login the users with a account / password combination
     *  @param name The username/email for the connection
     *  @param pass The password for the connection
     *  @throws ModuleException Throw if _Login not implemented
     *  @return Return true if connection is successful
     */
    public boolean Login(String name, String pass) throws ModuleException {
        if (!isLogged() && _type.equals(AuthenticatorType.Classical))
            _logged = _Login(name, pass);
        return (_logged);
    }

    /**
     * Login the users with a OAuth method
     *  @param pin The pin from the connnection
     *  @throws ModuleException Throw if _Login not implemented
     *  @return Return true if connection is successful
     */
    public boolean OAuthLogin(String pin) throws ModuleException {
        if (!isLogged() && _type.equals(AuthenticatorType.OAuth))
            _logged = _OAuthLogin(pin);
        return (_logged);
    }
    /**
     * Your implementation of the login methods
     *  @param name The username/email for the connection
     *  @param pass The password for the connection
     *  @throws ModuleException Throw if not implemented
     *  @return Return true if connection is successful
     */
    protected boolean _Login(String name, String pass) throws ModuleException {
        throw new ModuleException("No overload of: _Login(String, String) in " + this.toString());
    }

    /**
     * Your implementation of the OAuth login methods
     *  @param pin The pin for the connection
     *  @throws ModuleException Throw if not implemented
     *  @return Return true if connection is successful
     */
    protected boolean _OAuthLogin(String pin) throws ModuleException {
        throw new ModuleException("No overload of: _OAuthLogin(String) in " + this.toString());
    }

    /**
     * Return the OAuth Url
     * @return Contains the OAuth Url
     * @throws ModuleException Throw if not implemented or if not a OAuth module
     */
    public String GetOAuthURL() throws ModuleException {
        if (!_type.equals(AuthenticatorType.OAuth))
            throw new ModuleException("This Module isn't a OAuthentication module: " + this.toString());

        throw new ModuleException("No overload of: GetOAuthURL() in " + this.toString());
    }
}
