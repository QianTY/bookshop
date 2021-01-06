package czu.qty.bookshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @create 2020-12-25-12:28
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
/**     订单
 *      id       i      nt              主键--自增
 *      o_id            varchar         订单编号
 *      o_time          Date            订单创建时间
 *      o_price         float(7,2)      订单总价
 *      u_id            int             用户id
 *      is_receipt      int             是否发货 0未发货1已发货  默认为0
 *      receipt_time    Date            到货时间  发货即到货
 *      status          int             订单状态  0不可见1可见   默认为1   0表示订单被删除
 */
public class Order {

    private Integer id;
    private String o_id;
    private Date o_time;
    private Float o_price;
    private Integer u_id;
    private Integer is_receipt;
    private Date receipt_time;
    private Integer status;

}
