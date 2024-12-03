package lc;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class u {
    public String a(String str, String str2) {
        String trim = str2.trim();
        Matcher matcher = Pattern.compile("([a-zA-Z:*?<>|!@#$%^()={};•¥£€~_\\s\\\\\\/\\[\\]]+)").matcher(trim);
        if (TextUtils.isEmpty(trim) || matcher.find()) {
            return null;
        }
        if (Pattern.compile("([+])+").matcher(trim).find() && trim.contains(str)) {
            trim = trim.replace(str, "");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(trim);
        if (sb2.toString().length() > 16) {
            return null;
        }
        return sb2.toString();
    }

    public String b(String str, String str2, String str3, String str4, String str5, String str6) {
        return str + str2 + str3 + str4 + str5 + str6;
    }
}
