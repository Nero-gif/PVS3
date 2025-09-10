import java.util.Arrays;

public class H_250910_B_01 {
    public static void main(String[] args) {
        String neco = "tady je 3";

        for (int i = 0; i < neco.length(); i++) {
            if (Character.isDigit(neco.charAt(i))) {
                String[] arr = neco.split(":");
                System.out.println(Arrays.toString(arr));
                int num = Integer.parseInt(arr[0]);
            }
        }
    }
}
