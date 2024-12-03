package org.apache.commons.validator.routines;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Serializable {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String EMAIL_REGEX = "^\\s*?(.+)@(.+?)\\s*$";
    private static final EmailValidator EMAIL_VALIDATOR = new EmailValidator(false, false);
    private static final EmailValidator EMAIL_VALIDATOR_WITH_LOCAL = new EmailValidator(true, false);
    private static final EmailValidator EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD = new EmailValidator(true, true);
    private static final EmailValidator EMAIL_VALIDATOR_WITH_TLD = new EmailValidator(false, true);
    private static final Pattern IP_DOMAIN_PATTERN = Pattern.compile(IP_DOMAIN_REGEX);
    private static final String IP_DOMAIN_REGEX = "^\\[(.*)\\]$";
    private static final String QUOTED_USER = "(\"[^\"]*\")";
    private static final String SPECIAL_CHARS = "\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]";
    private static final Pattern USER_PATTERN = Pattern.compile(USER_REGEX);
    private static final String USER_REGEX = "^\\s*(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"[^\"]*\"))(\\.(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"[^\"]*\")))*$";
    private static final String VALID_CHARS = "(\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]";
    private static final String WORD = "(((\\\\.)|[^\\s\\p{Cntrl}\\(\\)<>@,;:'\\\\\\\"\\.\\[\\]]|')+|(\"[^\"]*\"))";
    private static final long serialVersionUID = 1705927040799295880L;
    private final boolean allowLocal;
    private final boolean allowTld;

    protected EmailValidator(boolean z10, boolean z11) {
        this.allowLocal = z10;
        this.allowTld = z11;
    }

    public static EmailValidator getInstance() {
        return EMAIL_VALIDATOR;
    }

    public boolean isValid(String str) {
        if (str == null || str.endsWith(".")) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(str);
        if (matcher.matches() && isValidUser(matcher.group(1)) && isValidDomain(matcher.group(2))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidDomain(String str) {
        Matcher matcher = IP_DOMAIN_PATTERN.matcher(str);
        if (matcher.matches()) {
            return InetAddressValidator.getInstance().isValid(matcher.group(1));
        }
        DomainValidator instance = DomainValidator.getInstance(this.allowLocal);
        if (!this.allowTld) {
            return instance.isValid(str);
        }
        if (instance.isValid(str) || instance.isValidTld(str)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidUser(String str) {
        if (str == null || str.length() > 64) {
            return false;
        }
        return USER_PATTERN.matcher(str).matches();
    }

    public static EmailValidator getInstance(boolean z10, boolean z11) {
        if (z10) {
            if (z11) {
                return EMAIL_VALIDATOR_WITH_LOCAL_WITH_TLD;
            }
            return EMAIL_VALIDATOR_WITH_LOCAL;
        } else if (z11) {
            return EMAIL_VALIDATOR_WITH_TLD;
        } else {
            return EMAIL_VALIDATOR;
        }
    }

    protected EmailValidator(boolean z10) {
        this.allowLocal = z10;
        this.allowTld = false;
    }

    public static EmailValidator getInstance(boolean z10) {
        return getInstance(z10, false);
    }
}
