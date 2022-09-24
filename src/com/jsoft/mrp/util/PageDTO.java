package com.jsoft.mrp.util;

import java.util.List;

public class PageDTO<T> {
    //      当前页码
    private Integer pageNum;
    //      每页记录数
    private Integer pageRecord;
    //      总记录数
    private Integer totalRecord;
    //      总页数
    private Integer totalPage;
    //      每页存储的内容
    private List<T> content;

    public PageDTO(){

    }
    public PageDTO(Integer pageRecord, Integer totalRecord){
        this.pageRecord = pageRecord;
        this.totalRecord = totalRecord;
        if(totalRecord%pageRecord == 0){
            this.totalPage = totalRecord/pageRecord;
            if (totalRecord == 0){
                this.totalPage = 1;
            }
        }else {
            this.totalPage = totalRecord/pageRecord+1;
        }
    }
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(Integer pageRecord) {
        this.pageRecord = pageRecord;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

}
