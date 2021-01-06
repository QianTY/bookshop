package czu.qty.bookshop.service;

import czu.qty.bookshop.pojo.BookInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @create 2020-12-29-12:16
 */
public interface IBookInfoService {

    //查看所有图书信息类目
    public List<BookInfo> getAllBookInfo();

    //添加图书信息类目
    public int addBookInfo(String info_name);

    //删除图书类目信息
    public int delBookInfo(Integer info_id);

    //修改图书类目信息
    public int update(Integer info_id,String info_name);
}
