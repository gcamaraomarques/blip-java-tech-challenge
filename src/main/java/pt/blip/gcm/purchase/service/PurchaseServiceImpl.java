package pt.blip.gcm.purchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;
import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseGenericException;
import pt.blip.gcm.purchase.repository.PurchaseRepository;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private PurchaseRepository purchaseRepository;
    private final CounterService counterService;
    private final static Long DB_SLA_IN_MILIS = 2500L;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, CounterService counterService) {
        this.purchaseRepository = purchaseRepository;
        this.counterService = counterService;
    }

    @Override
    public Iterable<Purchase> listAllValid() throws PurchaseGenericException {
        long startTime = System.currentTimeMillis();
        Iterable<Purchase> response = this.purchaseRepository.findAllValid();
        long endTime = System.currentTimeMillis();
        checkDBSLA(startTime, endTime);
        return response;
    }

    @Override
    public Purchase getById(Long id) throws PurchaseGenericException {
        long startTime = System.currentTimeMillis();
        Purchase response = this.purchaseRepository.findOne(id);
        long endTime = System.currentTimeMillis();
        checkDBSLA(startTime, endTime);
        return response;
    }

    @Override
    public Purchase save(Purchase purchase) throws PurchaseGenericException {
        long startTime = System.currentTimeMillis();
        Purchase response = this.purchaseRepository.save(purchase);
        long endTime = System.currentTimeMillis();
        checkDBSLA(startTime, endTime);
        return response;
    }

    @Override
    public void delete(Long id) throws PurchaseGenericException {
        long startTime = System.currentTimeMillis();
        this.purchaseRepository.delete(id);
        long endTime = System.currentTimeMillis();
        checkDBSLA(startTime, endTime);
    }

    private void checkDBSLA(long start, long end) {
        long elapsed = end - start;
        if (elapsed > DB_SLA_IN_MILIS) {
            counterService.increment("counter.db.sla.fails");
        }
    }
}
