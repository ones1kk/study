package com.example.study.uri;

import com.example.study.uri.model.Role;
import com.example.study.uri.model.User;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitData {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User admin = new User("admin@email.com", "1234", "관리자");
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        User test1 = new User("test1@email.com", "1234", "관리자");
        admin.setRole(Role.ADMIN);
        userRepository.save(test1);

        User test2 = new User("test2@email.com", "1234", "관리자");
        admin.setRole(Role.USER);
        userRepository.save(test2);

        User test3 = new User("test3@email.com", "1234", "관리자");
        admin.setRole(Role.USER);
        userRepository.save(test3);

        List<User> users = userRepository.findAll();
        users.forEach(it -> log.info(it.toString()));

    }

}
