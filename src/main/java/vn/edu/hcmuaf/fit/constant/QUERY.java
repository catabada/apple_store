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
        public static final String GET_LIST_BY_KEY_WORD = "select * from product where name like ?";
        public static final String GET_BY_ID = "select * from product where id = ?";
        public static final String GET_BY_SKU = "select * from product where sku = ?";
        public static final String INSERT = "insert into product(sku, name, type_id, price, url_image, discount) values (?, ?, ?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product where id = ?";
        public static final String UPDATE = "update product set sku = ?, name = ?, type_id = ?, price = ?, url_image = ?, discount = ?, rate = ?, viewed = ?, active = ? where id = ?";
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
        public static final String GET_LIST_BY_PRODUCT_ID = "select * from product_color where product_id = ?";
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
        public static final String GET_LIST_BY_PRODUCT_ID = "select * from product_option where product_id = ?";
        public static final String GET_BY_ID = "select * from product_option where id = ?";
        public static final String GET_BY_SKU = "select * from product_option where sku = ?";
        public static final String INSERT = "insert into product_option(sku, name, product_id, option_id) values (?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product_option where id = ?";
        public static final String UPDATE = "update product_option set sku = ?, name = ?, product_id = ?, option_id = ? where id = ?";
    }

    public static final class USER {
        public static final String GET_LIST = "select * from user";
        public static final String GET_BY_ID = "select * from user where id = ?";
        public static final String GET_BY_USERNAME = "select * from user where username = ?";
        public static final String INSERT = "insert into user(username, password, first_name, last_name,phone, email, address) values (?, ?, ?, ?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from user where id = ?";
        public static final String UPDATE = "update user set username = ?, password = ?, first_name = ?,last_name = ?,phone = ?,email = ?, address = ?, active = ?, role = ? where id=?";
        public static final String SIGN_IN = " select * from user where username = ? and password= ? ";
        public static final String CHECK_USERNAME = "select * from user where username = ?";
    }

    public static final class PRODUCT_DETAIL {
        public static final String GET_LIST = "select * from product_detail";
        public static final String GET_LIST_BY_PRODUCT_ID = "select * from product_detail where product_id = ?";
        public static final String GET_LIST_BY_PRODUCT_COLOR_ID = "select * from product_detail where product_color_id = ?";
        public static final String GET_LIST_BY_PRODUCT_OPTION_ID = "select * from product_detail where product_option_id = ?";
        public static final String GET_LIST_BY_PRODUCT_ID_AND_PRODUCT_COLOR_ID_AND_PRODUCT_OPTION_ID = "select * from product_detail where product_id = ? and product_color_id = ? and product_option_id = ?";
        public static final String GET_BY_ID = "select * from product_detail where id = ?";
        public static final String GET_BY_SKU = "select * from product_detail where sku = ?";
        public static final String INSERT = "insert into product_detail(sku, name, product_id, product_color_id, product_option_id, price, amount) values (?, ?, ?, ?, ?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from product_detail where id = ?";
        public static final String UPDATE = "update product_detail set sku = ?, name = ?, product_id = ?, product_color_id = ?, product_option_id = ?, price = ?, amount = ?, active = ? where id = ?";
        public static final String CHECK_COLOR_AND_OPTION = "select * from product_detail where product_id = ? and product_color_id = ? and product_option_id = ?";
    }

    public static final class CART {
        public static final String GET_LIST = "select * from cart";
        public static final String GET_BY_ID = "select * from cart where id = ?";
        public static final String GET_BY_USER_ID = "select * from cart where user_id = ?";
        public static final String INSERT = "insert into cart(user_id) values (?)";
        public static final String DELETE_BY_ID = "delete from cart where id = ?";
        public static final String UPDATE = "update cart set user_id = ? where id = ?";
    }

    public static final class CART_ITEM {
        public static final String GET_LIST = "select * from cart_item";
        public static final String GET_LIST_BY_CART_ID_AND_PRODUCT_DETAIL_ID = "select * from cart_item where cart_id = ? and product_detail_id = ?";
        public static final String GET_LIST_BY_CART_ID = "select * from cart_item where cart_id = ?";
        public static final String GET_BY_ID = "select * from cart_item where id = ?";
        public static final String INSERT = "insert into cart_item(cart_id , product_detail_id, quantity) values (?, ?, ?)";
        public static final String DELETE_BY_ID = "delete from cart_item where id = ?";
        public static final String UPDATE = "update cart_item set cart_id = ?, product_detail_id = ?, quantity = ? where id = ?";
    }

}

