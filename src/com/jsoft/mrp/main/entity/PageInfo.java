package com.jsoft.mrp.main.entity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class PageInfo {
    private List list;
    private Integer currentPage;
    private Long recordCount;
    private Integer recordSize = 5;   // 默认每页5条记录
    private Integer pageCount;
    private String url;
    private String method;



    public PageInfo(HttpServletRequest request) {
        // 当前页
        String currentPage = request.getParameter("currentPage");
        if(currentPage != null) {
            this.currentPage = Integer.valueOf( currentPage);
        }
        // url
       url = request.getRequestURL().toString();
        

        // method
        String method = request.getParameter("method");
        if(method != null) {
            this.method = method;
        }

        request.setAttribute("pageInfo",this);
    }


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordSize() {
        return recordSize;
    }

    public void setRecordSize(int recordSize) {
        this.recordSize = recordSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public void setRecordSize(Integer recordSize) {
        this.recordSize = recordSize;
    }

    // 获取页数
    public int getPageCount() {
        return (int) (recordCount % recordSize == 0 ? recordCount/recordSize : recordCount/recordSize + 1);
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "list=" + list +
                ", currentPage=" + currentPage +
                ", recordCount=" + recordCount +
                ", recordSize=" + recordSize +
                ", pageCount=" + pageCount +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}

