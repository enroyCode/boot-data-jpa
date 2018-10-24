/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * <p>
 * 项目名：	boot-data-jpa
 * 文件名：	UserRepository.java
 * 模块说明：
 * 修改历史：
 * 2018/10/24 - zhuchao - 创建。
 */
package com.enroy.cloud.boot.data.jpa.repository;

import com.enroy.cloud.boot.data.jpa.api.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zhuchao
 */
public interface UserRepository extends Repository<User, String> {
  @Query("select p from User p")
  List<User> findAll();

  @Modifying
  @Query("update User p set p.name = :name where p.uuid = :uuid")
  int rename(@Param("uuid") String uuid, @Param("name") String name);

  @Query("select p from User p where p.code= :code")
  User findByCode(@Param("code") String code);
}
