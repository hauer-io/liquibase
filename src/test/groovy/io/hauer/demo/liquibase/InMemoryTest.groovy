package io.hauer.demo.liquibase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class InMemoryTest extends Specification {

    @Autowired
    CiteRepo repo

    def "load test"() {
        expect:
        repo.count() == 4
    }
}
