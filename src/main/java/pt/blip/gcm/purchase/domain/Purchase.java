package pt.blip.gcm.purchase.domain;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * Created by gcamaraomarques on 2/7/16.
 */
public class Purchase {
    private Long id;
    private String productType;
    private OffsetDateTime expires;
    private Details purchaseDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public OffsetDateTime getExpires() {
        return expires;
    }

    public void setExpires(OffsetDateTime expires) {
        this.expires = expires;
    }

    public Details getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(Details purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }
}
