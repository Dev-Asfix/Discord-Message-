const API_URL = "http://localhost:8080";

document.addEventListener("DOMContentLoaded", () => {
    loadMessages();
});

document.getElementById("messageForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const text = document.getElementById("text").value;
    const scheduledDate = document.getElementById("scheduledDate").value;

    const response = await fetch(`${API_URL}/message`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ text, scheduledDate })
    });

    if (response.ok) {
        showNotification("Mensaje guardado correctamente", "success");
        loadMessages();
        document.getElementById("messageForm").reset();
    } else {
        showNotification("Error al guardar el mensaje", "error");
    }
});

async function loadMessages() {
    const response = await fetch(`${API_URL}/messages`);
    const messages = await response.json();
    const table = document.getElementById("messagesTable");
    table.innerHTML = "";

    messages.forEach(msg => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${msg.id}</td>
            <td>${msg.text}</td>
            <td>${msg.scheduledDate}</td>
            <td>
                <button class="delete-btn" onclick="deleteMessage(${msg.id})">Eliminar</button>

            </td>
        `;

        table.appendChild(row);
    });
}

async function deleteMessage(id) {
    if (!confirm("¿Estás seguro de eliminar este mensaje?")) return;

    const response = await fetch(`${API_URL}/message/${id}`, {
        method: "DELETE",
    });

    if (response.ok) {
        showNotification("Mensaje eliminado correctamente", "success");
        loadMessages();
    } else {
        showNotification("Error al eliminar el mensaje", "error");
    }
}





function showNotification(message, type) {
    const notificationContainer = document.getElementById("notificationContainer");
    const notification = document.createElement("div");
    notification.className = `notification ${type}`;
    notification.textContent = message;
    notificationContainer.appendChild(notification);

    setTimeout(() => {
        notification.classList.add("fade-out");
        setTimeout(() => notification.remove(), 500);
    }, 3000);
}
