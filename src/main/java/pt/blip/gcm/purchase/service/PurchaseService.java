package pt.blip.gcm.purchase.service;

import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseGenericException;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
public interface PurchaseService {
    Iterable<Purchase> listAllValid() throws PurchaseGenericException;
    Purchase getById(Long id) throws PurchaseGenericException;
    Purchase save(Purchase purchase) throws PurchaseGenericException;
    void delete(Long id) throws PurchaseGenericException;
}
