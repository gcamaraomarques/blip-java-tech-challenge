package pt.blip.gcm.purchase.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseGenericException;
import pt.blip.gcm.purchase.repository.PurchaseRepositoryImpl;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * Created by gcamaraomarques on 3/7/16.
 */
public class PurchaseServiceImplTest {

    private PurchaseServiceImpl purchaseService;
    private PurchaseRepositoryImpl purchaseRepository = Mockito.mock(PurchaseRepositoryImpl.class);
    private PodamFactory podamFactory;

    @Autowired
    private CounterService counterService;

    @Before
    public void setUp() {
        purchaseService = new PurchaseServiceImpl(purchaseRepository, counterService);
        podamFactory = new PodamFactoryImpl();
    }

    @Test
    public void testListAllValid() throws PurchaseGenericException {
        Purchase purchase1 = podamFactory.manufacturePojo(Purchase.class);
        Purchase purchase2 = podamFactory.manufacturePojo(Purchase.class);
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase1);
        purchases.add(purchase2);
        when(purchaseRepository.findAllValid()).thenReturn(purchases);

        List<Purchase> purchasesResponse = (List<Purchase>) purchaseService.listAllValid();
        assertEquals(purchases.size(), purchasesResponse.size());
        assertEquals(purchases.get(0).getId(), purchasesResponse.get(0).getId());
    }

    @Test
    public void testSave() throws PurchaseGenericException {
        Purchase purchase = podamFactory.manufacturePojo(Purchase.class);
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(purchase);

        Purchase purchaseResponse = purchaseService.save(purchase);
        assertEquals(purchase.getId(), purchaseResponse.getId());
    }

    //TODO: Need to test getById and delete methods, but left that for later because they are not in use in this challenge
}
