window.addEventListener("load", function () {
    let loginPage = this.document.querySelector(".login-page")

    let username = loginPage.querySelector(".email")
    let password = loginPage.querySelector(".password")
    let loginBtn = loginPage.querySelector(".btn-login")


    function onInput() {
        if (username.value.length >= 1 && password.value.length >= 1) {
            console.log("버튼 활성화");
            loginBtn.classList.add("active")
        }
    }
      username.addEventListener("input", onInput);
      password.addEventListener("input", onInput);

});