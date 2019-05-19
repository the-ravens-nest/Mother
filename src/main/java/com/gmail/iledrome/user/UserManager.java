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
        return this.users.add(user);
    }

    public boolean removeUser(User user) {
        return this.users.remove(user);
    }

    public void clearUsers() {
        this.users.clear();
    }

    public User getUser(final Player player) {
        return this.users.stream().filter(user -> user.getPlayer().equals(player)).findFirst().orElse(null);
    }

}
