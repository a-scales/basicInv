Basicinv Cloud Inventory
==================
The basicinv cloud inventory application provides a backend platform and api for inventory management.
It is designed to run on Google's App Engine and take advantage of the NoSql Datastore.


## Maven
This file is made for the google app engine. In order to delpoy or run the application, use the following.
### Running locally

    mvn appengine:run

### Deploying

    mvn appengine:deploy

## Getting Started ##
Once the application is running on the Cloud Platform, the API options currently are as follows:
### Creating Items ###
To create an item, you must make a POST request to /api/item/create
#### curl example ####
    curl -H "Content-Type: application/json" -X POST -d '{"sku":"12344","upc":"12344","name":"testMfr","color":"BLK","size":"","desc":"Test","location":"1","bin":"5","quantityOnHand":100,"purchasePrice":2.99,"salePrice":5.99,"msrp":5.99}' http://host:8080/api/item/create




## Testing
Unit tests coming soon.


