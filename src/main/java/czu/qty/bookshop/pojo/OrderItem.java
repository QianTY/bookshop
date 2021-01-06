package czu.qty.bookshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.security.PrivateKey;

/**
 *      id       int        主键--自增
 *      o_id     varchar    订单编号
 *      b_id     varchar    图书编号
 *      b_name   varchar    图书名
 *      count    int        数量
 *      price    float(7,2) 价格
 *      imgs     Strings    图片
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem implements Serializable {
    private Integer id;
    private String o_id;
    private String b_id;
    private String b_name;
    private Integer count;
    private Float price;
    private Float total_price;
    private String imgs;
}
