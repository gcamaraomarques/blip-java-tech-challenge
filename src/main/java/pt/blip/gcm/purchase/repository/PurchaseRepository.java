package pt.blip.gcm.purchase.repository;

import pt.blip.gcm.purchase.domain.Purchase;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
public interface PurchaseRepository {
    Purchase save(Purchase purchase);
    Iterable<Purchase> findAll();
    Purchase findOne(Long id);
    void delete(Long id);
}