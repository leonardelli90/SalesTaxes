package salestaxes;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;
import salestaxes.lucene.searchengine.LuceneSearchEngine;

public class AppTest extends TestCase
{

    public AppTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testTotalPriceInputOne() {
        ArrayList<Order> orderList = new ArrayList<Order>();

        orderList.add(new Order(1, new Item("book", true, new BigDecimal("12.49")), false));
        orderList.add(new Order(1, new Item("music CD", false, new BigDecimal("14.99")), false));
        orderList.add(new Order(1, new Item("chocolate bar", true, new BigDecimal("0.85")), false));

        Invoice invoice = new Invoice(orderList);
        assertEquals("29.83", invoice.getTotalPrice().toString());
    } 

    @Test

    public void testTotalTaxesInputOne() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        
        orderList.add(new Order(1, new Item("book", true, new BigDecimal("12.49")), false));
        orderList.add(new Order(1, new Item("music CD", false, new BigDecimal("14.99")), false));
        orderList.add(new Order(1, new Item("chocolate bar", true, new BigDecimal("0.85")), false));

        Invoice invoice = new Invoice(orderList);
        assertEquals("1.50", invoice.getTotalTaxes().toString());
    } 

    @Test

    public void testTotalPriceInputTwo() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        
        orderList.add(new Order(1, new Item("box of chocolates", true, new BigDecimal("10.00")), true));
        orderList.add(new Order(1, new Item("bottle of perfume", false, new BigDecimal("47.50")), true));

        Invoice invoice = new Invoice(orderList);
        assertEquals("65.15", invoice.getTotalPrice().toString());
    } 

    @Test

    public void testTotalTaxesInputTwo() {
        ArrayList<Order> orderList = new ArrayList<Order>();

        orderList.add(new Order(1, new Item("box of chocolates", true, new BigDecimal("10.00")), true));
        orderList.add(new Order(1, new Item("bottle of perfume", false, new BigDecimal("47.50")), true));
        Invoice invoice = new Invoice(orderList);
        assertEquals("7.65", invoice.getTotalTaxes().toString());
    } 

    @Test

    public void testTotalPriceInputThree() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        
        orderList.add(new Order(1, new Item("bottle of perfume", false, new BigDecimal("27.99")), true));
        orderList.add(new Order(1, new Item("bottle of perfume", false, new BigDecimal("18.99")), false));
        orderList.add(new Order(1, new Item("packet of headache pills", true, new BigDecimal("9.75")), false));
        orderList.add(new Order(1, new Item("box of chocolates", true, new BigDecimal("11.25")), true));

        Invoice invoice = new Invoice(orderList);
        assertEquals("74.68", invoice.getTotalPrice().toString());
    } 

    @Test

    public void testTotalTaxesInputThree() {
        ArrayList<Order> orderList = new ArrayList<Order>();
        
        orderList.add(new Order(1, new Item("bottle of perfume", false, new BigDecimal("27.99")), true));
        orderList.add(new Order(1, new Item("bottle of perfume", false, new BigDecimal("18.99")), false));
        orderList.add(new Order(1, new Item("packet of headache pills", true, new BigDecimal("9.75")), false));
        orderList.add(new Order(1, new Item("box of chocolates", true, new BigDecimal("11.25")), true));
       
        Invoice invoice = new Invoice(orderList);
        assertEquals("6.70", invoice.getTotalTaxes().toString());
    } 

    @Test
    public void testSearchEngine(){
        LuceneSearchEngine searchEngine = new LuceneSearchEngine();
        assertEquals(true, searchEngine.searchWord("chocolate"));
    }
}
