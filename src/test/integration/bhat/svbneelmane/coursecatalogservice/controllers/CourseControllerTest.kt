package bhat.svbneelmane.coursecatalogservice.controllers

/**
 * Integration test for Course Controller
 * @author shivaprasad-bhat
 */
import bhat.svbneelmane.coursecatalogservice.dto.CourseDTO
import bhat.svbneelmane.coursecatalogservice.repository.CourseRepository
import bhat.svbneelmane.coursecatalogservice.utils.getCourseEntityList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setUp() {
        courseRepository.deleteAll()
        val courses = getCourseEntityList()
        courseRepository.saveAll(courses)
    }

    /**
     * Function to test the add course POST endpoint
     */
    @Test
    fun addCourseTest() {
        val course = CourseDTO(null, "SpringBoot", "Java")
        val savedCourse = webTestClient.post()
            .uri("/v1/courses")
            .bodyValue(course)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertTrue(savedCourse?.id != null)
    }

    @Test
    fun getAllCoursesTest() {
        val allCourses = webTestClient.get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals(4, allCourses?.size)
    }
}