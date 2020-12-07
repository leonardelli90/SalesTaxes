package salestaxes;

import java.math.BigDecimal;

final class Order {
    
    private final int quantity;
    private final Item item;
    private final boolean isImported;

    Order(int quantity, Item item, boolean isImported){
        if (item == null){
            throw new NullPointerException();
        }
        this.quantity = quantity;
        this.item = item;
        this.isImported = isImported;
    }

    Item getItem() {
        return item;
    }

    int getQuantity() {
        return quantity;
    }

    boolean isImported() {
        return isImported;
    }

    private BigDecimal getPriceWithTaxes(){
        return item.getPrice().add(item.getItemTaxes(isImported));
    }

    BigDecimal getTotalPriceOfOrder(){
        return getPriceWithTaxes().multiply(new BigDecimal(quantity));
    }

    BigDecimal getTotalTaxesOfOrder(){
        return item.getItemTaxes(isImported).multiply(new BigDecimal(quantity));
    }

    @Override
    public String toString() {
        return quantity + (isImported ? " imported " : " ") + item.getName() + ": " + getPriceWithTaxes();
    }
}
