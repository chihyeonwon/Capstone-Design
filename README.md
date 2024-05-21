***
# 돌려드림 캡스톤 디자인 프로젝트

## 누군가에겐 그저 단순한 물건일지라도 누군가에겐 추억이 담긴 무엇보다도 소중한 물건입니다.
그 소중한 추억을 주인에게 돌려드릴 수 있도록 컴퓨터공학과 6인이 돌려드림 어플을 개발하게 되었습니다. 
</br>

[![All Collaborators](https://img.shields.io/badge/all_Collaborators-6-orange.svg)](#Collaborators)
</br>

## 목차
- [소개](#소개)
- [기존 사례 분석](#기존-사례-분석)
  - [기존 서비스의 문제점](#기존-서비스의-문제점)
  - [이번 프로젝트에서 개선할 점](#이번-프로젝트에서-개선할-점)
- [컴포넌트](#컴포넌트)
- [주기능](#주기능)
  - [프론트엔드](#프론트엔드)
    - [회원가입 및 로그인](#회원가입-및-로그인)
    - [메인페이지](#메인페이지)
    - [돌려드림 분실물 조회 페이지](#돌려드림-분실물-조회-페이지)
  - [백엔드](#백엔드)
    - [회원가입 및 로그인](#회원가입-및-로그인)
- [Collaborators](#Collaborators)
***

## 소개

> 기존 유실물 찾기 서비스의 불편함을 해소하고 개선하고자, 습득자는 유실물을 간편하게 등록하고 분실자는 간단한 인증을 통해 유실물을 찾아가고자 본 서비스를 고안하게 되었습니다.

</br>

## 기존 사례 분석


### 기존 서비스의 문제점

1. 회원가입, 로그인 유효성 검사 기능의 부재
2. 경찰서 마다 카테고리별 지칭명이 서로 달라 찾는데 어려움
3. 잃어버린 물건을 찾으러 경찰서에 방문 필수
4. 게시물마다 일부 정보의 부재(사진, 물품명, 보관장소 등)
6. 경찰관들이 분실물을 수동으로 정보를 기입해야하는 문제

### 이번 프로젝트에서 개선할 점

1. 회원가입, 로그인 기능 강화 및 보안성 강화
2. 습득물건을 사용자가 자발적으로 신고 후 직접 찾을 수 있도록 기능 개선
3. 분류된 결과를 자동으로 기입하여 편의성 개선

</br></br>

***
# 컴포넌트
- Firebase Authentication
- Firebase Realtime Database
- Firebase FireStore
- Firebase Storage
- Firebase Cloud Messaging
- Firebase Dynamic Links
- 
- **Device**
  - Android

***
# 주기능

## 프론트엔드(FrontEnd)

### 회원가입 및 로그인

</br>

>개인 정보 제공 동의 후 회원가입이 가능하며,  
모든 동의를 받으면 회원가입 페이지로 진입할 수 있습니다.  

</br></br>

</br>

>회원가입 진행시 유효성 검사를 실시간으로 진행하며, 
모든 유효성 검사를 충족시 회원가입을 진행합니다.
회원가입 시 학교 이메일로 이메일 인증을 진행합니다.

</br></br>
</br>

>회원가입시 가입한 이메일로 이메일 인증 메일이 전송됩니다.  
해당 메일에서 인증을 진행하여야 본 서비스를 이용하실 수 있습니다.

</br></br>

### 메인페이지

<p align="center">
  
</p>
</br>

> 메인페이지에서는 습득물과 분실물을 볼 수 있는 게시판을 제공합니다.

<p align="center">
</p>


</br></br>

### 돌려드림 분실물 조회 페이지
<p align="center">

</p>
</br>
<p align="center">

</p>
</br>

>돌려드림 서비스에 자동 분류되어 업로드된 분실물들의 목록을 볼 수 있습니다. 
해당 게시물을 클릭하면 상세 정보를 볼 수 있으며, 작성자의 경우 수정 및 삭제가 가능합니다. 

</br>

</br></br>

### 돌려드림 분실물 등록
<p align="center">

</p>
</br>


***
## 백엔드(BackEnd)


### 회원가입 및 로그인
<p align="center">

</br>

</br>

# Collaborators
<table>
</tr>
  <tr>
    </td>
    <td align="center">
  <a href="https://github.com/chihyeonwon">
    <img src="markdown/ljh.jpg" width="100px;" alt=""/>
    원치현<br>
    PM, Back End
  </a>
    </td>
    <td align="center">
  <a href="https://github.com/doncici77">
    <img src="markdown/ljh.jpg" width="100px;" alt=""/>
    박광호<br>
    Back End
  </a>
  <tr>
    <td align="center">
  <a href="https://github.com/Heestroy-118">
    <img src="markdown/ljh.jpg" width="100px;" alt=""/>
    문재희<br>
    Front End
  </a>
</td>
    <td align="center">
  <a href="https://github.com/HwanHee927">
    <img src="markdown/ljh.jpg" width="100px;" alt=""/>
    정환희<br>
    Front End
  </a>
</td>
    </td>
    </td>
    <td align="center">
  <a href="https://github.com/youngmumi">
    <img src="markdown/ljh.jpg" width="100px;" alt=""/>
    김유정<br>
    Back End
  </a>  
</td>
  </td>
    </td>
    <td align="center">
  <a href="https://github.com/jin0792">
    <img src="markdown/ljh.jpg" width="100px;" alt=""/>
    소진오<br>
    Back End
  </a>
</td>
  <tr>
  </tr>
<table>

## 3월 28일 팀회의 피드백
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/372bfaf1-415c-4c59-83e2-fb9330eb499f)
```
검색 결과 - 사진으로 블록형식으로 여러 개 보일 수 있게
-> gridView의 형태로 사진으로 여러 개를 보여줄 수 있게끔 수정한다.

물건등록 페이지 - 사진을 찍어서 올리는 기능, 사진 가져오는 기능
-> 사진을 찍어서 올리는 기능, 가져오는 기능을 드랍 메뉴의 형태로 구현, 사진을 여러 개를 추가할 수 있는 기능을 구현,
AI기능을 이용하여 여러 개의 사진을 분석하여 물건이 어떤 물건인지 파악하는 데 입력값으로 이용될 수가 있다.

지도 api 기능은 과할 수도 있다
-> 물건 등록 페이지의 지도 api 기능을 빼고 단순히 위치만을 입력하게 한다.

보관장소 입력 시 굳이 채팅 기능이 필요 하지 않을 수 있다.
보관장소 입력 안 할 시 채팅 기능이 필요 할 수도 있다.

물품명을 카테고리 시 - 등록 갯수 상위 5개 (자주 잃어버리는 물품) 나머지는 그냥 기타 로 구현하는 방법

기능 정의서 작성
```
[원주캠퍼스 지도의 건물](https://www.gwnu.ac.kr/newCampusMap/kr/view.do)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/b6cf8e7a-a1da-4cf9-8de6-24fcb000fa8e)
```
실제 지도에 있는 건물들의 명칭 데이터를 분실물 데이터베이스 Ref의 값(프로퍼티)들로 지정한다.
W1~W16, E1~E5
```
## 
```
UI 설계 수정 - 분실자가 글을 쓰는 인터페이스 없음-알림기능을 위해서 필요
```
## 4월 3일 회의 
```
<UI 수정사항>

● 처음 먼저 등록한 사진은 대표사진으로 추가됨 (안내 문구 추가)
→ 사진 여러장 등록 가능 
● 지도 보류 (학교 홈페이지 참고) api를 쓸 것인가? 지도를 빼고 드롭다운으로 수정
● 지도 도움말 버튼을 클릭 시 웹뷰 
● 상세 위치보단 추가 입력 사항으로 변경 ?
● 지도 상세위치 → 장소클릭+상세위치(과사, 화장실, 201호 등등) 
= W6 과학기술대학 남자 화장실 
● 사용자명 수정
● 검색 결과 분실물과 습득물 , 둘다 나오게 체크박스 추가
● 검색결과에서 습득물명과 분실물명 가시성 높이도록 수정
● 관리번호 쓸것인가
● 분실일자 시간 설정하는 것 삭제
● 습득물명에서 카테고리 한 번 더 쓰는걸로 하는게 좋을 것같다
● 습득물명 분류를 좀 더 포괄적으로 
ex) 금전 = 지갑+카드+현금+기타, 전자기기 = 핸드폰+컴퓨터+기타
● 키워드 알림 ex) 이어폰을 키워드 알림 설정하면 이어폰에 대한 새로운 글이 올라올 때마다 알림 전송
● 채팅알림과 키워드 알림 → 활성화/비활성화 설정 여부
ex) 버튼이나 아이콘을 눌러 간단히 알림 활성화/비활성화 설정할 수도 있다
● 마이페이지 설정 기능 추가
● 메인 메뉴를 게시판으로 고정해놓고 사이드나 하단바에 메뉴를 고를 수 있게 UI를 구현
```
## 4월 5일 회의
```
분실물과 습득물의 차이?
분실물 - 분실장소
습득물 - 습득장소, 보관장소(다른사람이 어디에보관했는지)

건물위치를 색깔로 나타냄

더보기를 누르면 사진을 추가적으로 확인할 수 있다.

분실신고를 누르면 습득자-습득물 게시판, 분실자-분실물 게시판

QnA - 제목 내용 상태
답변이 완료되면 상태로 변함

기능명세서에 보면 빠져있는 것들

캠퍼스 안내도 - 필수사항은아니다

1:1채팅을 구현한다. 어떻게 사람과 사람과의 연결을 할 것냐- 매칭
삭제를 한경우에 사용자 검색
채팅 수신 거부 (사용자 차단)

-이미지 몇개까지 할건지 제한

분실물을 마냥 가지고만 있을 순 없기 때문에 최대 한달,6개월 정도 보관기간을 정해놓고서
물품을 실제로 보관해놓고있는 장소에서도 처리를 해야하기때문에 몇개월정도 들고 있을 건지를
삭제

분실물도 찾은 경우에는 찾은 분실물이 완료가 되었다는 것을 사용자들이 체크를 하게 해서 텍스트들이 비활성화된다거나
하는 기능을 구현하면 좋겠다.

물건의 색깔 - 정확도를 올리기위해서 특징 -(불필요한 알람들이 올 수 도 있어서) 키워드 매칭을 더 해서
사용자가 입력한 것에 맞는 것들에 대한 정보

편의성에 대한 피드백 

다음에 해야 할 것 - 기능 1가지 정도 완료, 역할 분담

2주에 1번 정도 미팅 (4.18일정도)
팀장 주도하에 개발 진행 - 일주일간 했던 것들을 정리해서 보냄
```
## 24.04.07
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/ae47988a-06f6-4bfa-82c4-e3c0ed94c0a4)
```
게시물 작성해서 어뎁터의 키리스트를 get_board_list의 매개변수로 넘겨준다음 해당하는 스토리지 경로의 이미지를 추가했다.
```
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/582d1933-08fa-46a5-805c-004fcfae4ed5)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/c1df5236-aa5a-409a-bba7-4a0f709f28f0)
```
습득 위치 옆의 물음표 이미지를 클릭하면 건물 조직도 홈페이지로 이동한다.
```
## 24.04.08
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/2d3dbea3-821c-45c9-83e7-bffdc8ce8341)
```
습득 날짜 선택 UI를 EditText에서 DatePickerDialog로 수정하였습니다.
```
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/26e98a05-08af-4310-a125-0ff420a7bc9c)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a63f048b-cc71-4901-bc13-4d7673c823a3)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/020b90ed-97fc-4e3c-9523-5029203ceaff)
```
습득 위치와 보관 위치 선택 UI를 EditText에서 DropDown으로 수정하였습니다.
습득 위치와 보관 위치 드롭다운 선택한 String과 상세 습득위치, 상세 보관위치를 EditText로 입력받아
두 개의 String을 합쳐서 최종적으로 습득 위치, 상세위치를 산출한 뒤 데이터베이스에 저장하였습니다.

ps 드롭다운 메뉴의 Text 색을 변경할 수는 있으나 전체적으로 변경가능하다.
일부분 즉 W1~W15는 빨간색 E1~E5는 노란색 개별로는 변경불가능하다.
W1~W15, E1~E5 전체를 빨간색이나 노란색으로 변경하는 것은 가능
```
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/7d9d7ba6-e97d-46e0-843c-913e92a45e39)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/4c0a467a-35b0-425e-91bc-34766a1e9924)
```
하단 네비게이션 바의 UI를 설계 UI대로 수정하였습니다.

하단 네비게이션 바의 현재 창을 나타내는 바의 색상을 노란색(MainColor)에서 검정색으로 수정하였습니다.

PS 4번째 텍스트 Q/N -> Q/A로 수정할 예정
```
## 24.04.09
#### 검색 기능 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/87a014f2-8c2f-49e4-a0c9-ee4338783a5b)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/50094e5a-62ef-446f-8ab2-b78db8b6aa54)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/37c42101-8e85-4a81-abfb-02ac2efa36cd)
```
검색버튼을 눌렀을 때 검색하는 창(searchActivity)에서 검색옵션을 주고 그 옵션 값을 intent.putExtra에 담아서
검색된 창(searchActivity)로 넘긴다.(intent.getStringExtra)

검색된 창에서 넘겨받은 옵션 값과 게시글을 불러오는 함수 getFBBoardData의 매개변수로 넘겨준다음
옵션 값과 데이터 모델의 값과 같은 게시물만 출력하도록 한다.

최종적으로 옵션값에 입력한 습득물명과 같은 게시물만 출력하도록 했다.

ps 다음 구현 예정 -> 일자, 위치 검색 필터 옵션을 추가한다.
```
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/e3c43a64-1127-4319-a220-e8111416f9b6)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/779b8509-ad70-4c41-9fd2-ee4ccdac00d6)
```
검색된 창에서 전체 글보기(MainActivity)로 되돌아가는 버튼을 추가했다. 누르면 메인화면(GetFragment)로 이동한다.
```
## 24.04.10
#### 검색 기능 구현2 (시작일~종료일 기준 검색)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/3f3193e0-ef99-4709-ae6c-901883714c37)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/fbb3d806-e8f1-4396-a221-0dbc3f8d1f1d)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/60306577-95a3-4138-b2f1-6bc81be42050)
```
4월 8일,9일,10일,11일 게시물이 있을 때 4월 8일부터 4월 9일까지 게시물을 검색하면 8일, 9일게시물이 나온다.
```
#### 검색 기능 구현3 (습득 위치를 기준 검색)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/98e15e3e-aba7-49ea-81ba-7b42ea392038)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/f59ec81c-a5f8-454f-bd32-88014046382b)
```
습득 위치 같은 경우에는 W1 (건물이름) 스페이스(공백) 상세건물이름 스페이스(공백) 몇호관 이런식으로 되어있어서
입력값을 첫번째 공백 앞까지 추출해서 (건물이름)으로 비교하게 한다. substring(0, originalstring.indexOf(" "))

습득 위치를 W1로 했을 때 W1 뒤에 어떤 상세습득 위치가 오더라도 W1에서 습득한 습득물이 모두 나타나게 된다.
```
## 24.04.11
#### 습득물 등록 시 카메라, 갤러리에서 선택하는 다이얼로그 추가
[파이어베이스 스토리지 공식 문서](https://firebase.google.com/docs/storage/android/upload-files?hl=ko)     
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/00288169-34dc-4283-87a6-478c08692cda)
```

```
## 24.04.12
#### 마이페이지 내가 쓴 글(습득물, 분실물)을 모아서 보여주는 기능 추가
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/bf4908a6-986e-4c22-9bda-f2604fcf9edf)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/b24e9083-2867-4cf1-bc32-7f9ca5fc33ed)
```
내가 쓴 글 = 주황색 배경, 남이 쓴 글 = 하얀색 배경일 때 마이페이지의 게시글 버튼을 누르면 내가 작성한 습득물, 분실물에 대한
글만 모아서 볼 수 있다.
```
#### 마이페이지 키워드 버튼 옆 키워드 도움말 다이얼로그 기능 추가
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/567e4415-9f25-4ae0-a766-557378ac4093)
```
키워드 설정 관련 도움말을 알려주는 다이얼로그 기능을 추가했습니다.
```
#### 마이페이지 로그아웃, 회원탈퇴 버튼 클릭 시 다이얼로그 기능 추가
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/5c6fc8ec-f587-4c02-af00-fa2b8798c032)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/98101304-eff0-4cf0-bbc3-665337d78b07)
```
바로 로그아웃, 회원탈퇴가 이루어지지 않게 다이얼로그를 추가하였습니다.
```
## 24.04.13
#### 메인화면 
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/323c1994-b3fe-451e-941c-baf71038bdec)
```
기본적으로 화면에서 뒤로 가기 버튼을 누르면 onBackPressed() 메서드가 호출되어
현재 화면을 종료하고 이전 화면으로 돌아가게 된다.

화면(습득물게시판, 분실물게시판, 분실신고, Q/A, 마이페이지)에서 뒤로가기 버튼 시 앱이 바로 종료되는 것을 막기위해서
종료 다이얼로그 메세지와 함께 앱 종료 여부를 묻도록 수정하였다.(확인 시 앱이 꺼짐)
```
#### 키워드 설정 및 알림 기능 구현(백그라운드 정상 작동)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/fa1f5f39-9aa3-4e30-a0c2-0aea3fae182f)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/1e164a45-853e-4826-b2bc-2ac16e282025)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/fdfa2b3c-2a61-40c8-a5de-db075318d831)
```
키워드 설정 페이지에서 습득물명으로 키워드를 입력한 후 해당 키워드로 게시글이 올라오면 백그라운드에서 알림이 발생한다.
앱 및 화면이 꺼져있을 때도 작동하는 것으로 확인.

ps 알림을 눌렀을 때 해당 게시글로 이동하는 기능과 알림 메시지에 키워드명이 들어갈 수 있도록 수정한다.
```
## 24.04.14
#### 카메라로 업로드 하는 기능 추가
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/688f10b5-75bf-4d56-859d-88960e13455f)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/10655733-8897-4c22-806d-909cb128df53)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/033737ef-f6a5-45b9-a22c-76f6a6290b88)

