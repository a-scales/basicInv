package InventoryTwo;

import com.googlecode.objectify.Key;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

/**
 * Created by code on 7/30/17.
 */
public final class APIMethods {

    //All the things that make the API work go here.
    //TODO: Give this a name that actually reflects its usecase.
    //TODO: ADD ALL THE THINGS

    //TODO: Consider writing the DB write methods here. Or writing another class for it. Allowing for more pluggability in the long run.




    /*
    Methods below are the DB functions. They need to meet the javadoc, and should be re-written if the database changes.
     */

    /**
     * Saves an entity to the google datastore.
     * @param in any object, must be registered as entity with objectify service.
     * @param <T> Object type
     */
    public static <T> void saveEntity(T in) {

    }

    /**
     * Fetches a single item by UPC or SKU
     * @param upcsku UPC or SKU to load by
     * @return Item entity
     */
    public static Item loadByCode(String upcsku) {

        return null;
    }

    /**
     * Fetches a single item by key
     * @param a
     * @return Item entity
     */
    public static Item loadByKey(Key a) {

        return null;
    }

    /**
     * Fetches all items
     * @return Item array. TODO: Consider changing this to a List since that's what Google returns
     */
    public static Item[] loadAll() {

        return null;
    }

    /**
     * Fetches all by typecode
     * @return Item array.
     */
    public static List<Item> loadAllOfType(Location L) {
        ofy().load().entities();
        return null;
    }

    /**
     * Fetches all items where a key is set to a specific value. Allows for loading by weird conditions.
     * ie - mfr : adidas, color : green
     * @param key
     * @param val
     * @return
     */
    public static Item[] loadByValue(String key, String val) {

        return null;
    }
}
