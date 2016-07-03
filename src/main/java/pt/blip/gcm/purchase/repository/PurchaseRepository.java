package pt.blip.gcm.purchase.repository;

import pt.blip.gcm.purchase.domain.Purchase;

import java.time.OffsetDateTime;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
public interface PurchaseRepository {
    Purchase save(Purchase purchase);
    Iterable<Purchase> findAllValidUntil(OffsetDateTime expireDate);
    Purchase findOne(Long id);
    void delete(Long id);
}