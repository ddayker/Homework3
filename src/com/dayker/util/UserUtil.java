package com.dayker.util;

import com.dayker.domain.User;
import com.dayker.readResources.ReadUsersNameResources;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class UserUtil {


    public static ArrayList<User> generateListOfFriends(int numberOfFriends) {


        ArrayList<User> friends = new ArrayList<>();
        String resourceFileName = "usersNameInfo.txt";
        ReadUsersNameResources readUsersNameResources = new ReadUsersNameResources();

        ArrayList<User> allUserNames = readUsersNameResources.readUsersToArrayList(resourceFileName);

        for (int i = 0; i < numberOfFriends; i++) {

            User newFriend = allUserNames.get((int) (random() * allUserNames.size()));
            friends.add(new User(newFriend.getName(), newFriend.getSurname()));

        }

        return friends;
    }

    public static void generateFriendsOfFriends(List<User> friends, int numberOfFriends, int limitFlag) {

        final int limitValue = 0;

        for (User myFriends : friends) {
            ArrayList<User> randomFriends = UserUtil.generateListOfFriends(numberOfFriends);
            myFriends.setFriends(randomFriends);
            limitFlag--; //nesting level of friends
            if (limitFlag > limitValue)
                generateFriendsOfFriends(randomFriends, numberOfFriends, limitFlag);
        }
    }


    public static void printFriends(List<User> user) {

        int emptyListSize = 0;
        ArrayList<User> friendsOfFriends = new ArrayList<>();

        System.out.print("--> {");
        for (User friend : user) {
            System.out.print("( " + friend.getName() + " " + friend.getSurname() + " ) ");
            if (friend.getFriends() != null) {
                friendsOfFriends.addAll(friend.getFriends());
            }
        }
        System.out.print("}");
        if (friendsOfFriends.size() != emptyListSize) {
            printFriends(friendsOfFriends);
        }

    }
}








