package bhat.svbneelmane.coursecatalogservice.utils

import bhat.svbneelmane.coursecatalogservice.entity.Course

fun getCourseEntityList() = listOf(
    Course(null, "React", "web"),
    Course(null, "Java", "backend"),
    Course(null, "Angular", "web"),
    Course(null, "Kotlin", "android"),
)