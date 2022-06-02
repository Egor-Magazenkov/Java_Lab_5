package Lab_5.Commands;

import Lab_5.Collection.StudyGroup;
import Lab_5.Exceptions.AbsenceResultException;
import Lab_5.Exceptions.CommandResultException;
import Lab_5.Utilities.Control;
import Lab_5.Utilities.SortCollection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PrintDescendingCommand extends AbstractCommand{
    private String name = "print_descending";
    private String description = "вывод коллекции в порядке убывания";
    public PrintDescendingCommand(Control control) {
        super(control);
    }

    @Override
    public void activate(String arg, Scanner sc) throws CommandResultException {
        HashSet<StudyGroup> groups = this.control.getGroups();
        try{
            SortCollection sorter = new SortCollection(groups);
            TreeSet<StudyGroup> sorted = sorter.sort_descending();
            for (StudyGroup studyGroup : sorted) {
                for (StudyGroup group :
                        groups) {
                    if (group.getAverageMark() == studyGroup.getAverageMark()){
                        System.out.println(group);
                    }
                }
            }
            throw new CommandResultException(0, "");
        }
        catch(AbsenceResultException e){
            throw new CommandResultException(1, e.getMessage());
        }
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
