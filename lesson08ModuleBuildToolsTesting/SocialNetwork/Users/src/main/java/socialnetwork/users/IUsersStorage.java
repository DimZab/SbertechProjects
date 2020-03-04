package ru.sbertech.javaschoolrnd.d1zab.SocialNetwork.Users.src.main.java.socialnetwork.users;

public interface IUsersStorage {
    User getUser(long id);
    void putUser(User user);
}
