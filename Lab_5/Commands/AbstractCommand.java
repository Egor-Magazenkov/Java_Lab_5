package Lab_5.Commands;
import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.*;

import java.util.Scanner;

/**
 * Abstract class for all commands
 * Consists of method activate
 */
public abstract class AbstractCommand {
    protected String name;
    protected String description;
    protected Control control;
    public AbstractCommand(Control control) {
        this.control = control;
    }
    public abstract void activate(String arg, Scanner sc) throws CommandResultException;

    public abstract String getName();

    public abstract String getDescription();
}
