package com.zxz.ebook.service;

import com.zxz.ebook.entity.Book;
import com.zxz.ebook.entity.Eorder;
import com.zxz.ebook.entity.Writer;

import java.util.List;
import java.util.Set;

public interface WriterService {
    public List<Writer> lookAllWriter();
    public Set<Book> LookBookByAuthor(String authorName);
}
