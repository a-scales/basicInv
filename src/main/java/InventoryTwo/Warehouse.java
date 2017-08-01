package InventoryTwo;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by code on 7/30/17.
 */
@Entity
public class Warehouse extends Location {
    @Id long Id;
    String warehouseCode;
    boolean isOpen;
    boolean isAcceptingOrders;

    public Warehouse() { }

    public Warehouse(Long id, String warehouseCode, boolean isOpen, boolean isAcceptingOrders) {
        Id = id;
        this.warehouseCode = warehouseCode;
        this.isOpen = isOpen;
        this.isAcceptingOrders = isAcceptingOrders;
    }
}
