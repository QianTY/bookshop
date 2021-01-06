package czu.qty.bookshop.service;

import czu.qty.bookshop.pojo.BookKind;

import java.util.List;

/**
 * @create 2020-12-29-12:12
 */
public interface IBookKindService {

    //获取所有图书类别
    public List<BookKind> getAllBookKind();

    //增加图书类别
    public int addBookKind(Integer f_id,String f_name);

    //删除图书类别
    public int delBookKind(Integer f_id);

    //修改图书类别
    public int updataBookKind(String f_name,Integer f_id);

}
