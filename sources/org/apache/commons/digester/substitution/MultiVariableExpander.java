package org.apache.commons.digester.substitution;

import java.util.ArrayList;
import java.util.Map;

public class MultiVariableExpander implements VariableExpander {
    private ArrayList markers = new ArrayList(2);
    private int nEntries = 0;
    private ArrayList sources = new ArrayList(2);

    public void addSource(String str, Map map) {
        this.nEntries++;
        this.markers.add(str);
        this.sources.add(map);
    }

    public String expand(String str) {
        for (int i10 = 0; i10 < this.nEntries; i10++) {
            str = expand(str, (String) this.markers.get(i10), (Map) this.sources.get(i10));
        }
        return str;
    }

    public String expand(String str, String str2, Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        stringBuffer.append("{");
        String stringBuffer2 = stringBuffer.toString();
        int length = stringBuffer2.length();
        int i10 = 0;
        while (true) {
            int indexOf = str.indexOf(stringBuffer2, i10);
            if (indexOf == -1) {
                return str;
            }
            int i11 = indexOf + length;
            if (i11 <= str.length()) {
                int indexOf2 = str.indexOf("}", i11);
                if (indexOf2 != -1) {
                    String substring = str.substring(i11, indexOf2);
                    Object obj = map.get(substring);
                    if (obj != null) {
                        String obj2 = obj.toString();
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append(str.substring(0, indexOf));
                        stringBuffer3.append(obj2);
                        stringBuffer3.append(str.substring(indexOf2 + 1));
                        str = stringBuffer3.toString();
                        i10 = indexOf + obj2.length();
                    } else {
                        StringBuffer stringBuffer4 = new StringBuffer();
                        stringBuffer4.append("parameter [");
                        stringBuffer4.append(substring);
                        stringBuffer4.append("] is not defined.");
                        throw new IllegalArgumentException(stringBuffer4.toString());
                    }
                } else {
                    throw new IllegalArgumentException("var expression starts but does not end");
                }
            } else {
                throw new IllegalArgumentException("var expression starts at end of string");
            }
        }
    }
}
