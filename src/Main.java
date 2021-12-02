import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
public class Main {
    public  static  void  main(String [] args) throws ParseException {
        DbOperations dbo = new DbOperations();
        List<Salesperson> salesperson = dbo.getAllSalesperson();
        for(Salesperson sp : salesperson){
            System.out.println(sp);
        }

        Salesperson sp = new Salesperson(1111,"John Kenov", "Nordic", 26);
        boolean result = dbo.addSalesperson(sp);
        System.out.println("\n new salesperson record inserted " +result);

        boolean remove = dbo.removeSalesperson(1003);
        System.out.println("\n Salesperson is removed " +remove);

        Customer cust = new Customer(12563,"Samuel", "Thomas", "Stockholm",
                150,1111);
        boolean addcust = dbo.addCustomer(cust);
        System.out.println("\nCustomer Added " +addcust);
        java.util.Date dt = new SimpleDateFormat("yyyy-mm-dd").parse("2020-05-15");
        Orders ord2 = new Orders(12365, 3000, dt, cust.getCustomerId());
        boolean addorder = dbo.addOrders(ord2);

        Customer cust1 = dbo.getCustomerByName("Samuel");
        if(cust1==null) {
            System.out.println("Customer found ");
        }
        else{
            ord2.setAmount(3500);
            boolean result1 = dbo.update(ord2);
                if(result1==true){
                    System.out.println("updated");
                }
                else{
                    System.out.println("Not updated");
                }
            }
    }
}
