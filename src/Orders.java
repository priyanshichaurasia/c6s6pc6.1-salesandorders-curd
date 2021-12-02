import java.util.Date;
public class Orders {
    private  int orderId, amount,customerId;
    private Date orderDate;

    public Orders(int orderId, int amount, Date orderDate, int customerId){
        this.orderId=orderId;
        this.amount=amount;
        this.orderDate=orderDate;
        this.customerId=customerId;
    }
    //getter-setter

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String toString(){
        return (orderId +","+ amount +","+ orderDate +","+ customerId);
    }
}