```
갤러리에서의 requestCode 100 말고 카메라에서의 요청 requestCode를 200으로 수정한 뒤 Uri를 불러오기 전
비트맵으로 데이터를 변환한 후에 넘겨주도록 수정하여 카메라 찍은 사진이 갤러리에 저장되지 않고도 바로 파이어베이스
스토리지로 업로드되고 업로드된 이미지를 이미지뷰에 보여지도록 처리하였다.

1. 카메라 권한 확인 2. 카메라로 촬영 3. 카메라로 찰영된 이미지를 파이어베이스 스토리지에 업로드 4. 업로드 된 이미지를
이미지뷰에 띄운다.
```
#### 습득물 게시물 관리번호 텍스트 추가
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/9b850465-e74b-4688-8dc3-f4bd12509f0d)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/36a77d9f-92e0-453e-9cae-6dde2a04b14e)
```
습득물 게시글마다 고유한 관리번호를 부여하였다.(UI 설계대로)
관리번호는 고유한 String 형태의 key 값을 이용하였다.

```
#### 
```
사진 업로드를 6개 할 수 있도록 하고 그 중 첫번째 큰 이미지에 등록한 이미지는 미리보기 이미지로 한다.(대표이미지)
슬라이드 기능 (caurosel 기능이 있나 찾아보고 적용)을 적용해보고 사진을 클릭하면 학대 축소가 가능한 페이지로 이동하는 기능 구현
```
#### QnA에 댓글이 달리면 해당 게시글 상태 변경 기능 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a5bead61-3236-4dbe-bed0-ea82ab3221ab)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/5ee565cb-66fc-487f-8713-6225a90ad963)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/6665571f-1bd2-4917-9f95-0d1ee6594356)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/d1247fb7-327d-4625-965a-99f9e719f111)
```
QnA에 댓글이 달리면 해당 게시글의 상태를 대기에서 완료로 변경한다.
```
## 24.04.18
```kotlin
// 코루틴을 시작하여 백그라운드에서 실행
                GlobalScope.launch {
                    if(post?.category.equals(findViewById<TextView>(R.id.keywordArea).text.toString())) {
                        sendNotification()
                    }
                }
```
```
코루틴을 시작하여 백그라운드에서 키워드 알림이 실행되도록 수정하였다.
```
## 24.04.19
[알림 여러개 쌓기](https://velog.io/@yujeong136/Android-notification-%EC%83%9D%EC%84%B1-%EA%B4%80%EB%A0%A8-%EC%B6%94%EA%B0%80-%EC%A0%95%EB%A6%AC)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/9dd0a253-cd56-48a0-9cd6-621466864c8a)
```
현재 알림을 여러개 보내도, 가장 최신의 알림 1개로 업데이트만 되고, 쌓이지 않음. < 알림 여러개 쌓이게 하기. _ 아마 id값을 다른 값으로 주면 같은 알림이라고 인식 안 할 것 같다.

```
## 24.04.18 회의
```
UI 가 전체적으로 부족하다는 평가
키워드 알림에 백엔드 기능 추가, 사진 여러 장 업로드 할 수 있게 수정할 예정 - 원치현
키워드팀 - 키워드알림 UI 설계 및 전체 UI 변경 (Flutter의 UI 디자인툴 사용)

분실자가 직접 분실물을 찾아서 들고 간 경우 게시글을 삭제 또는 게시글에 표시할 수 있는 권한(상태)를 준다.
```
## 24.04.20 회원가입 정보를 데이터베이스에 저장
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/8dce16b6-ccea-4c71-bff5-b5e02675c690)
```
1:1 채팅 기능 개발을 위해서는 회원가입할 때 유저 정보를 데이터베이스에 저장해야 한다. user 데이터 객체를 생성하고
email와 uid 정보를 저장한다.
```
#### 습득자와의 채팅창으로 이동
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/6f7b5a64-dfd9-40bc-bf48-bca9e30b20be)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/e4e04c96-b4ce-424e-b1c7-d4b523c7f14f)
```
습득자가 게시한 글에 들어가서 채팅버튼을 누르면 습득자와 채팅할 수 있는 채팅방으로 이동하게 된다.
```
#### 습득자에게 메시지 전송
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/9d12c918-0ed6-4599-b244-06e1ba0f6fb8)
#### Chat Model
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/d1304a63-fcc9-41a7-adc7-15e695557d3f)
#### User Model
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a6ea5a85-1def-4239-8baa-bde7c6ad07d5)
```
 1. senderRoom = receiverUid + senderUid

   보낸 이의 방의 값을 받는 이 uId와 보낸 이 uId로 

   합쳐서 만들었습니다.

 2. receiverRoom = senderUid + receiverUid

   받는 이의 방의 값을 보낸 이 uId와 받는 이 uId로

   합쳐서 만들었습니다.

 3. mDbRef.child("chats").child(senderRoom!!).child("messages").push()
                .setValue(messageObject)

   chat -> senderRoom -> message -> 메시지 저장

ps 데이터베이스 경로명을 uid 말고 email로 하려고 했으나 파이어베이스 정책 상 데이터베이스의 경로명에는 @ 등 특수문자가
포함될 수 없다고 한다. 이를 substring이나 indexOf를 사용하여 @ 앞을 떼어서 경로명으로 사용할 수는 있겠으나 굳이?라는
생각이 들어서 그냥 유저 정보에 있는 uid를 경로명으로 사용하기로 했다.
```
#### 메시지 가져오기
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/43f642f3-1fd7-4cad-9d4c-04219d2e3580)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a333b46e-bc31-4cba-afa0-8adc7be11635)
```
메시지를 입력하고 전송하면 습득자에게 메시지를 보낼 수 있다.
```
#### 채팅 기능 제안
```
채팅하기를 누르고 1:1채팅기능은 구현이 되었지만 채팅방을 구현하기에는 데이터모델을 새롭게 짜야하는 문제
전체 사용자리스트를 서랍뷰에 넣고 습득자의 이메일을 습득자 게시글에서 알 수 있으니까 그거를 전체 사용자리스트에서 검색한 후
해당하는 사용자를 누르면 채팅을 시작할 수 있게끔은 구현 가능
```
## 24.04.23
```
현재 알림 기능을 포그라운드와 백그라운드에서 작동하도록 개발하였다.
포그라운드에서 특정 액티비티에 진입 시 코드 상에서 백그라운드로 코드를 돌리게 끔 짰다.
알림이 중첩되지만 전에 있던 데이터에 대한 알림도 발생하는 것을 수정하려고 한다.(intent. ONE SHOT)

또한 현재 에뮬레이터에서는 백그라운드에서 알림이 잘 작동하지만 실제 기기에서는 백그라운드 메모리 관리 시스템에 따라
필수적이거나 필요하다고 생각되는 앱의 메모리 사용을 제외하고 적은 량의 메모리를 할당하고 있어 강제로 앱을 종료시키는 문제가
발생하는 데 이를 강제적으로 백그라운드 상태에 계속 있게 하거나 메모리 최적화하는 코드를 적용하여 해결해야 할 것 같다. 
```
```
서버에서 데이터를 가져오거나 할 때 걸리는 시간 차로 인하여 기본 이미지가 1~2초간 보여지는 현상이 있다.
데이터 수정 역시도 바로 수정되지 않고 새로고침하거나 시간 차를 두어야 하는데 이를 해결하기 위한 작업을 이번주에는 할 것 같다.
```
## 24.04.28
```
습득물 코드를 재사용해서 분실물 게시판을 완성할 예정
Firebase Cloud Messaging 클라우드 서비스를 학습해서 적용해 볼 예정 ->메모리관리에 대한 불편함을 클라우드로 이관
```
## 24.04.29
#### 이미지 업로드 버튼 수정
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/9fc44794-fd80-48b7-846f-cf0fa1481245)
```
이미지 추가 버튼을 생성하고 버튼을 누르면 갤러리or카메라로 선택할 수 있는 다이얼로그가 나오도록 변경하였다.
```
#### 업로드 이미지 RecyclerView
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/e56f77aa-81f8-4a3d-a807-53914ff716cc)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/ca09f4a0-7bfe-4c33-b2b9-f9aac626ab1f)

