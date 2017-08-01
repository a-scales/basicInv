package InventoryTwo;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.HashMap;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by code on 7/30/17.
 */
@Entity
public class Transfer {
    @Id Long id;
    Store storeOrigin;
    Warehouse warehouseOrigin;
    Store storeEnd;
    Warehouse warehouseEnd;
    HashMap<Key<Item>, Integer> reciept; //TODO: Hashmap works. Does this need decent hashing, or can it just be 1-to-1?

    /*
    Constructors all based in the format Origin, Recepient, qty
     */

    public Transfer(Store origin, Warehouse recep) {
        storeOrigin = origin;
        warehouseEnd = recep;
        reciept = new HashMap<>();
    }
    public Transfer(Warehouse origin, Store recep) {
        warehouseOrigin = origin;
        storeEnd = recep;
        reciept = new HashMap<>();
    }
    public Transfer(Warehouse origin, Warehouse recep) {
        warehouseOrigin = origin;
        warehouseEnd = recep;
        reciept = new HashMap<>();
    }
    public Transfer(Store origin, Store recep) {
        storeOrigin = origin;
        storeEnd = recep;
        reciept = new HashMap<>();
    }

    /**
     * Add an item to the receipt with a quantity.
     * @param i an Item to add to the transfer
     * @param qty quantity of the item to be added.
     */
    public void addItem(Item i, int qty) {
        reciept.put(Key.create(i),qty);
    }

    /**
     * Add an item with the default quantity of 1;
     * @param i an Item to add to the transfer
     */
    public void addItem(Item i) {
        reciept.put(Key.create(i),1);
    }

    /**
     * Updates and saves to the DB
     */
    public void exec() {
        ofy().save().entity(this);
    }
}
