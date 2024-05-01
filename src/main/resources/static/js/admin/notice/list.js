window.addEventListener("load", function () {

    let search = document.querySelector(".container .search-btn");
    let formSection = document.querySelector(".container .search-form");
    let queryInput = formSection.querySelector(".input");
    let findButton = formSection.querySelector(".search");
    let content = document.querySelector(".board-list");


    search.onclick = function(e){
      formSection.classList.toggle("d:none");
    }

    // admin notice js

    function bind(list) {
        content.innerHTML='';

        console.log("이거 타나요");
        
        for (let n of list) {
            let template = `
          <li class="item" th:each="n : ${list}">
            <div class="board">
              <!-- TOP -->
              <div class="write-info-box">
                <div class="profile">
                  <div class="img-container">
                    <img class="img" src="/image/go_to_mars.png" alt="프로필사진">
                  </div>
                  <div class="nickname">${n.nickname}</div>
                </div>
                <div class="reg-date">${n.regDate}</div>
              </div>
              <!-- 증간 -->
              <div class="title-box">
                <a class="title" href="detail?id=${n.id}">${n.title}</a>
              </div>
              <!-- 아래 -->
              <div class="board-info">

                <div class="view-like-comment-box">
                  <div class="views deco icon-color-3 icon-views">${n.hit}</div>
                </div>
              </div>

            </div>

          </li>
      `;
            content.insertAdjacentHTML("beforeend", template);
            console.log(template);
        }
    }


    let filter = document.querySelector(".filter");
    let filterList = filter.querySelector(".sort-list");

    filter.onclick = async function(e){
        filterList.classList.toggle("d:none");
    }

    // 필터했을 때
    filterList.onclick = async function (e){
        e.preventDefault();

        let element = e.target;
        if(element.nodeName !== "A")
            return;
        console.log(element.dataset.filterId);

        let query = queryInput.value;
        let filterId = element.dataset.filterId;

        let response = await fetch(`/api/notices?p=1&q=${query}&f=${filterId}`)
        let json = await response.json();
        bind(json);

    }

    // 돋보기 버튼 눌렀을 때
    findButton.onclick =  async function(e){
        console.log(e);
        e.preventDefault();

        let query = queryInput.value;

        console.log(query)

        let response = await fetch(`/api/notices?p=1&q=${query}&f=1`);
        let json = await response.json();
        bind(json);
    }

    // 엔터 눌렀을 때
    queryInput.addEventListener("keydown", async function(e) {
        if (e.key === "Enter") {
            e.preventDefault();

            let query = queryInput.value;
            console.log(query);

            let response = await fetch(`/api/notices?p=1&q=${query}&f=1`);
            let json = await response.json();
            bind(json);
        }
    });



});