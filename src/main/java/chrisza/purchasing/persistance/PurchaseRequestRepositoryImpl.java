package chrisza.purchasing.persistance;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PurchaseRequestRepositoryImpl implements PurchaseRequestRepository {

    private final List<PurchaseRequest> purchaseRequestList;

    public PurchaseRequestRepositoryImpl() {
        this.purchaseRequestList = new ArrayList<>();
    }

    @Override
    public PurchaseRequest create(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getId() == null) {
            purchaseRequest.setId(UUID.randomUUID());
        }
        purchaseRequestList.add(purchaseRequest);
        return purchaseRequest;
    }

    @Override
    public PurchaseRequest getById(UUID id) {
        for (PurchaseRequest purchaseRequest : purchaseRequestList) {
            if (id.equals(purchaseRequest.getId())) {
                return purchaseRequest;
            }
        }
        return null;
    }
}
