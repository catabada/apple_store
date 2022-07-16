package vn.edu.hcmuaf.fit.constant;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable {
    public static final int DEFAULT_PAGE_SIZE = 4;
    private List<T> dataList;
    private int page;
    private int totalPage;

    public Pagination() {
    }

    public Pagination(List<T> dataList, int page, int totalPage) {
        this.dataList = dataList;
        this.page = page;
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
