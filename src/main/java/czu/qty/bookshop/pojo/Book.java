package czu.qty.bookshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create 2020-12-25-12:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 *  b_id     String 图书编号
 *  b_name   varchar()   图书名字
 *  b_price  Float(7,2)   价格 float(7,2)
 *  f_name   varchar 分类名
 *  b_author varchar 作者
 *  b_sales  Integer 销量
 *  b_stock  Integer 库存
 *  img_path varchar() 图片路径
 */
public class Book {

    private String b_id;
    private String b_name;
    private Float b_price;
    private String f_name;
    private String b_author;
    private Integer b_sales;
    private Integer b_stock;
    private String img_path;

}
