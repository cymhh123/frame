package com.chyou.modules.dict.dao;

import java.util.List;

import com.chyou.common.persistence.CrudDao;
import com.chyou.common.persistence.annotation.MyBatisDao;
import com.chyou.modules.dict.entity.SysDictBean;

/**
* Created by zhangbowen on 2015-8-11.
*/
@MyBatisDao
public interface ISysDictDao extends CrudDao<SysDictBean>{
	int queryTotal(SysDictBean param0);
	List<SysDictBean> queryList(SysDictBean param0);
}
