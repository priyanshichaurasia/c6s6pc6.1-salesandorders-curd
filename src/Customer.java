public class Customer {
    private int customerId,rating,salesId;
    private String name,lastName,city;

    public Customer(int customerId, String name, String lastName, String city, int rating, int salesId){
        this.customerId=customerId;
        this.name=name;
        this.lastName=lastName;
        this.city=city;
        this.rating=rating;
        this.salesId=salesId;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String toString(){
        return (customerId +","+ name +","+ lastName +","+ city +","+ rating +","+ salesId);
    }
}
