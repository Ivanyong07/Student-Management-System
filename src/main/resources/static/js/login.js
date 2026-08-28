const username = document.getElementById("username").value;
const password = document.getElementById("password").value;

username.trim();
password.trim();

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

login(username, password);