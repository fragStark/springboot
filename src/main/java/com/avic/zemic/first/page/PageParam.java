package com.avic.zemic.first.page;

public class PageParam {
    private Integer beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;

    public Integer getBeginLine() {
        return currentPage * pageSize;
    }

    public void setBeginLine(Integer beginLine) {
        this.beginLine = beginLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
