import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Student{
    private int token;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.token = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getToken() {
        return token;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

class Checker implements Comparator<Student>{
    public int compare(Student a, Student b){
        if(a.getCgpa() != b.getCgpa()){
            return Double.compare(b.getCgpa(),a.getCgpa());
        }
        else{
            if(!a.getFname().equals(b.getFname())){
                return a.getFname().compareTo(b.getFname());
            }
            else{
                return a.getToken() - b.getToken();
            }
        }
    }
}

public class StackProg {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        Checker check = new Checker();
        PriorityQueue<Student> ps = new PriorityQueue<Student>(totalEvents,check);
        while(totalEvents>0){
            String event = in.next();
            if(event.equals("ENTER")){
                String fname = in.next();
                double cgpa = in.nextDouble();
                int token = in.nextInt();
                Student stu = new Student(token, fname, cgpa);
                ps.add(stu);
            }
            else if(event.equals("SERVED")){
                ps.remove();
            }
            totalEvents--;
        }
        if(ps.size() == 0){
            System.out.println("EMPTY");
        }
        else{
            while(ps.size() != 0){
                Student stu = ps.remove();
                System.out.println(stu.getFname());
            }
        }

    }
}
