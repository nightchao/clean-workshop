package chrisza.purchasing.domain;

import java.util.UUID;

public class PurchaseRequestItem {

    private UUID id;
    private String item;
    private int amount;
    private int totalPrice;

    public PurchaseRequestItem(String item, int amount, int totalPrice) {
        this.item = item;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
