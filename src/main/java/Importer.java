import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Importer {

    public static void main(String[] args) {

        String filename = "src/main/DataCSV.txt";

        //create mongoDB connection string
        String connectionString = "mongodb+srv://nguyenkkent:QS1UKls5SSiQGJbE@jobpostingcluster.zr8ofhr.mongodb.net/?retryWrites=true&w=majority";
        MongoCollection<Document> collection = connectToMongoDB(connectionString);

        if (collection!=null){
            //parse CSV file
            ArrayList<String> listOfLines = parseCSVFile(filename);

            //Create document and insert into database
//        for (String str : listOfLines){
//            insertToMongo
//        }
        }
        else{
            System.out.println("Unable to connect to Database");
        }

    }//end of main

    /**
     *  Function: parseCSVFile
     *  Read in CSV file line by line
     *  @param filename
     *  Returns an arrayList of Strings containing the parsed CSV file
     **/
    private static ArrayList<String> parseCSVFile(String filename){
        ArrayList<String> listOfLines = new ArrayList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
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

    /**
     *  Function: connectToMongoDB
     *  Creates a connection to MongoDB Atlas Cloud Database
     *  @param connectionString
     *  Returns MongoCollection<Document> if successful
     **/
    private static MongoCollection<Document> connectToMongoDB(String connectionString){

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
//                MongoDatabase database = mongoClient.getDatabase("admin");
//                database.runCommand(new Document("ping", 1));
//                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                MongoDatabase database = mongoClient.getDatabase("WebScrapper");
                 return database.getCollection("JobPostings");
            } catch (MongoException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}


