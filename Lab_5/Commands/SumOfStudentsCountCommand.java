package Lab_5.Commands;

import Lab_5.Collection.StudyGroup;
import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;

import java.util.HashSet;
import java.util.Scanner;

public class SumOfStudentsCountCommand extends AbstractCommand{
    private String name = "sum_of_students_count";
    private String description = "вывести сумму значений поля studentsCount для всех элементов коллекции";

    public SumOfStudentsCountCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        if (groups.isEmpty()){
            throw new CommandResultException(1, "Пустая коллекция.");
        }
        Long sum = 0L;
        for (StudyGroup studyGroup : groups) {
            sum += studyGroup.getStudentsCount();
        }
        System.out.println(sum);
        throw new CommandResultException(0, "");
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
