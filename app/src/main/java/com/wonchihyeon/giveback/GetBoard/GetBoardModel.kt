package com.wonchihyeon.giveback.GetBoard

// 습득물 게시글의 데이터 구조를 정의
data class GetBoardModel (
    val uid: String  = "", // 습득자
    val email: String = "", // 습득자 이메일
    val title: String = "", // 습득물명
    val category: String = "", // 카테고리명
    val getDate: String = "", // 습득일자
    val getLocation: String = "", // 습득위치
    val getdetailLocation: String = "", // 상세 습득위치
    val keepLocation: String = "", // 보관위치
    val keepdetailLocation: String = "", // 상세 보관위치
    val content: String = "", // 상세 내용
)