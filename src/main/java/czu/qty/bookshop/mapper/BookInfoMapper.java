package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.BookInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @create 2020-12-26-18:54
 */
@Mapper
public interface BookInfoMapper {

    //查看所有图书信息类目
    @Select("select * from bookinfo")
    public List<BookInfo> getAllBookInfo();

    //添加图书信息类目
    @Insert("insert into bookinfo(info_name) values(#{info_name})")
    public int addBookInfo(String info_name);

    //删除图书类目信息
    @Delete("delete from bookinfo where info_id=#{info_id}")
    public int delBookInfo(Integer info_id);

    //修改图书类目信息
    @Update("update bookinfo set(info_name) values(#{info_name}) where info_id = #{info_id}")
    public int update(Integer info_id,String info_name);

}
