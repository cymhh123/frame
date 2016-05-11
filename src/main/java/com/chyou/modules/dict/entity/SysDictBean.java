package com.chyou.modules.dict.entity;

import com.chyou.common.persistence.DataEntity;

/**
* Created by zhangbowen on 2015-8-11.
*/
public class SysDictBean extends DataEntity {
    //数据值
    private String value;
    //标签名
    private String label;
    //类型
    private String type;
    //描述
    private String description;
    //排序（升序)
    private int sort;
    //父级编号
    private String parentId;

	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
	public void setLabel(String label){
		this.label=label;
	}
	public String getLabel(){
		return this.label;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return this.type;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setSort(int sort){
		this.sort=sort;
	}
	public int getSort(){
		return this.sort;
	}
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	public String getParentId(){
		return this.parentId;
	}

}
