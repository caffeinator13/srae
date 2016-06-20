package dota;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;



public class findWord {
	public static void experience() throws Exception {

        //String path = ""; //ADD YOUR PATH HERE
        //String fileName = "out.txt";
        String testWord = "years"; //CHANGE THIS IF YOU WANT
        File document = new File(Inputfile.getFileName());
        
        //String file = fileName;
        boolean check = true;

        try{
            FileInputStream fstream = new FileInputStream(document);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;        
            //Read File Line By Line
            while((strLine = br.readLine()) != null){   
            	
                //check to see whether testWord occurs at least once in the line of text
                check = strLine.toLowerCase().contains(testWord.toLowerCase());
                
                if(check){                    
                    //get the line, and parse its words into a String array
                    String[] lineWords = strLine.split("\\s+"); 
                    System.out.println(strLine);
                    Opennlp.Parse(strLine);
                    if(lineWords[0].equals(testWord))
                    		return;//no preceding word

                    		   for(int i=1;i<lineWords.length;i++){
                    		    if(lineWords[i].equals(testWord)){
                    		    System.out.println("experience : " + lineWords[i-1] + ' ' + lineWords[i]);
                    		    break;
                    		    }
                    		   }
                  /**  for(int i=0;i<lineWords.length;i++){
                    	System.out.print(lineWords[i]+ ' ');
                    	 
                    	} */
                    
                            
                }  
            }
            
            
            
        br.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
