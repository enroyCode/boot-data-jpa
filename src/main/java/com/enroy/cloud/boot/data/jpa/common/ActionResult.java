package com.enroy.cloud.boot.data.jpa.common;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 执行结果
 *
 * @author zhuchao
 */
@XmlRootElement
public class ActionResult {

  private boolean success = true;
  private String code;
  private String message;

  public static ActionResult ok() {
    return OK;
  }

  public static ActionResult fail(String message) {
    ActionResult r = new ActionResult();
    r.setSuccess(false);
    r.setMessage(message);
    return r;
  }

  public static ActionResult fail(String code, String message) {
    ActionResult r = new ActionResult();
    r.setSuccess(false);
    r.setCode(code);
    r.setMessage(message);
    return r;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  /** 错误码 */
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  /** 错误信息 */
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static final ActionResult OK = new ActionResult();
}
