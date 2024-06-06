function showLoginFailedAlert() {
    alert("로그인에 실패했습니다. 전화번호와 비밀번호를 다시 확인해주세요.");
}

// 페이지 로드 후 실행
window.onload = function() {
    // URL에 loginFailed 파라미터가 있는 경우 로그인 실패 알림 창을 띄움
    const urlParams = new URLSearchParams(window.location.search);
    if (urlParams.has('loginFailed')) {
        showLoginFailedAlert();
    }
};