package com.vuanhvu.blog.service;

import com.vuanhvu.blog.constant.Constants;
import com.vuanhvu.blog.entity.User;
import com.vuanhvu.blog.repository.UserRepository;
import com.vuanhvu.blog.auth.AuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getById(Integer id) {

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);

    }

    public User processOAuthPostLogin(String username, String provider) {
        User existUser = userRepository.getUserByUsername(username);

        if (existUser == null) {
            User newUser = new User();
            newUser.setUsername(username);
            if ("Google".equals(provider)) {
                newUser.setProvider(AuthenticationProvider.GOOGLE);
            } else {
                newUser.setProvider(AuthenticationProvider.FACEBOOK);
            }
            newUser.setCreateDatetime(new Date());
            newUser.setRole("user");
            newUser.setStatus(Constants.ACTIVE_STATUS);

            // TODO làm 1 bảng môi trường trên db
            newUser.setImgUrl("https://d1vego9xkjklqd.cloudfront.net/image/default-avartar.svg");

            existUser = userRepository.save(newUser);
        }

        return existUser;

    }

}
