package io.hauer.demo.liquibase

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@SpringBootApplication
class App{
    @Bean
    fun logDb(repo: CiteRepo) = InitializingBean{
        LoggerFactory.getLogger(App::class.java).info("Db has {} entries", repo.count())
    }
}

fun main(args: Array<String>) {
    runApplication<App>(*args)
}

@Entity
@Table(name = "cite")
data class CiteEntity(@Id var id: Long? = null, var text: String?)
interface CiteRepo : JpaRepository<CiteEntity, Long>