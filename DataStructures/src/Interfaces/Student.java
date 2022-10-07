package Interfaces;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    int id = 1;
    String firstName = "Avinash";
    String lastName = "Singh";

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {

    }


    @Override
    public int compareTo(Student o) {
        return this.firstName.compareTo(o.firstName);
    }

    public static void main(String[] args) {
        Student s = new Student();

        int result = s.compareTo(new Student(1,"Vishal","Singh"));
        System.out.println(result);
        LastNameComparator lastNameComparator = new LastNameComparator();
        int compare = lastNameComparator.compare(s, new Student(1, "Vishal", "Aingh"));
        System.out.println(compare);
    }
}

class LastNameComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        System.out.println(o1.lastName+" ,"+ o2.lastName);
        return o1.lastName.compareTo(o2.lastName);
    }
}



