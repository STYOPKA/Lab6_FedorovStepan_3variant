import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class lab6_1 {

    public static void main(String[] args) throws IOException {
        Reader in=null; // можно сразу записать FileReader in=null;
        Writer out=null; // можно сразу записать FileWriter out =null;
        try {
            in = new FileReader("C:\\MyFile1.txt"); // файл для чтения
            out= new FileWriter("C:\\MyFile2.txt", true); // файл для записи
            int oneByte; // переменная, в которую считываются данные
            while ((oneByte = in.read()) != -1) {
                out.append((char)oneByte); // запись с добавлением данных в конец
                System.out.print((char)oneByte);
            }
        } catch (IOException e) {
            System.out.println("Ошибка!!!! ");
        }
        // в блоке который выполняется в любом случае обязательно закрываем все потоки
        finally{
            in.close();
            out.close();
        }}
}
