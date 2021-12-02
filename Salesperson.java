public class Salesperson {
    private int salesId,commisionRate;
    private String firstName,city;

    public Salesperson(int salesId, String firstName, String city, int commisionRate){
        this.salesId=salesId;
        this.firstName=firstName;
        this.city=city;
        this.commisionRate=commisionRate;
    }
    //getter-setter
    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(int commisionRate) {
        this.commisionRate = commisionRate;
    }

    @Override
    public String toString(){
        return (salesId +" "+ firstName +" " + city +" " + commisionRate);
    }
}
