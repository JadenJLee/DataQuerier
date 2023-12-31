package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Product object to hold the information coming from JSON object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private int sku_id;
    private String image;
    private String additional_image_link;
    private int style_id;
    private int class_id;
    private String color;
    private int color_code;
    private String color_family;
    private String size;
    private int size_id;
    private int department_id;
    private int dissectioncode;
    private boolean hazmat;
    private boolean redline;
    private boolean promoted;
    private String tax_code;
    private int vendor;
    private float list_price;
    private String sale_price;
    private String sale_price_effective_date;
    private String currency;
    private boolean shoprunner_eligible;
    private String title;
    private String link;
    private String prod_description;
    private String start_date;
    private boolean featured_color;
    private String featured_color_category;
    private String related_products;
    private String pre_order;
    private String handling_code;
    private String video;
    private String proportion;
    private String proportion_products;
    private String master_style;
    private boolean cannot_return;
    private boolean great_find;
    private boolean web_exclusive;
    private String ny_deals;
    private String promo_tagline;
    private boolean partially_promoted;
    private String product_category;
    private String sort_order;
    private int quantity_sold;
    private String average_rating;
    private boolean duplicate;

    // getters and setters and create product class ___________________________________________________________________

    public int getSku_id() {
        return sku_id;
    }

    public void setSku_id(int sku_id) {
        this.sku_id = sku_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAdditional_image_link() {
        return additional_image_link;
    }

    public void setAdditional_image_link(String additional_image_link) {
        this.additional_image_link = additional_image_link;
    }

    public int getStyle_id() {
        return style_id;
    }

    public void setStyle_id(int style_id) {
        this.style_id = style_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getColor_code() {
        return color_code;
    }

    public void setColor_code(int color_code) {
        this.color_code = color_code;
    }

    public String getColor_family() {
        return color_family;
    }

    public void setColor_family(String color_family) {
        this.color_family = color_family;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDissectioncode() {
        return dissectioncode;
    }

    public void setDissectioncode(int dissectioncode) {
        this.dissectioncode = dissectioncode;
    }

    public boolean isHazmat() {
        return hazmat;
    }

    public void setHazmat(boolean hazmat) {
        this.hazmat = hazmat;
    }

    public boolean isRedline() {
        return redline;
    }

    public void setRedline(boolean redline) {
        this.redline = redline;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

    public int getVendor() {
        return vendor;
    }

    public void setVendor(int vendor) {
        this.vendor = vendor;
    }

    public float getList_price() {
        return list_price;
    }

    public void setList_price(float list_price) {
        this.list_price = list_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public String getSale_price_effective_date() {
        return sale_price_effective_date;
    }

    public void setSale_price_effective_date(String sale_price_effective_date) {
        this.sale_price_effective_date = sale_price_effective_date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isShoprunner_eligible() {
        return shoprunner_eligible;
    }

    public void setShoprunner_eligible(boolean shoprunner_eligible) {
        this.shoprunner_eligible = shoprunner_eligible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProd_description() {
        return prod_description;
    }

    public void setProd_description(String prod_description) {
        this.prod_description = prod_description;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public boolean isFeatured_color() {
        return featured_color;
    }

    public void setFeatured_color(boolean featured_color) {
        this.featured_color = featured_color;
    }

    public String getFeatured_color_category() {
        return featured_color_category;
    }

    public void setFeatured_color_category(String featured_color_category) {
        this.featured_color_category = featured_color_category;
    }

    public String getRelated_products() {
        return related_products;
    }

    public void setRelated_products(String related_products) {
        this.related_products = related_products;
    }

    public String getPre_order() {
        return pre_order;
    }

    public void setPre_order(String pre_order) {
        this.pre_order = pre_order;
    }

    public String getHandling_code() {
        return handling_code;
    }

    public void setHandling_code(String handling_code) {
        this.handling_code = handling_code;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getProportion_products() {
        return proportion_products;
    }

    public void setProportion_products(String proportion_products) {
        this.proportion_products = proportion_products;
    }

    public String getMaster_style() {
        return master_style;
    }

    public void setMaster_style(String master_style) {
        this.master_style = master_style;
    }

    public boolean isCannot_return() {
        return cannot_return;
    }

    public void setCannot_return(boolean cannot_return) {
        this.cannot_return = cannot_return;
    }

    public boolean isGreat_find() {
        return great_find;
    }

    public void setGreat_find(boolean great_find) {
        this.great_find = great_find;
    }

    public boolean isWeb_exclusive() {
        return web_exclusive;
    }

    public void setWeb_exclusive(boolean web_exclusive) {
        this.web_exclusive = web_exclusive;
    }

    public String getNy_deals() {
        return ny_deals;
    }

    public void setNy_deals(String ny_deals) {
        this.ny_deals = ny_deals;
    }

    public String getPromo_tagline() {
        return promo_tagline;
    }

    public void setPromo_tagline(String promo_tagline) {
        this.promo_tagline = promo_tagline;
    }

    public boolean isPartially_promoted() {
        return partially_promoted;
    }

    public void setPartially_promoted(boolean partially_promoted) {
        this.partially_promoted = partially_promoted;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }

    public int getQuantity_sold() {
        return quantity_sold;
    }

    public void setQuantity_sold(int quantity_sold) {
        this.quantity_sold = quantity_sold;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }
}
