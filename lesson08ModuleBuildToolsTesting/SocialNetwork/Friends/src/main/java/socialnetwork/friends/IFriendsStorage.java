package ru.sbertech.javaschoolrnd.d1zab.SocialNetwork.Friends.src.main.java.socialnetwork.friends;

import ru.sbertech.javaschoolrnd.d1zab.lesson08ModuleBuildToolsTesting.SocialNetwork.Users.src.main.java.socialnetwork.users.User;

import java.util.List;

public interface IFriendsStorage {
    List<User> getFriends(long userid);
}