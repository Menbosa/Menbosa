document.addEventListener("DOMContentLoaded", function() {
    let secessionButton = document.querySelector(".secessionButton");

    secessionButton.addEventListener("click", function(event) {
        if (!confirm("탈퇴 하시겠습니까?")) {
            event.preventDefault();
        } else {
            alert("탈퇴되었습니다.");
        }
    });
});