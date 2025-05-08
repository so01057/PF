package com.zemnnni.user.service;

import com.zemnnni.user.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @작성자 : DATA
 * @파일명 : UserServiceImpl
 * @작성일 : 2025-05-07
 * @설명 :
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
