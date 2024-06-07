package com.wonchihyeon.giveback.LostBoard

// 분실물 게시글의 데이터 구조를 정의
data class LostBoardModel (
    val uid: String  = "", // 분실자
    val email: String = "", // 분실자 이메일
    val title: String = "", // 분실물명
    val category: String = "", // 카테고리명
    val lostDate: String = "", // 분실일자
    val lostLocation: String = "", // 분실위치
    val lostdetailLocation: String = "", // 상세 분실위치
    val content: String = "", // 상세 내용
)