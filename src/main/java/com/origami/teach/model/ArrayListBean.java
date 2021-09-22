package com.origami.teach.model;

import java.util.ArrayList;
import java.util.List;

public class  ArrayListBean {

    private List<Object> list = new ArrayList<Object>();

    public void setList(Object object) {
        list.add(object);
    }

    public List<Object> getList() {
        return list;
    }
}
