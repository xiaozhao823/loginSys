package com.ming.brocent.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Email implements Serializable {
    /**
     * 收件人
     */
    private String sendTo;
    /**
     * 主题（业务的标识）
     */
    private String subject;
    /**
     * 模板内容
     */
    private String content;
    /**
     * 操作人
     */
    private String createdBy;
}
