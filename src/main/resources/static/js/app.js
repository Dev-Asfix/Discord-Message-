document.addEventListener("DOMContentLoaded", () => {
    loadMessages();
});

document.getElementById("messageForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const text = document.getElementById("text").value;
    const scheduledDate = document.getElementById("scheduledDate").value;

    const response = await fetch("/api/messages", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ text, scheduledDate })
    });

    if (response.ok) {
        alert("Mensaje guardado correctamente.");
        loadMessages();
        document.getElementById("messageForm").reset();
    } else {
        alert("Error al guardar el mensaje.");
    }
});

async function loadMessages() {
    const response = await fetch("/api/messages");
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

    const response = await fetch(`/api/messages/${id}`, {
        method: "DELETE",
    });

    if (response.ok) {
        alert("Mensaje eliminado correctamente.");
        loadMessages();
    } else {
        alert("Error al eliminar el mensaje.");
    }
}
