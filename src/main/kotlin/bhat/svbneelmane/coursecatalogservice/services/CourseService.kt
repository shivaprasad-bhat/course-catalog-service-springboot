package bhat.svbneelmane.coursecatalogservice.services

/**
 * Service that performs operations w.r.t courses
 * @author shivaprasad-bhat
 */
import bhat.svbneelmane.coursecatalogservice.dto.CourseDTO
import bhat.svbneelmane.coursecatalogservice.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    // Logger
    companion object : KLogging()

    /**
     * Function that adds a course into database
     * @param courseDTO Course DTO Object
     * @return inserted course data
     */
    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        val entity = courseDTO.toEntity()
        courseRepository.save(entity)
        logger.info("Saved course: $entity")
        return entity.toCourseData()
    }
}