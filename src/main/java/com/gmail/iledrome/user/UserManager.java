package com.gmail.iledrome.user;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class UserManager {

    private Set<User> users;

    public UserManager() {
        this.users = new HashSet();
    }

    public boolean addUser(User user) {
        //TODO: Check if Null Pointer Exception is thrown when you call list#add(object).
        if (user == null || this.users.contains(user)) {
            return false;
        } else {
            this.users.add(user);
            return true;
        }
    }

    public boolean removeUser(User user) {
        //TODO: Check if Null Pointer Exception is thrown when you call list#remove(object).
        if (user == null || !this.users.contains(user)) {
            return false;
        } else {
            this.users.remove(users);
            return true;
        }
    }

    public void clearUsers() {
        this.users.clear();
    }

    public User getUser(final Player player) {
        return this.users.stream().filter(user -> user.getPlayer().equals(player)).findFirst().orElse(null);
    }

    //TODO: Not sure if this is needed, remove if not necessary.
    @Deprecated
    public User getUser(final String name) {
        return this.users.stream().filter(user -> user.getPlayer().getName().equals(name)).findFirst().orElse(null);
    }

}
