package com.DailyDash.AccountManagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DashUserRepositoryTest {

    @Autowired
    private final DashUserRepository dashUserRepository;

    public DashUserRepositoryTest(DashUserRepository dashUserRepository) {
        this.dashUserRepository = dashUserRepository;
    }


}