```
갤러리에서 이미지를 여러 장 선택할 수 있도록 수정하였다.
선택되어진 이미지들은 Grid 뷰의 형태로 업로드된다.

ps 현재 파이어베이스 스토어에는 업로드 되지 않는다. 코드를 수정할 예정이다.
```
#### 사진 여러 장 업로드 개발의 방향성
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/f1157106-0dd5-4bf0-aed5-7deb5f2303f6)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/c7549be0-c26a-43af-8a13-1b1d494d7114)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a5fffadd-df0b-42c1-9786-86c04eee26bb)
```
선택한 사진의 수를 clipData의 getItemCount를 사용해서 count에 저장한 다음
갤러리에서 사진 2장을 선택하고 count  Value에 대한 로그를 찍었을 때 선택한 사진의 수만큼 count가 되는 것을 알 수 있다.

count를 lateinit var 키워드를 사용하여 전역변수로 뺀다음 count를 사용해서 upload함수에 매개변수로 넣는다면
파일명 + count 의 형태로 할 수 있을 것 같다.
```
#### 여러 장 업로드 로직 구현
[안드로이드 파이어베이스 스토리지 공식 문서](https://firebase.google.com/docs/storage/android/upload-files?hl=ko)     
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/db1ee53b-e314-48d9-b948-0674e421b511)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/aff64fcd-5bfa-44fa-b140-ee418c2c2fcb)
#### 파이어베이스 스토어에 업로드 된 이미지 2장
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/6c60e5d0-1ac8-49b6-af75-2fa4137ce363)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/7f86845f-95dc-43f5-ac1f-05a389e7dde8)
```
이미지 업로드 하는 함수를 선택한 이미지 수만큼 반복해서 실행하도록 로직을 수정했다.

count는 0부터 시작한다. 첫 번째 선택한 이미지 -> 0번으로 해서
key0, key1 이렇게 이름을 붙여서 업로드하도록 코드를 짰다.

선택한 이미지가 파이어베이스 스토어에 정상적으로 업로드 되는 것을 확인했고
GetBoardActivity 즉 습득물 게시판에서는 대표 이미지인 0번 이미지 한장만 업로드 되고
GetBoardInsideActivity 즉 습득물 게시글 하나를 선택해서 자세히 보기를 했을 때는 업로드한 이미지를 모두 볼 수 있도록
수정할 예정이다.

ps 공식 개발문서에 이미지 비트맵처리와 관련한 내용이 너무 부족한 것 같다 .
```
## 24.04.30
#### 습득물 게시판 대표이미지
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/fd1fd8ee-c19a-45b4-81c5-21c40680a198)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/23f4ef3d-bd32-4ab7-9c06-140e72bffd1f)
```
제일 첫 번째로 선택한 이미지가 대표이미지로 나오도록 수정했다.
```
#### 이미지 로딩 딜레이 문제

