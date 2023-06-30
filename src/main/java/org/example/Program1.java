package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program1 {
   /* 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE
    этого запроса, используя StringBuilder или String. Данные для фильтрации
    приведены ниже в виде json-строки.
    Если значение null, то параметр не должен попадать в запрос.
    Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}*/
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        String fileName = "students1.json";
        Scanner scanner = new Scanner(Paths.get(fileName));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            builder.append(scanner.next());
        }
        scanner.close();
        //System.out.println(builder);

        String str = builder.toString();
        str = str.replaceAll("[{\"]","");
        String[] arrayStr = str.split("}");
       //System.out.println(Arrays.toString(arrayStr));

        for (int i = 0; i < arrayStr.length; i++) {
            if (!arrayStr[i].contains("null")){
                System.out.println(arrayStr[i]);
            }
        }
    }


}
