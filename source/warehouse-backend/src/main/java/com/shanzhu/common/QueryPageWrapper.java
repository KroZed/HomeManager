package com.shanzhu.common;

import java.util.HashMap;

/**
 * 分页参数包装
 *
 * @author: ShanZhu
 * @date: 2024-01-08
 */
public class QueryPageWrapper {

    private int pageSize = 20;
    private int pageNum = 1;

    private HashMap param = new HashMap();

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public HashMap getParam() {
        return param;
    }

    public void setParam(HashMap param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "QueryPageParam{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", param=" + param +
                '}';
    }
}
