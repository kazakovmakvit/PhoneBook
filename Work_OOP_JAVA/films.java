import java.util.ArrayList;
import java.util.Scanner;

public class films {
    public static void main(String[] args) {
        Applicanion.run();
    }
}

class Movie {
    int id;
    String name;
    int creatorID;
    int producerID;
    int release_dateID;
    int total_episodesID;

    public Movie(int id, String name, int creatorID, int producerID, int release_dateID, int total_episodesID) {
        this.id = id;
        this.name = name;
        this.creatorID = creatorID;
        this.producerID = producerID;
        this.release_dateID = release_dateID;
        this.total_episodesID = total_episodesID;
    }

}

class Producer {
    int id;
    String name;

    public Producer(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Release_date {
    int id;
    String release_date;

    public Release_date(int id, String release_date) {
        this.id = id;
        this.release_date = release_date;
    }
}

class Film_duration {
    int id;
    String film_duration;

    public Film_duration(int id, String film_duration) {
        this.id = id;
        this.film_duration = film_duration;
    }
}

class Total_episodes {
    int id;
    String total_episodes;

    public Total_episodes(int id, String total_episodes) {
        this.id = id;
        this.total_episodes = total_episodes;
    }
}

class DataBases {
    ArrayList<Movie> film_name = new ArrayList<>();
    ArrayList<Producer> producers = new ArrayList<>();
    ArrayList<Release_date> date = new ArrayList<>();
    ArrayList<Film_duration> duration = new ArrayList<>();
    ArrayList<Total_episodes> episodes = new ArrayList<>();

}

class DataBasesAPI {
    int filmsIDg;
    int producerIDg;
    int release_dateIDg;
    int durationIDg;
    int total_episodesIDg;

    DataBases db;

    private int get_ProducerIDg() {
        return producerIDg++;

    }

    private int get_Release_dateIDg() {
        return release_dateIDg++;

    }

    private int get_DurationIDg() {
        return durationIDg++;

    }

    private int get_total_episodesIDg() {
        return total_episodesIDg++;

    }

    public void init() {
        db = new DataBases();

        producerIDg = -1;
        Producer Producer_1 = new Producer(get_ProducerIDg(), "Продюсер: Алекс Маркес");
        Producer Producer_2 = new Producer(get_ProducerIDg(), "Продюсер: Пётр Точилин");
        Producer Producer_3 = new Producer(get_ProducerIDg(), "Продюсер: Андрей Лошак");

        db.producers.add(Producer_1);
        db.producers.add(Producer_2);
        db.producers.add(Producer_3);

        release_dateIDg = -1;
        Release_date r_date_1 = new Release_date(get_Release_dateIDg(), "Дата выхода: 2016-09-16");
        Release_date r_date_2 = new Release_date(get_Release_dateIDg(), "Дата выхода: 2006-08-10");
        Release_date r_date_3 = new Release_date(get_Release_dateIDg(), "Дата выхода: 2022-03-01");

        db.date.add(r_date_1);
        db.date.add(r_date_2);
        db.date.add(r_date_3);

        durationIDg = -1;
        Film_duration f_d_1 = new Film_duration(get_DurationIDg(), "Длительность: 1ч:35м");
        Film_duration f_d_2 = new Film_duration(get_DurationIDg(), "Длительность: 1ч:33м");
        Film_duration f_d_3 = new Film_duration(get_DurationIDg(), "Длитнльность: 40 минут серия");

        db.duration.add(f_d_1);
        db.duration.add(f_d_2);
        db.duration.add(f_d_3);

        total_episodesIDg = -1;
        Total_episodes tEpisodes_1 = new Total_episodes(get_total_episodesIDg(), "Всего серий: 1 фильм");
        Total_episodes tEpisodes_2 = new Total_episodes(get_total_episodesIDg(), "Всего серий: 1 фильм");
        Total_episodes tEpisodes_3 = new Total_episodes(get_total_episodesIDg(), "Всего серий: 7 серий");

        db.episodes.add(tEpisodes_1);
        db.episodes.add(tEpisodes_2);
        db.episodes.add(tEpisodes_3);

        db.film_name.add(new Movie(1, "---////----\nФильм: Хакер", 1, 1, 1, 1));
        db.film_name.add(new Movie(2, "---////----\\nФильм: Хоттабыч", 2, 2, 2, 2));
        db.film_name.add(new Movie(3, "---////----\\nСериал: Холивар", 3, 3, 3, 3));
    }

    public DataBases get_Bases() {
        return db;
    }
}

class Film_info {

    String name_film;
    String producer;
    String release_date;
    String duration;
    String total_episodes;

    public Film_info(String name_film, String producer, String release_date, String duration,
            String total_episodes) {
        this.name_film = name_film;
        this.producer = producer;
        this.release_date = release_date;
        this.duration = duration;
        this.total_episodes = total_episodes;
    }

    @Override
    public String toString() {

        return String.format("%s -> %s -> %s -> %s -> %s",
                name_film,
                producer,
                release_date,
                duration,
                total_episodes);
    }

}

class Search_film {
    DataBases db;

    public Search_film(DataBases db) {
        this.db = db;
    }

    public Film_info getFilm(int id) {

        Movie f = db.film_name.get(id);
        Producer p = db.producers.get(id);
        Release_date rD = db.date.get(id);
        Film_duration fD = db.duration.get(id);
        Total_episodes tE = db.episodes.get(id);

        return new Film_info(f.name, p.name, rD.release_date, fD.film_duration, tE.total_episodes);
    }
}

class Applicanion {
    public static void run(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите id для вывода информации о фильме: \n1-Хакер \n2-Хоттабыч \n3-Холивар\n---////----");
        int id_film = scan.nextInt();
        scan.close();


        DataBasesAPI dbAPI = new DataBasesAPI();
        dbAPI.init();
        DataBases db = dbAPI.get_Bases();
        Search_film sF = new Search_film(db);

        if (id_film > 4 & id_film < 1){
            System.out.println("Нет id в каталоге");
        }else{
            System.out.println(sF.getFilm(id_film-1));
        }

    }

}
