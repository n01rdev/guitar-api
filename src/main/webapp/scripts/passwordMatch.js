function isPasswordCorrect() {
    let password = document.getElementById("password").value;
    let passwordConfirm = document.getElementById("passwordConfirm").value;
    if (password != passwordConfirm) {
        return false;
    }
    return true;
}