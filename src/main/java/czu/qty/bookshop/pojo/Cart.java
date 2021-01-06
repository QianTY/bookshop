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
/**     购物车
 *      u_id            Integer
 *      b_id            varchar     图书编号
 *      b_name          varchar     图书名字
 *      b_count         int         数量
 *      b_price         float(7,2)  图书单价
 *      total_price     float(7,2)  总价
 *      g_id            varchar     订单编号
 */
public class Cart {

    private Integer id;
    private Integer u_id;
    private Integer cart_id;
    private Double total_price;

}
