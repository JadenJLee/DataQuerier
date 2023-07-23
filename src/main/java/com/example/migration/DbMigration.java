package com.example.migration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbMigration {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/predictspring";
        String user = "root";
        String pass = "JLee1016^^";
        String tsvFilePath = "lib/Product_feed.tsv";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, user, pass);
            connection.setAutoCommit(false);

            // note to self, 45 columns
            String sqlStatement = "INSERT INTO product_feed (" +
                    "sku_id, image, additional_image_link, style_id, class_id, color, color_code, color_family," +
                    "size, size_id, department_id, dissectioncode, hazmat, redline, promoted, tax_code, vendor," +
                    "list_price, sale_price, sale_price_effective_date, currency, shoprunner_eligible, title, link," +
                    "prod_description, start_date, featured_color, featured_color_category, related_products," +
                    "pre_order, handling_code, video, proportion, proportion_products, master_style, cannot_return," +
                    "great_find, web_exclusive, ny_deals, promo_tagline, partially_promoted, product_category, sort_order," +
                    "quantity_sold, average_rating, duplicate) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,false)" +
                    "ON DUPLICATE KEY UPDATE duplicate = true";
            PreparedStatement statement = connection.prepareStatement(sqlStatement);

            BufferedReader reader = new BufferedReader(new FileReader(tsvFilePath));
            String line = null;
            int ct = 0;
            int batchSize = 20;

            // skip first line
            reader.readLine();

            while((line = reader.readLine()) != null) {
                String[] lineItems = line.split("\t");
                // insert to each parameter index
                statement.setInt(1, Integer.parseInt(lineItems[0])); // sku_id
                statement.setString(2, lineItems[1]); // image
                statement.setString(3, lineItems[2]); // additional_image_link
                statement.setInt(4, Integer.parseInt(lineItems[3])); // style_id
                statement.setInt(5, Integer.parseInt(lineItems[4])); // class_id
                statement.setString(6, lineItems[5]); // color
                statement.setInt(7, lineItems[6].isEmpty() ? -999 : Integer.parseInt(lineItems[6])); // color_code
                statement.setString(8, lineItems[7]); // color_family
                statement.setString(9, lineItems[8]); // size
                statement.setInt(10, lineItems[9].isEmpty() ? -999 : Integer.parseInt(lineItems[9])); // size_id
                statement.setInt(11, Integer.parseInt(lineItems[10])); // department_id
                statement.setInt(12,
                        lineItems[11].chars().allMatch(Character::isLetter) || lineItems[11].isEmpty() ? -999 : Integer.parseInt(lineItems[11])); // dissectioncode
                statement.setBoolean(13, Boolean.parseBoolean(lineItems[12])); // hazmat
                statement.setBoolean(14, Boolean.parseBoolean(lineItems[13])); // redline
                statement.setBoolean(15, Boolean.parseBoolean(lineItems[14])); // promoted
                statement.setString(16, lineItems[15]); // tax_code
                statement.setInt(17, Integer.parseInt(lineItems[16])); // vendor
                statement.setDouble(18, Double.parseDouble(lineItems[17])); // list_price
                statement.setString(19, lineItems[18]); // sale_price
                statement.setString(20, lineItems[19]); // sale_price_effective_date
                statement.setString(21, lineItems[20]); // currency
                statement.setBoolean(22, Boolean.parseBoolean(lineItems[21])); // shoprunner_eligible
                statement.setString(23, lineItems[22]); // title
                statement.setString(24, lineItems[23]); // link
                statement.setString(25, lineItems[24]); // prod_description
                statement.setString(26, lineItems[25]); // start_date
                statement.setBoolean(27, Boolean.parseBoolean(lineItems[26])); // featured_color
                statement.setString(28, lineItems[27]); // featured_color_category
                statement.setString(29, lineItems[28]); // related_products
                statement.setString(30, lineItems[29]); // pre_order
                statement.setString(31, lineItems[30]); // handling_code
                statement.setString(32, lineItems[31]); // video
                statement.setString(33, lineItems[32]); // proportion
                statement.setString(34, lineItems[33]); // proportion_products
                statement.setString(35, lineItems[34]); // master_style
                statement.setBoolean(36, Boolean.parseBoolean(lineItems[35])); // cannot_return
                statement.setBoolean(37, Boolean.parseBoolean(lineItems[36])); // great_find
                statement.setBoolean(38, Boolean.parseBoolean(lineItems[37])); // web_exclusive
                statement.setString(39, lineItems[38]); // ny_deals
                statement.setString(40, lineItems[39]); // promo_tagline
                statement.setBoolean(41, Boolean.parseBoolean(lineItems[40])); // partially_promoted
                statement.setString(42, lineItems[41]); // product_category
                statement.setString(43, lineItems[42]); // sort_order
                statement.setInt(44, lineItems[43].isEmpty() ? 0 : Integer.parseInt(lineItems[43])); // quantity_sold

                // so sometimes, there is no average rating, so we want to make sure the line length is consistent throughout the csv
                if (lineItems.length == 44) {
                    statement.setString(45, "");
                } else {
                    statement.setString(45, lineItems[44]); // average_rating
                }

                statement.addBatch();
                ct += 1;

                if (ct % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            reader.close();

            statement.executeBatch();
            connection.commit();
            connection.close();

        } catch(IOException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
