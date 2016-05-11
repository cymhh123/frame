package com.chyou.common.persistence;


import java.util.Date;

import com.chyou.common.utils.IdGen;
import com.chyou.modules.sys.utils.DictUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 数据实体bean
 * @author chengyou
 * @since 2015.6.3
 */
@JsonIgnoreProperties(value = {"rows","sortBy","ver","sblx","delFlag","start"})
public class DataEntity {
	private String id;
	
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	
	//更新时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;

	//删除标识(0:未删除1：删除)
	private String delFlag="0";

	//设备类型
	private String sblx;

	//版本号
	private String ver;

	//分页开始
	private Integer start;

	//分页数量
	private Integer rows;

	//自定义排序(默认)
	private String sortBy="createDate";

	public DataEntity(){
		this.rows = Integer.valueOf(DictUtils.getDictValue("page_rows", "page", "10"));
	}

	public DataEntity(String id){
		this.id = id;
		this.rows = Integer.valueOf(DictUtils.getDictValue("page_rows", "page", "10"));
	}
	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSblx() {
		return sblx;
	}

	public void setSblx(String sblx) {
		this.sblx = sblx;
	}


	public String getVer() {
		return ver;
	}


	public void setVer(String ver) {
		this.ver = ver;
	}
	
	
	/**
	 * 插入之前执行方法，需要手动调用
	 */
	public void preInsert(){
		this.setId(IdGen.uuid());
		this.updateDate = new Date();
		this.createDate = this.updateDate;
	}
	
	/**
	 * 更新之前执行方法，需要手动调用
	 */
	public void preUpdate(){
		this.updateDate = new Date();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
}
