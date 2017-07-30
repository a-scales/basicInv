package InventoryTwo;

import com.googlecode.objectify.annotation.Subclass;

/**
 * Created by code on 7/30/17.
 */
@Subclass
public class StoreItem extends Item {
    Store s;
    public StoreItem(Item i, Store s) {
        this.s = s;
    }
}
