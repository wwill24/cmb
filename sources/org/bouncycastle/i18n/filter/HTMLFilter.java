package org.bouncycastle.i18n.filter;

public class HTMLFilter implements Filter {
    public String doFilter(String str) {
        String str2;
        int i10;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i11 = 0;
        while (i11 < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i11);
            if (charAt == '\"') {
                i10 = i11 + 1;
                str2 = "&#34";
            } else if (charAt == '#') {
                i10 = i11 + 1;
                str2 = "&#35";
            } else if (charAt == '+') {
                i10 = i11 + 1;
                str2 = "&#43";
            } else if (charAt == '-') {
                i10 = i11 + 1;
                str2 = "&#45";
            } else if (charAt == '>') {
                i10 = i11 + 1;
                str2 = "&#62";
            } else if (charAt == ';') {
                i10 = i11 + 1;
                str2 = "&#59";
            } else if (charAt != '<') {
                switch (charAt) {
                    case '%':
                        i10 = i11 + 1;
                        str2 = "&#37";
                        break;
                    case '&':
                        i10 = i11 + 1;
                        str2 = "&#38";
                        break;
                    case '\'':
                        i10 = i11 + 1;
                        str2 = "&#39";
                        break;
                    case '(':
                        i10 = i11 + 1;
                        str2 = "&#40";
                        break;
                    case ')':
                        i10 = i11 + 1;
                        str2 = "&#41";
                        break;
                    default:
                        i11 -= 3;
                        continue;
                }
            } else {
                i10 = i11 + 1;
                str2 = "&#60";
            }
            stringBuffer.replace(i11, i10, str2);
            i11 += 4;
        }
        return stringBuffer.toString();
    }

    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
