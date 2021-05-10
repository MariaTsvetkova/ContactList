package com.contactlist.contacts.paging;


public class PageItem {

    private PageItemType pageItemType;

    private int index;

    private boolean active;

    private PageItem() {
    }

    public PageItem(PageItemType pageItemType, int index, boolean active) {
        this.pageItemType = pageItemType;
        this.index = index;
        this.active = active;
    }

    public PageItemType getPageItemType() {
        return pageItemType;
    }

    public int getIndex() {
        return index;
    }

    public boolean isActive() {
        return active;
    }

    public void setPageItemType(PageItemType pageItemType) {
        this.pageItemType = pageItemType;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static Builder builder() {
        return new PageItem().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder pageItemType(PageItemType pageItemType) {
            PageItem.this.pageItemType = pageItemType;

            return this;
        }

        public Builder active(boolean active) {
            PageItem.this.active = active;

            return this;
        }

        public Builder index(int index) {
            PageItem.this.index = index;

            return this;
        }

        public PageItem build() {
            return PageItem.this;
        }
    }
}
