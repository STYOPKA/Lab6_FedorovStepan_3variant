import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class lab6_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;
        try {
            br = new BufferedReader( new FileReader("C:\\MyFile1.txt" ), 1024);
            out = new BufferedWriter( new FileWriter( "C:\\MyFile2.txt" ));
            int lineCount = 0;
            String s;

            // Переписывание информации из одного файла в другой
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                out.write(s);
                out.newLine(); // переход на новую строку

            }
        }catch (IOException e) {
            System.out.println(e.getLocalizedMessage());

        } finally{
            br.close();
            out.flush();
            out.close();
        }
    }
}
