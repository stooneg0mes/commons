package net.stonegomes.commons.storage.query;

public class QueryBuilder {

    private String queryContent;
    private Object[] values;

    public QueryBuilder queryContent(String queryContent) {
        this.queryContent = queryContent;
        return this;
    }

    public QueryBuilder values(Object... values) {
        this.values = values;
        return this;
    }

    public Query build() {
        return new Query(queryContent, values);
    }

}
