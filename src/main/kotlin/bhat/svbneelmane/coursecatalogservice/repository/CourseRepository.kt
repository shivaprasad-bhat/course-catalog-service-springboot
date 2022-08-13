package bhat.svbneelmane.coursecatalogservice.repository

import bhat.svbneelmane.coursecatalogservice.entity.Course
import org.springframework.data.repository.CrudRepository

/**
 * Repository implementing CrudRepository class
 * @author shivaprasad-bhat
 */
interface CourseRepository: CrudRepository<Course, Int> {

}