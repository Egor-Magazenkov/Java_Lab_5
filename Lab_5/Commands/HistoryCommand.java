package Lab_5.Commands;

import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HistoryCommand extends AbstractCommand{
    private String name = "history";
    private String description = "Вывод последних 7 успешных команд.";
    public HistoryCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        String[] commandHistory = control.getCommandHistory();
        if (commandHistory[0] == null){
            System.out.println("Не было успешных команд. История пуста!");
        }
        else {
            System.out.println("Последние использованные команды:");
            for (String command :
                    commandHistory) {
                if (command != null) System.out.println(command);
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
