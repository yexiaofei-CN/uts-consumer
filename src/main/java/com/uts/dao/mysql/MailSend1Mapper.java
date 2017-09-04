package com.uts.dao.mysql;

import com.uts.entity.MailSend;

import java.util.List;

public interface MailSend1Mapper {
    int deleteByPrimaryKey(String sendId);

    int insert(MailSend record);

    int insertSelective(MailSend record);

    MailSend selectByPrimaryKey(String sendId);

    int updateByPrimaryKeySelective(MailSend record);

    int updateByPrimaryKey(MailSend record);

    List<MailSend> queryDraftlList();
}