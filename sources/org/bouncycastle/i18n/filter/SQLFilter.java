package org.bouncycastle.i18n.filter;

public class SQLFilter implements Filter {
    public String doFilter(String str) {
        String str2;
        int i10;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i11 = 0;
        while (i11 < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i11);
            if (charAt == 10) {
                i10 = i11 + 1;
                str2 = "\\n";
            } else if (charAt == 13) {
                i10 = i11 + 1;
                str2 = "\\r";
            } else if (charAt == '\"') {
                i10 = i11 + 1;
                str2 = "\\\"";
            } else if (charAt == '\'') {
                i10 = i11 + 1;
                str2 = "\\'";
            } else if (charAt == '-') {
                i10 = i11 + 1;
                str2 = "\\-";
            } else if (charAt == '/') {
                i10 = i11 + 1;
                str2 = "\\/";
            } else if (charAt == ';') {
                i10 = i11 + 1;
                str2 = "\\;";
            } else if (charAt == '=') {
                i10 = i11 + 1;
                str2 = "\\=";
            } else if (charAt != '\\') {
                i11++;
            } else {
                i10 = i11 + 1;
                str2 = "\\\\";
            }
            stringBuffer.replace(i11, i10, str2);
            i11 = i10;
            i11++;
        }
        return stringBuffer.toString();
    }

    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
