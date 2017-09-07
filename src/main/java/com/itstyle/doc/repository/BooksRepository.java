package com.itstyle.doc.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.doc.model.Books;
/**
 * 项目文档
 * 创建者 小柒2012
 * 创建时间	2017年9月7日
 *
 */
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
