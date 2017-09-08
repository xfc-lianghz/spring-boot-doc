package com.itstyle.doc.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.itstyle.doc.model.Member;
/**
 * 用户管理
 * 创建者 小柒2012
 * 创建时间	2017年9月7日
 */
public interface MemberRepository extends JpaRepository<Member, Integer> {
	Member findByAccount(String account);
	Member findByEmail(String email);
}
