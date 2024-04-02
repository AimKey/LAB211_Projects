package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

import Model.UserFile;
import View.FileProgram;

public class Controller {
    private FileProgram view;

    public Controller(FileProgram view) {
        this.view = view;
    }

    public void analyzeFile(UserFile userFile) throws Exception {
        String path = userFile.getFilePath();
        File file = new File(path);
        if (file.exists()) {
            path = file.getAbsolutePath();
            String[] fileFolders = path.split("\\\\");
            String fileName = fileFolders[fileFolders.length - 1];
            userFile.setFileDisk(path.substring(0, 3));
            userFile.setFilePath(path);
            userFile.setFileExtension(fileName.split("[.]")[1]);
            userFile.setFileName(fileName);
            userFile.setFileFolders(fileFolders[fileFolders.length - 2]);
        } else {
            throw new IOException("File does not exist");
        }
        view.displayFile(userFile);
    }

}
