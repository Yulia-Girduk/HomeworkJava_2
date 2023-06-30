package org.example;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program2 {
    /*2) Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
    Написать метод(ы), который распарсит json и, используя StringBuilder,
    создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
    Пример вывода:
    Студент Иванов получил 5 по предмету Математика.
    Студент Петрова получил 4 по предмету Информатика.
    Студент Краснов получил 5 по предмету Физика.*/

    public static void main(String[] args) throws IOException {
        String fileName = "students2.json";
        Scanner scanner = new Scanner(Paths.get(fileName));
        scanner.useDelimiter(System.getProperty("line.separator"));
        StringBuilder builder = new StringBuilder();
        while(scanner.hasNext()){
            builder.append(scanner.next());
        }
        scanner.close();
        System.out.println(builder);

        String str = builder.toString();
        str = str.replaceAll("[:,]"," ");
        str = str.replaceAll("[{\"]","");
        System.out.println(str);
        String[] arrayStr = str.split("}");
        //System.out.println(Arrays.toString(arrayStr));

        for (int i = 0; i < arrayStr.length; i++) {
            if (arrayStr[i].startsWith(" ")) {
                arrayStr[i] = arrayStr[i].replaceFirst(" ", "");
            }
            arrayStr[i] = arrayStr[i].replace("фамилия", "Студент");
            arrayStr[i] = arrayStr[i].replace("оценка", "получил");
            arrayStr[i] = arrayStr[i].replace("предмет", "по предмету");
            arrayStr[i] = arrayStr[i] + ".";
            System.out.println(arrayStr[i]);
        }
    }
}

