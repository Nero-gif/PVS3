import java.io.*;

public class testFiles {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\user\\IdeaProjects\\PVS3\\testdata\\textInput.txt";
        File f = new File(path);

        System.out.println("File exists: " + f.exists());
        System.out.println("Count of characters: " + f.length());

        BufferedReader br = new BufferedReader(new FileReader(path));
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        System.out.println("Count of lines: " + lines);

        int sentences = 0;
        while (br.read() == '.' ) {
            sentences++;
        }
        System.out.println("Count of lines: " + lines);
        System.out.println("Sentences: " + sentences);

        br.close();
    }
}
