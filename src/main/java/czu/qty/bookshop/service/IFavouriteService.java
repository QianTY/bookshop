package czu.qty.bookshop.service;

import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Favourite;


import java.util.List;

/**
 * @create 2021-01-01-15:01
 */
public interface IFavouriteService {

    //添加收藏
    public int addFavourite(Integer u_id , String b_id);

    //取消收藏
    public int delFavourite(Integer u_id , String b_id);

    //根据用户id找到所有收藏
    public PageInfo<Book> getAllMyFavourite(Integer u_id, Integer pageNum, Integer pageSize);

    public List<Book> getAll(Integer u_id);

    public Favourite getFavouriteByUidAndBid(Integer u_id,String b_id);

    public void delFavourite2(Integer u_id ,String b_id);
}
