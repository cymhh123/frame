package com.chyou.modules.dict.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chyou.modules.dict.dao.ISysDictDao;
import com.chyou.modules.dict.entity.SysDictBean;
import com.chyou.modules.sys.utils.DictUtils;


/**
* Created by zhangbowen on 2015-8-11.
*/
@Service
@Transactional
public class SysDictService{
    @Autowired
    private ISysDictDao sysDictDao;

    public SysDictBean get(String param0){
        return sysDictDao.get( param0);
    }
    public void delete(String param0){
        sysDictDao.delete( param0);
    }
    public void insert(SysDictBean param0){
        param0.preInsert();
        sysDictDao.insert(param0);
    }
    public void update(SysDictBean param0){
        param0.preUpdate();
        sysDictDao.update(param0);
    }
    public int queryTotal(SysDictBean param0){
        return sysDictDao.queryTotal( param0);
    }
    public List<SysDictBean> queryList(SysDictBean param0){
        return sysDictDao.queryList( param0);
    }
}
