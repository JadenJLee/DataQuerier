This is a Spring Application that allows us to run a Spring instance locally to hit the endpoints to extract data from an Apache Solr Instance running locally.

To run DB migration (already done locally):
1. Ensure lib/Product_feed.tsv or tsv file with similar column characteristics are loaded into the lib directory.
2. Run DbMigration Class in com.example.migration.

Setup Apache SOLR instance
1. Download Solr 8.11.2
2. ~ solr start
3. ~ solr restart -p 8983
4. ~ solr status

To run Spring Application, run src/main/java/com/example/DemoApplication. The following endpoints connect to the Solr instance running locally, and extracts data via Java endpoints.

The endpoints are as follows once the spring application is running locally:
1. /product -- params: sku_id
2. /select -- params: column Name, exact word


