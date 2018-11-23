package be.technifutur.mobile.service;

import be.technifutur.mobile.domain.User;

public interface UserService {

    User register(String username, String password);

    boolean login(String username, String password);
}
