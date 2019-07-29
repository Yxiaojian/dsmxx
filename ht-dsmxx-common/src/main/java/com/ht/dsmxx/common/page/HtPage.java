package com.ht.dsmxx.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HtPage<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private long pageSize = 10L;
    private long pageIndex = 1L;
    private List<T> records;
    private long total;

    public HtPage() {
    }

    public HtPage(long pageIndex, long pageSize) {
        this.pageSize = pageSize > 100L ? 100L : pageSize;
        this.pageIndex = pageIndex;
    }

    public HtPage(long pageIndex, long pageSize, List<T> records, long total) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.records = records;
        this.total = total;
    }

    public HtPage(IPage<T> iPage) {
        this.pageIndex = iPage.getCurrent();
        this.pageSize = iPage.getSize();
        this.records = iPage.getRecords();
        this.total = iPage.getTotal();
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public long getPageIndex() {
        return this.pageIndex;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public long getTotal() {
        return this.total;
    }

    public void setPageSize(final long pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageIndex(final long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setRecords(final List<T> records) {
        this.records = records;
    }

    public void setTotal(final long total) {
        this.total = total;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HtPage)) {
            return false;
        } else {
            HtPage<?> other = (HtPage)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageSize() != other.getPageSize()) {
                return false;
            } else if (this.getPageIndex() != other.getPageIndex()) {
                return false;
            } else {
                Object this$records = this.getRecords();
                Object other$records = other.getRecords();
                if (this$records == null) {
                    if (other$records == null) {
                        return this.getTotal() == other.getTotal();
                    }
                } else if (this$records.equals(other$records)) {
                    return this.getTotal() == other.getTotal();
                }

                return false;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HtPage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageSize, pageIndex, records, total);
    }

    @Override
    public String toString() {
        return "HtPage{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", records=" + records +
                ", total=" + total +
                '}';
    }
}
