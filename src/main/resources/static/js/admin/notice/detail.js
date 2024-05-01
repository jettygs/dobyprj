window.addEventListener("load", function () {

    let editDelBtn = document.querySelector(".dots-btn-list-container .dots-btn");
    let editDelList = document.querySelector(".dots-btn-list-container ul");
    let edit = editDelList.querySelector("li:nth-child(1)");
    let del = editDelList.querySelector("li:nth-child(2)");
    let csrf = document.querySelector("#csrf");

    editDelBtn.onclick = async function (e) {
        e.preventDefault()

        editDelList.classList.toggle("d:none");
    }

    const URLSearch = new URLSearchParams(location.search);

    function searchParam(id) {
        return new URLSearchParams(URLSearch).get(id);
    }

    del.onclick = async function (e) {
        e.preventDefault();

        if (confirm("정말 삭제하시겠습니까?") === true) {
            let id = searchParam('id');

            await fetch(`/api/notices/${id}`, {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                    "X-CSRF-Token": csrf.content
                }
            });
        alert("게시글이 삭제되었습니다.")
        location.href = `/admin/notice/list`
        }
    }

    edit.onclick = function (e){
        e.preventDefault();
        let id = searchParam('id');
        location.href = `/admin/notice/edit?id=${id}`
    }

})