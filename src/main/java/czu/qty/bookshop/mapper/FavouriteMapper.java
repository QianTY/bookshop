package czu.qty.bookshop.mapper;

import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Favourite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @create 2021-01-01-14:56
 */
@Mapper
public interface FavouriteMapper {


    //添加收藏
    @Insert("insert into favorite(u_id,b_id) values(#{u_id},#{b_id})")
    public int addFavourite(Integer u_id , String b_id);

    //删除收藏
    @Delete("delete from favorite where u_id=#{u_id} and b_id=#{b_id}")
    public int delFavourite(Integer u_id , String b_id);

    //查看所有收藏
    @Select("select * from book where b_id in(select b_id from favorite where u_id=#{u_id})")
    public List<Book> getAllMyFavourite(Integer u_id);

    @Select("select * from favorite where u_id =#{u_id} and b_id = #{b_id}")
    public Favourite getFavouriteByUidAndBid(Integer u_id,String b_id);
    //收藏页面删除取消收藏
    @Delete("delete from favorite where u_id=#{u_id} and b_id=#{b_id}")
    public void delFavourite2(Integer u_id , String b_id);


}
