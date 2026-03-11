//package serialization;
//
//import java.awt.*;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//
//public class basics {
//    public static void main(String[] args) {
//        String path = "testdata/points.ser";
//
//        Point a = new Point(0, 0);
//        Point b = new Point(1, 1);
//        Point c = new Point(2, 2);
//
//        System.out.println(a);
//
//        try {
//            ObjectInputStream oos = new ObjectInputStream(new FileOutputStream(path));
//
//            oos.writeObject(a);
//            oos.writeObject(b);
//            oos.writeObject(c);
//
//
//        } catch (IOException e) {
//            System.err.println("Some shit happened");
//
//        }
//    }
//}
