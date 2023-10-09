
import java.util.List;

public class Developer {
    private String name;
    private List<String> languages;

    public Developer(String name, List<String> languages) {
        this.name = name;
        this.languages = languages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    public static int getCountUniqueLanguages(List languages) {
        return (int) languages.stream().distinct().count();
    }

    @Override
    public String toString() {
        return name;
    }
}
