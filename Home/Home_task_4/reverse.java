package Home.Home_task_4;
import java.util.Collections;
import java.util.LinkedList;

public class reverse {
    public static void main(String[] args) {

        LinkedList<Integer> Int_list = new LinkedList<>();

        Int_list.add(5);
        Int_list.add(4);
        Int_list.add(55);
        Int_list.add(666);
        Int_list.add(7777);
        Int_list.add(1055);
        Int_list.add(1459675);

        
        System.out.println(Int_list);

        Collections.reverse(Int_list);

        System.out.println(Int_list);
    }
}