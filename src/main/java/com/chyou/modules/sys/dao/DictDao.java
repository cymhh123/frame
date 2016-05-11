package com.chyou.modules.sys.dao;


import java.util.List;

import com.chyou.common.persistence.CrudDao;
import com.chyou.common.persistence.annotation.MyBatisDao;
import com.chyou.modules.sys.entity.Dict;

/**
 * 字典DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {
	
	/**
	 * 
	 * @param dict
	 * @return
	 */
	public List<String> findTypeList(Dict dict);
	
	public List<Dict> findList(Dict dict);
	
}
