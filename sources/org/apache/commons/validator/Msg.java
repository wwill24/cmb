package org.apache.commons.validator;

import java.io.Serializable;

public class Msg implements Cloneable, Serializable {
    private static final long serialVersionUID = 5690015734364127124L;
    protected String bundle = null;
    protected String key = null;
    protected String name = null;
    protected boolean resource = true;

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

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public boolean isResource() {
        return this.resource;
    }

    public void setBundle(String str) {
        this.bundle = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setResource(boolean z10) {
        this.resource = z10;
    }

    public String toString() {
        return "Msg: name=" + this.name + "  key=" + this.key + "  resource=" + this.resource + "  bundle=" + this.bundle + "\n";
    }
}
