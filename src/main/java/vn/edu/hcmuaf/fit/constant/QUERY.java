package vn.edu.hcmuaf.fit.constant;

public final class QUERY {
    public static final class TYPE_PRODUCT {
        public static final String GET_LIST = "select * from type_product";
        public static final String GET_BY_ID = "select * from type_product where id = ?";
        public static final String GET_BY_SKU = "select * from type_product where sku = ?";
        public static final String GET_BY_SKU_EXCEPT = "select * from type_product where sku != ?";
        public static final String INSERT = "insert into type_product(sku, name) values (?, ?)";
        public static final String DELETE_BY_ID = "delete from type_product where id = ?";
        public static final String UPDATE = "update type_product set sku = ?, name = ?, active = ? where id = ?";

    }

    public static final class PRODUCT {
        public static final String GET_LIST = "select * from product";
        public static final String GET_LIST_BY_TYPE_PRODUCT_ID = "select * from product where type_id = ?";
        public static final String GET_BY_ID = "select * from product where id = ?";
        public static final String GET_BY_SKU = "select * from product where sku = ?";
        public static final String INSERT = "insert into product(sku, name, type_id, price, url_image, discount) values (?, ?, ?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product where id = ?";
        public static final String UPDATE = "update type_product set sku = ?, name = ?, type_id = ?, price = ?, url_image = ?, discount = ?, rate = ?, viewed = ?, active = ? where id = ?";
    }

    public static final class COLOR {
        public static final String GET_LIST = "select * from color";
        public static final String GET_BY_ID = "select * from color where id = ?";
        public static final String GET_BY_SKU = "select * from color where sku = ?";
        public static final String INSERT = "insert into color(sku, name, hex) values (?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from color where id = ?";
        public static final String UPDATE = "update color set sku = ?, name = ?, hex = ? where id = ?";
    }

    public static final class PRODUCT_COLOR {
        public static final String GET_LIST = "select * from product_color";
        public static final String GET_BY_ID = "select * from product_color where id = ?";
        public static final String GET_BY_SKU = "select * from product_color where sku = ?";
        public static final String INSERT = "insert into product_color(product_id, color_id, bg_image, de_images) values (?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product_color where id = ?";
        public static final String UPDATE = "update product_color set product_id = ?, color_id = ?, bg_image = ?, de_images = ? where id = ?";
    }

    public static final class OPTION {
        public static final String GET_LIST = "select * from options";
        public static final String GET_LIST_BY_TYPE_PRODUCT_ID = "select * from options where type_product_id = ?";
        public static final String GET_BY_ID = "select * from options where id = ?";
        public static final String GET_BY_SKU = "select * from options where sku = ?";
        public static final String INSERT = "insert into options(sku, name, type_product_id) values (?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from options where id = ?";
        public static final String UPDATE = "update options set sku = ?, name = ?, type_product_id = ? where id = ?";
    }

    public static final class PRODUCT_OPTION {
        public static final String GET_LIST = "select * from product_option";
        public static final String GET_BY_ID = "select * from product_option where id = ?";
        public static final String GET_BY_SKU = "select * from product_option where sku = ?";
        public static final String INSERT = "insert into product_option(sku, name, product_id, option_id) values (?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product_option where id = ?";
        public static final String UPDATE = "update product_option set sku = ?, name = ?, product_id = ?, option_id = ? where id = ?";
    }
}
