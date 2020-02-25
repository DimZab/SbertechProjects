package socialnetwork.friends;

import socialnetwork.users.User;

import java.util.List;

public interface IFriendsStorage {
    List<User> getFriends(long userid);
}