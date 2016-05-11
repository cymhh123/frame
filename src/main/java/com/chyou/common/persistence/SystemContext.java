package com.chyou.common.persistence;



public class SystemContext {
    
    private static ThreadLocal<Integer> _offset = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> _pagesize = new ThreadLocal<Integer>();
    private static ThreadLocal<String> _searchValue = new ThreadLocal<String>();

    public static final int DEFAULT_PAGE_SIZE=10;
     
    public static void setOffset(Integer offset) {
        _offset.set(offset);
    }
     
    public static void removeOffset() {
        _offset.remove();
    }
     
    public static Integer getOffset() {
        Integer offset  =  _offset.get();
        if (offset  == null || offset < 0) {
            return 0;
        }
        return offset;
    }
     
    public static void setPageSize(Integer pagesize) {
        _pagesize.set(pagesize);
    }
     
    public static void removePageSize() {
        _pagesize.remove();
    }
     
    public static Integer getPageSize() {
        Integer pagesize  =  _pagesize.get();
        if (pagesize  == null || pagesize < 0) {
            return DEFAULT_PAGE_SIZE;
        }
        return pagesize;
    }
    public static void removeSearchValue(){
        _searchValue.remove();
    }
    public static void setSearchValue(String searchValue){
        _searchValue.set(searchValue);
    }
    public static String getSearchValue() {
        return _searchValue.get();
    }
}