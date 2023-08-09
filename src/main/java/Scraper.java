import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;

public class Scraper {
    public static void main(String[] args) {
        Document doc;
        try {
            // fetching the target website returns a Connection object
            doc = Jsoup.connect("https://www.monster.com/jobs/search")
                    .data("q","software engineer intern")
                    .data("where","")
                    .data("page","1")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //now we have a document object to work with
        System.out.println(doc.location());
        System.out.println(doc.title());
//        System.out.println(doc.text());

//        try{
//
//            String strText =
//                    Jsoup
//                            .connect("https://www.google.com/")
//                            .get()
//                            .text();
//
//            System.out.println(strText);
//
//        }catch(IOException ioe){
//            System.out.println("Exception: " + ioe);
//        }
    }
}