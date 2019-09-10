package statisticsdemo;

/**
 * This is the Employee class of the StatisticsDemo program.
 * @author Ian Nezat (inezat2)
 */
public class Employee implements Measurables, Comparable{
    private String name;
    private int hours;
    private int rate;
    private int sales;
    private double netPay;
    
    /**
     * This is the parameterized constructor for the employee object.
     * @param name
     * @param hours
     * @param rate
     * @param sales 
     */
    public Employee(String name, int hours, int rate, int sales){
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.sales = sales;
        double wage = 0;
        if(hours <= 40){
            wage = rate * hours;
        }else if(hours > 40 && hours <= 60){
            wage = rate * 40 + 1.5 * rate * (hours - 40);
        }else if(hours > 60){
            wage = rate * 40 + 1.5 * rate * 20 + 2 * rate * (hours - 60);
        }
        double commission  = sales * .15;
        double grossPay = wage + commission;
        double withholdingTax = grossPay * .18;
        this.netPay = grossPay - withholdingTax;
    }
    
    /**
     * This is the getFirstInt method of the Employee class.
     * @return hours
     */
    public int getFirstInt(){
        return hours;
    }
    
    /**
     * This is the getSecondInt method of the Employee class.
     * @return rate
     */
    public int getSecondInt(){
        return rate;
    }
    
    /**
     * This is the getThirdInt method of the Employee class.
     * @return sales
     */
    public int getThirdInt(){
        return sales;
    }
    
    /**
     * This is the getDouble method of the Employee class.
     * @return netPay
     */
    public double getDouble(){
        return netPay;
    }
    
    /**
     * This is the compareTo method of the Employee class.
     * @param otherObject
     * @return a value for whether they are equal.
     */
    public int compareTo(Object otherObject){
        Employee other = (Employee) otherObject;
        if(this.netPay < other.netPay){
            return -1;
        }else if(this.netPay > other.netPay){
            return 1;
        }else{
            return 0;
        }
    }
    
    /**
     * This is the toString method of the Employee class.
     * @return a string representation of the employee and their information.
     */
    public String toString(){
        return String.format("(%s %d,%d,%d,%.2f)",name, hours, rate, sales, netPay);
    }
}
