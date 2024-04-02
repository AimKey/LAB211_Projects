package Model;

public class UserFile {
    private String filePath, fileName, fileExtension, fileDisk, fileFolders;

    public UserFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        String s = String.format("Disk: %s\nExtension: %s\nFile name: %s\nPath: %s\nFolders: [%s]", fileDisk,
                fileExtension, fileName, filePath, fileFolders);
        return s;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setFileDisk(String fileDisk) {
        this.fileDisk = fileDisk;
    }

    public void setFileFolders(String fileFolders) {
        this.fileFolders = fileFolders;
    }

}
