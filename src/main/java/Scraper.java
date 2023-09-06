import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;
import java.io.IOException;

public class Scraper {
    public static void main(String[] args) {
        Document doc;
        try {
            // fetching the target website returns a Connection object
//            doc = Jsoup.connect("https://www.monster.com/jobs/search")
            doc = Jsoup.connect("https://www.monster.com/jobs/search?q=software+engineer&where=&page=1")
//                    .data("q","software engineer intern")
//                    .data("where","")
//                    .data("page","1")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //test print to check current url location and title
        System.out.println(doc.location());
        System.out.println(doc.title());

//        Element links  = doc.getElementsByClass("sc-gAjuZT cUPTNR").first();
//        for (Element link : links){
//            String linkHref = link.attr("href");
//            String linkText = link.text();
//            System.out.println(linkHref);
//        }


//        System.out.println(doc);

        /*
        a test to collect all <a> tags and any href attribute associated with each tag
        */

//        Elements jobTitleList = doc.getElementsByClass("sc-gAjuZT cUPTNR"); //returns an ArrayList<Element>
        Elements jobTitleList = doc.getElementsByTag("a");
        System.out.println(jobTitleList.size());
        for (Element element : jobTitleList){
            System.out.println(element.attr("href"));
        }


    }
}