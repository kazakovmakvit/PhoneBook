package Home.Home_task_6;

import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;

public class Filter_methods_notebook {

    public static void GET_FILTER_RAM(HashSet<GET_CREATE_NOTEBOOK> note, int ram) {
        Stream<GET_CREATE_NOTEBOOK> str = note.stream();
        str.filter(n -> n.GET_RAM_NOTEBOOK() >= ram)
                .sorted(Comparator.comparingInt(GET_CREATE_NOTEBOOK::GET_RAM_NOTEBOOK))
                .forEach(GET_CREATE_NOTEBOOK::info);
    }

    public static void FILTER_MARK_buy(HashSet<GET_CREATE_NOTEBOOK> note, String br) {
        Stream<GET_CREATE_NOTEBOOK> str = note.stream();
        str.filter(n -> n.getMark().equals(br)).forEach(GET_CREATE_NOTEBOOK::info);
    }

    public static void GET_FILTER_ROM_buy(HashSet<GET_CREATE_NOTEBOOK> note, int rom) {
        Stream<GET_CREATE_NOTEBOOK> str = note.stream();
        str.filter(n -> n.getRom() >= rom).sorted(Comparator.comparingInt(GET_CREATE_NOTEBOOK::getRom))
                .forEach(GET_CREATE_NOTEBOOK::info);
    }

    public static void FILTER_OS_buy(HashSet<GET_CREATE_NOTEBOOK> note, String os) {
        Stream<GET_CREATE_NOTEBOOK> str = note.stream();
        str.filter(n -> n.GET_OS_NITEBOOK().equals(os)).forEach(GET_CREATE_NOTEBOOK::info);
    }
}