```
이미지 로딩 딜레이를 줄여보기Permalink
현실적으로 이미지 같은 경우에는 서버로 부터 다운받은 시간 자체를 줄이기는 어렵다.
가장 이상적인 방법으로는 썸네일용 저용량 이미지 파일을 서버에서 제공하는 것도 있지만 서버에서 제공하지 않는다면 결국 client, 즉 APP에서 문제를 해결해야 한다.
따라서 이미지를 다운받는 속도를 줄일수 없다면 그 다음 방법으로는 보여질 이미지를 미리 다운 받아서 app에 저장하는 것이다.
즉 cache를 이용하는 것이다. cache 자체는 직접 구현할수도 있지만 더 좋은 것은 라이브러리를 사용하는 것이다.

Glide 같은 경우 자체에 cache 동작을 제공한다.
```
#### 습득물 자세히보기 페이지 사진 여러 개 
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/12aca6f8-dcef-49fa-87d5-476a52f74a84)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/34354e1c-66eb-44a6-807c-6e3a594b266d)
#### 사진이 한장일 때
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/3dda1c11-68c6-4c01-a44f-1035b3947042)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/53131e4b-2aae-4f8d-87f7-84cf6c376c12)
```
Glide로 이미지를 불러올 때 ImageView로 한 개씩 가져오는 것이 가능했다.
처음에 게시글 작성 페이지에서 Uri 타입이 담긴 imageList를 intent로 넘겨서 uri 리스트로 처리하려고 했는데 문제가 발생해서
imageView를 여러 개 생성하고 0 부터 count(count는 최대 이미지 개수가 된다.)까지 반복문을 돌려서
이미지를 경로명0, 경로명1 이렇게 받아오되 경로명에 해당하는 이미지가 없을 때 이미지뷰를 invisible 처리해서 이미지가 없는데
공간을 차지하고 있는 문제를 해결했다. 또 이미지뷰를 linearlayout으로 Grid 형태로 4x4의 형태로 나오게끔 처리했다.
사진 개수에 따라서 유동적으로 사진이 차지하고 있는 공간의 크기가 변한다.(수가 적으면 커지고 수가 많아지면 Grid형태)
```
## 24.05.01
#### 분실물 작성 페이지 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/277be702-40f0-4eab-9d32-126059b7782d)
```
분실물 작성 페이지를 구현하였습니다. 습득물 작성 페이지의 코드에서 보관위치와 상세보관위치 란을 삭제하고 재사용하였습니다.
```
#### 분실물 게시판 페이지 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/01d5bdba-611c-4fe0-8b19-270ca992d1c8)
```
분실물 게시판 페이지를 구현하였습니다. 습득물 게시판 페이지의 코드에서 보관위치 란을 삭제하고 재사용하였습니다.
```
#### 분실물 상세보기 페이지 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/2a8fe45d-f20e-42b7-91ec-12798a3a0aac)
```
분실물 상세보기 페이지를 구현하였습니다. 습득물 게시판 페이지의 코드에서 보관위치 란을 삭제하고 재사용하였습니다.
```
#### 분실물 수정 페이지 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/8a3c5a23-3899-45b7-99c4-6d3bb121bd15)
```
분실물 수정 페이지를 구현하였습니다. 수정과 삭제기능을 포함합니다.
습득물 수정 페이지의 코드에서 보관위치 수정란을 삭제하고 재사용하였습니다.
```
## 24.05.02 
#### 분실물 검색 페이지 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/cb76c5a2-f438-446e-91ef-afe997445b17)
```
분실물 검색 페이지를 구현하였습니다. 습득물 검색 페이지의 코드를 재사용하였습니다.
```
#### 분실물 검색된 페이지 구현
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/15966886-3c72-4760-9f99-b8cce54c11be)
```
분실물 검색된 페이지를 구현하였습니다. 습득물 검색 페이지의 코드를 재사용하였습니다.
```
## 24.05.03
#### 한 달뒤 자동으로 삭제되는 기능 구현 
```
한 달뒤에 자동으로 삭제되는 기눙을 구현한다.

ps 코드와 기능을 다시 보면서 문제를 정의하고 생각해봐야겠다.
```
## 24.05.05
#### Glide Preload 로딩 이슈 해결
[이미지 로딩 개선안](https://medium.com/@wodbs135/%EC%B4%88%EA%B8%89-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%9C%EB%B0%9C%EC%9E%90%EC%9D%98-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%86%8D%EB%8F%84-%EA%B0%9C%EC%84%A0%EA%B8%B0-da3610509231)
[Glide 관련 메서드](https://zibro.tistory.com/18)
#### Glide 이미지 최적화 전 .Gif
![123-ezgif com-video-to-gif-converter](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/f3a423e5-231a-4050-9c8d-a3c3c43134e7)
#### Glide 이미지 최적화 후 .Gif
![ezgif com-video-to-gif-converter](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/814d3944-3108-49f9-b41f-bf39d592c133)
```
Glide의 override(이미지 리사이징)과 캐싱 메서드(skipMemoryCache, diskCacheStragtegy)를 사용하여 이미지를 서버에서 가져올 때 발생하는
로딩 지연의 문제를 해결(최적화)하였습니다.
추가로 로딩 중 이미지를 추가하였습니다. 에러 시에도 로딩 중 이미지가 나타납니다.
```
## 24.05.06
#### 리스트 뷰 UI 개선
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a52cc52c-d58a-4683-8a91-67774a8c086f)
```
기존 컨텐츠 크기에 따라 변하던 리스트 뷰의 높이 크기가 고정되도록 수정하였습니다.
리스트 뷰의 높이를 통일 -> (Text(습득명,습득장소)자식요소가 일정 크기를 넘어가면 짤리게 둔다.)
```
## 24.05.06 
#### 게시글 url 공유 기능
```
사용자 편의성-> 하지만 공유 기능을 사용하려면 앱을 들어가야하지 않나? <- 기업의 입장에서는 앱 사용자를 유치하기 위해서는
공유기능을 넣는것이 좋아보임
```
#### 업로드 할 사진의 개수를 제한하는 기능 
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/ef404ee8-1731-43e2-9f54-e7942b3cc9a5)
```
업로드 한 사진이 5장 초과 시 알림이 발생하며 업로드가 불가능해집니다.
```

