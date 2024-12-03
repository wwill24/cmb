package org.apache.commons.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.InetAddressValidator;

public class EmailValidator {
    private static final String ATOM = "[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]+";
    private static final Pattern ATOM_PATTERN = Pattern.compile("([^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]+)");
    private static final Pattern DOMAIN_PATTERN = Pattern.compile("^[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]+(\\.[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]+)*\\s*$");
    private static final EmailValidator EMAIL_VALIDATOR = new EmailValidator();
    private static final Pattern IP_DOMAIN_PATTERN = Pattern.compile("^\\[(.*)\\]$");
    private static final String QUOTED_USER = "(\"[^\"]*\")";
    private static final String SPECIAL_CHARS = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
    private static final Pattern TLD_PATTERN = Pattern.compile("^([a-zA-Z]+)$");
    private static final Pattern USER_PATTERN = Pattern.compile("^\\s*(([^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"[^\"]*\"))(\\.(([^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"[^\"]*\")))*$");
    private static final String VALID_CHARS = "[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]";
    private static final String WORD = "(([^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"[^\"]*\"))";

    protected EmailValidator() {
    }

    public static EmailValidator getInstance() {
        return EMAIL_VALIDATOR;
    }

    public boolean isValid(String str) {
        return org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(str);
    }

    /* access modifiers changed from: protected */
    public boolean isValidDomain(String str) {
        boolean z10;
        Matcher matcher = IP_DOMAIN_PATTERN.matcher(str);
        if (!matcher.matches()) {
            z10 = DOMAIN_PATTERN.matcher(str).matches();
        } else if (InetAddressValidator.getInstance().isValid(matcher.group(1))) {
            return true;
        } else {
            z10 = false;
        }
        if (!z10 || !isValidSymbolicDomain(str)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isValidIpAddress(String str) {
        Matcher matcher = IP_DOMAIN_PATTERN.matcher(str);
        int i10 = 1;
        while (i10 <= 4) {
            String group = matcher.group(i10);
            if (group != null && group.length() > 0) {
                try {
                    if (Integer.parseInt(group) > 255) {
                        return false;
                    }
                    i10++;
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isValidSymbolicDomain(String str) {
        String[] strArr = new String[10];
        Matcher matcher = ATOM_PATTERN.matcher(str);
        int i10 = 0;
        boolean z10 = true;
        while (z10) {
            z10 = matcher.matches();
            if (z10) {
                String group = matcher.group(1);
                strArr[i10] = group;
                int length = group.length() + 1;
                if (length >= str.length()) {
                    str = "";
                } else {
                    str = str.substring(length);
                }
                i10++;
            }
        }
        if (i10 < 2) {
            return false;
        }
        String str2 = strArr[i10 - 1];
        if (str2.length() <= 1 || !TLD_PATTERN.matcher(str2).matches()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isValidUser(String str) {
        return USER_PATTERN.matcher(str).matches();
    }

    /* access modifiers changed from: protected */
    public String stripComments(String str) {
        Pattern compile = Pattern.compile("^((?:[^\"\\\\]|\\\\.)*(?:\"(?:[^\"\\\\]|\\\\.)*\"(?:[^\"\\\\]|I111\\\\.)*)*)\\((?:[^()\\\\]|\\\\.)*\\)/");
        while (compile.matcher(str).matches()) {
            str = str.replaceFirst("^((?:[^\"\\\\]|\\\\.)*(?:\"(?:[^\"\\\\]|\\\\.)*\"(?:[^\"\\\\]|I111\\\\.)*)*)\\((?:[^()\\\\]|\\\\.)*\\)/", "\u0001 ");
        }
        return str;
    }
}
