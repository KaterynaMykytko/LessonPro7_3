package com.itvdn.javaProfessional.ex_004_JSON.JSON;

public class Query {
    public int count;
    public String created;
    public String lang;
//    public Results results;

    public Query(int count, String created, String lang) {
        this.count = count;
        this.created = created;
        this.lang = lang;
    }

/*    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }*/

    @Override
    public String toString() {
        return "Query{" +
                "count=" + count +
                ", created='" + created + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
