package InventoryTwo;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by code on 7/30/17.
 */
@Entity
public class Item {
    @Id Long id;
    @Index String sku;
    @Index String upc;
    String name;
    String mfr;
    String color;
    String size;
    String desc;
    String location;
    String bin;
    int quantityOnHand;
    double purchasePrice;
    double salePrice;
    double msrp;

    public Item() {

    }

    public Item(Long id, String sku, String upc, String name, String mfr, String color, String size, String desc, String location, String bin, int quantityOnHand, double purchasePrice, double salePrice, double msrp) {
        this.id = id;
        this.sku = sku;
        this.upc = upc;
        this.name = name;
        this.mfr = mfr;
        this.color = color;
        this.size = size;
        this.desc = desc;
        this.location = location;
        this.bin = bin;
        this.quantityOnHand = quantityOnHand;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.msrp = msrp;
    }
}
