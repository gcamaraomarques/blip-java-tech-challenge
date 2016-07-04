package pt.blip.gcm.purchase.repository;

import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseGenericException;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
public interface PurchaseRepository {
    Purchase save(Purchase purchase) throws PurchaseGenericException;
    Iterable<Purchase> findAllValid() throws PurchaseGenericException;
    Purchase findOne(Long id) throws PurchaseGenericException;
    void delete(Long id) throws PurchaseGenericException;
}