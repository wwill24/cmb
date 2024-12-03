package org.apache.commons.digester;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SimpleRegexMatcher extends RegexMatcher {
    private static final Log baseLog;
    static /* synthetic */ Class class$org$apache$commons$digester$SimpleRegexMatcher;
    private Log log = baseLog;

    static {
        Class cls = class$org$apache$commons$digester$SimpleRegexMatcher;
        if (cls == null) {
            cls = class$("org.apache.commons.digester.SimpleRegexMatcher");
            class$org$apache$commons$digester$SimpleRegexMatcher = cls;
        }
        baseLog = LogFactory.getLog(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError(e10.getMessage());
        }
    }

    public Log getLog() {
        return this.log;
    }

    public boolean match(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return match(str, str2, 0, 0);
    }

    public void setLog(Log log2) {
        this.log = log2;
    }

    private boolean match(String str, String str2, int i10, int i11) {
        if (this.log.isTraceEnabled()) {
            Log log2 = this.log;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Base: ");
            stringBuffer.append(str);
            log2.trace(stringBuffer.toString());
            Log log3 = this.log;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Regex: ");
            stringBuffer2.append(str2);
            log3.trace(stringBuffer2.toString());
            Log log4 = this.log;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Base@");
            stringBuffer3.append(i10);
            log4.trace(stringBuffer3.toString());
            Log log5 = this.log;
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Regex@");
            stringBuffer4.append(i11);
            log5.trace(stringBuffer4.toString());
        }
        if (i11 >= str2.length()) {
            return i10 >= str.length();
        }
        if (i10 >= str.length()) {
            return false;
        }
        char charAt = str2.charAt(i11);
        if (charAt == '*') {
            int i12 = i11 + 1;
            if (i12 >= str2.length()) {
                return true;
            }
            char charAt2 = str2.charAt(i12);
            if (this.log.isTraceEnabled()) {
                Log log6 = this.log;
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Searching for next '");
                stringBuffer5.append(charAt2);
                stringBuffer5.append("' char");
                log6.trace(stringBuffer5.toString());
            }
            int indexOf = str.indexOf(charAt2, i10);
            while (indexOf != -1) {
                if (this.log.isTraceEnabled()) {
                    Log log7 = this.log;
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Trying '*' match@");
                    stringBuffer6.append(indexOf);
                    log7.trace(stringBuffer6.toString());
                }
                if (match(str, str2, indexOf, i12)) {
                    return true;
                }
                indexOf = str.indexOf(charAt2, indexOf + 1);
            }
            this.log.trace("No matches found.");
            return false;
        } else if (charAt == '?') {
            return match(str, str2, i10 + 1, i11 + 1);
        } else {
            if (this.log.isTraceEnabled()) {
                Log log8 = this.log;
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append("Camparing ");
                stringBuffer7.append(charAt);
                stringBuffer7.append(" to ");
                stringBuffer7.append(str.charAt(i10));
                log8.trace(stringBuffer7.toString());
            }
            if (charAt == str.charAt(i10)) {
                return match(str, str2, i10 + 1, i11 + 1);
            }
            return false;
        }
    }
}
