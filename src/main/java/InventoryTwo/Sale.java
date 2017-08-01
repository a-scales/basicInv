package InventoryTwo;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by code on 7/30/17.
 */
@Entity
public class Sale {
    //TODO: Consider the benefit of an abstract parent class for transfers and sales that captures this info
    Store store;
    Date date;
    Date expiration;
    HashMap<Key<Item>,Integer> receipt;

    public Sale() {}

    public Sale(Store store, Date date, Date expiration) {
        this.store = store;
        this.date = date;
        this.expiration = expiration;
    }


    /**
     * Saves to the DB
     */
    public void exec() {

    }
}