## 24.05.07
#### 공유하기 기능 구현
[파이어베이스 동적 링크](https://firebase.google.com/docs/dynamic-links/android/create?hl=ko)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/22131258-07af-47ba-9f68-dec332a6efd7)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/aff2760c-d3da-4724-bae6-9060a02bb9dd)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/727e6fa1-138e-40b4-b321-d517aacd0065)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/646b5407-3d4d-4429-b0da-d108a070323c)
```
개발하고자 하는 기능의 정식 명칭은 "딥링크 DeepLink"이다.
원하는 도메인이 많이 등록되어있어서 일단 보류


```
#### QnA 관리자만 댓글 달 수 있도록 수정
#### 관리자 아이디가 아닌 경우
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/ba70aa19-685c-4588-a2d9-5f1705e424d6)
#### 관리자 아이디인 경우(heungeob1003@gwnu.myplug.kr)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/a258964c-3437-443c-8cbe-2c6641eb796d)
```
heungeob1003@gwnu.myplug.kr <-를 관리자로 하고 관리자일 경우에만 댓글을 작성할 수 있도록 수정한다.
관리자 아이디가 아닌 경우 댓글창이 보이지 않아 댓글을 입력할 수 없다.
```

```

```
## 24.05.09 팀회의
```
기능 구현 테스트

알림 기능 파이어베이스 클라우드 메시징
UI 초기설계단계임

지속적으로 진행상황
계획서 보고서

최종 제출 자료가 무엇이 될것인가
```
[파이어베이스 클라우드 메시징 개념](https://www.youtube.com/watch?v=tvASwNaDZww)
[FCM 알림시스템 개발](https://www.inflearn.com/course/lecture?courseSlug=%EC%9D%B8%EC%8A%A4%ED%83%80%EA%B7%B8%EB%9E%A8%EB%A7%8C%EB%93%A4%EA%B8%B0-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C&unitId=30386)
```
전체 사용자가 아닌 특정 사용자에게 메시지를 보내고 싶을 때는 기기마다 토큰아이디를 받아와야 한다.
```
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/8d4361b7-a624-4981-ae15-763587e1e6eb)
```
토큰 발급 메서드인 registerPushToken() 메서드를 생성하고 로그인 시 바로 토큰이 발급되고 해당 토큰을 DB에 저장한다.
```
## 24.05.12 Solution.
[FirebaseInstanceID is deprecated.](https://firebase.google.com/docs/cloud-messaging/android/first-message?hl=ko#retrieve-the-current-registration-token)FirebaseInstanceID -> FirebaseMessaging.getInstance()
```
유저의 토큰을 기준으로 특정 사용자/전체 사용자에게 보낼 수 있는게 fcm
이제 저걸 어떻게 구분할지는 fcm요청을 작성하는 주체에서 해야한다. 대부분이 서버 -> OKhttp 라이브러리
예를들어 사용자가 특정 기준을 제공하면 (제목 키워드 등록 등)
서버에서 신규 글이 등록되었을 때 fcm 요청을 할 대상을 걸러내는 로직 구현
```
```
api키 보안을 위해서 서버에서 푸시push를 전송해줘야한다.
하지만 서버의 전문 지식이 필요,
기존 안드로이드 디바이스가 서버 역할도 해주는 라이브러리(okhttp3, gson, multidex)를 추가한다.

com.squareup.okhttp3 
com.google.code.gson 2.10.1
androidx.mulitidex 2.0.1<-8개까지만 요청(multidex 오류 발생하기 때문에)
라이브러리 추가하고 defaultConfig안에 multiDexEnabled true 추가
```
## 24.05.13
#### FCMHttp -> Http V1 마이그레이션
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/0171e410-6d2a-48ca-a846-dd89bf7cf951)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/22f11537-ca8d-415b-89f6-f8aed69396a6)
[기존 HTTP 방식 사용](https://youtu.be/iOJGtKmk6tk?si=e56LvcnYFBbk3FrU)
[챗 노티](https://www.youtube.com/watch?v=YjNZO90yVsE&feature=youtu.be)
```
기존 Http 에서 HTTP V1으로 마이그레이션
```
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/21abe0c4-e2c8-4ba8-8467-a95488aa31a3)
```
기존 http 의 서버 키를 사용하는 방식으로 이번 프로젝트에서 알림 개발을 수행한 후 이후에 http v1 마이그레이션을 학습
```
#### FireStore native
[구글 코솔에서만 접속 가능한 문제 해결](https://velog.io/@mary0393/Firebase-Firestore-%EA%B5%AC%EA%B8%80-%EC%BD%98%EC%86%94%EC%97%90%EC%84%9C%EB%A7%8C-%EC%A0%91%EA%B7%BC-%EA%B0%80%EB%8A%A5%ED%95%9C-%EB%AC%B8%EC%A0%9C-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/2e6e47b3-4186-4e2f-ac8c-cf325c879b72)
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/7f448920-91f7-4857-9ef3-f5050e48778d)

#### FCM 알림 발생 성공
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/83a1df0c-8119-476b-9fe8-fd62ed3483a0)
```
Responbody.create() is deprecated ->  val body = jsonObject.toString().toRequestBody("application/json; charset=utf-8".toMediaType()

메인액티비티에서 onStop으로 백그라운드로 이동했을 때 알림이 발생하는 지 실험, 알림이 발생하는 것을 확인

```
#### 채팅 기능에 백그라운드 알림 기능 확인
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/deaba78d-b451-4ac1-8d2e-ca317cea2b8c)
```
백그라운드일 때 채팅을 보내면 알림이 발생하는 것을 확인하였다.

ps 포그라운드일때는 작동안하는 문제를 해결할 예정
```
## 24.05.17 
#### FCM 포그라운드 알림 기능 개발 완료
#### MyFirebaseMessagingService.kt
```
MyFirebaseMessagingService의 onMessageReceived 메서드를 오버라이딩 한후 포그라운드 메시지를 보내도록 채널을 생성한 후
알림에 대한 설정을 진행하였다.
```
#### 채팅 알림 포그라운드 확인
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/047f4388-eb0e-4e11-9210-e05f90cbf513)

