package statisticsdemo;

/**
 * This is the Student class of the StatisticsDemo program.
 * @author Ian Nezat (inezat2)
 */
public class Student implements Measurables, Comparable{
    
    private String name;
    private int exam1;
    private int exam2;
    private int finalExam;
    private double courseGrade;
    
    /**
     * This is a parameterized constructor for the Student object.
     * @param name
     * @param exam1
     * @param exam2
     * @param finalExam 
     */
    public Student(String name, int exam1, int exam2, int finalExam){
        this.name = name;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.finalExam = finalExam;
        this.courseGrade = (exam1+exam2+finalExam)/3.0;
    }
    
    /**
     * This is the getFirstInt method of the Student class.
     * @return exam1
     */
    public int getFirstInt(){
        return exam1;
    }
    
    /**
     * This is the getSecondInt method of the Student class.
     * @return exam2
     */
    public int getSecondInt(){
        return exam2;
    }
    
    /**
     * This is the getThirdInt method of the Student class.
     * @return finalExam
     */
    public int getThirdInt(){
        return finalExam;
    }
    
    /**
     * This is the getDouble method of the Student class.
     * @return courseGrade
     */
    public double getDouble(){
        return courseGrade;
    }
    
    /**
     * This is the compareTo method of the Student class.
     * @param otherObject
     * @return a value for whether they are equal.
     */
    public int compareTo(Object otherObject){
        Student other = (Student) otherObject;
        if (this.courseGrade < other.courseGrade){
            return -1;
        }else if(this.courseGrade > other.courseGrade){
            return 1;
        }else{
            return 0;
        }
    }
    
    /**
     * This is the toString method of the Student class.
     * @return a string representation of the student and their grades.
     */
    public String toString(){
        return String.format("(%s %d,%d,%d,%.1f)",name, exam1, exam2, finalExam, courseGrade);
    }
}
