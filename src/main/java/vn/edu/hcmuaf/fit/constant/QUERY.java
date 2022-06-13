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
        public static final String GET_BY_ID = "select * from product where id = ?";
        public static final String GET_BY_SKU = "select * from product where sku = ?";
        public static final String INSERT = "insert into product(sku, name, type_id, price, url_image, discount) values (?, ?, ?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product where id = ?";
        public static final String UPDATE = "update type_product set sku = ?, name = ?, type_id = ?, price = ?, url_image = ?, discount = ?, rate = ?, viewed = ?, active = ? where id = ?";
    }
}
