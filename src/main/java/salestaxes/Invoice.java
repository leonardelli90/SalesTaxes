package salestaxes;

import java.math.BigDecimal;
import java.util.ArrayList;

final class Invoice {
    
    private final ArrayList<Order> orders;

    Invoice(ArrayList<Order> orders) {
        this.orders = orders;
    }

    ArrayList<Order> getOrders() {
        return orders;
    }

    BigDecimal getTotalTaxes(){
        BigDecimal taxes = BigDecimal.ZERO;
        for(Order order : orders){
            taxes = taxes.add(order.getTotalTaxesOfOrder());
        }
        return taxes;
    }

    BigDecimal getTotalPrice(){
        BigDecimal totalPrice = BigDecimal.ZERO;
        for(Order order : orders){
            totalPrice = totalPrice.add(order.getTotalPriceOfOrder());
        }
        return totalPrice;
    }

    void printInvoice(){
        StringBuilder sb = new StringBuilder();
        
        for(Order order : orders){
            sb.append(order.toString() + "\n");
        }

        sb.append("Sales Taxes: " + getTotalTaxes() + "\n");
        sb.append("Total: " + getTotalPrice() + "\n");
        
        System.out.println(sb);
        
    }
}
