package com.uts.entity;

import java.io.Serializable;
import java.util.Date;

public class MailSend implements Serializable {
    /** 投递主键  SEND_ID **/
    private String sendId;

    /** 投递人  SEND_USER_ID **/
    private String sendUserId;

    /** 投递邮箱  SEND_TO **/
    private String sendTo;

    /** 投递邮件  SEND_MAIL **/
    private String sendMail;

    /** 投递内容  SEND_CONTENT **/
    private String sendContent;

    /** 投递优先级  SEND_PRIORITY **/
    private Long sendPriority;

    /** 投递次数  SEND_COUNT **/
    private Long sendCount;

    /** 投递状态  SEND_STATUS **/
    private String sendStatus;

    /** 备注  REMARK **/
    private String remark;

    /** 版本号  VERSION **/
    private Long version;

    /** 更新人  UPDATE_BY **/
    private String updateBy;

    /** 更新时间  UPDATE_TIME **/
    private Date updateTime;

    /**   tableName: mail_send2   **/
    private static final long serialVersionUID = 1L;

    /**   投递主键  SEND_ID   **/
    public String getSendId() {
        return sendId;
    }

    /**   投递主键  SEND_ID   **/
    public void setSendId(String sendId) {
        this.sendId = sendId == null ? null : sendId.trim();
    }

    /**   投递人  SEND_USER_ID   **/
    public String getSendUserId() {
        return sendUserId;
    }

    /**   投递人  SEND_USER_ID   **/
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId == null ? null : sendUserId.trim();
    }

    /**   投递邮箱  SEND_TO   **/
    public String getSendTo() {
        return sendTo;
    }

    /**   投递邮箱  SEND_TO   **/
    public void setSendTo(String sendTo) {
        this.sendTo = sendTo == null ? null : sendTo.trim();
    }

    /**   投递邮件  SEND_MAIL   **/
    public String getSendMail() {
        return sendMail;
    }

    /**   投递邮件  SEND_MAIL   **/
    public void setSendMail(String sendMail) {
        this.sendMail = sendMail == null ? null : sendMail.trim();
    }

    /**   投递内容  SEND_CONTENT   **/
    public String getSendContent() {
        return sendContent;
    }

    /**   投递内容  SEND_CONTENT   **/
    public void setSendContent(String sendContent) {
        this.sendContent = sendContent == null ? null : sendContent.trim();
    }

    /**   投递优先级  SEND_PRIORITY   **/
    public Long getSendPriority() {
        return sendPriority;
    }

    /**   投递优先级  SEND_PRIORITY   **/
    public void setSendPriority(Long sendPriority) {
        this.sendPriority = sendPriority;
    }

    /**   投递次数  SEND_COUNT   **/
    public Long getSendCount() {
        return sendCount;
    }

    /**   投递次数  SEND_COUNT   **/
    public void setSendCount(Long sendCount) {
        this.sendCount = sendCount;
    }

    /**   投递状态  SEND_STATUS   **/
    public String getSendStatus() {
        return sendStatus;
    }

    /**   投递状态  SEND_STATUS   **/
    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }

    /**   备注  REMARK   **/
    public String getRemark() {
        return remark;
    }

    /**   备注  REMARK   **/
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**   版本号  VERSION   **/
    public Long getVersion() {
        return version;
    }

    /**   版本号  VERSION   **/
    public void setVersion(Long version) {
        this.version = version;
    }

    /**   更信任  UPDATE_BY   **/
    public String getUpdateBy() {
        return updateBy;
    }

    /**   更信任  UPDATE_BY   **/
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**   更新时间  UPDATE_TIME   **/
    public Date getUpdateTime() {
        return updateTime;
    }

    /**   更新时间  UPDATE_TIME   **/
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sendId=").append(sendId);
        sb.append(", sendUserId=").append(sendUserId);
        sb.append(", sendTo=").append(sendTo);
        sb.append(", sendMail=").append(sendMail);
        sb.append(", sendContent=").append(sendContent);
        sb.append(", sendPriority=").append(sendPriority);
        sb.append(", sendCount=").append(sendCount);
        sb.append(", sendStatus=").append(sendStatus);
        sb.append(", remark=").append(remark);
        sb.append(", version=").append(version);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}