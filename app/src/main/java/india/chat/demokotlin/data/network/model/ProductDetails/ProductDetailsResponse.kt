package india.chat.demokotlin.data.network.model.ProductDetails

import com.google.gson.annotations.SerializedName



    data class Categories (

        @SerializedName("id") val id : Int,
        @SerializedName("name") val name : String,
        @SerializedName("slug") val slug : String
    )

    data class Collection (

        @SerializedName("href") val href : String
    )


    data class Self (

        @SerializedName("href") val href : String
    )

    data class _links (

        @SerializedName("self") val self : List<Self>,
        @SerializedName("collection") val collection : List<Collection>
    )


    data class Images (

        @SerializedName("id") val id : Int,
        @SerializedName("date_created") val date_created : String,
        @SerializedName("date_created_gmt") val date_created_gmt : String,
        @SerializedName("date_modified") val date_modified : String,
        @SerializedName("date_modified_gmt") val date_modified_gmt : String,
        @SerializedName("src") val src : String,
        @SerializedName("name") val name : String,
        @SerializedName("alt") val alt : String,
        @SerializedName("position") val position : Int
    )

    data class Dimensions (

        @SerializedName("length") val length : String,
        @SerializedName("width") val width : String,
        @SerializedName("height") val height : String
    )


    data class ProductDetailsResponse (

        @SerializedName("id") val id : Int,
        @SerializedName("name") val name : String,
        @SerializedName("slug") val slug : String,
        @SerializedName("permalink") val permalink : String,
        @SerializedName("date_created") val date_created : String,
        @SerializedName("date_created_gmt") val date_created_gmt : String,
        @SerializedName("date_modified") val date_modified : String,
        @SerializedName("date_modified_gmt") val date_modified_gmt : String,
        @SerializedName("type") val type : String,
        @SerializedName("status") val status : String,
        @SerializedName("featured") val featured : Boolean,
        @SerializedName("catalog_visibility") val catalog_visibility : String,
        @SerializedName("description") val description : String,
        @SerializedName("short_description") val short_description : String,
        @SerializedName("sku") val sku : String,
        @SerializedName("price") val price : Double,
        @SerializedName("regular_price") val regular_price : Double,
        @SerializedName("sale_price") val sale_price : String,
        @SerializedName("date_on_sale_from") val date_on_sale_from : String,
        @SerializedName("date_on_sale_from_gmt") val date_on_sale_from_gmt : String,
        @SerializedName("date_on_sale_to") val date_on_sale_to : String,
        @SerializedName("date_on_sale_to_gmt") val date_on_sale_to_gmt : String,
        @SerializedName("price_html") val price_html : String,
        @SerializedName("on_sale") val on_sale : Boolean,
        @SerializedName("purchasable") val purchasable : Boolean,
        @SerializedName("total_sales") val total_sales : Int,
        @SerializedName("virtual") val virtual : Boolean,
        @SerializedName("downloadable") val downloadable : Boolean,
        @SerializedName("downloads") val downloads : List<String>,
        @SerializedName("download_limit") val download_limit : Int,
        @SerializedName("download_expiry") val download_expiry : Int,
        @SerializedName("external_url") val external_url : String,
        @SerializedName("button_text") val button_text : String,
        @SerializedName("tax_status") val tax_status : String,
        @SerializedName("tax_class") val tax_class : String,
        @SerializedName("manage_stock") val manage_stock : Boolean,
        @SerializedName("stock_quantity") val stock_quantity : String,
        @SerializedName("in_stock") val in_stock : Boolean,
        @SerializedName("backorders") val backorders : String,
        @SerializedName("backorders_allowed") val backorders_allowed : Boolean,
        @SerializedName("backordered") val backordered : Boolean,
        @SerializedName("sold_individually") val sold_individually : Boolean,
        @SerializedName("weight") val weight : String,
        @SerializedName("dimensions") val dimensions : Dimensions,
        @SerializedName("shipping_required") val shipping_required : Boolean,
        @SerializedName("shipping_taxable") val shipping_taxable : Boolean,
        @SerializedName("shipping_class") val shipping_class : String,
        @SerializedName("shipping_class_id") val shipping_class_id : Int,
        @SerializedName("reviews_allowed") val reviews_allowed : Boolean,
        @SerializedName("average_rating") val average_rating : Double,
        @SerializedName("rating_count") val rating_count : Int,
        @SerializedName("related_ids") val related_ids : List<Int>,
        @SerializedName("upsell_ids") val upsell_ids : List<String>,
        @SerializedName("cross_sell_ids") val cross_sell_ids : List<String>,
        @SerializedName("parent_id") val parent_id : Int,
        @SerializedName("purchase_note") val purchase_note : String,
        @SerializedName("categories") val categories : List<Categories>,
        @SerializedName("tags") val tags : List<String>,
        @SerializedName("images") val images : List<Images>,
        @SerializedName("attributes") val attributes : List<String>,
        @SerializedName("default_attributes") val default_attributes : List<String>,
        @SerializedName("variations") val variations : List<String>,
        @SerializedName("grouped_products") val grouped_products : List<String>,
        @SerializedName("menu_order") val menu_order : Int,
        @SerializedName("_links") val _links : _links
    )
