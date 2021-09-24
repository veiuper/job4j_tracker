package ru.job4j.pojo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Osipov Valeriy Vyacheslavovich");
        student.setGroup("Java programmer");
        student.setRegister(new GregorianCalendar(2021, Calendar.AUGUST, 19).getTime());
        System.out.println(student.getFio() + System.lineSeparator()
                + student.getGroup() + System.lineSeparator()
                + student.getRegister()
        );
    }
}
