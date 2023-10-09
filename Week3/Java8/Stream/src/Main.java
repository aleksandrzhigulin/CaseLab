import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Developer dev1 = new Developer("Наташа", Arrays.asList("Java", "C++"));
        Developer dev2 = new Developer("Эрнест", Arrays.asList("Java", "Python"));
        Developer dev3 = new Developer("Элла", Arrays.asList("С#", "Python", "JavaScript"));
        Stream<Developer> developerStream = Stream.of(dev1, dev2, dev3);


        List topDevelopers = developerStream
                .sorted(Comparator.comparingInt(dev -> -Developer.getCountUniqueLanguages(dev.getLanguages())))
                .limit(2)
                .collect(Collectors.toList());


        System.out.println(topDevelopers);

    }
}