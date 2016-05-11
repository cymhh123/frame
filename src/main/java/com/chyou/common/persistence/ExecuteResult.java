package com.chyou.common.persistence;

/**
 * Created by zhangbowen on 2015/6/24.
 */
public class ExecuteResult<T> {
    private int code;
    private String msg;
    private T extra;
    /**
     * 分页查询起始位置
     */
    private Integer start;

    /**
     * 总记录数
     */
    private Integer total;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ExecuteResult(StatusCode code, T result) {
        this.code = code.getValue();
        this.extra = result;
        this.msg = code.GetDescription();
    }

    public ExecuteResult(StatusCode code, String des) {
        this.code = code.getValue();
        this.msg = des;
    }

    public ExecuteResult(T result) {
        this.extra = result;
    }

    public ExecuteResult() {
    }

    public ExecuteResult(StatusCode code) {
        this.code = code.getValue();
        this.msg = code.GetDescription();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getExtra() {
        return extra;
    }

    public void setExtra(T extra) {
        this.extra = extra;
    }
}
