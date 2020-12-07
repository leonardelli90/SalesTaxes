package salestaxes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        
        for (int i = 0; i<args.length; i++){

            File file = new File("src\\main\\java\\resources\\input\\" + args[i]);
            ArrayList<Order> orders = new ArrayList<Order>();
       
            try {
            
                Scanner scanner = new Scanner(file);

                while(scanner.hasNext()) {
                    String line = scanner.nextLine();
                    if (!line.contains("Input")){
                        Order order = OrderFactory.getOrderFromInput(line);
                        orders.add(order);
                    }
                }
                
                scanner.close();
            
            } catch (FileNotFoundException e) {    
                System.out.println("File not found");
                e.printStackTrace();
            } catch (IllegalStateException | NumberFormatException e) {
                System.out.println("Input bad formatted");
                e.printStackTrace();
            }

            Invoice invoice = new Invoice(orders);

            invoice.printInvoice();
        }
    }
}
