/**
 * 版权所有(C)，上海海鼎信息工程股份有限公司，2018，所有权利保留。
 * <p>
 * 项目名：	boot-data-jpa
 * 文件名：	Role.java
 * 模块说明：
 * 修改历史：
 * 2018/10/24 - zhuchao - 创建。
 */
package com.enroy.cloud.boot.data.jpa.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.xml.internal.txw2.annotation.XmlElement;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhuchao
 */
@Entity
@Table(name = "test_role")
@Data
public class Role implements Serializable {
  private static final long serialVersionUID = 410597533934161960L;
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  @Column(name = "f_uuid", length = 38, nullable = false)
  private String uuid;
  @Column(name = "f_code", nullable = false)
  private String code;
  @Column(name = "f_name", nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userUuid", nullable = false)
  @JsonIgnore//解决json解析循环引用导致的内存溢出问题
  private User user;
}
