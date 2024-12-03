package org.apache.commons.digester.substitution;

import java.util.ArrayList;
import org.xml.sax.Attributes;

public class VariableAttributes implements Attributes {
    private Attributes attrs;
    private VariableExpander expander;
    private ArrayList values = new ArrayList(10);

    public int getIndex(String str) {
        return this.attrs.getIndex(str);
    }

    public int getLength() {
        return this.attrs.getLength();
    }

    public String getLocalName(int i10) {
        return this.attrs.getLocalName(i10);
    }

    public String getQName(int i10) {
        return this.attrs.getQName(i10);
    }

    public String getType(int i10) {
        return this.attrs.getType(i10);
    }

    public String getURI(int i10) {
        return this.attrs.getURI(i10);
    }

    public String getValue(int i10) {
        if (i10 >= this.values.size()) {
            this.values.ensureCapacity(i10 + 1);
            for (int size = this.values.size(); size <= i10; size++) {
                this.values.add((Object) null);
            }
        }
        String str = (String) this.values.get(i10);
        if (str != null) {
            return str;
        }
        String value = this.attrs.getValue(i10);
        if (value == null) {
            return value;
        }
        String expand = this.expander.expand(value);
        this.values.set(i10, expand);
        return expand;
    }

    public void init(Attributes attributes, VariableExpander variableExpander) {
        this.attrs = attributes;
        this.expander = variableExpander;
        this.values.clear();
    }

    public int getIndex(String str, String str2) {
        return this.attrs.getIndex(str, str2);
    }

    public String getType(String str) {
        return this.attrs.getType(str);
    }

    public String getType(String str, String str2) {
        return this.attrs.getType(str, str2);
    }

    public String getValue(String str) {
        int index = this.attrs.getIndex(str);
        if (index == -1) {
            return null;
        }
        return getValue(index);
    }

    public String getValue(String str, String str2) {
        int index = this.attrs.getIndex(str, str2);
        if (index == -1) {
            return null;
        }
        return getValue(index);
    }
}
