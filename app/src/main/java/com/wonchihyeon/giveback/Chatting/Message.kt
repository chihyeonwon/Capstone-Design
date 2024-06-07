package com.wonchihyeon.giveback.Chatting

data class Message(
    var message: String?, // 메시지
    var sendId: String?, // 보낸 사람의 uid
    var receiveId: String?, // 받는 사람의 uid
    var sendEmail: String?,
    var time: String, // 보낸 시간
){
    constructor():this("","", "","", "")
}