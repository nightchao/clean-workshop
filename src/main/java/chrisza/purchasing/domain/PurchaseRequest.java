package chrisza.purchasing.domain;

import java.util.List;
import java.util.UUID;

public class PurchaseRequest {

    private UUID id;
    private List<PurchaseRequestItem> items;
    private Employee owner;
    private Employee approver;

    public PurchaseRequest(List<PurchaseRequestItem> items, Employee owner, Employee approver) {
        this.setItems(items);
        this.setOwner(owner);
        this.setApprover(approver);
    }

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
    }

    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    public List<PurchaseRequestItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseRequestItem> items) {
        this.items = items;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean isValid() {
        if (approver.level() == EmployeeLevel.Employee) {
            return false;
        }
        int totalPrice = 0;
        for (PurchaseRequestItem item : this.items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice <= 100000 || approver.level() != EmployeeLevel.MidLevelManagement;
    }
}
