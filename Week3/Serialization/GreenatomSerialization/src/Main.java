import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human human = new Human("Aleksandr", 18);
        // Serialization
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Aleksandr\\Desktop\\human.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // Save to file
        objectOutputStream.writeObject(human);

        objectOutputStream.close();

        // Deserialization
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Aleksandr\\Desktop\\human.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Human humanDeserialized = (Human) objectInputStream.readObject();
        Human deserializated = new Human(humanDeserialized.getName(), humanDeserialized.getAge());
        System.out.println("Human:" + human);
        System.out.println("Deserialized:" + deserializated);
    }
}