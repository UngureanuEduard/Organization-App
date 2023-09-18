package com.example.organizationapp;

import com.example.organizationapp.model.FileModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    public Button button;
    public ImageView imageView;

    @FXML
    private TextField textField;

    @FXML
    private TableView<FileModel> fileTableView;

    private File selectedDirectory;

    @FXML
    private void onImageViewClicked() {
        selectedDirectory = chooseDirectory();

        if (selectedDirectory != null) {
            String folderPath = selectedDirectory.getAbsolutePath();
            textField.setText(folderPath);
            updateTableView();
        }
    }

    @FXML
    private void onButtonClicked() {
        if (selectedDirectory != null) {
            // Create subfolders for organizing files within the selected directory
            File imagesFolder = new File(selectedDirectory, "Images");
            File documentsFolder = new File(selectedDirectory, "Documents");
            File textDocumentsFolder = new File(selectedDirectory, "TextDocuments");
            File otherFolder = new File(selectedDirectory, "Other");

            createFolders(imagesFolder, documentsFolder, textDocumentsFolder, otherFolder);

            // List files in the selected directory
            File[] files = selectedDirectory.listFiles();
            if (files != null) {
                organizeFiles(files, imagesFolder, documentsFolder, textDocumentsFolder, otherFolder);
            }

            updateTableView();
        }
    }

    private void createFolders(File... folders) {
        for (File folder : folders) {
            boolean created = folder.mkdirs();
            if (!created) {
                System.err.println("Failed to create folder: " + folder.getAbsolutePath());
            }
        }
    }

    private void organizeFiles(File[] files, File imagesFolder, File documentsFolder, File textDocumentsFolder, File otherFolder) {
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                // Move files to appropriate subfolders based on their extensions
                File destinationFolder = switch (fileExtension) {
                    case "jpg", "png" -> imagesFolder;
                    case "pdf", "docx" -> documentsFolder;
                    case "txt" -> textDocumentsFolder;
                    default -> otherFolder;
                };

                moveFile(file, new File(destinationFolder, fileName));
            }
        }
    }


    private void moveFile(File sourceFile, File destinationFile) {
        if (sourceFile.renameTo(destinationFile)) {
        } else {
            System.err.println("Failed to move file: " + sourceFile.getAbsolutePath());
        }
    }


    private File chooseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a Folder");
        return directoryChooser.showDialog(new Stage());
    }

    private void updateTableView() {
        if (selectedDirectory != null) {
            // Clear existing items in the TableView
            fileTableView.getItems().clear();

            // List files in the selected directory
            File[] files = selectedDirectory.listFiles();
            if (files != null) {
                List<FileModel> fileModels = new ArrayList<>();
                int index = 1;
                for (File file : files) {
                    String name = file.getName();
                    long size = file.length();
                    fileModels.add(new FileModel(name, size, index));
                    index++;
                }

                // Add the fileModels list to the TableView
                fileTableView.getItems().addAll(fileModels);
            }
        }
    }
}
