window.addEventListener("load", function () {
    let form = document.querySelector(".container form");
    let saveBtn = form.querySelector(".save-btn");
    let cancelReg = form.querySelector(".cancel-btn");
    let csrf = document.querySelector("#csrf");
    console.log(csrf);

    console.log(saveBtn);

    saveBtn.onclick = function (e) {
        console.log(e);
        e.preventDefault();

        let title = form.querySelector("input[name=title]");
        console.log(title.value);

        let content = form.querySelector("input[name=content]");

        console.log(content.value);
        console.log(csrf.content);

        const URLSearch = new URLSearchParams(location.search);

        function searchParam(id) {
            return new URLSearchParams(URLSearch).get(id);
        }

        let id = searchParam('id');

        fetch(`/api/notices/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
                "X-CSRF-Token": csrf.content
            },
            body: JSON.stringify({
                title: title.value,
                content: content.value,
                id: id
            }),
        })
            .then((response) => response.json())
            .then((data) => console.log(data));
        location.href = `/admin/notice/detail?id=${id}`;


        fetch(`/api/notices/${id}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "X-CSRF-Token": csrf.content
            }
        })
            .then((response) => response.json())
            .then((data) => console.log(data));
    }


});
