package InventoryTwo;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * Created by code on 7/30/17.
 */
@Entity
public class Store extends Location {
    //TODO: Consider the benefit of a parent class for Store and Warehouse that captures this information.
    @Id Long Id;
    String code;
    boolean isOpen;
    boolean isAcceptingOrders;

    public Store() { }

    public Store(Long id, String storeCode, boolean isOpen, boolean isAcceptingOrders) {
        Id = id;
        this.code = storeCode;
        this.isOpen = isOpen;
        this.isAcceptingOrders = isAcceptingOrders;
    }
}
