package org.apache.commons.validator;

import java.io.Serializable;

public class Var implements Cloneable, Serializable {
    public static final String JSTYPE_INT = "int";
    public static final String JSTYPE_REGEXP = "regexp";
    public static final String JSTYPE_STRING = "string";
    private static final long serialVersionUID = -684185211548420224L;
    private String bundle;
    private String jsType;
    private String name;
    private boolean resource;
    private String value;

    public Var() {
        this.name = null;
        this.value = null;
        this.jsType = null;
        this.resource = false;
        this.bundle = null;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10.toString());
        }
    }

    public String getBundle() {
        return this.bundle;
    }

    public String getJsType() {
        return this.jsType;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isResource() {
        return this.resource;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public void setJsType(String str) {
        this.jsType = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setResource(boolean z10) {
        this.resource = z10;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Var: name=");
        sb2.append(this.name);
        sb2.append("  value=");
        sb2.append(this.value);
        sb2.append("  resource=");
        sb2.append(this.resource);
        if (this.resource) {
            sb2.append("  bundle=");
            sb2.append(this.bundle);
        }
        sb2.append("  jsType=");
        sb2.append(this.jsType);
        sb2.append("\n");
        return sb2.toString();
    }

    public Var(String str, String str2, String str3) {
        this.resource = false;
        this.bundle = null;
        this.name = str;
        this.value = str2;
        this.jsType = str3;
    }
}
