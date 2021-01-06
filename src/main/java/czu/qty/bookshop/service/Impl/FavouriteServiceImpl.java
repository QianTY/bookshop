package czu.qty.bookshop.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import czu.qty.bookshop.mapper.FavouriteMapper;
import czu.qty.bookshop.pojo.Book;
import czu.qty.bookshop.pojo.Favourite;
import czu.qty.bookshop.service.IFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2021-01-01-15:01
 */
@Service
public class FavouriteServiceImpl implements IFavouriteService {

    @Autowired
    private FavouriteMapper favouriteMapper;

    @Override
    public int addFavourite(Integer u_id, String b_id) {
        return favouriteMapper.addFavourite(u_id,b_id);
    }

    @Override
    public int delFavourite(Integer u_id, String b_id) {
        return favouriteMapper.delFavourite(u_id,b_id);
    }

    @Override
    public void delFavourite2(Integer u_id ,String b_id) {favouriteMapper.delFavourite2(u_id ,b_id);}

    @Override
    public PageInfo<Book> getAllMyFavourite(Integer u_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Book> list = favouriteMapper.getAllMyFavourite(u_id);

        PageInfo<Book> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
//得到当前用户的所有收藏并返回
    @Override
    public List<Book> getAll(Integer u_id) {
        return favouriteMapper.getAllMyFavourite(u_id);
    }

    @Override
    public Favourite getFavouriteByUidAndBid(Integer u_id, String b_id) {
        return favouriteMapper.getFavouriteByUidAndBid(u_id,b_id);
    }


}
