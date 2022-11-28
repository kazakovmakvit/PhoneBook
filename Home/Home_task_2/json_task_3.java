// 3**Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.
// https://comaqa.gitbook.io/java-automation/rabota-s-failami/rabota-s-json-failami

package Home.Home_task_2;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class json_task_3 {
    private static final String Surname = "Фамилия";
    private static final String Grade = "Оценка";
    private static final String Subject = "Предмет";
    private static final String File_students = "Students.json";
    private static final String Stud = "Students";

    public static void main(String[] args) throws Exception {
        // Создаю Json объект эдентичный объекту из задания.
        JSONArray jsonArray = new JSONArray();
        JSONObject Student_1 = GetJSON("Иванов", "5", "Математика");
        JSONObject Student_2 = GetJSON("Петрова", "4", "Информатика");
        JSONObject Student_3 = GetJSON("Краснов", "5", "Физика");
        JSONObject jsonObject = new JSONObject();
        jsonArray.add(Student_1);
        jsonArray.add(Student_2);
        jsonArray.add(Student_3);
        jsonObject.put("Students", jsonArray);
        // Объект создан.
        System.out.println();
        System.out.println(jsonObject);
        System.out.println("\n Сохранение Students.json");
        GetPrintJSON(jsonObject); 

        JSONObject object = (JSONObject) GetReadJSON((File_students));

        System.out.println("\n Чтение Students.json.\n");
        System.out.println(object);

        JSONArray StudentsArray = (JSONArray) object.get(Stud);

        System.out.println("\nСписок студентов:\n");
        for (Object i : StudentsArray) {
            JSONObject StudentsJsonObject = (JSONObject) i;

            String name_Students = (String) StudentsJsonObject.get(Surname);
            String Grade_Students = (String) StudentsJsonObject.get(Grade);
            String Subject_Studetn = (String) StudentsJsonObject.get(Subject);
            System.out.printf("Студент %s получил %s по предмету %s.\n", name_Students, Grade_Students,
                    Subject_Studetn);
        }

        StringBuilder result = new StringBuilder();

        System.out.println(
                "\n--------------------StringBuilder--------------------------\n\nСписок студентов (StringBuilder)\n");
        for (Object i : StudentsArray) {
            JSONObject Students = (JSONObject) i;
            result.append("Студент " + (String) Students.get(Surname) + " ");
            result.append("получил " + (String) Students.get(Grade) + " ");
            result.append("по предмету " + (String) Students.get(Subject) + ".");
            System.out.println(result);
            result = new StringBuilder();
        }
    }

    public static JSONObject GetJSON(String secondName, String mark, String object) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put(Surname, secondName);
        jsonObject.put(Grade, mark);
        jsonObject.put(Subject, object);

        return jsonObject;
    }

    public static void GetPrintJSON(JSONObject object) throws Exception {

        Files.write(Paths.get(File_students), object.toJSONString().getBytes());
    }

    public static Object GetReadJSON(String filename) throws Exception {

        try (FileReader reader = new FileReader(filename)) {
            JSONParser parser = new JSONParser();
            return parser.parse(reader);
        }
    }

}
