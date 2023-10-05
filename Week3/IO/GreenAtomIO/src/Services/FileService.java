package Services;

import Exceptions.FileAlreadyExistsException;
import Exceptions.UnableToReadException;
import Interfaces.FileManager;

import java.io.*;

public class FileService implements FileManager {
    private final File file;
    public FileService(String fileDir) {
        this.file = new File(fileDir);
    }

    @Override
    public void createFile() {
        if (file.exists()) {
            throw new FileAlreadyExistsException("File already exists");
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Unable to create file");
        }


    }

    @Override
    public void deleteFile() {
        file.delete();
    }

    @Override
    public String readFile() {
        StringBuilder res = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            if (!file.canRead()) {
                throw new UnableToReadException("Unable to read the file");
            }
            reader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new Exceptions.FileNotFoundException();
        }

        return res.toString();
    }

    @Override
    public void writeToFile(String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(content);
            writer.close();
        } catch (Exception e) {
            System.out.println("Unable to write to the file");
        }

    }
}
