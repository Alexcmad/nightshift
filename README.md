# The Night Shift 🎶  
A **Spotify-like** web-based application that allows users to listen to musical arrangements uploaded by other users. Sheet music for these arrangements is optionally available. Built with **Java Spring Boot, AWS S3, and PostgreSQL**.

## Features ✨  
- **Music Streaming**: Listen to arrangements uploaded by users.
- **User Authentication**: Uses **JWT and OAuth2** for secure access.
- **Playlist Creation**: Logged-in users can create and manage playlists.
- **Sheet Music Storage**: Uploads and stores sheet music as PDFs.
- **AWS Integration**: Uses **AWS S3** for audio storage and **AWS RDS (PostgreSQL)** for data management.
- **Metadata & Search**: Arrangements include title, artist, genre, instrumentation, and tags.

## Development Roadmap 🚀  
✅ **1. Set up project on EC2** ← *You are here*  
⬜ **2. Implement authentication (JWT & OAuth2)**  (skipped for now)
⬜ **3. Set up database schema (PostgreSQL)**  
⬜ **4. Develop API endpoints for user & arrangement management**  
⬜ **5. Integrate AWS S3 for file storage**  
⬜ **6. Implement playlist management**  
⬜ **7. Deploy and optimize for production**  

## Tech Stack 🛠️  
- **Backend**: Java, Spring Boot, Spring Security, REST API
- **Database**: PostgreSQL (AWS RDS)
- **Storage**: AWS S3 for audio & sheet music
- **Authentication**: JWT, OAuth2

## Setup & Installation 🚀  
### Prerequisites:
- Java 17+
- PostgreSQL
- AWS S3 bucket

### Steps:
1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/nightshift.git
   cd nightshift
   ```
2. **Configure database & AWS credentials** in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nightshift
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   
   aws.s3.bucket-name=your-bucket-name
   ```
3. **Build the project**:
   ```sh
   mvn clean package
   ```
4. **Run the application**:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints 📌  
| Method | Endpoint             | Description |
|--------|----------------------|-------------|
| `POST` | `/auth/register`     | Register a new user |
| `POST` | `/auth/login`        | Authenticate user & get JWT |
| `GET`  | `/arrangements`      | Fetch all musical arrangements |
| `POST` | `/arrangements`      | Upload a new arrangement |
| `GET`  | `/playlists`         | Get user playlists |
| `POST` | `/playlists`         | Create a new playlist |

## Future Improvements 🌱  
- Implement **CDN for optimized streaming**
- Develop an **in-app sheet music viewer**
- Advanced **search & filtering options**

## License 📜  
This project is licensed under the **MIT License**.
