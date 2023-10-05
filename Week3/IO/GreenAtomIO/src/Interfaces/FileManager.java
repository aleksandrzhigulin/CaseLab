package Interfaces;

public interface FileManager {
    void createFile();
    void deleteFile();

    String readFile();

    void writeToFile(String content);
}
