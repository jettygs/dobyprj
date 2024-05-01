window.addEventListener("load", function () {
    let userProfile = document.querySelector(".profile-edit");

    let nicknameBox = userProfile.querySelector(".nickname-box");
    let nickname = userProfile.querySelector(".nickname");
    let editBtn = userProfile.querySelector(".nickname-edit");

    let csrf = document.querySelector("#csrf");

    nicknameBox.onclick = function (e) {
        e.preventDefault();
        nickname.readOnly = false;
    }


    // 기술스택 =========
    // 입력 박스
    let techStackBox = userProfile.querySelector(".techstack-box");
    let techInputBox = techStackBox.querySelector(".tech-input-box");
    let inputTech = techInputBox.querySelector(".tech-input-box ul li"); // input의 list

    //리스트
    let techListBox = techStackBox.querySelector(".tech-list-box");
    let techList = techListBox.querySelector(".tech-list"); // list
    let itemList = techListBox.querySelectorAll(".tech-list .item");

    // 열고닫기 버튼
    let listOpen = techStackBox.querySelector(".list-open");
    let listClose = techStackBox.querySelector(".list-close");


    // 리스트 열고닫기
    listOpen.onclick = function (e) {
        e.preventDefault();
        techListBox.classList.remove("d:none");
        listOpen.classList.add("d:none");
        listClose.classList.remove("d:none");
    }

    listClose.onclick = function (e) {
        e.preventDefault();
        techListBox.classList.add("d:none");
        listOpen.classList.remove("d:none");
        listClose.classList.add("d:none");
    }

    // let isSelected = itemList[i].innerHTML;

    // let inputItemList = techInputBox.querySelectorAll(".tech-input-box .item");

    // 스택 추가하기
    for (let i = 0; i < itemList.length; i++) {

        itemList[i].onclick = function (e) {
            e.preventDefault();
            itemList[i].classList.toggle("selected");
            console.log("이거탐?");

            // 입력박스에 선택아이템이 없다면 입력박스에 <div>선택아이템<div> 추가
            if (!techInputBox.innerText.includes(itemList[i].innerText))
                // techInputBox.innerHTML += '<div class="item">'+itemList[i].innerHTML+'</div>'; 
                techInputBox.append(itemList[i]);

            else {
                techList.appendChild(itemList[i])
            }
            ;


            console.log("====================")
            console.log(itemList[i].innerHTML);
            console.log(techInputBox.innerText.includes(itemList[i].innerText))

        }

    }

    // 전화번호 인증하기
    let certifBtn = userProfile.querySelector(".btn-certif");
    let phoneWarning = userProfile.querySelector(".warning"); // 휴대전화번호가 정확한지~

    let inputPhoneNumber = userProfile.querySelector(".phone-num-box");
    let certifBox = userProfile.querySelector(".certif-number-box");
    let inputCertifNumber = userProfile.querySelector(".certif-input-box");

    certifBtn.onclick = async function (e) {
        e.preventDefault();
        console.log("전화번호 인증");

        certifBox.classList.remove("d:none");

        console.log(inputPhoneNumber.value);

        let bodyObj = {
            phone: inputPhoneNumber.value
        }

        let config = {
            method: "post",
            headers: {
                "Content-Type": "application/json",
                "X-CSRF-Token": csrf.content
            },
            body: JSON.stringify(bodyObj),
        }

        let response = await fetch(`member/profile/sendSMS`, config);
        let data = await response.json();
        console.log(response);
        console.log(data);

    }


    // 이메일 정규식 검사

    function emailCheck(email) {
        let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

        if (exptext.test(email) == false) {
            // 이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
            return false;
        }
        return true;
    }

    // 이메일수신동의 toggle
    let toggle = userProfile.querySelector(".toggle");
    let toggleBtn = userProfile.querySelector(".toggle-btn");

    // 토글 active, dataset 이용하기
    toggleBtn.onclick = function (e) {
        e.preventDefault();

        console.log("토글 누르기 테스트");

        if (toggle.classList.contains("active"))
            toggle.classList.remove("active");
        else
            toggle.classList.add("active");
    }

    let saveBtn = userProfile.querySelector(".btn-save");
    let form = document.querySelector(".information-box form");

    let profileImage = form.querySelector("input[type=file]");
    let id = form.querySelector("input[name=id]");
    let nicknameValue = form.querySelector("input[name=nickname]");
    let password = form.querySelector("input[name=password]");
    let phone = form.querySelector("input[name=phone]");
    let email = form.querySelector("input[name=email]");

    let csrfToken = document.querySelector("#csrf").content;
    // let memberId = document.querySelector("#member-id").content;

    console.log(saveBtn);


    let selectedTechList = form.querySelectorAll(".tech-input-box .selected")
    let memberId = 1;

    for (let selectedTech of selectedTechList) {
        let techId = selectedTech.dataset.techId;
        let memberTechData = {memberId, techId};

        let memberTechId = inputTech.dataset.techId; // 멤버가 가지고 있는 기술스택

        console.log("이 회원의 기술스택은" + inputTech.dataset.techId);
        console.log(memberTechData);
    }

        console.log(nicknameValue.value);
        console.log(password.value);

        saveBtn.onclick = async function (e) {

            e.preventDefault();

            let response = await fetch(`/api/members`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                    "X-CSRF-Token": csrf.content
                },
                body: JSON.stringify({
                    id: id.value,
                    nickname: nicknameValue.value,
                    password: password.value,
                    phone: phone.value,
                    email: email.value
                }),
            })
            console.log(response.status);
            await response.json();

            if (response.status === 204)
            alert("프로필이 변경되었습니다.")
            location.href = `/member/profile`;

        }


});