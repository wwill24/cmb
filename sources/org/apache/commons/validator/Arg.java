package org.apache.commons.validator;

import java.io.Serializable;

public class Arg implements Cloneable, Serializable {
    private static final long serialVersionUID = -8922606779669839294L;
    protected String bundle = null;
    protected String key = null;
    protected String name = null;
    protected int position = -1;
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

    public int getPosition() {
        return this.position;
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

    public void setPosition(int i10) {
        this.position = i10;
    }

    public void setResource(boolean z10) {
        this.resource = z10;
    }

    public String toString() {
        return "Arg: name=" + this.name + "  key=" + this.key + "  position=" + this.position + "  bundle=" + this.bundle + "  resource=" + this.resource + "\n";
    }
}
