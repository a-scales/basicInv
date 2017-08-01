package InventoryTwo;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Subclass;

/**
 * Created by code on 7/30/17.
 */
@Subclass
public class StoreItem extends Item {
//    Store s;

    public StoreItem(Long id, String sku, String upc, String name, String mfr, String color, String size, String desc, String location, String bin, String typeCode, int quantityOnHand, double purchasePrice, double salePrice, double msrp, Store s) {
        super(id, sku, upc, name, mfr, color, size, desc, typeCode, purchasePrice, salePrice, msrp);
        this.quantityOnHand = quantityOnHand;
        this.location = location;
        this.bin = bin;
        this.owner = Key.create(s);
    }
    public StoreItem() {}
}
