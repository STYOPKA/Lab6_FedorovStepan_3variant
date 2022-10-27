import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class lab6_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        PrintWriter out = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C:\\MyFile1.txt"),"UTF-8"));
            out = new PrintWriter("C:\\MyFile2.txt","UTF-8");

            // Переписывание информации из одного файла в другой

            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                out.println(lineCount + ": " + s);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: "+ e);
        } finally {
            br.close();
            out.flush();
            out.close();
        }

    }
}
