package com.coffeemeetsbagel.models;

import java.util.Map;

public class Tag {
    private Map<?, ?> attrs;

    /* renamed from: id  reason: collision with root package name */
    private int f34713id;
    private String text;

    public Tag(int i10, String str) {
        this.f34713id = i10;
        this.text = str;
    }

    public Map<?, ?> getAttrs() {
        return this.attrs;
    }

    public int getId() {
        return this.f34713id;
    }

    public String getText() {
        return this.text;
    }

    public void setAttrs(Map<?, ?> map) {
        this.attrs = map;
    }

    public void setId(int i10) {
        this.f34713id = i10;
    }

    public void setText(String str) {
        this.text = str;
    }
}
