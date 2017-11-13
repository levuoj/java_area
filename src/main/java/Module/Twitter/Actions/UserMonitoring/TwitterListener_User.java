package Module.Twitter.Actions.UserMonitoring;

import twitter4j.*;

public class TwitterListener_User implements UserStreamListener {
    @Override public void onStatus(Status status) {/*System.out.println(status.getUser().getName() + " : " + status.getText());*/}

    @Override public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) { }

    @Override public void onTrackLimitationNotice(int i) { }

    @Override public void onScrubGeo(long l, long l1) { }
    @Override public void onStallWarning(StallWarning stallWarning) {/*System.out.println("StallWarning: " + stallWarning.getMessage());*/}
    @Override public void onDeletionNotice(long l, long l1) { }

    @Override public void onFriendList(long[] longs) { }

    @Override public void onFavorite(User user, User user1, Status status) {/*System.out.println("Favorite: " + user.getName() + ": " + user1.getName() + " tweet: " + status.getText());*/}
    @Override public void onUnfavorite(User user, User user1, Status status) {/*System.out.println("UnFavorite: " + user.getName() + ": " + user1.getName() + " tweet: " + status.getText());*/}

    @Override public void onFollow(User user, User user1) {/*System.out.println(user.getName() + ": follow " + user1.getName());*/}
    @Override public void onUnfollow(User user, User user1) {/*System.out.println(user.getName() + ": unfollow " + user1.getName());*/}

    @Override public void onDirectMessage(DirectMessage directMessage) {/*System.out.println(directMessage.getSender().getName() + ": send to " + directMessage.getRecipient().getName() + " a message: " + directMessage.getText());*/}

    @Override public void onUserListMemberAddition(User user, User user1, UserList userList) { }
    @Override public void onUserListMemberDeletion(User user, User user1, UserList userList) { }
    @Override public void onUserListSubscription(User user, User user1, UserList userList) { }
    @Override public void onUserListUnsubscription(User user, User user1, UserList userList) { }
    @Override public void onUserListCreation(User user, UserList userList) { }
    @Override public void onUserListUpdate(User user, UserList userList) { }
    @Override public void onUserListDeletion(User user, UserList userList) { }
    @Override public void onUserProfileUpdate(User user) { }

    @Override public void onUserSuspension(long l) { }
    @Override public void onUserDeletion(long l) { }

    @Override public void onBlock(User user, User user1) {/*System.out.println(user.getName() + ": blocked " + user1.getName());*/}
    @Override public void onUnblock(User user, User user1) {/*System.out.println(user.getName() + ": unblocked " + user1.getName());*/ }

    @Override public void onRetweetedRetweet(User user, User user1, Status status) {/*System.out.println(user.getName() + ": retweeted " + user1.getName() + " retweet: " + status.getText());*/}
    @Override public void onFavoritedRetweet(User user, User user1, Status status) {/*System.out.println(user.getName() + ": favorite " + user1.getName() + " retweet: " + status.getText());*/}
    @Override public void onQuotedTweet(User user, User user1, Status status) { /*System.out.println(user.getName() + ": quoted " + user1.getName() + " tweet: " + status.getText());*/}

    @Override
    public void onException(Exception e) {
        System.err.println("TwitterListener_User: " + e.getMessage());
        e.printStackTrace();
    }
}
