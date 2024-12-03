package org.apache.commons.validator;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.commons.validator.util.Flags;

public class UrlValidator implements Serializable {
    public static final int ALLOW_2_SLASHES = 2;
    public static final int ALLOW_ALL_SCHEMES = 1;
    private static final String ALPHA_CHARS = "a-zA-Z";
    private static final Pattern ALPHA_PATTERN = Pattern.compile("^[a-zA-Z]");
    private static final String ATOM = "[^\\s;/@&=,.?:+$]+";
    private static final Pattern ATOM_PATTERN = Pattern.compile("^([^\\s;/@&=,.?:+$]+).*?$");
    private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
    private static final Pattern AUTHORITY_PATTERN = Pattern.compile(AUTHORITY_REGEX);
    private static final String AUTHORITY_REGEX = "^([\\p{Alnum}\\-\\.]*)(:\\d*)?(.*)?";
    private static final Pattern DOMAIN_PATTERN = Pattern.compile("^[^\\s;/@&=,.?:+$]+(\\.[^\\s;/@&=,.?:+$]+)*$");
    private static final Pattern LEGAL_ASCII_PATTERN = Pattern.compile("^\\p{ASCII}+$");
    public static final int NO_FRAGMENTS = 4;
    private static final int PARSE_AUTHORITY_EXTRA = 3;
    private static final int PARSE_AUTHORITY_HOST_IP = 1;
    private static final int PARSE_AUTHORITY_PORT = 2;
    private static final int PARSE_URL_AUTHORITY = 4;
    private static final int PARSE_URL_FRAGMENT = 9;
    private static final int PARSE_URL_PATH = 5;
    private static final int PARSE_URL_QUERY = 7;
    private static final int PARSE_URL_SCHEME = 2;
    private static final Pattern PATH_PATTERN = Pattern.compile("^(/[-\\w:@&?=+,.!/~*'%$_;]*)?$");
    private static final Pattern PORT_PATTERN = Pattern.compile("^:(\\d{1,5})$");
    private static final Pattern QUERY_PATTERN = Pattern.compile("^(.*)$");
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*");
    private static final String SPECIAL_CHARS = ";/@&=,.?:+$";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private static final String URL_REGEX = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
    private static final String VALID_CHARS = "[^\\s;/@&=,.?:+$]";
    private static final long serialVersionUID = 24137157400029593L;
    private final Set<String> allowedSchemes;
    protected String[] defaultSchemes;
    private final Flags options;

    public UrlValidator() {
        this((String[]) null);
    }

    /* access modifiers changed from: protected */
    public int countToken(String str, String str2) {
        int i10 = 0;
        int i11 = 0;
        while (i10 != -1) {
            i10 = str2.indexOf(str, i10);
            if (i10 > -1) {
                i10++;
                i11++;
            }
        }
        return i11;
    }

    public boolean isValid(String str) {
        if (str == null || !LEGAL_ASCII_PATTERN.matcher(str).matches()) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(str);
        if (matcher.matches() && isValidScheme(matcher.group(2)) && isValidAuthority(matcher.group(4)) && isValidPath(matcher.group(5)) && isValidQuery(matcher.group(7)) && isValidFragment(matcher.group(9))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidAuthority(String str) {
        boolean z10;
        if (str == null) {
            return false;
        }
        InetAddressValidator instance = InetAddressValidator.getInstance();
        Matcher matcher = AUTHORITY_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(1);
        boolean isValid = instance.isValid(group);
        if (!isValid) {
            z10 = DOMAIN_PATTERN.matcher(group).matches();
        } else {
            z10 = false;
        }
        if (z10) {
            char[] charArray = group.toCharArray();
            int i10 = 1;
            for (char c10 : charArray) {
                if (c10 == '.') {
                    i10++;
                }
            }
            String[] strArr = new String[i10];
            int i11 = 0;
            boolean z11 = true;
            while (z11) {
                Matcher matcher2 = ATOM_PATTERN.matcher(group);
                boolean matches = matcher2.matches();
                if (matches) {
                    String group2 = matcher2.group(1);
                    strArr[i11] = group2;
                    int length = group2.length() + 1;
                    if (length >= group.length()) {
                        group = "";
                    } else {
                        group = group.substring(length);
                    }
                    i11++;
                }
                z11 = matches;
            }
            String str2 = strArr[i11 - 1];
            if (str2.length() < 2 || str2.length() > 4 || !ALPHA_PATTERN.matcher(str2.substring(0, 1)).matches() || i11 < 2) {
                return false;
            }
        }
        if (!z10 && !isValid) {
            return false;
        }
        String group3 = matcher.group(2);
        if ((group3 == null || PORT_PATTERN.matcher(group3).matches()) && GenericValidator.isBlankOrNull(matcher.group(3))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidFragment(String str) {
        if (str == null) {
            return true;
        }
        return this.options.isOff(4);
    }

    /* access modifiers changed from: protected */
    public boolean isValidPath(String str) {
        if (str == null || !PATH_PATTERN.matcher(str).matches()) {
            return false;
        }
        int countToken = countToken("//", str);
        if (this.options.isOff(2) && countToken > 0) {
            return false;
        }
        int countToken2 = countToken(RemoteSettings.FORWARD_SLASH_STRING, str);
        int countToken3 = countToken("..", str);
        if (countToken3 <= 0 || (countToken2 - countToken) - 1 > countToken3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidQuery(String str) {
        if (str == null) {
            return true;
        }
        return QUERY_PATTERN.matcher(str).matches();
    }

    /* access modifiers changed from: protected */
    public boolean isValidScheme(String str) {
        if (str == null || !SCHEME_PATTERN.matcher(str).matches()) {
            return false;
        }
        if (!this.options.isOff(1) || this.allowedSchemes.contains(str)) {
            return true;
        }
        return false;
    }

    public UrlValidator(String[] strArr) {
        this(strArr, 0);
    }

    public UrlValidator(int i10) {
        this((String[]) null, i10);
    }

    public UrlValidator(String[] strArr, int i10) {
        HashSet hashSet = new HashSet();
        this.allowedSchemes = hashSet;
        this.defaultSchemes = new String[]{"http", "https", "ftp"};
        Flags flags = new Flags((long) i10);
        this.options = flags;
        if (!flags.isOn(1)) {
            hashSet.addAll(Arrays.asList(strArr == null ? this.defaultSchemes : strArr));
        }
    }
}
