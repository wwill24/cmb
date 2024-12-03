package org.apache.commons.validator.routines;

import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlValidator implements Serializable {
    public static final long ALLOW_2_SLASHES = 2;
    public static final long ALLOW_ALL_SCHEMES = 1;
    public static final long ALLOW_LOCAL_URLS = 8;
    private static final String AUTHORITY_CHARS_REGEX = "\\p{Alnum}\\-\\.";
    private static final Pattern AUTHORITY_PATTERN = Pattern.compile(AUTHORITY_REGEX);
    private static final String AUTHORITY_REGEX = "(?:\\[([0-9a-fA-F:]+)\\]|(?:(?:[a-zA-Z0-9%-._~!$&'()*+,;=]+:[a-zA-Z0-9%-._~!$&'()*+,;=]*@)?([\\p{Alnum}\\-\\.]*)))(:\\d*)?(.*)?";
    private static final String[] DEFAULT_SCHEMES = {"http", "https", "ftp"};
    private static final UrlValidator DEFAULT_URL_VALIDATOR = new UrlValidator();
    private static final String IPV6_REGEX = "[0-9a-fA-F:]+";
    public static final long NO_FRAGMENTS = 4;
    private static final int PARSE_AUTHORITY_EXTRA = 4;
    private static final int PARSE_AUTHORITY_HOST_IP = 2;
    private static final int PARSE_AUTHORITY_IPV6 = 1;
    private static final int PARSE_URL_AUTHORITY = 4;
    private static final int PARSE_URL_FRAGMENT = 9;
    private static final int PARSE_URL_PATH = 5;
    private static final int PARSE_URL_QUERY = 7;
    private static final int PARSE_URL_SCHEME = 2;
    private static final Pattern PATH_PATTERN = Pattern.compile(PATH_REGEX);
    private static final String PATH_REGEX = "^(/[-\\w:@&?=+,.!/~*'%$_;\\(\\)]*)?$";
    private static final Pattern QUERY_PATTERN = Pattern.compile(QUERY_REGEX);
    private static final String QUERY_REGEX = "^(.*)$";
    private static final Pattern SCHEME_PATTERN = Pattern.compile(SCHEME_REGEX);
    private static final String SCHEME_REGEX = "^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*";
    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private static final String URL_REGEX = "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
    private static final String USERINFO_CHARS_REGEX = "[a-zA-Z0-9%-._~!$&'()*+,;=]";
    private static final String USERINFO_FIELD_REGEX = "[a-zA-Z0-9%-._~!$&'()*+,;=]+:[a-zA-Z0-9%-._~!$&'()*+,;=]*@";
    private static final long serialVersionUID = 7557161713937335013L;
    private final Set<String> allowedSchemes;
    private final RegexValidator authorityValidator;
    private final long options;

    public UrlValidator() {
        this((String[]) null);
    }

    public static UrlValidator getInstance() {
        return DEFAULT_URL_VALIDATOR;
    }

    private boolean isOff(long j10) {
        return (j10 & this.options) == 0;
    }

    private boolean isOn(long j10) {
        return (j10 & this.options) > 0;
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
        if (str == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(2);
        if (!isValidScheme(group)) {
            return false;
        }
        String group2 = matcher.group(4);
        if ("file".equals(group)) {
            if (!"".equals(group2) && group2.contains(CertificateUtil.DELIMITER)) {
                return false;
            }
        } else if (!isValidAuthority(group2)) {
            return false;
        }
        if (isValidPath(matcher.group(5)) && isValidQuery(matcher.group(7)) && isValidFragment(matcher.group(9))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidAuthority(String str) {
        if (str == null) {
            return false;
        }
        RegexValidator regexValidator = this.authorityValidator;
        if (regexValidator != null && regexValidator.isValid(str)) {
            return true;
        }
        Matcher matcher = AUTHORITY_PATTERN.matcher(DomainValidator.unicodeToASCII(str));
        if (!matcher.matches()) {
            return false;
        }
        String group = matcher.group(1);
        if (group == null) {
            String group2 = matcher.group(2);
            if (!DomainValidator.getInstance(isOn(8)).isValid(group2) && !InetAddressValidator.getInstance().isValidInet4Address(group2)) {
                return false;
            }
        } else if (!InetAddressValidator.getInstance().isValidInet6Address(group)) {
            return false;
        }
        String group3 = matcher.group(4);
        if (group3 == null || group3.trim().length() <= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isValidFragment(String str) {
        if (str == null) {
            return true;
        }
        return isOff(4);
    }

    /* access modifiers changed from: protected */
    public boolean isValidPath(String str) {
        if (str == null || !PATH_PATTERN.matcher(str).matches()) {
            return false;
        }
        try {
            String path = new URI((String) null, (String) null, str, (String) null).normalize().getPath();
            if (!path.startsWith("/../") && !path.equals("/..")) {
                int countToken = countToken("//", str);
                if (!isOff(2) || countToken <= 0) {
                    return true;
                }
                return false;
            }
        } catch (URISyntaxException unused) {
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
        if (!isOff(1) || this.allowedSchemes.contains(str.toLowerCase(Locale.ENGLISH))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Matcher matchURL(String str) {
        return URL_PATTERN.matcher(str);
    }

    public UrlValidator(String[] strArr) {
        this(strArr, 0);
    }

    public UrlValidator(long j10) {
        this((String[]) null, (RegexValidator) null, j10);
    }

    public UrlValidator(String[] strArr, long j10) {
        this(strArr, (RegexValidator) null, j10);
    }

    public UrlValidator(RegexValidator regexValidator, long j10) {
        this((String[]) null, regexValidator, j10);
    }

    public UrlValidator(String[] strArr, RegexValidator regexValidator, long j10) {
        this.options = j10;
        if (isOn(1)) {
            this.allowedSchemes = Collections.emptySet();
        } else {
            strArr = strArr == null ? DEFAULT_SCHEMES : strArr;
            this.allowedSchemes = new HashSet(strArr.length);
            for (String lowerCase : strArr) {
                this.allowedSchemes.add(lowerCase.toLowerCase(Locale.ENGLISH));
            }
        }
        this.authorityValidator = regexValidator;
    }
}
