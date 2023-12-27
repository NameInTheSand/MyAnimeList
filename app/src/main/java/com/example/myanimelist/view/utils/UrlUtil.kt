package com.example.myanimelist.view.utils

object UrlUtil {

    private val urls = listOf(
        "https://assets-prd.ignimgs.com/2022/08/17/24-vash-1660778366361.jpg",
        "https://assets-prd.ignimgs.com/2022/08/17/23-lelouch-lamperouge-1660778366362.jpg",
        "https://assets-prd.ignimgs.com/2022/08/17/22-light-yagami-1660778366362.jpg",
        "https://assets-prd.ignimgs.com/2022/08/17/21-dio-1660778366362.jpeg",
        "https://assets-prd.ignimgs.com/2022/08/17/20-gon-1660778366362.jpeg",
        "https://assets-prd.ignimgs.com/2022/08/17/18-levi-ackerman-1660778366362.jpeg",
    )

    fun getRandomUrl(): String {
        return urls.random()
    }

}