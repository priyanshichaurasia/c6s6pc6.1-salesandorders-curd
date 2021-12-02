import java.util.List;
public class Main {
    public  static  void  main(String [] args){
        DbOperations dbo = new DbOperations();
        List<Salesperson> salesperson = dbo.getAllSalesperson();
        for(Salesperson sp : salesperson){
            System.out.println(sp);
        }

        Salesperson sp = new Salesperson(1111,"John Kenov", "Nordic", 26);
        boolean result = dbo.addSalesperson(sp);
        System.out.println("\n new salesperson record inserted " +result);

        boolean remove = dbo.removeSalesperson("axelrod");
        System.out.println("\n Salesperson is removed " +remove);
    }
}
