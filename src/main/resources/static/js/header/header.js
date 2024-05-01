window.addEventListener("load", function (){
    let header = document.querySelector(".header")
    let profileBox = header.querySelector('.profile-box');
    let profileListBox = header.querySelector('.list-box');

    profileBox.onclick = function (e){
        profileListBox.classList.toggle('d:none');
    }


});