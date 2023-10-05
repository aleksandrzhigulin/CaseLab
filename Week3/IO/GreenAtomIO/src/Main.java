import Services.FileService;

public class Main {
    public static void main(String[] args) {
        String dir = "";
        String operation = "";
        try {
            dir = args[0];
            operation = args[1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Command not found");
            System.exit(0);
        }

        FileService fileService = new FileService(dir);

        switch (operation) {
            case "-create":
                fileService.createFile();
                break;
            case "-read":
                System.out.println(fileService.readFile());
                break;
            case "-delete":
                fileService.deleteFile();
                break;
            case "-write":
                fileService.writeToFile(args[2]);
                break;
        }
    }
}