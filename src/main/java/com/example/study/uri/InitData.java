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


        List<User> users = userRepository.findAll();
        users.forEach(it -> log.info(it.toString()));

    }

}
