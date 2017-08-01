package InventoryTwo;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Subclass;



/**
 * Created by code on 7/30/17.
 */
@Subclass
public class WarehouseItem extends Item {
//    Warehouse wh;

    public WarehouseItem(Long id, String sku, String upc, String name, String mfr, String color, String size, String desc, String type, String location, String bin, int quantityOnHand, double purchasePrice, double salePrice, double msrp, Warehouse wh) {
        super(id, sku, upc, name, mfr, color, size, desc, type, purchasePrice, salePrice, msrp);
        this.quantityOnHand = quantityOnHand;
        this.location = location;
        this.bin = bin;
        this.owner = Key.create(wh);
    }
    public WarehouseItem() {};

}
