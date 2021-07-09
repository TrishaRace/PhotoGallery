package com.trisharace.generalgallery.models.entity

data class UserEntity(
    val username: String?
) {

    fun toUserEntity() = UserEntity(username)
}