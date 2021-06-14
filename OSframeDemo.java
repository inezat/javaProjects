import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class prog2j {
    static LinkedList<frame> frameList = new LinkedList<frame>();
    public static int ageCounter = 0;
    public static int frameSize;
    public static int accessTime;
    public static int swapIn;
    public static int swapOut;
    
    public static int cost;
    public static int pageReference;
    public static int readRef;
    public static int writeRef;
    public static int accessCounter;
    public static int inCounter;
    public static int outCounter;

    static String outString = "Output Trace File \n";

    static void frameSetter(int x, String a){
        ageCounter++;
        pageReference++;
        for(int i = 0; i < frameList.size(); i++){
            frame tempFrame = frameList.get(i);
            //page hit?
            if(tempFrame.pageNum == x){
                outString+=(a+" "+x+" H "+"-1 "+accessTime+" 0  0"+"\n");
                cost+=accessTime;
                System.out.print(a+" "+x+" H "+"-1 "+accessTime+" 0  0"+"\n");
                if(a.equals("W")){
                    tempFrame.modify = 1;
                }
                if(tempFrame.reference == 0){
                    tempFrame.reference = 1;
                }
                //printa();
                return;
            }
        }
        if(a.equals("R")){
            readRef++;
        }else{
            writeRef++;
        }
        //page miss
        frame framed = new frame(x);
        framed.reference = 0;
        int index = 0;
        outString+=(a+" "+x+" F ");
        System.out.print(a+" "+x+" F ");
        if(frameList.size() < frameSize){
            framed.setAge(ageCounter);
            frameList.add(framed);
            outString+=("-1 "+accessTime+" "+swapIn+" 0"+"\n");
            System.out.print("-1 "+accessTime+" "+swapIn+" 0"+"\n");
            cost+=(accessTime+swapIn);
            inCounter++;
        }else{
            frame oldestFrame = new frame(x);
            //find the oldest frame
            oldestFrame.setAge(999);
            for(int i = 0; i < frameList.size(); i++){
                frame tempFrame = frameList.get(i);
                //replace the oldest frame with ref 0
                if(tempFrame.reference == 0){
                    if(tempFrame.age < oldestFrame.age){
                        oldestFrame = tempFrame;
                        index = i;
                    }
                }
            }
            for(int i = 0; i < frameList.size(); i++){
                frame tempFrame = frameList.get(i);
                if(i == index){
                    if(tempFrame.modify==1){
                        outString+=(" "+frameList.get(i).getPageNum()+" "+accessTime+" "+swapIn+" "+swapOut+"\n");
                        System.out.print(" "+frameList.get(i).getPageNum()+" "+accessTime+" "+swapIn+" "+swapOut+"\n");
                        cost+=(accessTime+swapIn+swapOut);
                    }else{
                        outString+=(" "+frameList.get(i).getPageNum()+" "+accessTime+" "+swapIn+" "+"0"+"\n");
                        System.out.print(" "+frameList.get(i).getPageNum()+" "+accessTime+" "+swapIn+" "+"0"+"\n");
                        cost+=(accessTime+swapIn);
                    }
                    inCounter++;
                    outCounter++;
                    tempFrame.pageNum = x;
                    tempFrame.reference = 0;
                    tempFrame.modify = 0;
                    tempFrame.age = ageCounter;
                    break;
                }
                if(tempFrame.reference == 1){
                    tempFrame.reference = 0;
                }
            }

        }
        //printa();
    }
    public static void main(String[] args) throws IOException
    {   
        //20 pageref.txt 1 10 20 trace.txt

        frameSize = Integer.valueOf(args[0]);
        String input = args[1];
        accessTime = Integer.valueOf(args[2]);
        swapIn = Integer.valueOf(args[3]);
        swapOut = Integer.valueOf(args[4]);
        String output = args[5];
        
        
        //input from file
        String directory = "/classes/cs4103/cs410358/prog2/";
        String fileName = input;
        String path = directory + File.separator + fileName;
        int ch;
  
        // file check
        FileReader fr=null;
        try
        {
            fr = new FileReader(path);
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("Error: FNF");
        }
  
        LinkedList<Character> chars = new LinkedList<Character>();


            int counter = 1;
            int secondCounter = 1;
            int thirdCounter = 1;
            boolean flip = false;
    
            while((ch=fr.read())!=-1){
                if(flip == false){
                    if(counter%2 != 0){
                        chars.add((char)ch);
                        if(secondCounter%3 == 0){
                            flip = true;
                            counter++;
                        }
                    }
                counter++;
                secondCounter++;
                }else{
                    if(thirdCounter%2 == 0){
                        flip = false;
                    }
                    thirdCounter++;
                }
            }
    
            //call frameSetter
            for(int i = 0; i < chars.size()-1; i+=2){
                String a = Character.toString(chars.get(i));
                int b = Character.getNumericValue(chars.get(i+1));
                frameSetter(b,a);
            }
    
            //output to file
             FileWriter fw=new FileWriter(output);
      
             for (int i = 0; i < outString.length(); i++){
                 fw.write(outString.charAt(i));
             }
             System.out.println("Successful write to file: "+output);
             fw.close();
            System.out.println("Total page references: "+pageReference);
            System.out.println("Total fault read references: "+readRef);
            System.out.println("Total fault write references: "+writeRef);
            System.out.println("Total number of time units for accessing pages in memory: "+pageReference);
            System.out.println("Total number of time units for swapping in pages: "+inCounter);
            System.out.println("Total number of time units for swapping out pages: "+outCounter);
            System.out.println("The total cost of page faults is " + cost);
        


            //output to file
            FileWriter fw=new FileWriter(output);
        
            for (int i = 0; i < outString.length(); i++){
                fw.write(outString.charAt(i));
            }
            System.out.println("Successful write to file: "+output);
            fw.close();
            System.out.println("Total page references: "+pageReference);
            System.out.println("Total fault read references: "+readRef);
            System.out.println("Total fault write references: "+writeRef);
            System.out.println("Total number of time units for accessing pages in memory: "+pageReference);
            System.out.println("Total number of time units for swapping in pages: "+inCounter);
            System.out.println("Total number of time units for swapping out pages: "+outCounter);
            System.out.println("The total cost of page faults is " + cost);
        }
    }
  
}