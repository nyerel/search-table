package eu.nyerel.searchtable.api.model;

import eu.nyerel.searchtable.api.model.filter.expression.Expression;

/**
 * @author Rastislav Papp (rastislav.papp@gmail.com)
 */
public class SearchRequest {

    private Sort sort;
    private Expression filter;
    private int page = 1;
    private int itemsPerPage = -1;

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Expression getFilter() {
        return filter;
    }

    public void setFilter(Expression filter) {
        this.filter = filter;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

}
