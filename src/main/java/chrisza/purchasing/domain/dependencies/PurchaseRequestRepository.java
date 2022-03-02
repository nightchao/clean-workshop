package chrisza.purchasing.domain.dependencies;

import chrisza.purchasing.domain.PurchaseRequest;

import java.util.UUID;

public interface PurchaseRequestRepository {

    PurchaseRequest create(PurchaseRequest purchaseRequest);

    PurchaseRequest getById(UUID id);
}
