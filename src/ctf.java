import java.io.*;

public class ctf {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\IdeaProjects\\PVS3\\testdata\\ctf\\ctf\\final\\";

        for (int i = 1; i < 21; i++) {
            String prefix = "file" + i + "_";

            File dir = new File(path);
            File[] files = dir.listFiles((d, name) -> name.startsWith(prefix));

            if (files == null || files.length == 0) continue;

            try (BufferedReader br = new BufferedReader(new FileReader(files[0]))) {
                while (br.readLine() != null) {
                    String[] parse = br.readLine().split(";");
                    while (parse[0].equals(new StringBuilder(parse[2]).reverse().toString())) {
                        for (int j = 0; j < parse.length; j++) {
                            System.out.println(parse[j]);
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
