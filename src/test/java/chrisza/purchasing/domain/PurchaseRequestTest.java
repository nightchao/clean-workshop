package chrisza.purchasing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PurchaseRequestTest {

    @Test
    void shouldBeValidForPrWhichApproverIsAManager() {
        PurchaseRequestItem item1 = new PurchaseRequestItem("MacBook", 2, 20000);
        PurchaseRequestItem item2 = new PurchaseRequestItem("PS5 Digital Edition", 1, 13990);
        List<PurchaseRequestItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Employee owner = new Employee("billgates@microsoft.com");
        Employee approver = new Employee("mark@microapplesoft.com");

        PurchaseRequest createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertTrue(createdPurchaseRequest.isValid());
    }

    @Test
    void shouldBeInValidForPrWhichApproverIsAnEmployee() {
        PurchaseRequestItem item1 = new PurchaseRequestItem("MacBook", 2, 20000);
        PurchaseRequestItem item2 = new PurchaseRequestItem("PS5 Digital Edition", 1, 13990);
        List<PurchaseRequestItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Employee owner = new Employee("billgates@microsoft.com");
        Employee approver = new Employee("mike@microapplesoft.com");

        PurchaseRequest createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertFalse(createdPurchaseRequest.isValid());
    }

    @Test
    void shouldBeInValidForPrWhichApproverIsAMidManagerExceed100000THB() {
        PurchaseRequestItem item1 = new PurchaseRequestItem("MacBook", 2, 100001);
        List<PurchaseRequestItem> items = new ArrayList<>();
        items.add(item1);

        Employee owner = new Employee("billgates@microsoft.com");
        Employee approver = new Employee("steve@microapplesoft.com");

        PurchaseRequest createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertFalse(createdPurchaseRequest.isValid());
    }

    @Test
    void ShouldBeInValidForPrWhichApproverIsASeniorManagerExceed100000THB() {
        PurchaseRequestItem item1 = new PurchaseRequestItem("MacBook", 2, 100001);
        List<PurchaseRequestItem> items = new ArrayList<>();
        items.add(item1);

        Employee owner = new Employee("billgates@microsoft.com");
        Employee approver = new Employee("mark@microapplesoft.com");

        PurchaseRequest createdPurchaseRequest = new PurchaseRequest(items, owner, approver);
        assertTrue(createdPurchaseRequest.isValid());
    }
}