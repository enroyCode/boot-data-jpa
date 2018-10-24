/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * <p>
 * 项目名：	boot-data-jpa
 * 文件名：	UserService.java
 * 模块说明：
 * 修改历史：
 * 2018/10/24 - zhuchao - 创建。
 */
package com.enroy.cloud.boot.data.jpa.service;

import com.enroy.cloud.boot.data.jpa.api.User;
import com.enroy.cloud.boot.data.jpa.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuchao
 */
@Service
public class UserService {
  @Autowired
  private UserDao userDao;

  public List<User> findAll() {
    return userDao.findAll();
  }

}
