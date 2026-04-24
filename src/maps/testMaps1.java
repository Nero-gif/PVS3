package maps;

import javax.security.auth.Subject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class testMaps1 {
    public static void main(String[] args) {
        String dataPath = "testdata/maps1/scores.csv";

        try {
            List<TestResult> results = Files.lines(Path.of(dataPath))
                    .skip(1)
                    .map(line -> line.trim().split(","))
                    .map(parts -> new TestResult(
                                    parts[0],
                                    parts[1],
                                    Double.parseDouble(parts[2]),
                                    Integer.parseInt(parts[3])
                            )
                    )
                    .toList();
            
            results.stream().forEach(System.out::println);

            results.stream()
                    .collect(Collectors.groupingBy(TestResult::getSubject))
                    .forEach((subject, testResults) -> {
                        System.out.println("Subject: " + subject + ", Number of Students: " + testResults.size());
                        System.out.println("Average Score: " + testResults.stream().mapToDouble(TestResult::getScore).average().orElse(0));
                    });
            AtomicInteger sudentsCount = new AtomicInteger();
            
            results.stream()
                    .collect(Collectors.groupingBy(TestResult::getStudentName))
                    .forEach((name, testResults) -> {
                        sudentsCount.getAndIncrement();
                    });
            System.out.println("Unique sudents count: " + sudentsCount);
            
           
                    
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class TestResult {
    String studentName;
    String subject;
    double score;
    int timeSpent;

    public TestResult(String studentName, String subject, double score, int timeSpent) {
        this.studentName = studentName;
        this.subject = subject;
        this.score = score;
        this.timeSpent = timeSpent;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "studentName='" + studentName + '\'' +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", timeSpent=" + timeSpent +
                '}';
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
}
