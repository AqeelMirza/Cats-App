# CatList App

CatList is an Android application that allows users to view a list of adorable cats along with their descriptions. This project is built using Kotlin and follows the MVVM (Model-View-ViewModel) architecture. It incorporates various modern Android development libraries and best practices to provide a seamless user experience.

## Features

- Display a list of cats with their names and descriptions.
- Implement MVVM architecture for a clean and maintainable codebase.
- Use HILT (Hilt is the new Dagger) for Dependency Injection.
- Manage dependencies using Gradle catalogs.
- Utilize Jetpack Compose for building a modern and responsive UI.
- Load cat images asynchronously using the Coil image loading library.
- Includes unit tests for ViewModel and Repository classes.
- Perform UI testing using Jetpack Compose UI testing framework.

## Screenshots

![CatList App Screenshot](screenshots/screenshot.png)

## Installation

To build and run the CatList app, follow these steps:

1. Clone this repository to your local machine.

   ```bash
   git clone https://github.com/AqeelMirza/catlist.git
   ```

2. Open the project in Android Studio.

3. Build and run the app on an Android emulator or physical device.

## Running the Cat App

1. **Clone the repository:**

    ```bash
    git clone https://github.com/AqeelMirza/Cats-server
    ```

2. **Navigate to the project directory:**

    ```bash
    cd Cats-server
    ```

3. **Install dependencies:**

    ```bash
    npm install
    ```

4. **Start the server:**

    ```bash
    npm start
    ```

## Usage

Upon launching the CatList app, you will be presented with a list of cats along with their descriptions. You can scroll through the list to view more cats. There are no specific user actions required, as the app is designed for a simple viewing experience.

## Dependencies

The following libraries and tools are used in this project:

- [Kotlin](https://kotlinlang.org/) - The primary programming language.
- [HILT](https://developer.android.com/training/dependency-injection/hilt-android) - For dependency injection.
- [Gradle Catelogs](https://docs.gradle.org/current/userguide/dependency_catalogs.html) - To manage dependencies.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - For building the UI.
- [JUnit](https://junit.org/junit5/) - For unit testing.
- [Espresso](https://developer.android.com/training/testing/espresso) - For UI testing.

## Unit Tests

Unit tests are included for ViewModel and Repository classes to ensure the app's functionality remains stable as development progresses. To run unit tests, you can use the following Gradle command:

```bash
./gradlew test
```

## UI Tests

UI tests are included to verify the app's user interface and interactions. To run UI tests, use the following Gradle command:

```bash
./gradlew connectedAndroidTest
```

## Contributions

Contributions to this project are welcome. If you find a bug or have suggestions for improvements, please open an issue or create a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

This project was created with the help of various open-source libraries and resources from the Android development community. We would like to thank all the contributors and maintainers who have made these resources available for use.

Enjoy exploring the world of cats with the CatList app! If you have any questions or need assistance, feel free to reach out to us.

