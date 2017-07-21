package scales;

import InventoryManager.Inventory;
import InventoryManager.InventoryItem;
import com.google.appengine.repackaged.com.google.api.client.json.Json;
import com.google.gson.*;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;
import static spark.Spark.*;
/**
 * Created by code on 7/17/17.
 */
public class SparkServer implements spark.servlet.SparkApplication {
    static {
//        ObjectifyService.register(InventoryItem.class);
    }
    public void init()
    {
        objectRegistration(); //Starts the Objectify service and registers classes with the Objectify Service

        /*Testing Methods*/
//        get("/", (req, res) -> "Testing");
//        get("/hello3", (req, res) -> "Testing a route");
//        get("/t", (req, res) -> Inventory.fetchBySKU("12345").itemToJson()+"TEST");
//        get("/testUpdate", (req, res) -> testUpdate());
//        get("/test", (req,res) -> objectifyTesting());

        /*
        API Endpoints
         */
        path("/api",() -> {
            path("/item",() -> {
                /*
                Methods for requesting from the Database
                */
                get("/all", (request, response) -> Inventory.getAllItems());
                get("/upc/*", (request,response) -> Inventory.fetchByUPC(request.splat()[0]));
                get("/sku/*", (request,response) -> Inventory.fetchBySKU(request.splat()[0]));

                /*
                Methods for adding to the Database
                 */
                post("/create", (request, response) -> {
                    int status = Inventory.createItemFromJson(request.body());
                    response.status(status);
                    return response;
                });
                put("/qty", (request, response) -> {
                    JsonElement je = new JsonParser().parse(request.body());
                    JsonObject jo = je.getAsJsonObject();
                    String itemID = jo.get("id").getAsString();
                    InventoryItem item = ofy().load().type(InventoryItem.class).filter("id",itemID).first().now();
                    int status = Inventory.changeQuantity(jo.get("amount").getAsInt(),item);
                    response.status(status);
                    return response;

                });
            });
        });
    }
    public static void main(String args[]) {
        SparkServer server = new SparkServer();
        server.init();

    }

    /**
     * Initiates Objectify and registers the entities.
     */
    private static void objectRegistration() {
        ObjectifyService.begin();
        try {
            ofy().factory().register(InventoryItem.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static List<InventoryItem> obectifyTestLoad() {
        List<InventoryItem> items =  ofy().load().type(InventoryItem.class).list();
        return items;
    }
    public static String listPrint(List<InventoryItem> l) {
        String t = "";
        Gson g = new Gson();
        for(InventoryItem e: l) {
            t+=g.toJson(l);
        }
        return t;
    }
    public static String testUpdate() {
        InventoryItem theItem = Inventory.fetchBySKU("12345");
        Inventory.changeQuantity(-1, theItem);
        return "New QuantityOnHand: " + theItem;
    }

    public static String objectifyTesting() {
        InventoryItem testItem = new InventoryItem(
                "12345",
                "12345",
                "test item",
                "test mfr",
                "BLK",
                "0",
                "A Item for testing",
                "4",
                "10",
                10,
                9.99,
                14.95,
                14.95
        );
        ofy().save().entity(testItem).now();

        return "insert attempted";
    }
}
