package czu.qty.bookshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @create 2020-12-25-12:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

/**    图书分类
 *  f_id    Integer(自增) 分类id
 *  f_name  varchar     分类名
 */
public class BookKind {

    private Integer f_id;
    private String f_name;

}
