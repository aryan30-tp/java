import java.util.Scanner;

//task 1

class Student{
    String rollNo;
    String name;
    String course;
    String grade;
    double marks;
    Scanner SC= new Scanner(System.in);
    public void inputStudent(){
        System.out.print("Enter name: ");
        name= SC.nextLine();

        System.out.print("Enter Roll NO: ");
        rollNo= SC.nextLine();

        System.out.print("Enter Course: ");
        course= SC.nextLine();

        System.out.print("Enter Marks: ");
        marks=SC.nextDouble();
        SC.nextLine();

        calculateGrade();
    } 

    public void calculateGrade(){
        if (marks>=90) grade="A+";
        else if( marks>=80) grade="A";
        else if(marks>=70) grade="B";
        else if(marks>=60) grade="C";
        else if(marks>=50) grade="D";
        else grade="F";
    }

    public void displayStudent(){
        System.out.println("Roll NO:"+ rollNo);
        System.out.println("Name:"+ name);
        System.out.println("Course:"+ course);
        System.out.println("Marks:"+ marks);
        System.out.println("Grade:"+ grade);
        System.out.println("--------------------------------------------------------------");
    }
}

//task 2

class StudentManagementSystem{
    Student[] students;
    int studentCount;
    Scanner SC= new Scanner (System.in);

    public void initializeSystem(int size){
        students= new Student[size];
        studentCount=0;
    }

    public void addStudent(){
        if (studentCount >= students.length){
            System.out.println("Cant add more.");
            return;
        }
        Student s= new Student();
        s.inputStudent();
        students[studentCount]=s;
        studentCount++;
        System.out.println("Student added succcessfully\n");
    }

    public void display(){
        if (studentCount==0){
            System.out.println("No Records\n");
            return;
        }
        System.out.println("---------------Student Records-------------");
        for (int i=0; i<studentCount; i++){
            students[i].displayStudent();
        }
    }
}

//task 3

public class Main{
    public static void main(String[]args){
        Scanner SC = new Scanner(System.in);
        StudentManagementSystem sms= new StudentManagementSystem();

        System.out.println("Max No of Students: ");
        int size=SC.nextInt();
        SC.nextLine();
        sms.initializeSystem(size);

        int choice;
        do{
            System.out.println("----------------------------Student Record management------------------------------");
            System.out.println("1.Add Student");
            System.out.println("2.Display Student");
            System.out.println("3.Exit");
            System.out.print("Enter your choice: ");
            choice=SC.nextInt();

            switch(choice){
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.display();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("False")
            }
        } while(choice != 3);
        SC.close();
    }
}
