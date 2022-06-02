package Lab_5.Commands;

import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;

import java.util.Collection;
import java.util.Scanner;

public class HelpCommand extends AbstractCommand{
    private String name = "help";
    private String description = "вывести справку по доступным командам";

    public HelpCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        Collection<AbstractCommand> commands = control.getCommands();
        System.out.println("Список доступных команд:");

        for (AbstractCommand command :
                commands) {
            System.out.println(command.getName() + " (" + command.getDescription() + ")");
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
