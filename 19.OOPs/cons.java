public class cons {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ayush";
        s1.roll = 12114021;
        s1.password = "Abcd";
        s1.marks[0]=99;
        s1.marks[1] =98;
        s1.marks[2]=100;
        Student s2 = new Student("Ayush");
        Student s3 = new Student(12114021);
     
        //copy constructor
        Student s4 = new Student(s1); //copy
        s1.password = "Xyz";
         s1.marks[2]=89;
         for(int i =0 ;i<3 ;i++){
         System.out.println(s4.marks[i]);
      }
    }
}
class Student{
     String name;
     int roll;
     String password;
     int marks[];
    //shallow copy constructor
   //   Student(Student s1){
   //    this.name = s1.name;
   //    this.roll = s1.roll;
   //    marks = new int[3];
   //    this.marks = s1.marks; //marks bhi copy kar rahe hai 
   //   }

   // Deep copy constructor
     Student(Student s1){
      marks = new int[3];
      this.name = s1.name;
      this.roll = s1.roll;
      for(int i=0; i< marks.length; i++){
         this.marks[i]= s1.marks[i];
      }
     }

     //non-parameterized constructor
     Student(){
        System.out.println("Constructor is called");
      marks = new int[3];

     }
     //parameterized constructor
     Student(String name){
        this.name = name;
     }
     Student(int roll){
        this.roll =roll;
     }
}