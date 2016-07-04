package pt.blip.gcm.purchase.repository;

import org.springframework.stereotype.Repository;
import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseGenericException;

/**
 * Created by gcamaraomarques on 3/7/16.
 */
//TODO: To be implemented by another team.
@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {
    @Override
    public Purchase save(Purchase purchase) throws PurchaseGenericException {
        return null;
    }

    @Override
    public Iterable<Purchase> findAllValid() throws PurchaseGenericException {
        return null;
    }

    @Override
    public Purchase findOne(Long id) throws PurchaseGenericException {
        return null;
    }

    @Override
    public void delete(Long id) throws PurchaseGenericException {

    }
}
