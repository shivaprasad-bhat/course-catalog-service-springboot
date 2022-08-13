package bhat.svbneelmane.coursecatalogservice.entity

import bhat.svbneelmane.coursecatalogservice.dto.CourseDTO
import javax.persistence.*

@Entity
@Table(name = "Courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    val name: String,
    val category: String
) {
    fun toCourseData() = CourseDTO(
        id, name, category
    )
}