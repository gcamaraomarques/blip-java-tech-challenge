package pt.blip.gcm.purchase.repository;

import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseException;
import pt.blip.gcm.purchase.exception.PurchaseNotFoundException;

import java.time.OffsetDateTime;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
public interface PurchaseRepository {
    Purchase save(Purchase purchase) throws PurchaseException;
    Iterable<Purchase> findAllValidUntil(OffsetDateTime expireDate) throws PurchaseException;
    Purchase findOne(Long id) throws PurchaseNotFoundException, PurchaseException;
    void delete(Long id) throws PurchaseNotFoundException, PurchaseException;
}