// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package Home.Home_task_2;
import java.util.HashMap;
import java.util.Map;


public class Request_1 {
    public static void main(String[] args) {
        Map<String, String> param = new HashMap<String,String>();
        param.put("name","Максим");
        param.put("country","Россия ");
        param.put("city","Челны");
        param.put("age",null);
        System.out.println(getQuery(param));
    }
    public static String getQuery(Map<String, String> param)
    {
        StringBuilder string = new StringBuilder();
        for (Map.Entry<String,String> entry : param.entrySet())
        {
            if (entry.getValue() != null)
            {
                string.append(entry.getKey() +" = '" + entry.getValue()+"' and ");
            }
        }
        string.delete(string.toString().length()-5,string.toString().length());
        return string.toString();
    }
}
