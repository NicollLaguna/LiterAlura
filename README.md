# LiterAlura 📚

A Java application designed to provide a comprehensive literary search experience using external APIs. Built with Spring Boot, LiterAlura allows users to search for books, authors, and filter results by language or other criteria. The application uses the **Gutendex API** to fetch literary data and **Jackson** for JSON processing.

---

## Features 🌟

- **Search for books by title:** Retrieve detailed information about books by entering a title. The application queries the **Gutendex API** to find books based on the provided title.
- **List all books:** View a complete collection of books stored in the repository.
- **List authors:** Display a list of authors from the stored books.
- **Filter books by language:** Search for books available in a specific language.
- **Filter authors alive in a specific year:** Find authors who were alive during a given year.

---

## Requirements ⚙️

- Java 11 or higher
- Spring Boot
- Maven or Gradle
- Jackson (for JSON processing)

---

## Installation 🚀

1. Clone the repository:
   git clone https://github.com/NicollLaguna/LiterAlura.git

Navigate to the project directory:
cd LiterAlura

Install dependencies using Maven or Gradle:

Maven:
mvn install

Gradle:
gradle build

Run the application:
mvn spring-boot:run

Or if you’re using Gradle:
gradle bootRun

## How it Works 🔧
The application connects to the Gutendex API to retrieve data about books, authors, and languages. The API URL used is:

private String urlBase = "https://gutendex.com/books?search=%20";
Jackson is used to parse the JSON response returned from the API and convert it into Java objects for further processing.

## Usage 🖥️
Once the application is running, you can interact with it through the command line interface. The menu will prompt you to choose between different options such as searching books by title, listing all books, or filtering results by language.

For example, you can search for books by their title. The application sends a request to the Gutendex API and displays the results, such as the book's title, author(s), and language(s).

## Contributing 🤝
Feel free to fork the repository and submit pull requests. If you encounter any issues or have suggestions for improvements, please open an issue in the GitHub repository.

## License 📄
This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments 🙏
- Spring Boot for the backend framework
- Jackson for parsing JSON data
- Gutendex API for providing free access to a vast collection of books and literary data
- External APIs for book and author data
---
Enjoy exploring the world of literature with LiterAlura! 😊
