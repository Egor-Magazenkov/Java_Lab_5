package Lab_5.Exceptions;

public class AbsenceResultException extends Exception{
    private String message;
    public AbsenceResultException(String m){
        this.message = m;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
