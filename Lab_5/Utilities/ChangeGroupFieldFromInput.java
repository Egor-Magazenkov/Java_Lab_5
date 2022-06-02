package Lab_5.Utilities;

import Lab_5.Collection.*;
import Lab_5.Exceptions.SetResultException;
import Lab_5.Exceptions.WrongFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ChangeGroupFieldFromInput {
    private StudyGroup group;
    Scanner sc = new Scanner(System.in);
    public ChangeGroupFieldFromInput(StudyGroup group){
        this.group = group;
    }

    public void change_name(){
        System.out.println("Введите имя группы");
        while (true) {
            String name = sc.nextLine();
            try {
                group.setName(name);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте еще раз");
            }
        }
    }

    public void change_coordinate(){
        System.out.println("Координаты группы");
        Coordinates coords = new Coordinates();

        System.out.println("Введите x координату группы");
        while (true){
        Double x;
            try {
                x = sc.nextDouble();
                coords.setX(x);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Требуется число типа Double.");
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }
        }
        System.out.println("Введите y координату группы");
        while (true) {
            try {
                float y = sc.nextFloat();
                coords.setY(y);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Требуется число типа float.");
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }
        }
        while (true) {
            try {
                group.setCoordinates(coords);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void change_StudentsCount(){
        System.out.println("Введите количество студентов в группе");
        while (true) {
            try {
                Long studentsCount = sc.nextLong();
                group.setStudentsCount(studentsCount);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Требуется число типа Long.");
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }
        }
    }


    public void change_ExpelledStudents(){
        System.out.println("Введите количество отчисленных студентов в группе");
        while (true) {
            try {
                int expelledStudents = sc.nextInt();
                group.setExpelledStudents(expelledStudents);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Требуется число типа int.");
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }
        }
    }

    public void change_AverageMark() {
        System.out.println("Введите среднюю оценку по группе");
        while (true) {
            try {
                int averageMark = sc.nextInt();
                group.setAverageMark(averageMark);
                sc.nextLine();
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("Требуется число типа int.");
                System.out.println("Попробуйте ещё раз.");
                sc.nextLine();
            }
        }
    }
    public void change_FormOfEducation(){
            System.out.println("Выберите форму обучения группы из предложенных: \nDISTANCE_EDUCATION,\nFULL_TIME_EDUCATION,\nEVENING_CLASSES");
            while (true) {
                String formOfEducation = sc.nextLine();
                try {
                    group.setFormOfEducation(FormOfEducation.valueOf(formOfEducation));
                    break;
                } catch (WrongFormatException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Попробуйте ещё раз.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Выберите форму обучения  группы ТОЛЬКО из предложенных: \nDISTANCE_EDUCATION,\nFULL_TIME_EDUCATION,\nEVENING_CLASSES");
                    System.out.println("Попробуйте ещё раз.");
                }
            }
        }

    public void change_Admin(){
        System.out.println("Админ группы");
        Person admin = new Person();
        System.out.println("Введите имя админа группы");
        while (true) {
            String name = sc.nextLine();
            try {
                admin.setName(name);;
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            }
        }
        System.out.println("Введите дату рождения админа в формате dd.mm.YYYY");
        while (true) {
            String birthday = sc.nextLine();
            try {
                admin.setBirthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd.MM.yyyy")));;
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            }catch (DateTimeParseException e){
                System.out.println("Используйте формат dd.MM.YYYY");
                System.out.println("Попробуйте ещё раз.");
            }
        }
        System.out.println("Выберите цвет глаз админа из предложенных: \nRED,\nYELLOW,\nORANGE");
        while (true) {
            String color = sc.nextLine().toUpperCase();
            try {
                admin.setEyeColor(Color.valueOf(color));
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите цвет глаз админа ТОЛЬКО из предложенных: \nRED,\nYELLOW,\nORANGE");
                System.out.println("Попробуйте ещё раз.");
            }
        }
        System.out.println("Выберите национальность админа из предложенных: \nJAPAN,\nUSA,\nVATIKAN");
        while (true) {
            String nationality = sc.nextLine().toUpperCase();
            try {
                admin.setNationality(Country.valueOf(nationality));
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            } catch (IllegalArgumentException e) {
                System.out.println("Выберите национальность админа ТОЛЬКО из предложенных: \nJAPAN,\nUSA,\nVATIKAN");
                System.out.println("Попробуйте ещё раз.");
            }
        }
        System.out.println("Местоположение админа");
        Location location = new Location();
        System.out.println("Введите x координату");
        while (true) {
            try {
                double x = sc.nextDouble();
                location.setX(x);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            } catch (InputMismatchException e){
                System.out.println("Требуется число типа double.");
                System.out.println("Попробуйте ещё раз.");
            }finally {
                sc.nextLine();
            }
        }
        System.out.println("Введите y координату");
        while (true) {
            try {
                Double y = sc.nextDouble();
                location.setY(y);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            }catch (InputMismatchException e){
                System.out.println("Требуется число типа Double.");
                System.out.println("Попробуйте ещё раз.");
            }finally {
                sc.nextLine();
            }
        }
        System.out.println("Введите название города");
        while (true) {
            String name = sc.nextLine();
            try {
                location.setName(name);;
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Попробуйте ещё раз.");
            }
        }
        while (true) {
            try {
                admin.setLocation(location);
                break;
            } catch (WrongFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            group.setGroupAdmin(admin);
        } catch (WrongFormatException e) {
            System.out.println(e.getMessage());
        }

    }



}
