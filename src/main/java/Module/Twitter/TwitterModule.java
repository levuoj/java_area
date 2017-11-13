package Module.Twitter;

import Module.Exception.ModuleException;
import Module.Interfaces.IAction;
import Module.Interfaces.IModule;

import java.util.List;
import java.util.Scanner;

import Module.Interfaces.IReaction;
import Module.Log.LogModule;
import Module.Twitter.Actions.UserMonitoring.Implementation.Action_HaveTweeted;
import Module.Twitter.Actions.UserMonitoring.Implementation.Action_NewFollower;
import Module.Twitter.Actions.UserMonitoring.Implementation.Action_TimelineUpdate;
import Module.Twitter.Reactions.Reaction_TweetSomething;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterModule extends IModule {
    private static String       ConsumerKey = "ulBOBXGB8Hf2EuuKBk0CPUzHr";
    private static String       ConsumerKeySecret = "AtBGoaNuDvNl69E2xUa8m8yEpiqmDjSo6vnXjRV84oaj1HF9J4";
    private ConfigurationBuilder    cb;
    private Configuration           config;
    private TwitterFactory          tf;
    private Twitter                 twitter;

    private TwitterStreamFactory    streamTf;

    private RequestToken            reqToken;
    private AccessToken             accessToken;

    public TwitterModule() throws TwitterException {
        _type = AuthenticatorType.OAuth;

    }

    /**
     * Init the Twitter4J Variables and all the
     *  Keep in constructor the value commons to all IModule
     * @return Contains this
     * @throws ModuleException Trowed if init is not implemented
     */
    @Override
    public IModule init() throws Exception {
        cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(ConsumerKey).setOAuthConsumerSecret(ConsumerKeySecret);
        config = cb.build();

        tf = new TwitterFactory(config);
        streamTf = new TwitterStreamFactory(config);

        twitter = tf.getInstance();

        reqToken = twitter.getOAuthRequestToken();
        accessToken = null;

        return (this);
    }

    /**
     * Return the OAuth Url
     * @return Contains the OAuth Url
     */
    @Override
    public  String GetOAuthURL() {
        return (reqToken.getAuthorizationURL());
    }

    /**
     * Your implementation of the OAuth login methods
     *  @param pin The pin for the connection
     *  @throws ModuleException Throw if not implemented
     *  @return Return true if connection is successful
     */
    @Override
    protected boolean _OAuthLogin(String pin) throws ModuleException {
        try {
            accessToken = twitter.getOAuthAccessToken(reqToken, pin);
            mainUser = twitter.showUser(twitter.getScreenName());

            _reactions.add(new Reaction_TweetSomething().init(twitter));

            _actions.add(new Action_HaveTweeted().init(this));
            _actions.add(new Action_TimelineUpdate().init(this));
            _actions.add(new Action_NewFollower().init(this));

            return (true);
        } catch (TwitterException te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            return (false);
        }
    }

    private User        mainUser;

    /**
     * Get the user connected to the account
     * @return Contains the user
     */
    public User             GetUser() { return (mainUser); }

    private TwitterStream   stream;
    private int             streamHolded = 0;
    private final Object    LOCK_STREAM_USER = new Object();

    /**
     * Get a good StreamTwitter with a account connected to it
     * @param listener Listener
     * @return Contains the streamTwitter
     */
    public TwitterStream requireANewStream(StatusListener listener) {
        synchronized (LOCK_STREAM_USER) {
            streamHolded += 1;

            if (streamHolded == 1) {
                stream = streamTf.getInstance();
                stream.setOAuthAccessToken(accessToken);
                stream.addListener(listener);
                stream.user(mainUser.getName());
            } else
                stream.addListener(listener);

            return (stream);
        }
    }

    /**
     * Free the hold of a Stream in a action
     * @param listener Listener
     */
    public void freeHoldOfAStream(StatusListener listener) {
       synchronized (LOCK_STREAM_USER) {
           streamHolded -= 1;

           stream.removeListener(listener);

           if (streamHolded <= 0) {
               if (stream != null)
                   stream.shutdown();
               stream = null;
               streamHolded = 0;
           }
       }
    }
}
