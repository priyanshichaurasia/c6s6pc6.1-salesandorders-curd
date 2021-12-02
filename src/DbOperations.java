import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbOperations {

    public List<Salesperson> getAllSalesperson(){
        List<Salesperson> salespersonList = new ArrayList<Salesperson>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData",
                    "root", "root");
            String query = "select * from salesperson";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Salesperson sp = new Salesperson(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                salespersonList.add(sp);
            }
            rs.close();
            st.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return salespersonList;
    }

    public boolean addSalesperson(Salesperson sp){
        boolean result = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData",
                    "root", "root");
            String query = "insert into salesperson values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sp.getSalesId());
            ps.setString(2,sp.getFirstName());
            ps.setString(3,sp.getCity());
            ps.setInt(4,sp.getCommisionRate());

            int res = ps.executeUpdate();
            if(res==1){
                result = true;
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }

    public boolean removeSalesperson(int salesId){
        boolean result = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData",
                    "root", "root");
            String query = "delete from salesperson where salesId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,salesId);
            int res = ps.executeUpdate();
            if(res==1){
                result = true;
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }

    public boolean addCustomer(Customer c){
        boolean result = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData",
                    "root", "root");
            String query = "insert into customer values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,c.getCustomerId());
            ps.setString(2,c.getName());
            ps.setString(3, c.getLastName());
            ps.setString(4,c.getCity());
            ps.setInt(5,c.getRating());
            ps.setInt(6,c.getSalesId());

            int res = ps.executeUpdate();
            if(res==1){
                result = true;
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }

    public boolean addOrders(Orders or){
        boolean result = true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData",
                    "root", "root");
            String query = "insert into orders values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, or.getOrderId());
            ps.setInt(2, or.getAmount());
            ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
            ps.setInt(4, or.getCustomerId());
            int res = ps.executeUpdate();
            if(res==1){
                result = true;
            }
            ps.close();
            con.close();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        return result;
    }
       public Customer getCustomerByName(String name){
           Customer cust = null;
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData", "root",
                       "root");
               String query = "insert into customer values where name = ?";
               PreparedStatement ps = con.prepareStatement(query);
               ps.setString(1,name);
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                   cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),
                           rs.getString(4), rs.getInt(5), rs.getInt(6));
               }
               ps.close();
               con.close();
           }
           catch (Exception ex){
               System.out.println(ex);
           }
           return cust;
       }

       public boolean update(Orders or) {
           boolean result = false;
           try {
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarsSalesData", "root",
                       "root");
               String query = "update orders set orderId = ?, amount = ?, orderDate = ?, where customerId = ?";
               PreparedStatement ps = con.prepareStatement(query);
               ps.setInt(1, or.getOrderId());
               ps.setInt(2, or.getAmount());
               ps.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
               int res = ps.executeUpdate();
               if (res != 0) {
                   result = true;
               }
               ps.close();
               con.close();
           } catch (Exception ex) {
               System.out.println(ex);
           }
           return result;
       }
}
