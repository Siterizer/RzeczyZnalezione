package pl.znalezione.rzeczy.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.znalezione.rzeczy.entities.user.User;
import pl.znalezione.rzeczy.entities.user.enums.Roles;
import pl.znalezione.rzeczy.repositories.UserRepository;


@Component
@Slf4j
public class InitialData {

    private final UserRepository userRepository;

    @Autowired
    public InitialData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void addUsersToDB() {
        log.info("Persisted account data to database");

        userRepository.save(User.builder()
                .username("must1")
                .password("$2a$10$3g4oIfNqX51bvq7pICs1ReHex8tfb3Dp3eJ9U.MvrX.aPXF7folb6")//123
                .email("user@gmail.com")
                .phoneNumber("213702137")
                .roles(Roles.USER)
                .id_photo(1)
                .build());

        userRepository.save(User.builder()
                .username("must1")
                .password("$2a$10$UPRK/oWCc3e.yTb5TLvGG.CdJP8aGP6jNJH.LCtvQhgvigse83VZG")//admin
                .email("admin@gmail.com")
                .phoneNumber("213702137")
                .roles(Roles.USER)
                .id_photo(1)
                .build());
    }
}
