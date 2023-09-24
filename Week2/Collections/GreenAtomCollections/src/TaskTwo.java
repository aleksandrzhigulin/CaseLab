import java.util.Map;
import java.util.stream.Collectors;

public class TaskTwo {
    public static void main(String[] args) {

    }

    private static Map<String, String> swapKeysAndValues(Map<String, String> map) {
        return map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
