/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2016，所有权利保留。
 * <p>
 * 项目名：	boot-data-jpa
 * 文件名：	DataJpaNew.java
 * 模块说明：
 * 修改历史：
 * 2018/10/24 - zhuchao - 创建。
 */
package com.enroy.cloud.boot.data.jpa.transactional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author zhuchao
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
public @interface DataJpaNewTx {
}
