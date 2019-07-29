package com.ht.dsmxx.websocket.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("ht_dsm_alarm_mail")
public class AlarmMail implements Serializable {

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @TableField("Create_Time")
    private Date createTime;

    @TableField("Create_User_Account")
    private String createUserAccount;

    @TableField("Is_System")
    private Integer isSystem;

    @TableField("Modify_Time")
    private Date modifyTime;

    @TableField("Modify_User_Account")
    private String modifyUserAccount;

    @TableField("Guid")
    private String guid;

    @TableField("Ip_Address")
    private String ipAddress;

    @TableField("Is_Import")
    private Boolean isImport;

    @TableField("Original_Create_Date")
    private Date originalCreateDate;

    @TableField("User_Account")
    private String userAccount;

    @TableField("User_Name")
    private String userName;

    @TableField("Alarm_Type")
    private Integer alarmType;

    @TableField("Current_Count")
    private Integer currentCount;

    @TableField("Depart_Ids")
    private String departIds;

    @TableField("Device_Name")
    private String deviceName;

    @TableField("Error_Pwd_Count")
    private Integer errorPwdCount;

    @TableField("File_Name")
    private String fileName;

    @TableField("Filel_Security_Level")
    private String filelSecurityLevel;

    @TableField("Is_Send")
    private Boolean isSend;

    @TableField("Mac_Address")
    private String macAddress;

    @TableField("Operation_Content")
    private String operationContent;

    @TableField("Teminal_Name")
    private String teminalName;

    @TableField("Teminal_Security_Level")
    private String teminalSecurityLevel;

    @TableField("Threshold")
    private Integer threshold;

    @TableField("User_Security_Level")
    private String userSecurityLevel;

    @TableField("Uuid")
    private String uuid;

    private static final long serialVersionUID = 1L;
}