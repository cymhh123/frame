package com.chyou.common.persistence;

import java.util.List;

/**
 * EasyUI DataGrid模型
 *
 * @author memgshunying
 * @version 1.0
 * @time 2014年8月1日
 */
public class GridPager implements java.io.Serializable {

    private int total = 0;
    private List rows;
    private List footer;


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public List getFooter() {
        return footer;
    }

    public void setFooter(List footer) {
        this.footer = footer;
    }

}
