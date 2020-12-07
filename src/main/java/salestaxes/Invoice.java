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

    void printInvoice(){
        StringBuilder sb = new StringBuilder();
        BigDecimal taxes = BigDecimal.ZERO;
        BigDecimal totalPrice = BigDecimal.ZERO;

        for(Order order : orders){
            sb.append(order.toString() + "\n");
            taxes = taxes.add(order.getTotalTaxesOfOrder());
            totalPrice = totalPrice.add(order.getTotalPriceOfOrder());
        }

        sb.append("Sales Taxes: " + taxes + "\n");
        sb.append("Total: " + totalPrice + "\n");
        
        System.out.println(sb);
        
    }
}
