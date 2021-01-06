package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.BookKind;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @create 2020-12-26-13:44
 */
@Mapper
public interface BookKindMapper {

    //获取所有图书类别
    @Select("select * from bookkind")
    public List<BookKind> getAllBookKind();

    //增加图书类别
    @Insert("insert into bookkind (f_name) values(#{f_name})")
    public int addBookKind(Integer f_id,String f_name);

    //删除图书类别
    @Delete("delete from bookkind where f_id=#{f_id}")
    public int delBookKind(Integer f_id);

    //修改图书类别
    @Update("update bookkind set(f_name) value(#{f_name} where f_id=#{f_id})")
    public int updataBookKind(String f_name,Integer f_id);


}
