import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Importer {

    public static void main(String[] args) {
        BufferedReader reader;
        String filename = "src/main/DataCSV.txt";

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }


    }//end of main





    private String parseJsonFile(String filename){

        return null;
    }

    private JobPosting createJobPostingJson(String json){


        return null;
    }

}


