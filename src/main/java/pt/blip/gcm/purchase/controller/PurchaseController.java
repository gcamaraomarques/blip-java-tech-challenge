package pt.blip.gcm.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pt.blip.gcm.purchase.domain.Purchase;
import pt.blip.gcm.purchase.exception.PurchaseGenericException;
import pt.blip.gcm.purchase.service.PurchaseService;

import java.util.List;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
@RestController
public class PurchaseController {
    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    public List<Purchase> getPurchasesValidUntil() throws PurchaseGenericException {
        return (List<Purchase>) this.purchaseService.listAllValid();
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase savePurchase(Purchase purchase) throws PurchaseGenericException {
        return this.purchaseService.save(purchase);
    }

    @RequestMapping(value = "/purchase/{id}", method = RequestMethod.PUT)
    public Purchase updatePurchase(@PathVariable Long id, Purchase purchase) throws PurchaseGenericException {
        purchase.setId(id);
        return this.purchaseService.save(purchase);
    }

}
