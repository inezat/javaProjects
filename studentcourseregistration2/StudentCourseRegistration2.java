package studentcourseregistration2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Ian Nezat (inezat2) 
 * Manages students' course registrations.
 */
public class StudentCourseRegistration2 
{
    public static Student[] students;
    public static Course[] courses;
    public static LinkedList<Registration> registrations = 
            new LinkedList<Registration>();
    
    public static void readStudentNamesEtc()
    {
        try
        {
            File inputFile = new File("studentNamesEtc.dat");
            Scanner scan = new Scanner(inputFile);
            int numStudents = scan.nextInt();
            scan.nextLine();
            students = new Student[numStudents];
            for(int i = 0; i < numStudents; i++)
            {
                String name = scan.next();
                int id = scan.nextInt();
                scan.nextLine();
                Student student = new Student(name, id);
                students[i] = student;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File studentNamesEtc.dat not found");
        }
    }
    
    public static void readCourseNamesEtc()
    {
        try
            {
                File inputFile = new File("courseNamesEtc.dat");
                Scanner scan = new Scanner(inputFile);
                int numCourses = scan.nextInt();
                scan.nextLine();
                courses = new Course[numCourses];
                for (int i = 0; i < numCourses; i++)
                {
                    String name = scan.next();
                    String id = scan.next();
                    int creditHrs = scan.nextInt();
                    int cost = scan.nextInt();
                    int maxClassSize = scan.nextInt();
                    scan.nextLine();
                    Course course = new Course(name, id,creditHrs, cost,
                        maxClassSize);
                    courses[i] = course;
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println("File courseNamesEtc.dat not found.");
            }
    }
    
    public static int findStudent(int studentId)
    {
        for(int i = 0; i< students.length; i ++)
                if(students[i].id == studentId)
                    return i;
        return -1; 
    }
    
    public static int findCourse(String courseId)
    {
        for(int i = 0; i < courses.length; i++)
                if(courses[i].id.equals(courseId))
                    return i;
        return -1;
    }
    
    public static void addRegistration(int studentId, String courseId)
    {
        int studentIndex = findStudent(studentId);
        int courseIndex = findCourse(courseId);
	
		if(studentIndex == -1){
			System.out.println("*** Registration of " + "(studentId=" + studentId +
			", courseId=" + courseId + ") failed for invalid studentId");
		}
		else if(courseIndex == -1){
			System.out.println("*** Registration of " + "(studentId=" + studentId +
			", courseId=" + courseId + ") failed for invalid courseId");
		}
		else if(students[studentIndex].numRegisteredCourseIDs == students[studentIndex].maxNumRegisteredCourses){
		System.out.println("--- Registration of " + "(studentId=" + studentId +
			", courseId=" + courseId + ") failed due to maxNumRegisteredCourses =  " + students[studentIndex].maxNumRegisteredCourses + " limit");
                }
                
                else if(students[studentIndex].totalRegisteredCreditHrs + courses[courseIndex].creditHrs > students[studentIndex].maxRegisteredCreditHrs)
                {
                    System.out.println("--- Registration of " + "(studentId=" + studentId +
			", courseId=" + courseId + ") failed due to maxRegisteredCreditHrs =  " + students[studentIndex].maxRegisteredCreditHrs + " limit");
                    System.out.println("    your current "+ "totalRegisteredCreditHrs = " + students[studentIndex].totalRegisteredCreditHrs + " and " + courseId + " has creditHrs = " + courses[courseIndex].creditHrs);
                }
                
                else if(courses[courseIndex].classSize == courses[courseIndex].maxClassSize)
                {    
                    System.out.println("--- Registration of " + "(studentId=" + studentId + ", courseId=" + courseId + ") failed due to the maxClassSize = " + courses[courseIndex].maxClassSize + " limit");
                }
                
                else if (registrations.contains(new Registration(students[studentIndex], courses [courseIndex])))
                {
                    System.out.println("??? Registration of " + "studentId=" + studentId + ", courseId=" + courseId + ") failed due to existing registration of the same");
                }
                
                else
                {
                    int numReg;
                    numReg = students[studentIndex].numRegisteredCourseIDs;
                    students[studentIndex].registeredCourseIDs[numReg] = courses[courseIndex].id;
                    students[studentIndex].numRegisteredCourseIDs++;
                    numReg++;
                    students[studentIndex].totalRegisteredCreditHrs += courses[courseIndex].creditHrs;
                    courses[courseIndex].classSize++;
                    Registration registration = new Registration(students[studentIndex], courses[courseIndex]);
                    registrations.add(registration);
                    System.out.println("+++ " + students[studentIndex] + " is now registered in " + courses[courseIndex]);
                    System.out.println("    Your numRegisteredCourseIds = " + students[studentIndex].numRegisteredCourseIDs + "; totalRegisteredCreditHrs = " + students[studentIndex].totalRegisteredCreditHrs);
                    
                    if(numReg > 1){
                        String coursId;
                        coursId = students[studentIndex].registeredCourseIDs[0];
                        courseIndex = findCourse(coursId);
                        System.out.println("    Your previous course registrations: " + courses[courseIndex]);
                    }
                    
                }
     }
    
    public static void deleteRegistration(int studentId, String courseId)
    {
        int studentIndex = findStudent(studentId);
        int courseIndex = findCourse(courseId);
            
                if(studentIndex == -1){
			System.out.println("*** Delete registration of " + "(studentId=" + studentId +
			", courseId=" + courseId + ") failed for invalid studentId");
		}
		else if(courseIndex == -1){
			System.out.println("*** Delete registration of " + "(studentId=" + studentId +
			", courseId=" + courseId + ") failed for invalid courseId");
		}
                
                else if (!registrations.contains(new Registration(students[studentIndex], courses [courseIndex])))
                {
                    System.out.println("??? Delete registration of (" + "studentId=" + studentId + ", courseId=" + courseId + ") failed because registration not found");
                }
                
                else
                {
                    int numReg;
                    numReg = students[studentIndex].numRegisteredCourseIDs;
                    for(int i = 0; i < numReg; i++){
                        if(students[studentIndex].registeredCourseIDs[i].equals(courses[courseIndex].id)){
                            for(int j = i; j < numReg - 1; j++){
                                students[studentIndex].registeredCourseIDs[j] = students[studentIndex].registeredCourseIDs[j + 1]; 
                            }
                            students[studentIndex].numRegisteredCourseIDs--;  
                        }
                    }
                    
                    students[studentIndex].totalRegisteredCreditHrs -= courses[courseIndex].creditHrs;
                    courses[courseIndex].classSize--;
                    Registration registration = new Registration(students[studentIndex], courses[courseIndex]);
                    registrations.remove(registration);
                    System.out.println("ddd " + students[studentIndex] + "'s registration in " + courses[courseIndex] + "is now deleted");
                    System.out.println("    Your numRegisteredCourseIds = " + students[studentIndex].numRegisteredCourseIDs + " totalRegisteredCreditHrs = " + students[studentIndex].totalRegisteredCreditHrs);
                    
                    if(students[studentIndex].numRegisteredCourseIDs > 0){
                        String coursId;
                        System.out.print("    Your current course registrations: ");
                        for(int i = 0; i < numReg-1; i++){
                            coursId = students[studentIndex].registeredCourseIDs[i];
                            courseIndex = findCourse(coursId);
                            if(i > 0){
                                System.out.print(", ");
                            }
                            System.out.print(courses[courseIndex]);
                        }
                        System.out.println();
                    }
                }
    }
    
    public static void main(String[] args) 
    {
        readStudentNamesEtc();
        System.out.print("students: ");
        System.out.println(Arrays.toString(students));
        readCourseNamesEtc();
        System.out.print("courses: ");
        System.out.println(Arrays.toString(courses));
        
        addRegistration(55,"cs0");
        addRegistration(11,"cs5");
        addRegistration(11,"ee2");
        addRegistration(11,"ee3");
        addRegistration(11,"cs0");
        addRegistration(11,"cs1");
        addRegistration(22,"ee2");
        addRegistration(22,"ee2");
        addRegistration(33,"ee2");
        addRegistration(10,"ee2");
        System.out.println();
        deleteRegistration(44,"ee2");
        deleteRegistration(22,"cs2");
        deleteRegistration(11,"cs1");
        deleteRegistration(11,"ee2");
        addRegistration(11,"cs0");
        deleteRegistration(11,"cs0");
        addRegistration(11,"cs0");
        addRegistration(10,"ee2");
        addRegistration(11,"ee3");
        deleteRegistration(11,"cs0");
        addRegistration(11,"cs1");
               
    }
    
}

