package czu.qty.bookshop.service.Impl;

import czu.qty.bookshop.mapper.BookKindMapper;
import czu.qty.bookshop.pojo.BookKind;
import czu.qty.bookshop.service.IBookKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @create 2020-12-29-12:13
 */
@Service
public class BookKindServiceImpl implements IBookKindService {

    @Autowired
    private BookKindMapper bookKindMapper;

    @Override
    public List<BookKind> getAllBookKind() {
        return bookKindMapper.getAllBookKind();
    }

    @Override
    public int addBookKind(Integer f_id, String f_name) {
        return bookKindMapper.addBookKind(f_id,f_name);
    }

    @Override
    public int delBookKind(Integer f_id) {
        return bookKindMapper.delBookKind(f_id);
    }

    @Override
    public int updataBookKind(String f_name, Integer f_id) {
        return bookKindMapper.updataBookKind(f_name,f_id);
    }
}
