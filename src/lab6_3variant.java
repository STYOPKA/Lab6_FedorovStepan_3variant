import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class lab6_3variant {

    // ФЕДОРОВ СТЕПАН ПИЭ 21_1 3 ВАРИАНТ!
    // Не забудьте добавить файл src.txt в диске C
    // Напишите по столбцам несколько слов, которые начинаются с согласными

    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) {

        BufferedReader br = null;
        PrintWriter out = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("C:/src.txt"),"UTF-8"));
            out = new PrintWriter("C:/dst.txt","UTF-8");

            // Переписывание информации из одного файла в другой

            int lineCount = 0;
            String s;

            while ((s = br.readLine()) != null) {
                lineCount++;
                int numWords = 0; // сбрасываем счетчик на каждой строке
                out.print(lineCount + ": "); // записываем номер строки

                // пишем слова
                String tmp[] = s.split(" ");
                // проход по 1 слову в массиве слов строки
                for (int i = 0; i < tmp.length; i++) {
                    // если слово начинается с согласной буквы пищем его и прибавляем счетчик согласных слов
                    if(!isVowel(tmp[i].charAt(0))) {
                        numWords++;
                        out.print(tmp[i] + " ");
                    }
                }
                out.println(" кво слов: " + numWords);
            }
            br.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            out.flush();
            out.close();
        }
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
