package Lab_5.Utilities;
import Lab_5.Collection.*;
import Lab_5.Commands.*;
import Lab_5.Exceptions.CommandResultException;

import java.io.File;
import java.util.*;

public class Control {
    private final File filename;
    private HashSet<StudyGroup> groups;
    private boolean fromFile;
    private HashMap<String, AbstractCommand> commands;
    private final Date dateInitialization;
    public Date dateSave;
    private Date dateChange;
    private String[] commandHistory = new String[7];

    private HelpCommand helpCommand;
    private ShowCommand showCommand;
    private AddCommand addCommand;
    private UpdateIdCommand updateIdCommand;
    private RemoveByIdCommand removeByIdCommand;
    private ClearCommand clearCommand;
    private ExecuteScriptCommand executeScriptCommand;
    private ExitCommand exitCommand;
    private AddIfMinCommand addIfMinCommand;
    private RemoveLowerCommand removeLowerCommand;
    private RemoveAllByGroupAdminCommand removeAllByGroupAdminCommand;
    private SumOfStudentsCountCommand sumOfStudentsCountCommand;
    private PrintDescendingCommand printDescendingCommand;
    private InfoCommand infoCommand;
    private HistoryCommand historyCommand;
    {
        groups = new HashSet<StudyGroup>();
        infoCommand = new InfoCommand(this);
        updateIdCommand =  new UpdateIdCommand(this);
        addCommand = new AddCommand(this);
        showCommand = new ShowCommand(this);
        helpCommand = new HelpCommand(this);
        removeByIdCommand = new RemoveByIdCommand(this);
        addIfMinCommand = new AddIfMinCommand(this);
        clearCommand = new ClearCommand(this);
        removeLowerCommand = new RemoveLowerCommand(this);
        exitCommand = new ExitCommand(this);
        executeScriptCommand = new ExecuteScriptCommand(this);
//        saveCommand = new SaveCommand(this);
        removeAllByGroupAdminCommand = new RemoveAllByGroupAdminCommand(this);
        sumOfStudentsCountCommand = new SumOfStudentsCountCommand(this);
        printDescendingCommand = new PrintDescendingCommand(this);
        historyCommand = new HistoryCommand(this);

        commands = new HashMap<String, AbstractCommand>(){{
            put("update_id", updateIdCommand);
            put("exit", exitCommand);
            put("remove_by_id", removeByIdCommand);
            put("add", addCommand);
            put("add_if_min", addIfMinCommand);
            put("execute_script", executeScriptCommand);
            put("clear", clearCommand);
            put("show", showCommand);
            put("info", infoCommand);
            put("sum_of_students_count", sumOfStudentsCountCommand);
            put("remove_all_by_group_admin", removeAllByGroupAdminCommand);
            put("print_descending", printDescendingCommand);
            put("remove_lower", removeLowerCommand);
            put("help", helpCommand);
            put("history", historyCommand);
        }};
    }

    public Control(HashSet<StudyGroup> groups, File filename){
        this.filename = filename;
        this.groups = groups;
        dateInitialization = dateSave = dateChange = new Date();
    }


    public void processing(String textCommand){
        String[] trimCommand = textCommand.trim().split(" ", 2);
        fromFile = false;
        if(commands.containsKey(trimCommand[0])){
            try {
                commands.get(trimCommand[0]).activate(trimCommand.length < 2 ? "" : trimCommand[1], new Scanner(System.in));
            } catch (CommandResultException e) {
                if (e.getStatus() == 0){
                    for (int i = 7-1; i>0; i--) {
                        commandHistory[i] = commandHistory[i-1];
                    }
                    commandHistory[0] = textCommand;
                }
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Нет такой команды!");
        }
    }
    public void processing(String textCommand, Scanner sc){
        String[] trimCommand = textCommand.trim().split(" ", 2);
        fromFile = true;
        if(commands.containsKey(trimCommand[0])){
            try {
                commands.get(trimCommand[0]).activate(trimCommand.length < 2 ? "" : trimCommand[1], sc);
            } catch (CommandResultException e) {
                if (e.getStatus() == 0){
                    for (int i = 7-1; i>0; i--) {
                        commandHistory[i] = commandHistory[i-1];
                    }
                    commandHistory[0] = textCommand;
                }
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Нет такой команды!");
        }
    }


    public HashSet<StudyGroup> getGroups(){
        return this.groups;
    }
    public Date getDateInitialization(){
        return dateInitialization;
    }

    public Date getDateChange() {
        return dateChange;
    }

    public Date getDateSave() {
        return dateSave;
    }

    public Collection<AbstractCommand> getCommands() {
        return commands.values();
    }

    public String[] getCommandHistory() {
        return commandHistory;
    }

    public boolean isFromFile() {
        return fromFile;
    }

    public File getFilename() {
        return filename;
    }
}
