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
}
