# Organization App

The Organization App is a JavaFX application designed to help you organize files within a selected directory. It allows you to choose a directory, view the files in that directory, and then organize them into subfolders based on their file types.

![1](https://github.com/UngureanuEduard/Organization-App/assets/130817880/c66676e0-3f36-458e-9fb5-8575d58be67d)
![2](https://github.com/UngureanuEduard/Organization-App/assets/130817880/737ce06a-66fa-4ef9-a437-b1c39aadfa55)
![3](https://github.com/UngureanuEduard/Organization-App/assets/130817880/28cbb60d-4d98-4093-8c87-2e3682aa481d)

## Features

- **Select a Directory**: Choose a directory on your computer where you want to organize files.

- **View Files**: Display a list of files in the selected directory, including their names and sizes, in a TableView.

- **Organize Files**: Organize the files into subfolders within the selected directory based on their file types (e.g., Images, Documents, TextDocuments, Other).
- 
### Prerequisites

Before running the Organization App, you need to have the following software installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html): The app is written in Java, so you need JDK to compile and run it.

### Installation

1. Clone the repository to your local machine:

   ```shell
   git clone <repository-url>
   ```

2. Open the project in your preferred Java development environment (e.g., IntelliJ IDEA, Eclipse).

3. Build and run the `OrganizeApp` class, which serves as the entry point for the application.

## Usage

1. Launch the Organization App by running the `OrganizeApp` class.

2. Click on the folder icon (ImageView) to select a directory that you want to organize.

3. Once a directory is selected, its path will be displayed in the text field.

4. Click the "Organize" button to start organizing files within the selected directory.

5. The app will create subfolders (Images, Documents, TextDocuments, Other) within the selected directory and move files into these folders based on their file types.

6. The TableView will be updated to display the organized files' names, sizes, and indices.
