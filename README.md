# DOBY

개발자들을 위한 커뮤니티, DevelOper Beside You! DOBY!

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
