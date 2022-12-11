package Home.Home_task_5;


// Иван Иванов
// Светлана Петрова
// Кристина Белова
// Анна Мусина
// Анна Крутова
// Иван Юрин
// Петр Лыков
// Павел Чернов
// Петр Чернышов
// Мария Федорова
// Марина Светлова
// Мария Савина
// Мария Рыкова
// Марина Лугова
// Анна Владимирова
// Иван Мечников
// Петр Петин
// Иван Ежов


import java.util.*;
import java.util.stream.Collectors;

public class task_2 {


    public static Map<String,Integer> get_Recurring_Name(ArrayList object){
        Map<String,Integer> usersRecurring = new HashMap<>();
        String[] temp;
        for (Object s: object
             ) {
            String value = (String) s;
            temp = value.split(" ");
            if(usersRecurring.containsKey(temp[0])){
                usersRecurring.put(temp[0], usersRecurring.get(temp[0]) + 1);
            } else usersRecurring.put(temp[0], 1);
        }
        System.out.println("Ключ = имя, число = кол-во повторов : \n" + usersRecurring);
        return usersRecurring;
    }

    public static void main(String[] args) {
        ArrayList<String> users = new ArrayList<>(Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин"
                ,"Иван Ежов"));



        System.out.println("Список сотрудников: \n" + users);
        Map<String,Integer> usersRecurring = get_Recurring_Name(users);
        Map<String,Integer> sortedMapPopularity = usersRecurring.entrySet().stream().sorted(Comparator.comparingInt(i -> -i.getValue())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b)-> {throw new AssertionError();}, LinkedHashMap::new));
        System.out.println("Сортированный список: \n");
        sortedMapPopularity.entrySet().forEach(System.out::println);
    }
}