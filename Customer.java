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

}
