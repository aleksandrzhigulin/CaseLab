import java.io.*;

public class Human implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    private transient String occupation;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        if (age < 3) this.occupation = "Sitting at home";
        else if (age < 7) this.occupation = "Going to kindergarten";
        else if (age < 18) this.occupation = "Studying at school";
        else if (age < 23) this.occupation = "Studying at university";
        else if (age < 65) this.occupation = "Working";
        else this.occupation = "pension";
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", specialization='" + occupation + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }
}
