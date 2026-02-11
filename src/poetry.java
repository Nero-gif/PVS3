import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class poetry {
    public static void main(String[] args) {
        String path = "testdata\\poetry\\";
        ArrayList<String> poems = new ArrayList<>();
//        Scanner fsc = new Scanner();
        try {
            File[] fileList = new File(path).listFiles();
            for (File file : fileList) {
                if (getFileExtension(file.getName()).equals("txt") && file.length() <= 2*1024*1024){
                    Scanner fsc = new Scanner(file.getAbsoluteFile());
                    StringBuilder sb = new StringBuilder();
                    while (fsc.hasNextLine()) {
                        sb.append(fsc.nextLine());
                        if (fsc.hasNextLine()) {
                            sb.append(System.lineSeparator());
                        }
                    }
                    fsc.close();
                    poems.add(file.getName() + ";" + sb.toString());
                };
            }
//            poems.sort((a, b) -> {
//                int ai = a.indexOf(';');
//                int bi = b.indexOf(';');
//                int alen = ai >= 0 ? a.length() - (ai + 1) : 0;
//                int blen = bi >= 0 ? b.length() - (bi + 1) : 0;
//                return Integer.compare(blen, alen);
//            });
            for (int i = 0; i < poems.size(); i++) {
                System.out.println(poems.get(i));
            }

        } catch (NullPointerException e){
            throw new RuntimeException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


}
