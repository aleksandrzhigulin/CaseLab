import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Set<Integer> treeSet = new TreeSet<>();
        Set<Integer> hashSet = new HashSet<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            arrayList.add(i);
        }
        System.out.println("ArrayList 10mil elements added: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            linkedList.add(i);
        }
        System.out.println("LinkedList 10mil elements added: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            treeSet.add(i);
        }
        System.out.println("TreeSet 10mil elements added: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            hashSet.add(i);
        }
        System.out.println("HashSet 10mil elements added: " + (System.currentTimeMillis() - startTime) + "ms");

        // Поиск 5 миллионного элемента:
        startTime = System.currentTimeMillis();
        arrayList.indexOf(5_000_000);
        System.out.println("ArrayList 5mil element find: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.indexOf(5_000_000);
        System.out.println("LinkedList 5mil element find: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        treeSet.contains(5_000_000);
        System.out.println("TreeSet 5mil element find: " + (System.currentTimeMillis() - startTime) + "ms");
        hashSet.contains(5_000_000);

        startTime = System.currentTimeMillis();
        linkedList.indexOf(5_000_000);
        System.out.println("HashSet 5mil element find: " + (System.currentTimeMillis() - startTime) + "ms");

        // Удаление элемента
        startTime = System.currentTimeMillis();
        Integer integer = 5_000_000;
        arrayList.remove(integer);
        System.out.println("ArrayList 5mil element remove: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        linkedList.remove(integer);
        System.out.println("LinkedList 5mil element remove: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        treeSet.remove(5_000_000);
        System.out.println("TreeSet 5mil element remove: " + (System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        hashSet.remove(5_000_000);
        System.out.println("HashSet 5mil element remove: " + (System.currentTimeMillis() - startTime) + "ms");
    }


}