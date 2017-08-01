package InventoryTwo;

import com.googlecode.objectify.annotation.Id;

/**
 * Created by code on 8/1/17.
 */
public abstract class Location {
    //DONE: Consider the benefit of a parent class for Store and Warehouse that captures this information.
    @Id
    Long Id;
    String code;
    boolean isOpen;
    boolean isAcceptingOrders;

    public Location() { }

    public Location(Long id, String code, boolean isOpen, boolean isAcceptingOrders) {
        Id = id;
        this.code = code;
        this.isOpen = isOpen;
        this.isAcceptingOrders = isAcceptingOrders;
    }
}
