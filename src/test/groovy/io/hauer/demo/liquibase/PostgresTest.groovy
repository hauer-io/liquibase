package io.hauer.demo.liquibase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import spock.lang.Specification

@SpringBootTest
class PostgresTest extends Specification {

    private static DB_CONTAINER = new PostgreSQLContainer<>("postgres:12.2")

    @DynamicPropertySource
    static void dbProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", { DB_CONTAINER.getJdbcUrl() });
        registry.add("spring.datasource.username", { DB_CONTAINER.getUsername() });
        registry.add("spring.datasource.password", { DB_CONTAINER.getPassword() });
    }

    void setupSpec() {
        DB_CONTAINER.start()
    }

    void cleanupSpec() {
        DB_CONTAINER.stop()
    }

    @Autowired
    CiteRepo repo

    def "load test"() {
        expect:
        repo.count() == 4
    }
}
