package studentcourseregistration2;

/**
 *
 * @author @Ian Nezat (inezat2)
 */
public class Registration {

    public Student student;
    public Course course;

    public Registration(Student student, Course course){
    this.student = student;
    this.course = course;
    }
    
    public boolean equals(Object obj){
        Registration other = (Registration) obj;
        return this.student.id == other.student.id && 
                this.course.id.equals(other.course.id);
    }
}
