package InventoryTwo;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

/**
 * Created by code on 7/30/17.
 */
//DONE: Add a type code that can index items
@Entity
public class Item {
    @Id Long id;
    @Index String sku; //TODO: Think about if this needs to be unique or not. Probably does.
    @Index String upc;
    String name;
    String mfr;
    String color;
    String size;
    String desc;
    String location;
    String bin;
    String typeCode; //Also might be considered classcode, but that's semantics.
    int quantityOnHand;
    double purchasePrice;
    double salePrice;
    double msrp;

    @Parent Key<Location> owner;

    public Item() {

    }

    public Item(Long id, String sku, String upc, String name, String mfr, String color, String size, String desc, String typeCode, double purchasePrice, double salePrice, double msrp) {
        this.id = id;
        this.sku = sku;
        this.upc = upc;
        this.name = name;
        this.mfr = mfr;
        this.color = color;
        this.size = size;
        this.desc = desc;
        this.typeCode = typeCode;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.msrp = msrp;
    }
}
