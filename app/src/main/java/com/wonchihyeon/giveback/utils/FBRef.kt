package com.wonchihyeon.giveback.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

// 파이어베이스 실시간 데이터베이스의 관련 설정을 위한 클래스
class FBRef {

    companion object {

        private val database = Firebase.database

        // Getboard 경로의 데이터베이스 경로를 선언 (습득물 게시판)
        val getboardRef = database.getReference("getboard")

        // LostBoard 경로의 데이터베이스 경로를 선언 (분실물 게시판)
        val lostboardRef = database.getReference("lostboard")

        // QnaBoard 경로의 데이터베이스 경로를 선언 (QnA 게시판)
        val qnaboardRef = database.getReference("qnaboard")

        // comment 경로의 데이터베이스 경로를 선언
        val commentRef = database.getReference("comment")

        // keyword 경로의 데이터베이스 경로를 선언
        val keywordRef= database.getReference("keyword")
    }
}