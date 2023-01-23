using CodeLogic;
using Parsing;
using Scheudules;
using Students;

namespace Menu
{
    public class MainMenu
    {
        public void mainMenu()
        {
            Logic logic = new Logic();
            JsonParsing parser = new JsonParsing();
            bool flag = true;
            bool modeSelected = false;
            int mode = 0;
            Student[] students = new Student[] { };
            Scheudule[] scheudule = new Scheudule[] { };
            while (flag)
            {
                while (!modeSelected)
                {
                    Console.WriteLine("Меню:\n1 - Студент,\n2 - Преподаватель");
                    switch (Console.ReadLine())
                    {
                        case "1":
                            mode = 1;
                            modeSelected = true;
                            break;
                        case "2":
                            mode = 2;
                            modeSelected = true;
                            break;
                        default:
                            Console.WriteLine("Ввод не верен, попробуйте еще раз");
                            break;
                    }
                }
                Console.WriteLine(@"Options: 1 - Добавить учеников в базу данных
                    2 - Загрузка тестовых данных (даные вшиты для проверки)
                    3 - Загрузить список студентов из файла
                    4 - Загрузить расписание из файла
                    5 - Вывести список студентов
                    6 - Вывести расписание
                    7 - Экспортировать файл со студентами
                    8 - Экспортировать файл с расписанием
                    0 - Выход");
                switch (Console.ReadLine())
                {
                    case "1":
                        if (mode != 2)
                        {
                            Console.WriteLine("Доступ запрещен");
                        }
                        else
                        {
                            students = logic.createStudentsList();
                        }
                        break;
                    case "2":
                        if (mode != 2)
                        {
                            Console.WriteLine("Доступ запрещен");
                        }
                        else
                        {
                            scheudule = logic.createScheudule();
                        }
                        break;
                    case "3":
                        students = parser.readStudentsFromFile();
                        break;
                    case "4":
                        scheudule = parser.readScheuduleFromFile();
                        break;
                    case "5":
                        logic.printStudents(students);
                        break;
                    case "6":
                        logic.printScheudule(scheudule);
                        break;
                    case "7":
                        if (mode != 2)
                        {
                            Console.WriteLine("Доступ запрещен");
                        }
                        else
                        {
                            parser.writeStudentsToFile(students);
                        }
                        break;
                    case "8":
                        if (mode != 2)
                        {
                            Console.WriteLine("Доступ запрещен");
                        }
                        else
                        {
                            parser.writeScheuduleToFile(scheudule);
                        }
                        break;
                    case "0":
                        Console.WriteLine("Завершение приложения");
                        flag = false;
                        break;
                    default:
                        Console.WriteLine("Неверный ввод, попробуйте снова");
                        break;
                }
            }
        }
    }
}