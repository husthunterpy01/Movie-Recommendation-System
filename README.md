# Movie Recommendation System

An app-based movie recommendation system using MySQL and Java Swing.

## Overview

This project is a desktop application designed to recommend movies to users based on their preferences and viewing history. Built with Java Swing for the front-end interface and MySQL as the backend database, it showcases how traditional technologies can be combined to create interactive and user-friendly applications.

## Features

- **User Authentication:** Sign up and log in securely.
- **Movie Browsing:** View the catalog of movies with detailed information.
- **Personalized Recommendations:** Receive movie suggestions based on your viewing history, ratings, and preferences.
- **Search & Filter:** Search for movies by title, genre, year, or other filters.
- **Rate & Review:** Users can rate and leave reviews on movies they have watched.
- **Favorites List:** Add movies to a favorites/watchlist.
- **Admin Panel:** For managing the movie database (add, remove, update movie details).

## Technologies Used

- **Java** (Java Swing for GUI)
- **MySQL** (for persistent data storage)
- **JDBC** (Java Database Connectivity)

## Getting Started

### Prerequisites

- Java JDK 8 or above
- MySQL Server
- IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

### Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/husthunterpy01/Movie-Recommendation-System.git
   cd Movie-Recommendation-System
   ```

2. **Set up the MySQL Database:**
   - Create a new database in MySQL (e.g., `moviedb`).
   - Run the SQL scripts provided in the `/db` directory (if present) to set up the tables and sample data.
   - Update the database connection configuration in the Java project (`DBConnection.java` or similar file) with your MySQL credentials.

3. **Build and Run the Application:**
   - Import the project into your IDE.
   - Make sure the MySQL JDBC driver `.jar` is included in the project dependencies.
   - Compile and run the main class (e.g., `Main.java` or `MovieRecommendationSystem.java`).

## Project Structure

```
/src            # Java source files
/db             # SQL scripts and sample data
/resources      # Images, icons, and static assets
README.md       # Project readme
...
```

## Screenshots

_Add screenshots of the UI here when available._

## Contributing

Contributions are welcome! Feel free to submit a pull request or open issues for bug reports and feature requests.

## License

This project is licensed under the MIT License.

## Author

- [husthunterpy01](https://github.com/husthunterpy01)
