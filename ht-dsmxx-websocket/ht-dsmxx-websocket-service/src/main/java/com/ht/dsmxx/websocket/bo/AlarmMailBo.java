package com.ht.dsmxx.websocket.bo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 * @author zhangyang
 * @date 2019/07/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AlarmMailBo implements Serializable {

    private Long id;

    private Date createTime;

    private String createUserAccount;

    private Integer isSystem;

    private Date modifyTime;

    private String modifyUserAccount;

    private String guid;

    private String ipAddress;

    private Boolean isImport;

    private Date originalCreateDate;

    private String userAccount;

    private String userName;

    private Integer alarmType;

    private Integer currentCount;

    private String departIds;

    private String deviceName;

    private Integer errorPwdCount;

    private String fileName;

    private String filelSecurityLevel;

    private Boolean isSend;

    private String macAddress;

    private String operationContent;

    private String teminalName;

    private String teminalSecurityLevel;

    private Integer threshold;

    private String userSecurityLevel;

    private String uuid;

    private static final long serialVersionUID = 1L;
}