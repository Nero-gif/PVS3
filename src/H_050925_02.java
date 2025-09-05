import fileworks.DataExport;

public class H_050925_02 {
    public static void main(String[] args) {
        DataExport dataExport = new DataExport("output.txt");

        dataExport.writeLine("ahoj, tohle je první line output souboru hahaha");
        dataExport.finishExport();
    }
}
