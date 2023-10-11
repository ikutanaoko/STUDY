package Person;

public class Student extends Person {
 private int studentNo;
 
 public Student(String name) {
  this(name, 9);

 }

 public Student(String name, int studentNo) {
  super(name);
  this.studentNo = studentNo;

 }

 public void display() {
  super.display();
  System.out.println("学籍番号：" + studentNo);

 }
 
}
