window.addEventListener("load", function(){

    let adminUserDetail = document.querySelector(".admin-user-detail");
    
    let manageUL = adminUserDetail.querySelector(".management");

    let mainAndLogoutUL = adminUserDetail.querySelector(".toDoby-logout");

    let currentManage = manageUL.querySelector("li:first-child a");
    // active를 가져오는 방법?

    manageUL.onclick = function(e){
        e.preventDefault();

        let el = e.target;

        if(el.tagName != "A")
        return;

        currentManage.classList.remove("active");
        el.classList.add("active");
        currentManage = el;

        console.log(currentManage.className);

    }

    // ======================================================

    // 카테고리 선택

    let category = adminUserDetail.querySelector(".category")
    let currentCategory = category.querySelector("li:first-child a");

    category.onclick = function(e){
        e.preventDefault();

        let el = e.target;

        if(el.tagName != "A")
        return;

        currentCategory.classList.remove("active");
        el.classList.add("active");
        currentCategory = el;

        console.log(currentCategory.className);

    }


    // ======================================================

    // 카테고리 선택

    let stopPeriodBox = adminUserDetail.querySelector(".stop-period-box");
    let stopPeriod = stopPeriodBox.querySelector(".stop-period span");
    let stopPeriodList = stopPeriodBox.querySelector(".period-list");
    let periods = stopPeriodBox.querySelectorAll(".period-list li");


    let periodDownArrow = stopPeriodBox.querySelector(".stop-period-box .btn-down");
    let periodUpArrow = stopPeriodBox.querySelector(".stop-period-box .btn-up");

    periodDownArrow.onclick = function(e){
        e.preventDefault

        console.log("리스트 열기 테스트")

        periodDownArrow.classList.add("d:none");
        periodUpArrow.classList.remove("d:none");
        
        stopPeriodList.classList.remove("d:none");
        console.log(stopPeriod.innerText);
    }

    for(let i = 0; i < periods.length; i++){
        periods[i].onclick = function(e){
            console.log(periods[i].innerText); // 찍히는지 확인
            stopPeriod.innerText = periods[i].innerText;
            
            stopPeriodList.classList.add("d:none");
            periodDownArrow.classList.remove("d:none");

            periodUpArrow.classList.add("d:none");
            
            console.log(periodDownArrow.classList);
        
        }
    }
    
    periodUpArrow.onclick = function(e){
        e.preventDefault

        console.log("리스트 닫기 테스트")

        periodUpArrow.classList.add("d:none");
        periodDownArrow.classList.remove("d:none");

        stopPeriodList.classList.add("d:none");
    }



// 이유 선택

    let stopReasonBox = adminUserDetail.querySelector(".stop-reason-box");
    let stopReason = stopReasonBox.querySelector(".stop-reason span");
    let stopReasonList = stopReasonBox.querySelector(".reason-list");
    let reasons = stopReasonBox.querySelectorAll(".reason-list li");

    let reasonDownArrow = stopReasonBox.querySelector(".stop-reason-box .btn-down");
    let reasonUpArrow = stopReasonBox.querySelector(".stop-reason-box .btn-up");

    reasonDownArrow.onclick = function(e){
        e.preventDefault

        console.log("리스트 열기 테스트")

        reasonDownArrow.classList.add("d:none");
        reasonUpArrow.classList.remove("d:none");
        
        stopReasonList.classList.remove("d:none");
        console.log(stopReason.innerText);
    }

    for(let i = 0; i < reasons.length; i++){
        reasons[i].onclick = function(e){
            console.log(reasons[i].innerText); // 찍히는지 확인
            stopReason.innerText = reasons[i].innerText;
            
            stopReasonList.classList.add("d:none");
            reasonDownArrow.classList.remove("d:none");

            reasonUpArrow.classList.add("d:none");
            
            console.log(reasonDownArrow.classList);
        
        }
    }
    
    reasonUpArrow.onclick = function(e){
        e.preventDefault

        console.log("리스트 닫기 테스트")

        reasonUpArrow.classList.add("d:none");
        reasonDownArrow.classList.remove("d:none");

        stopReasonList.classList.add("d:none");
    }

})