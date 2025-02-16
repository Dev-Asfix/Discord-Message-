
<div align="center">
  <img src="./src/main/resources/img/Badge-Spring.png" alt="Logo" height="100">
  <h2>
    🌐Discord Message Scheduler 📩
  </h2>
</div>

Este proyecto es un servicio backend desarrollado con **Spring Boot**, que permite **programar y gestionar mensajes automáticos en Discord**. Utiliza **JDA** para la interacción con Discord, **Spring Boot** para la gestión del backend y **MySQL** como base de datos.

## 🚀 Características

- 📌 **Programación de mensajes** con fecha y hora específicas.
- 🔄 **Eliminación automática** de mensajes programados después de su envío.
- 📝 **Validaciones** con `Jakarta Validation` para garantizar datos correctos.
- 🌐 **API REST** documentada con `Swagger`.
- 🔧 **Configuración flexible** con variables de entorno y `application.properties`.

---

<div align="center">
<h2>
🔧 Tecnologías Usadas
</h2>
</div>

<div align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="Spring Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" height="40" alt="IntelliJ Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="Java Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original.svg" height="40" alt="Git Logo" />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original.svg" height="40" alt="MySQL Logo" />
  <img width="12" />

  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" height="40" alt="GitHub Logo" />
</div>

## 📦 Instalación

### 1️⃣ Clonar el repositorio
```sh
 git clone https://github.com/tuusuario/discord-message-scheduler.git
 cd discord-message-scheduler
```

### 2️⃣ Configurar la base de datos MySQL
Crea la base de datos con el siguiente comando en MySQL:
```sql
CREATE DATABASE discorddb;
```

Asegúrate de configurar correctamente las credenciales en `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3307/discorddb?serverTimezone=America/Lima
spring.datasource.username=root
spring.datasource.password=admin
```

### 3️⃣ Configurar las variables de entorno
Crea un archivo `.env` en la raíz del proyecto:
```sh
TOKEN=TU_BOT_DISCORD_TOKEN
IdCanalDeDiscord=ID_DEL_CANAL
```

### 4️⃣ Ejecutar la aplicación
```sh
mvn spring-boot:run
```

---

## 📜 Endpoints principales

| Método | Endpoint | Descripción |
|--------|---------|-------------|
| `POST` | `/message` | Crea un mensaje programado |
| `GET` | `/messages` | Lista todos los mensajes programados |
| `DELETE` | `/message/{id}` | Elimina un mensaje programado |

Puedes probar la API con **Swagger UI** accediendo a:
```
http://localhost:8080/swagger-ui/index.html
```

---

## ⚙️ Tecnologías utilizadas
- **Spring Boot 3.4.2**
- **JDA (Java Discord API) 5.0.0-beta.14**
- **Spring Data JPA y Hibernate**
- **MySQL 8**
- **Spring Validation**
- **Swagger para documentación**

---

## 🤝 Contribuciones
¡Las contribuciones son bienvenidas! Si deseas mejorar el proyecto, sigue estos pasos:
1. **Fork** este repositorio.
2. Crea una rama con la nueva funcionalidad: `git checkout -b feature/nueva-funcionalidad`
3. Realiza el commit de tus cambios: `git commit -m 'Agregada nueva funcionalidad'`
4. Sube la rama: `git push origin feature/nueva-funcionalidad`
5. Abre un **Pull Request**.

---

## 📄 Licencia
Este proyecto está licenciado bajo **Apache 2.0**. Puedes ver más detalles en [`LICENSE`](LICENSE).

---

## 🛠 Mantenimiento y contacto
**Autor:** Pablo Aldair Rosas Ramírez  
📧 Email: [rosasramirez753@gmail.com](mailto:rosasramirez753@gmail.com)  
🔗 GitHub: [Dev Asfix](https://github.com/Dev-Asfix)  
💼 LinkedIn: [Pablo Rosas Ramirez](https://www.linkedin.com/in/pablo-rosas-dev/)

---

Hecho con ❤️ por Dev Asfix 🚀