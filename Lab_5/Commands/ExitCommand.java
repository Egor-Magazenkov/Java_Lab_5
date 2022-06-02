package Lab_5.Commands;

import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;
import Lab_5.Utilities.SaveToFile;

import java.util.Scanner;

public class ExitCommand extends AbstractCommand{
    private String name = "exit";
    private String description = "завершить программу (без сохранения в файл)";
    public ExitCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        SaveToFile saveToFile = new SaveToFile(control.getGroups(), control.getFilename());
        System.out.println("Выход.\n Всего хорошего)");
        System.exit(1);
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
