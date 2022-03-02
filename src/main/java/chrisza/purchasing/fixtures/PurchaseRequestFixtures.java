package chrisza.purchasing.fixtures;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;

import java.util.ArrayList;
import java.util.List;

public class PurchaseRequestFixtures {

    public static PurchaseRequest getInvalidPurchaseRequest() {
        PurchaseRequestItem item1 = new PurchaseRequestItem("MacBook", 2, 100001);
        List<PurchaseRequestItem> items = new ArrayList<>();
        items.add(item1);

        Employee owner = new Employee("billgates@microsoft.com");
        Employee approver = new Employee("steve@microapplesoft.com");

        return new PurchaseRequest(items, owner, approver);
    }

    public static PurchaseRequest getValidPurchaseRequest() {
        PurchaseRequestItem item1 = new PurchaseRequestItem("MacBook", 2, 9999);
        List<PurchaseRequestItem> items = new ArrayList<>();
        items.add(item1);

        Employee owner = new Employee("billgates@microsoft.com");
        Employee approver = new Employee("steve@microapplesoft.com");

        return new PurchaseRequest(items, owner, approver);
    }
}
