package com.example.AuthBasic.repositories;

import com.example.AuthBasic.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestPropertySource(locations = "/application-test.properties")
public class UserRepositoryDataJpaTestIT {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void whenSaveUsername_thenReturnUser(){
        User user = createUser();
        entityManager.persist(user);
        entityManager.flush();

        User b = userRepository.save(user);
        assertThat(b.getUsername())
                .isEqualTo(user.getUsername());


    }
    @Test
    public void whenFindByUsername_thenReturnUser(){
        User user = createUser();
        entityManager.persist(user);
        entityManager.flush();

        User b = userRepository.findByUsername("Adrian").orElseThrow();
        assertThat(b.getUsername())
                .isEqualTo(user.getUsername());

    }


    private User createUser() {
        User user = new User();


        user.setUsername("Adrian");
        user.setPassword("dexter");
        return user;
    }
}
