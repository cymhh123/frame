package com.chyou.common.persistence;


import java.util.List;

public class PageModel<T> {
    
    private List<T> list;
     
    private int totalCount; // 总记录数
    private int listSize;   // 当前分页数据条数
    private int pageCount;  // 页数
    private String searchValue;
 
    public PageModel() {
        super();
    }

    public PageModel(List<T> list, int totalCount) {
        super();
        this.setList(list);
        this.totalCount = totalCount;
        this.searchValue = SystemContext.getSearchValue();
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<T> getList() {
        return list;
    }
 
    public void setList(List<T> list) {
        this.list = list;
        this.listSize = list.size();
    }
 
    public int getTotalCount() {
        return totalCount;
    }
 
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
 
    public int getListSize() {
        return listSize;
    }
 
    public int getPageCount() {
        if(totalCount > 0){
            int pageSize = SystemContext.getPageSize();
            pageCount = (totalCount-1)/(pageSize)+1;
        }
        return pageCount;
    }
 
}
