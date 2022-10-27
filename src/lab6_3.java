import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;



public class lab6_3 {
    public static void readAllByByte( Reader in) throws IOException {
        while (true) {
            int oneByte = in.read(); // читает 1 байт
            if (oneByte != -1) { // признак конца файла
                System.out.print((char) oneByte);
            } else {
                System.out.print("\n" + " конец ");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            // С потоком связан файл
            // байтовый поток
            InputStream inFile = new FileInputStream("C:\\MyFile1.txt");
            // символьный поток
            Reader rFile= new InputStreamReader(inFile,"UTF-8");

            readAllByByte(rFile);
            System.out.print("\n\n\n");
            inFile.close();
            rFile.close();

            // С потоком связана интернет-страница
            // байтовый поток
// у меня на google.com timeout почемуто
            InputStream inUrl = new URL("http://mail.ru").openStream();
            // символьный поток
            Reader rUrl=new InputStreamReader(inUrl, "UTF-8");

            readAllByByte(rUrl);
            System.out.print("\n\n\n");
            inUrl.close();
            rUrl.close();

            // С потоком связан массив типа byte
            InputStream inArray = new ByteArrayInputStream( new byte[] {5, 8, 3, 9, 11});
            Reader rArray=new InputStreamReader(inArray,"UTF-8" );

            readAllByByte(rArray);
            System.out.print("\n\n\n");
            inArray.close();
            rArray.close();
        } catch (IOException e) {
            System.out.println("Ошибка: "+ e);
        }

    }
}
