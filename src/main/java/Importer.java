import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Importer {

    public static void main(String[] args) {

        String filename = "src/main/DataCSV.txt";
        //create mongo connection

        //parse CSV file
        ArrayList<String> listOfLines = parseCSVFile(filename);

        //insert into document
//        for (String str : listOfLines){
//            //placeholder
//        }





    }//end of main

    private static ArrayList<String> parseCSVFile(String filename){
        ArrayList<String> listOfLines = new ArrayList<String>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                listOfLines.add((line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        return listOfLines;
    }



}


