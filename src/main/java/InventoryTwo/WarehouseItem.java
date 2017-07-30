package InventoryTwo;

import com.googlecode.objectify.annotation.Subclass;

/**
 * Created by code on 7/30/17.
 */
@Subclass
public class WarehouseItem extends Item {
    Warehouse wh;


    public WarehouseItem(Item i, Warehouse wh) {
        this.wh = wh;
    }

}
