package org.apache.commons.cli;

import com.facebook.internal.ServerProtocol;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class CommandLine implements Serializable {
    private static final long serialVersionUID = 1;
    private List args = new LinkedList();
    private List options = new ArrayList();

    CommandLine() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.cli.Option resolveOption(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = org.apache.commons.cli.Util.stripLeadingHyphens(r4)
            java.util.List r0 = r3.options
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r0.next()
            org.apache.commons.cli.Option r1 = (org.apache.commons.cli.Option) r1
            java.lang.String r2 = r1.getOpt()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0021
            return r1
        L_0x0021:
            java.lang.String r2 = r1.getLongOpt()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x000a
            return r1
        L_0x002c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.CommandLine.resolveOption(java.lang.String):org.apache.commons.cli.Option");
    }

    /* access modifiers changed from: package-private */
    public void addArg(String str) {
        this.args.add(str);
    }

    /* access modifiers changed from: package-private */
    public void addOption(Option option) {
        this.options.add(option);
    }

    public List getArgList() {
        return this.args;
    }

    public String[] getArgs() {
        String[] strArr = new String[this.args.size()];
        this.args.toArray(strArr);
        return strArr;
    }

    public Object getOptionObject(String str) {
        try {
            return getParsedOptionValue(str);
        } catch (ParseException e10) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception found converting ");
            stringBuffer.append(str);
            stringBuffer.append(" to desired type: ");
            stringBuffer.append(e10.getMessage());
            printStream.println(stringBuffer.toString());
            return null;
        }
    }

    public Properties getOptionProperties(String str) {
        Properties properties = new Properties();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                List valuesList = option.getValuesList();
                if (valuesList.size() >= 2) {
                    properties.put(valuesList.get(0), valuesList.get(1));
                } else if (valuesList.size() == 1) {
                    properties.put(valuesList.get(0), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
            }
        }
        return properties;
    }

    public String getOptionValue(String str) {
        String[] optionValues = getOptionValues(str);
        if (optionValues == null) {
            return null;
        }
        return optionValues[0];
    }

    public String[] getOptionValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Option option : this.options) {
            if (str.equals(option.getOpt()) || str.equals(option.getLongOpt())) {
                arrayList.addAll(option.getValuesList());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Option[] getOptions() {
        List list = this.options;
        return (Option[]) list.toArray(new Option[list.size()]);
    }

    public Object getParsedOptionValue(String str) throws ParseException {
        String optionValue = getOptionValue(str);
        Option resolveOption = resolveOption(str);
        if (resolveOption == null) {
            return null;
        }
        Object type = resolveOption.getType();
        if (optionValue == null) {
            return null;
        }
        return TypeHandler.createValue(optionValue, type);
    }

    public boolean hasOption(String str) {
        return this.options.contains(resolveOption(str));
    }

    public Iterator iterator() {
        return this.options.iterator();
    }

    public boolean hasOption(char c10) {
        return hasOption(String.valueOf(c10));
    }

    public Object getOptionObject(char c10) {
        return getOptionObject(String.valueOf(c10));
    }

    public String getOptionValue(char c10) {
        return getOptionValue(String.valueOf(c10));
    }

    public String getOptionValue(String str, String str2) {
        String optionValue = getOptionValue(str);
        return optionValue != null ? optionValue : str2;
    }

    public String getOptionValue(char c10, String str) {
        return getOptionValue(String.valueOf(c10), str);
    }

    public String[] getOptionValues(char c10) {
        return getOptionValues(String.valueOf(c10));
    }
}
