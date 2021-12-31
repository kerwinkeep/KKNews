package com.kerwinkeep.kknews;

public class NewsRequest {

    private int num;
    private int page = -1;
    private int rand;
    private String keyword;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        String retValue;
        retValue = "?" + "key=" + Constants.API_KEY + "&num=" + num;
        if (page != -1) {
            retValue += "&page=" + page;
        }
        return retValue;
    }
}
