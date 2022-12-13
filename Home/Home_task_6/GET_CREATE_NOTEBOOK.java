package Home.Home_task_6;

public class GET_CREATE_NOTEBOOK {

    String mark, processor, os;
    int ram;
    int rom;

    public GET_CREATE_NOTEBOOK() {

    }

    public void info() {
        System.out.printf("\n----------------\nМарка ноутбука: %s\n", mark);
        System.out.printf("OS: %s; Процессор: %s; ПЗУ: %d Gb; ОЗУ: %d Gb\n", os, processor, rom, ram);
    }

    public int GET_RAM_NOTEBOOK() {
        return ram;
    }

    public int GET_ROM_NOTEBOOK() {
        return rom;
    }

    public String GET_OS_NITEBOOK() {
        return os;
    }

    public String GET_MARK() {
        return mark;
    }

}
