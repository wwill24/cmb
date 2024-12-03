package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option implements Cloneable, Serializable {
    public static final int UNINITIALIZED = -1;
    public static final int UNLIMITED_VALUES = -2;
    private static final long serialVersionUID = 1;
    private String argName;
    private String description;
    private String longOpt;
    private int numberOfArgs;
    private String opt;
    private boolean optionalArg;
    private boolean required;
    private Object type;
    private List values;
    private char valuesep;

    public Option(String str, String str2) throws IllegalArgumentException {
        this(str, (String) null, false, str2);
    }

    private void add(String str) {
        if (this.numberOfArgs <= 0 || this.values.size() <= this.numberOfArgs - 1) {
            this.values.add(str);
            return;
        }
        throw new RuntimeException("Cannot add value, list full.");
    }

    private boolean hasNoValues() {
        return this.values.isEmpty();
    }

    private void processValue(String str) {
        if (hasValueSeparator()) {
            char valueSeparator = getValueSeparator();
            int indexOf = str.indexOf(valueSeparator);
            while (indexOf != -1 && this.values.size() != this.numberOfArgs - 1) {
                add(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
                indexOf = str.indexOf(valueSeparator);
            }
        }
        add(str);
    }

    public boolean addValue(String str) {
        throw new UnsupportedOperationException("The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
    }

    /* access modifiers changed from: package-private */
    public void addValueForProcessing(String str) {
        if (this.numberOfArgs != -1) {
            processValue(str);
            return;
        }
        throw new RuntimeException("NO_ARGS_ALLOWED");
    }

    /* access modifiers changed from: package-private */
    public void clearValues() {
        this.values.clear();
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.values = new ArrayList(this.values);
            return option;
        } catch (CloneNotSupportedException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e10.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Option option = (Option) obj;
        String str = this.opt;
        if (str == null ? option.opt != null : !str.equals(option.opt)) {
            return false;
        }
        String str2 = this.longOpt;
        String str3 = option.longOpt;
        if (str2 == null ? str3 == null : str2.equals(str3)) {
            return true;
        }
        return false;
    }

    public String getArgName() {
        return this.argName;
    }

    public int getArgs() {
        return this.numberOfArgs;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId() {
        return getKey().charAt(0);
    }

    /* access modifiers changed from: package-private */
    public String getKey() {
        String str = this.opt;
        if (str == null) {
            return this.longOpt;
        }
        return str;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public String getOpt() {
        return this.opt;
    }

    public Object getType() {
        return this.type;
    }

    public String getValue() {
        if (hasNoValues()) {
            return null;
        }
        return (String) this.values.get(0);
    }

    public char getValueSeparator() {
        return this.valuesep;
    }

    public String[] getValues() {
        if (hasNoValues()) {
            return null;
        }
        List list = this.values;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public List getValuesList() {
        return this.values;
    }

    public boolean hasArg() {
        int i10 = this.numberOfArgs;
        return i10 > 0 || i10 == -2;
    }

    public boolean hasArgName() {
        String str = this.argName;
        return str != null && str.length() > 0;
    }

    public boolean hasArgs() {
        int i10 = this.numberOfArgs;
        return i10 > 1 || i10 == -2;
    }

    public boolean hasLongOpt() {
        return this.longOpt != null;
    }

    public boolean hasOptionalArg() {
        return this.optionalArg;
    }

    public boolean hasValueSeparator() {
        return this.valuesep > 0;
    }

    public int hashCode() {
        int i10;
        String str = this.opt;
        int i11 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i12 = i10 * 31;
        String str2 = this.longOpt;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setArgName(String str) {
        this.argName = str;
    }

    public void setArgs(int i10) {
        this.numberOfArgs = i10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLongOpt(String str) {
        this.longOpt = str;
    }

    public void setOptionalArg(boolean z10) {
        this.optionalArg = z10;
    }

    public void setRequired(boolean z10) {
        this.required = z10;
    }

    public void setType(Object obj) {
        this.type = obj;
    }

    public void setValueSeparator(char c10) {
        this.valuesep = c10;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ option: ");
        stringBuffer.append(this.opt);
        if (this.longOpt != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.longOpt);
        }
        stringBuffer.append(" ");
        if (hasArgs()) {
            stringBuffer.append("[ARG...]");
        } else if (hasArg()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.description);
        if (this.type != null) {
            stringBuffer.append(" :: ");
            stringBuffer.append(this.type);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public Option(String str, boolean z10, String str2) throws IllegalArgumentException {
        this(str, (String) null, z10, str2);
    }

    public String getValue(int i10) throws IndexOutOfBoundsException {
        if (hasNoValues()) {
            return null;
        }
        return (String) this.values.get(i10);
    }

    public Option(String str, String str2, boolean z10, String str3) throws IllegalArgumentException {
        this.argName = "arg";
        this.numberOfArgs = -1;
        this.values = new ArrayList();
        OptionValidator.validateOption(str);
        this.opt = str;
        this.longOpt = str2;
        if (z10) {
            this.numberOfArgs = 1;
        }
        this.description = str3;
    }

    public String getValue(String str) {
        String value = getValue();
        return value != null ? value : str;
    }
}