#### 키워드 알림 포그라운드 확인
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/c8d07ca4-1ccd-415b-8cf7-d20fd8d3e8fe)

#### 알림 body 수정
![image](https://github.com/chihyeonwon/Capstone-Design/assets/58906858/d69faebc-d845-4191-a6ed-c7aa21bf0506)
```
마지막 보낸 메시지가 알림의 메시지로 오도록 수정하였습니다.
```
## 24.05.18 
#### 포그라운드&백그라운드 알림 아이콘 수정
```
아이콘 수정하려는데 R 안드로이드 내장 이미지로 계속 인식되어서 drawable 에 있는 notification_icon을 찾지 못하는 문제가 있었는데
import android.R을 삭제하니까 로컬 drawable 파일에 있는 notification_icon으로 수정할 수 있었다.
```
## 24.05.19
#### 토큰 업데이트
```
토큰이 기기에 종속되는 문제 
```
[토큰 관리](https://seungwoolog.tistory.com/88)
## 24.05.21 
#### 토큰 트러블 슈팅  
```
로그아웃 할 때 해당 uid 값을 가지는 문서로 작성된 파이어스토어의 토큰 데이터를 삭제하도록 수정하였습니다.

토큰이 기기에 종속되는 문제, 즉 1@gwnu.ac.kr로 로그인했을 때 토큰이 발급, MutuableMap 형식으로 데이터베이스에 저장되고
로그아웃 후 다른 계정인 2@gwnu.ac.kr로 로그인된 상황에서1@gwnu.ac.kr로 채팅을 보내면 알림이 발생하는 문제,
즉 1@gwnu.ac.kr 토큰이 데이터베이스에 저장되어 있기 때문에 발생되는 문제를
-> 로그아웃을 했을 때 해당 uid 값을 가지는 document의 토큰 데이터를 삭제하도록 하여 토큰이 기기에 종속되는 문제를 해결하였습니다. 
```
#### UI 폰트 수정 
[프리텐다드 무료 폰트](https://noonnu.cc/font_page/694)    
[피그마 Figma](https://www.figma.com/)       
[M3 머터리얼 디자인](https://m2.material.io/develop/android)      

#### 분실물 & 습득물 게시판 UI 개선

##### Before


##### After


