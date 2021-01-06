package czu.qty.bookshop.service.Impl;

import czu.qty.bookshop.mapper.BookInfoMapper;
import czu.qty.bookshop.pojo.BookInfo;
import czu.qty.bookshop.service.IBookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2020-12-29-12:17
 */
@Service
public class BookInfoServiceImpl implements IBookInfoService {
    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public List<BookInfo> getAllBookInfo() {
        return bookInfoMapper.getAllBookInfo();
    }

    @Override
    public int addBookInfo(String info_name) {
        return bookInfoMapper.addBookInfo(info_name);
    }

    @Override
    public int delBookInfo(Integer info_id) {
        return bookInfoMapper.delBookInfo(info_id);
    }

    @Override
    public int update(Integer info_id, String info_name) {
        return bookInfoMapper.update(info_id,info_name);
    }
}
