package chrisza.purchasing.usecase;

import chrisza.purchasing.domain.InvalidPurchaseRequestException;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.fixtures.PurchaseRequestFixtures;
import chrisza.purchasing.persistance.PurchaseRequestRepositoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseRequestUseCaseTest {

    @Test
    void shouldThrowForInvalidPurchaseRequest() {
        PurchaseRequest pr = PurchaseRequestFixtures.getInvalidPurchaseRequest();
        PurchaseRequestUseCase useCase = new PurchaseRequestUseCase(new MockRepo());
        assertThrows(InvalidPurchaseRequestException.class, () -> useCase.create(pr));
    }

    @Test
    void shouldSaveToRepository() throws InvalidPurchaseRequestException {
        PurchaseRequest pr = PurchaseRequestFixtures.getValidPurchaseRequest();
        MockRepo mockRepo = new MockRepo();
        PurchaseRequestUseCase useCase = new PurchaseRequestUseCase(mockRepo);
        PurchaseRequest result = useCase.create(pr);
        assertTrue(mockRepo.IsCreated);
        assertEquals(result, pr);
    }

    private static class MockRepo extends PurchaseRequestRepositoryImpl {
        public Boolean IsCreated;

        @Override
        public PurchaseRequest create(PurchaseRequest purchaseRequest) {
            this.IsCreated = true;
            return purchaseRequest;
        }
    }
}