/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * <p>
 * 项目名：	boot-data-jpa
 * 文件名：	UserController.java
 * 模块说明：
 * 修改历史：
 * 2018/10/24 - zhuchao - 创建。
 */
package com.enroy.cloud.boot.data.jpa.controller;

import com.enroy.cloud.boot.data.jpa.api.User;
import com.enroy.cloud.boot.data.jpa.common.ActionResult;
import com.enroy.cloud.boot.data.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuchao
 */
@Api(tags = "人员管理")
@RestController
@RequestMapping(value = "/user", produces = "application/json;charset=utf-8")
public class UserController {
  @Autowired
  private UserService userService;

  @ApiOperation("获取本系统所有员工")
  @RequestMapping(value = "/gets", method = RequestMethod.GET)
  public List<User> gets() {
    return userService.findAll();
  }

  @ApiOperation("修改员工姓名")
  @RequestMapping(value = "/rename", method = RequestMethod.POST)
  public ActionResult rename(@ApiParam("用户代码") @RequestParam("code") String code, @ApiParam("修改名称") @RequestParam("name") String name) {
    return userService.rename(code, name);
  }

  @ApiOperation("获取指定员工")
  @RequestMapping(value = "/get/code", method = RequestMethod.GET)
  public User getByCode(@ApiParam("用户代码") @RequestParam("code") String code) {
    return userService.getByCode(code);
  }

  @ApiOperation("根据key查询员工")
  @RequestMapping(value = "/query", method = RequestMethod.POST)
  public Page<User> query(@ApiParam("用户代码") @RequestParam("key") String key, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
    return userService.query(key, page, pageSize);
  }

}
