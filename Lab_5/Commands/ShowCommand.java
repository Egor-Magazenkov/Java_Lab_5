package Lab_5.Commands;

import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;
import Lab_5.Collection.*;
import java.util.HashSet;
import java.util.Scanner;

public class ShowCommand extends AbstractCommand{
    private String name = "show";
    private String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";

    public ShowCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        if (groups.isEmpty()){
            throw new CommandResultException(1, "Пустая коллекция. Нечего выводить.");
        }
        System.out.printf("%6s %10s %12s %20s %25s %35s  %20s %60s %15s", "Id", "Назание", "Координаты", "Форма обучения", "Количество студентов", "Количество отчисленных студентов", "Средняя оценка", "Админ", "Дата создания");
        System.out.println();
        for (StudyGroup studyGroup : groups) {
            System.out.println(studyGroup);
        }
        throw new CommandResultException(0, "");
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}

