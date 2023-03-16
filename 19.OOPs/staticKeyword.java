public class staticKeyword {
        public static void main(String[] args) {
            Student s1 = new Student();
            s1.schoolName ="JV";
            Student s2 = new Student();
            System.out.println(s2.schoolName);
            Student s3 = new Student(); 
            s3.schoolName = "BHS";
            System.out.println(s1.schoolName); //ye bhs dega cause schoolName static hai ek hi hoga          
        }    
}
class Student{
    int roll;
    String name;
    
    static void percent(int a, int b, int c ){
        System.out.println((a+b+c)/3);
    }
    static String schoolName;

    void setname(String name){
        this.name= name;
    }
    String getname(){
        return this.name;
    }
}
