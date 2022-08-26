import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class assignmentJ8 {

    private static Path path = Paths.get("D:\\assignment1\\assignment1.csv");

    static void calAvg() throws IOException {
            // Storing average age of students in list integer.
            List<String> lines = Files.readAllLines(path);
            List<Integer> age = lines.stream().skip(1)
                    .map(s -> Integer.parseInt(s.trim().split(",")[2])).collect(Collectors.toList());
            // Calculating average in OptionalDouble.
            OptionalDouble average = age.stream().mapToDouble(a->a).average();
            System.out.println("Average of all - ");
            age.forEach(System.out::println);
    }

    static void ascSortStudents() throws Throwable{
       List<String> lines = Files.readAllLines(path);
       // Storing students in String list.
       List<String> sortedStudents = lines.stream().skip(1)
               .map(s-> (s.trim().split(",")[1])).collect(Collectors.toList());
       System.out.println("Students sorted in ascending order - ");
       // Sorting in ascending order.
       sortedStudents.stream().sorted().forEach(System.out::println);
    }

    static void ascSortAge() throws Throwable{
        List<String> lines = Files.readAllLines(path);
        // Mapping the age and name in maps
        Map<Object, String> age =
                lines.stream().skip(1).map(line -> line.split(","))
                        .collect(Collectors.toMap(line -> line[2], line -> line[1]));
        // Storing in Treemap to sort according to age.
        TreeMap<Object, String> sortAge = new TreeMap<>(age);
        System.out.println("Age sorted in ascending order - ");
        sortAge.forEach((key,value) -> System.out.println("Name - " + value + " age - " + key));
    }

    static void validStudents() throws Throwable{
        List<String> lines = Files.readAllLines(path);
        // Filtering students who can't appear in exam.
        List<String> valid= lines.stream().skip(1)
                .filter(s -> Integer.parseInt(s.trim().split(",")[2]) < 70).collect(Collectors.toList());
        System.out.println(valid);
    }

    static void desMarks() throws Throwable{
        List<String> lines = Files.readAllLines(path);
        // Storing students who have attendance more than 70%.
        List<String> desMarks = lines.stream().skip(1)
                .filter(s->Integer.parseInt(s.trim().split(",")[3]) >= 70).collect(Collectors.toList());
        // Sorting and reversing in descending order.
        Collections.sort(desMarks);
        Collections.reverse(desMarks);
        desMarks.forEach(System.out::println);
    }

    static void failedStudents() throws Throwable{
        List<String> lines = Files.readAllLines(path);
        // Filtering students who got marks under 30%.
        List<String> failedStudents = lines.stream().skip(1).filter(s->Integer.parseInt(s.trim().split(",")[4]) < 30).collect(Collectors.toList());
        failedStudents.forEach(System.out::println);
    }

    static void variousGroup() throws Throwable{
        List<String> lines = Files.readAllLines(path);
        //Storing various categories in different lists.
        List<String> below30 = lines.stream().skip(1)
                .filter(s->Integer.parseInt(s.trim().split(",")[4]) < 30)
                .collect(Collectors.toList());
        List<String> above30AndBelow50 = lines.stream().skip(1)
                .filter(s->Integer.parseInt(s.trim().split(",")[4]) > 30
                        && Integer.parseInt(s.trim().split(",")[4]) < 50)
                .collect(Collectors.toList());
        List<String> above50AndBelow70 = lines.stream().skip(1)
                .filter(s->Integer.parseInt(s.trim().split(",")[4]) > 50
                        && Integer.parseInt(s.trim().split(",")[4]) < 70)
                .collect(Collectors.toList());
        List<String> above70AndBelow90 = lines.stream().skip(1)
                .filter(s->Integer.parseInt(s.trim().split(",")[4]) > 70
                        && Integer.parseInt(s.trim().split(",")[4]) < 90)
                .collect(Collectors.toList());
        List<String> above90 = lines.stream().skip(1)
                .filter(s->Integer.parseInt(s.trim().split(",")[4]) > 90)
                .collect(Collectors.toList());

        System.out.println("Students below 30%");
        below30.forEach(System.out::println);
        System.out.println("Students above 30% and below 50%");
        above30AndBelow50.forEach(System.out::println);
        System.out.println("Students above 50% and below 70%");
        above50AndBelow70.forEach(System.out::println);
        System.out.println("Students above 70% and below 90%");
        above70AndBelow90.forEach(System.out::println);
        System.out.println("Students above 90%");
        above90.forEach(System.out::println);
    }

    public static void main(String[] args) throws Throwable {
        ReadCSVdata();
        calAvg();
        ascSortStudents();
        ascSortAge();
        validStudents();
        desMarks();
        failedStudents();
        variousGroup();
    }

    private static void ReadCSVdata() throws Throwable{
            List<String> lines = Files.readAllLines(path);
    }
}
