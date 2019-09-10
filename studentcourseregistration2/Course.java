package studentcourseregistration2;

/**
 *
 * @author @Ian Nezat (inezat2)
 */
public class Course {

    public String name;
    public String id;
    public int creditHrs;
    public int cost;
    public int maxClassSize;
    public int classSize = 0;

    public Course(String name, String id, int creditHrs, int cost, int maxClassSize){
    this.name = name;
    this.id = id;
    this.creditHrs = creditHrs;
    this.cost = cost;
    this.maxClassSize = maxClassSize;
    }
    
    public String toString(){
        return "(" + name + ", id = " + id + ", " + creditHrs + 
                " hrs, cost = " + cost + ")";
    }
}
