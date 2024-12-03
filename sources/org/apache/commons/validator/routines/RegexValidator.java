package org.apache.commons.validator.routines;

import com.mparticle.kits.AppsFlyerKit;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator implements Serializable {
    private static final long serialVersionUID = -8832409930574867162L;
    private final Pattern[] patterns;

    public RegexValidator(String str) {
        this(str, true);
    }

    public boolean isValid(String str) {
        if (str == null) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i10 >= patternArr.length) {
                return false;
            }
            if (patternArr[i10].matcher(str).matches()) {
                return true;
            }
            i10++;
        }
    }

    public String[] match(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i11 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i11].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                String[] strArr = new String[groupCount];
                while (i10 < groupCount) {
                    int i12 = i10 + 1;
                    strArr[i10] = matcher.group(i12);
                    i10 = i12;
                }
                return strArr;
            }
            i11++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("RegexValidator{");
        for (int i10 = 0; i10 < this.patterns.length; i10++) {
            if (i10 > 0) {
                sb2.append(AppsFlyerKit.COMMA);
            }
            sb2.append(this.patterns[i10].pattern());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public String validate(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i11 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i11].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                if (groupCount == 1) {
                    return matcher.group(1);
                }
                StringBuilder sb2 = new StringBuilder();
                while (i10 < groupCount) {
                    i10++;
                    String group = matcher.group(i10);
                    if (group != null) {
                        sb2.append(group);
                    }
                }
                return sb2.toString();
            }
            i11++;
        }
    }

    public RegexValidator(String str, boolean z10) {
        this(new String[]{str}, z10);
    }

    public RegexValidator(String[] strArr) {
        this(strArr, true);
    }

    public RegexValidator(String[] strArr, boolean z10) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("Regular expressions are missing");
        }
        this.patterns = new Pattern[strArr.length];
        int i10 = z10 ? 0 : 2;
        for (int i11 = 0; i11 < strArr.length; i11++) {
            String str = strArr[i11];
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("Regular expression[" + i11 + "] is missing");
            }
            this.patterns[i11] = Pattern.compile(strArr[i11], i10);
        }
    }
}
