package studentcourseregistration2;

/**
 *
 * @author @Ian Nezat (inezat2)
 */
public class Student {

    public static final int maxNumRegisteredCourses = 2;
    public static final int maxRegisteredCreditHrs = 4;
    public String name;
    public int id;
    public int numRegisteredCourseIDs = 0;
    public int totalRegisteredCreditHrs  =0;
    public String[] registeredCourseIDs = new String [maxNumRegisteredCourses];
    
    public Student (String name, int id){
        this.name = name;
        this.id = id;
    }
    
    public String toString(){
        return "(" + name + ", id = " + id + ")";
    }
    
}
