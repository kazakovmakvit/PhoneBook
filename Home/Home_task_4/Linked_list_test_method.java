package Home.Home_task_4;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.


import java.util.Deque;
import java.util.LinkedList;

public class Linked_list_test_method {

    public static void main(String[] args) {
        Deque<Object> test_method = new LinkedList<>();
        Linked_list_test_method main = new Linked_list_test_method();
        test_method.push(4);
        test_method.push("5");
        test_method.push("6");
        test_method.push("7");
        test_method.push("8");
        test_method.push("9");
        System.out.printf("Составляющая очередь: %s\n", test_method);
        main.enqueue(test_method);
        System.out.printf("Очередь перемещений: %s \n", test_method);
        main.dequeue(test_method);
        System.out.printf("Очередь после удаление 1 эл-та: %s \n", test_method);
        main.first(test_method);
        System.out.printf("Очередь после возврата 1 эл-та: %s \n", test_method);
        
    }
    private void enqueue(Deque<Object> object){
        object.addLast(object.pollFirst());
    }

    public void first(Deque<Object> object){
        System.out.println("1 Элемент: " + object.getFirst());
    }

    private void dequeue(Deque<Object> object){
        System.out.println("Удаление 1 эл-та: " + object.removeFirst());
    }

}