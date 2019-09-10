package statisticsdemo;

import java.util.Arrays;

/**
 *This is the StatisticsDemo class of the StatisticsDemo program. It contains the main method and both the averages and median methods.
 * @author Ian Nezat (inezat2)
 */
public class StatisticsDemo {
    
    public static void main(String[] args) {
        Student[] studentObjects = new Student[6];
        studentObjects[0] = new Student("Mary",85,93,97);
        studentObjects[1] = new Student("Bob",67,77,71);
        studentObjects[2] = new Student("Tom",85,91,89);
        studentObjects[3] = new Student("Anna", 79, 72, 80);
        studentObjects[4] = new Student("Hal", 96, 88, 99);
        studentObjects[5] = new Student("Gina", 89,91,82);
        
        double[] stuAvg = averages(studentObjects);
        System.out.printf("Students:   %s%n", Arrays.toString(studentObjects));
        System.out.printf("Average Exam 1 Grade = %.2f%n", (stuAvg[0]));
        System.out.printf("Average Exam 2 Grade = %.2f%n", (stuAvg[1]));
        System.out.printf("Average Final Exam Grade = %.2f%n", (stuAvg[2]));
        System.out.printf("Average Course Grade = %.2f%n", (stuAvg[3]));
        System.out.println();
        Arrays.sort(studentObjects);
        System.out.println("After sorting students by course grade,");
        System.out.println("Students: " + Arrays.toString(studentObjects));
        System.out.println();
        
        System.out.printf("Median of Course Grades = %.2f%n",median(studentObjects));
        System.out.println();
        
        Employee[] employeeObjects = new Employee[5];
        employeeObjects[0] = new Employee ("Sara",68, 19, 5473); 
        employeeObjects[1] = new Employee ("Sam", 51, 18, 5829);
        employeeObjects[2] = new Employee ("Lisa", 47, 16, 3892);
        employeeObjects[3] = new Employee ("Jim", 33, 21, 4857);
        employeeObjects[4] = new Employee ("Judy", 39, 23, 4295);
        
        double[] empAvg = averages(employeeObjects);
        System.out.printf("Employees:   %s%n", Arrays.toString(employeeObjects));
        System.out.println();
        System.out.printf("Average Hours = %.2f%n", (empAvg[0]));
        System.out.printf("Average Rate = $%.2f%n", (empAvg[1]));
        System.out.printf("Average Sales = $%.2f%n", (empAvg[2]));
        System.out.printf("Average Net Pay = $%.2f%n", (empAvg[3]));
        System.out.println();
        Arrays.sort(employeeObjects);
        System.out.printf("After Sorting employees by net pay, %n");
        System.out.println("Employees:   "+Arrays.toString(employeeObjects));
        System.out.printf("Median of Net Pay = $%.2f%n",median(employeeObjects));
       
   }
    
    /**
     * This is the averages method of the StatisticsDemo class. 
     * @param objects 
     * @return averages stored in an array.
     */
    public static double[] averages (Measurables[] objects){
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        int n = objects.length;
        double[] avg = new double[4];
        for (int i = 0; i < n; i++){
            sum1 += objects[i].getFirstInt();
            sum2 += objects[i].getSecondInt();
            sum3 += objects[i].getThirdInt();
            sum4 += objects[i].getDouble();
        }
        avg[0] = sum1/n;
        avg[1] = sum2/n;
        avg[2] = sum3/n;
        avg[3] = sum4/n;
        return avg;
    }
    
    /**
     * This is the median method of the StatisticsDemo class. 
     * @param objects
     * @return the median
     */
    public static double median (Measurables[] objects){
        Arrays.sort(objects);
        int n = objects.length;
        if(n%2!=0){
            return objects[(n-1)/2].getDouble();
        }else{
            return ((objects[(n-1)/2].getDouble())+(objects[((n-1)/2)+1].getDouble()))/2;
        }
    }
}
