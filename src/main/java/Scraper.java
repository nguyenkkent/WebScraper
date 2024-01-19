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
//      System.out.println(doc.body());


//        Elements links  = doc.getElementsByClass("sc-gAjuZT.cUPTNR");
//        System.out.println(links.size());
//        for (Element link : links){
//            String linkHref = link.attr("href");
//            String linkText = link.text();
//            System.out.println(linkHref);
//        }

        //sc-gAjuZT.cUPTNR

//        Elements outerLiHTMLElement = doc.getElementsByClass("sc-gwZKzw.evWkPy");
        Elements outerLiHTMLElement = doc.select("ul.sc-harTkY.jEHPnr"); //returns an ArrayList<Element>
        System.out.println(outerLiHTMLElement.size());
//        System.out.println(outerLiHTMLElement.get(0));


    }
}