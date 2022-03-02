package chrisza.purchasing.usecase;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;

public class PurchaseRequestUseCase {

    private final PurchaseRequestRepository repo;

    public PurchaseRequestUseCase(PurchaseRequestRepository repo) {
        this.repo = repo;
    }

    public PurchaseRequest create(PurchaseRequest pr) throws InvalidPurchaseRequestException {
        if (!pr.isValid()) {
            throw new InvalidPurchaseRequestException();
        }
        this.repo.create(pr);
        return pr;
    }
}
