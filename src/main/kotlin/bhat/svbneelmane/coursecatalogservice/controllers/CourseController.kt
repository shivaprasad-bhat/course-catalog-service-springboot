package bhat.svbneelmane.coursecatalogservice.controllers

import bhat.svbneelmane.coursecatalogservice.dto.CourseDTO
import bhat.svbneelmane.coursecatalogservice.services.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {

    /**
     * Request - POST
     * Controller function that adds a new course to database
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDTO): CourseDTO {
        return courseService.addCourse(courseDTO)
    }

    @GetMapping
    fun getAllCourses(): List<CourseDTO> = courseService.getAllCourses()
}