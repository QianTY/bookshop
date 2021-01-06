package czu.qty.bookshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create 2020-12-25-15:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cartitem {

    private Integer id;
    private Integer cart_id;
    private String b_id;
    private String b_name;
    private Integer num;
    private Double price;
    private String imgs;

}
