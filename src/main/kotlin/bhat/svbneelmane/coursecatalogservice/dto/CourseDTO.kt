package bhat.svbneelmane.coursecatalogservice.dto

import bhat.svbneelmane.coursecatalogservice.entity.Course

data class CourseDTO(
    val id: Int?,        // Nullable, auto generated
    val name: String,
    val category: String
) {
    fun toEntity() = Course(id, name, category)
}
