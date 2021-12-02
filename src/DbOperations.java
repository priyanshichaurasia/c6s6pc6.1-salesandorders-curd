import java.sql.*;
import java.util.List;
import java.util.ArrayList;

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
            // id, name, city, rate
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
}
