package bhat.svbneelmane.coursecatalogservice.controllers
/**
 * Unit test
 * @author shivaprasad-bhat
 */
import bhat.svbneelmane.coursecatalogservice.services.GreetingsService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient


@WebMvcTest(controllers = [GreetingsController::class])
@AutoConfigureWebTestClient
class GreetingsControllersTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var greetingsServiceMock: GreetingsService

    @Test
    fun retrieveGreetings() {
        val name = "shivaprasad"

        every {
            greetingsServiceMock.retrieveGreeting(any())
        } returns "$name, Hello from default profile"

        val result = webTestClient.get()
            .uri("/v1/greetings/{name}", name)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody(String::class.java)
            .returnResult()

        Assertions.assertEquals("$name, Hello from default profile", result.responseBody)
    }
}