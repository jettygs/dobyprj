# DOBY

개발자들을 위한 커뮤니티, DevelOper Beside You! DOBY!

<h3>config</h3>
Spring Boot 설정 패키지입니다.

<h4>auth /</h4>
<ul>
  <li>DobySecurityConfig - 로그인 구현을 위한 Spring Seurity 설정 클래스입니다.</li>
  <li>DobyUserDetails - 로그인 시 회원의 상세정보를 확인하기 위한 메서드들을 규정한 클래스입니다.</li>  
  <li>DobyUserDetailService - DobyUserDetails를 구현한 클래스입니다.</li>  
</ul>

<h3>controller</h3>
admin/user 역할에 따라 접근할 수 있는 페이지가 나뉘어져 있습니다.

<h4>controller / </h4>
<ul>
<li>AdminController - admin 사용자의 메인 페이지를 제어합니다.</li>
<li>HomeController - 로그인하지 않은 사용자의 메인 페이지를 제어합니다.</li>
<li>MemberController - 멤버 마이페이지를 제어합니다.</li>
<li>NoticeController - 일반 사용자가 볼 수 있는 공지 페이지를 제어합니다.</li>
</ul>

<h4>Admin / </h4>
<ul>
<li>NoticeController - admin 사용자가 공지를 조회/등록/수정/삭제할 때 요청을 처리하는 controller입니다.</li>
</ul>

<h3>entity</h3>
<ul>
  <li>InactiveMemver - 정지된 멤버 속성 엔티티입니다.</li>
  <li>Member - 멤버 속성 엔티티입니다.</li>
  <li>MemberRoleView - 멤버 역할 뷰 엔티티입니다.</li>
  <li>MemberTechView - 마이페이지에서 등록 가능한 멤버 기술스택 엔티티입니다.</li>
  <li>Notice - 공지사항 게시글의 속성 엔티티입니다.</li>
  <li>NoticeView - 공지사항 게시글 뷰 엔티티입니다.</li>
  <li>Role - 멤버 역할 엔티티입니다.</li>
  <li>Tech - 기술스택 엔티티입니다.</li>
</ul>

<h3>repository</h3>
<ul>
  <li>InactiveMemberRepository - 정지된 멤버 정보 데이터에 접근하기 위한 repository입니다.</li>
  <li>MemberRepository - 멤버 정보 데이터에 접근하기 위한 repository입니다.</li>
  <li>MemberRoleRepository - 멤버 역할 데이터에 접근하기 위한 repository입니다.</li>
  <li>MemberTechRepository - 멤버가 보유중 기술스택 데이터에 접근하기 위한 repository입니다.</li>
  <li>NoticeRepository - 공지사항 데이터에 접근하기 위한 repository입니다.</li>
  <li>TechRepository - 기술스택 데이터에 접근하기 위한 repository입니다.</li>  
</ul>

<h3>service</h3>
db에 접근하여 정보를 가져오는 모듈의 결합도를 낮추기 위한 service class 목록입니다.
<ul>
  <li>MemberService - 멤버의 정보를 가져오기 위한 메서드들을 규정한 추상 클래스입니다. </li>
  <li>MemberServiceImp - MemberService에 규정한 메서드들의 기능을 구현한 클래스입니다.</li>
  <li>NoticeService - 공지사항의 정보를 가져오기 위한 메서드들을 규정한 추상 클래스입니다.</li>
  <li>NoticeServiceImp - NoticeService에 규정한 메서드들의 기능을 구현한 클래스입니다.</li>
</ul>
