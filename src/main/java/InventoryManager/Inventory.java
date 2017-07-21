package InventoryManager;
import java.util.List;

import com.google.gson.Gson;
import com.googlecode.objectify.SaveException;
import com.googlecode.objectify.VoidWork;
import com.googlecode.objectify.Work;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by code on 7/18/17.
 * Helper/Manager class for managing Items in the DB.
 */
public abstract class Inventory {
    /*TODO: Consider rewriting this as an abstract class,
    forcing individual implementations of toJson and toString while providing a single manager instance for all of the inventory items.
    and allowing calls of itemInstance.doSomething() that relays to super.doSomething()
     */
    public static List<InventoryItem> fetchAllItemsAsList() {
        return ofy().load().type(InventoryItem.class).list();
    }
    public static String fetchAllItemsAsJson() {
        return listToJson(fetchAllItemsAsList());
    }
    /*
     =================
     POST Methods
     =================
     */
    /**
     * Create an item from a json string.
     * @param i json formatted string string
     * @return
     */
    //TODO: add error catching for Gson in case it goes FUBAR because of bad input.
    public static int createItemFromJson(String i) {
        InventoryItem newItem = new Gson().fromJson(i, InventoryItem.class);
        try {
            newItem.saveItem();
            return 201;
        }
        catch (SaveException e) {
            System.out.println("Google Datastore save error: "+e);
            return 500;
        }
    }

    /*
    ==================
    GET Methods
    ==================
     */

    /**
     * Fetch by item SKU. SKU numbers should be unique
     * @param sku
     * @return the Item. SKU
     */
    public static InventoryItem fetchBySKU(String sku) {
        return ofy().load().type(InventoryItem.class).filter("sku", sku).first().now();
    }

    /**
     * Fetch by item UPC. UPC numbers should be unique
     * @param upc
     * @return
     */
    public static InventoryItem fetchByUPC(String upc) {
        return ofy().load().type(InventoryItem.class).filter("upc", upc).first().now();
    }

    /**
     * Fetch all items as a list
     * @return
     */
    private static List<InventoryItem> allItems() {
        return ofy().load().type(InventoryItem.class).list();
    }

    /**
     * Turn a List of type inventory item into a JSON string.
     * @return
     */
    public static String getAllItems() {
        return listToJson(allItems());
    }

    private static String listToJson(List<InventoryItem> l) {
        Gson g = new Gson();
        String jsonString = "";
        for(InventoryItem i: l) {
            jsonString+=g.toJson(i);
        }
        return jsonString;
    }



    /*
    ===================
    PUT Methods
    ===================
     */
    public static int changeQuantity(int i, InventoryItem item) {
        item.changeQuantity(i);
        try {
            item.saveItem();
        }
        catch (SaveException e) {
            System.out.println("Google Datastore error: "+e);
            return 500;
        }
        return 201;



    }
    abstract String itemToJson();
    abstract void saveItem();


}
