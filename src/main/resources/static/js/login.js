const API_BASE = "http://localhost:8080";

function login(username, password){

    if (username === " " && password === " ") {
        showErr
    }
    fetch(`${API_BASE}/api/auth/login`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    });
}

document.querySelector("form").addEventListener("submit", function(event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    login(username, password);
});