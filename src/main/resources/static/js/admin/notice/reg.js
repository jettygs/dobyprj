window.addEventListener("load", function () {

    let form = document.querySelector(".container form");
    let saveBtn = form.querySelector(".save-btn");
    let cancelReg = form.querySelector(".cancel-btn");
    let csrf = document.querySelector("#csrf");
    console.log(csrf);

    console.log(saveBtn);
    saveBtn.onclick = async function (e) {
        console.log(e);
        e.preventDefault();

        let title = form.querySelector("input[name=title]");
        console.log(title.value);

        let content = form.querySelector("input[name=content]");

        console.log(content.value);
        console.log(csrf.content);

        // 전송할 바디 데이터. title의 값과 content의 값을 bodyObj객체에 담는다.
        let bodyObj = {
            title: title.value,
            content: content.value

        }

        // fetch 요청을 보낼 config
        // post 요청으로, 헤더에 content타입과 토큰을 심어, 바디에 bodyObj 객체를 json으로 반환
        let config = {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "X-CSRF-Token": csrf.content

            },
            body: JSON.stringify(bodyObj),
        }

        let response = await fetch(`/api/notices`, config);
        let data = await response.json();
        console.log(response);
        console.log(response.status);
        let code = response.status;
        if (code !== 201) {
            throw new Error("등록에 실패했습니다")
            return;
        }
        else
            alert("공지사항이 등록되었습니다.");

        let noticeId = data.id;
        location.href = `/notice/detail?id=${noticeId}`;

        // let noticeId= response.id;

    }

});
