/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.chyou.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chyou.common.utils.CacheUtils;
import com.chyou.modules.sys.dao.DictDao;
import com.chyou.modules.sys.entity.Dict;
import com.chyou.modules.sys.utils.DictUtils;

/**
 * 字典Service
 * @author chengyou
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class DictService {
	/**
	 * 持久层对象
	 */
	@Autowired
	protected DictDao dictDao;
	
	/**
	 * 查询字段类型列表
	 * @return
	 */
	public List<String> findTypeList(){
		return dictDao.findTypeList(new Dict());
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		//dict.preInsert();
		this.dictDao.insert(dict);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}

	@Transactional(readOnly = false)
	public void delete(String id) {
		this.dictDao.delete(id);
		CacheUtils.remove(DictUtils.CACHE_DICT_MAP);
	}
	
	public Dict get(String id){
		return this.dictDao.get(id);
	}

}
