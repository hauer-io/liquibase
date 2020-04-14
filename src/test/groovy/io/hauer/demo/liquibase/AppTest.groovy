package io.hauer.demo.liquibase

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class AppTest extends Specification {

    @Autowired
    CiteRepo repo

    def "repo has data"() {
        expect:
        repo.count() > 0
    }
}
