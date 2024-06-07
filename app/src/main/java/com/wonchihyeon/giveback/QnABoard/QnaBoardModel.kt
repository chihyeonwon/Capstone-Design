package com.wonchihyeon.giveback.QnABoard

// 게시글의 데이터 구조를 정의
data class QnaBoardModel (
    val uid: String ="",
    val email: String = "",
    val title: String = "",
    val content: String = "",
    val status: String = ""
)