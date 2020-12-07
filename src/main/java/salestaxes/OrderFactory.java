package salestaxes;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import salestaxes.lucene.searchengine.LuceneSearchEngine;

public class OrderFactory {
    
    public static Order getOrderFromInput(String inputString) throws NumberFormatException, IllegalStateException{

        boolean imported = inputString.indexOf("imported") > -1;
        inputString = inputString.replaceAll("imported ", "");

        Pattern pattern = Pattern.compile("(\\d+)\\s+(.*)\\s+at\\s+(.*)");

        Matcher matcher = pattern.matcher(inputString);
        matcher.find();
        
        LuceneSearchEngine searchEngine = new LuceneSearchEngine();
        
        Item item = new Item(matcher.group(2), searchEngine.searchWord(matcher.group(2)), new BigDecimal(matcher.group(3)));
        Order order = new Order(Integer.parseInt(matcher.group(1)), item, imported);

        return order;

    }

}
