package Lab_5.Commands;

import Lab_5.Collection.StudyGroup;
import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;

public class InfoCommand extends AbstractCommand{
    private String name = "info";
    private String description = "получить информацию о коллекции";

    public InfoCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = control.getGroups();
        Date dateInitialization = control.getDateInitialization();
        Date dateSave = control.getDateSave();
        Date dateChange = control.getDateChange();
        System.out.println("Дата загрузки: " + dateInitialization +
                "\nДата сохранения: " + dateSave +
                "\nДата изменения: " + dateChange +
                "\nТип коллекции: " + groups.getClass() +
                "\nКоличество элементов: " + groups.size());
        throw new CommandResultException(0, "");
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
