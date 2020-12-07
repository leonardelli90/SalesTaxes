package salestaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;

final class Item {

    private static final BigDecimal ROUNDER_MOLTIPLICATOR = new BigDecimal("20");
    private static final BigDecimal IMPORT_TAX = new BigDecimal("0.05");
    private static final BigDecimal BASE_TAX = new BigDecimal("0.1");

    private final String name;
    private final BigDecimal price;
    private final boolean isTaxFree;
    
    //mettere la categoria dell'oggetto oppure solo se è taxfree?
    Item(String name,  boolean isTaxFree, BigDecimal price){
        
        if (name == null || price == null){
            throw new NullPointerException();
        }

        this.name = name;
        this.isTaxFree = isTaxFree;
        this.price = price;
        //this.isTaxFree = isTaxFree;
    }

    String getName() {
        return name;
    }

    BigDecimal getPrice() {
        return price;
    }
    
    boolean isTaxFree(){
        return isTaxFree;
    }

    BigDecimal getItemTaxes(boolean imported){

        BigDecimal tax = isTaxFree ? BigDecimal.ZERO : BASE_TAX;
        
        if(imported){
            tax = tax.add(IMPORT_TAX);
        }

        BigDecimal result = price.multiply(tax);
        //round up to the nearest 0.05
        result = result.multiply(ROUNDER_MOLTIPLICATOR).setScale(0, RoundingMode.CEILING).divide(ROUNDER_MOLTIPLICATOR).setScale(2);

        return result;

    }

    @Override
    public String toString() {
        return name + " at " + price;
    }

}