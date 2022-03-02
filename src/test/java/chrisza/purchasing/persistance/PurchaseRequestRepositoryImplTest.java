package chrisza.purchasing.persistance;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PurchaseRequestRepositoryImplTest {

    private PurchaseRequest initData() {
        List<PurchaseRequestItem> items = new ArrayList<>();
        PurchaseRequestItem requestItem = new PurchaseRequestItem("item01", 5, 500);
        items.add(requestItem);

        Employee owner = new Employee("ower123@abc.xyz.com");
        Employee approver = new Employee("approver123@abc.xyz.com");
        return new PurchaseRequest(items, owner, approver);
    }

    @Test
    void create() {
        // Arrange
        PurchaseRequest purchaseRequest = initData();

        // Act
        PurchaseRequestRepositoryImpl purchaseRequestRepository = new PurchaseRequestRepositoryImpl();
        PurchaseRequest result = purchaseRequestRepository.create(purchaseRequest);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getItems().size());
    }

    @Test
    void getById() {
        // Arrange
        PurchaseRequest purchaseRequest = initData();
        UUID id = UUID.randomUUID();
        purchaseRequest.setId(id);

        // Act
        PurchaseRequestRepositoryImpl purchaseRequestRepository = new PurchaseRequestRepositoryImpl();
        purchaseRequestRepository.create(purchaseRequest);
        PurchaseRequest resultSearch = purchaseRequestRepository.getById(id);

        // Assert
        assertNotNull(resultSearch);
    }
}
