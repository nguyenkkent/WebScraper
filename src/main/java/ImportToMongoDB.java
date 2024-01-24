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

public class ImportToMongoDB {

    public static void main(String[] args) {

        String filename = "src/main/DataCSV.txt";

        //create mongoDB connection string
        String connectionString = "mongodb+srv://nguyenkkent:QS1UKls5SSiQGJbE@jobpostingcluster.zr8ofhr.mongodb.net/?retryWrites=true&w=majority";
        //connect to mongoDB
        MongoCollection<Document> collection = connectToMongoDB(connectionString);

        if (collection!=null){
            //parse CSV file
            ArrayList<String> listOfLines = parseCSVFile(filename);
            //Create document and insert into database
            for (String line : listOfLines){
                addToCollection(collection,line);
            }
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

        MongoClient mongoClient = MongoClients.create(settings);

            try{
            MongoDatabase database = mongoClient.getDatabase("WebScrapper");
            MongoCollection<Document> collection = database.getCollection("JobPostings");
            return collection;
            } catch(MongoException e){
                e.printStackTrace();
                return null;
        }
    }

    /**
     *  Function: addToCollection
     *  Creates a mongoDB Document object from line string and add to database's collection
     *  @param collection
     *  @param line
     **/
    private static void addToCollection(MongoCollection<Document> collection, String line){

        String[] fields = line.split(",");
        Document doc = new Document("role", fields[0])
                .append("company",fields[1])
                .append("datePosted", fields[2])
                .append("city", fields[3])
                .append("state", fields[4])
                .append("URL", fields[5]);
        collection.insertOne(doc);
    }


}


