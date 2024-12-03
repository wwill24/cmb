package com.google.android.gms.internal.gtm;

public enum zzao implements zzvb {
    ESCAPE_HTML(1),
    ESCAPE_HTML_RCDATA(2),
    ESCAPE_HTML_ATTRIBUTE(3),
    ESCAPE_HTML_ATTRIBUTE_NOSPACE(4),
    FILTER_HTML_ELEMENT_NAME(5),
    FILTER_HTML_ATTRIBUTES(6),
    ESCAPE_JS_STRING(7),
    ESCAPE_JS_VALUE(8),
    ESCAPE_JS_REGEX(9),
    ESCAPE_CSS_STRING(10),
    FILTER_CSS_VALUE(11),
    ESCAPE_URI(12),
    NORMALIZE_URI(13),
    FILTER_NORMALIZE_URI(14),
    NO_AUTOESCAPE(15),
    TEXT(17),
    CONVERT_JS_VALUE_TO_EXPRESSION(16);
    
    private static final zzvc<zzao> zzr = null;
    private final int zzt;

    static {
        zzr = new zzam();
    }

    private zzao(int i10) {
        this.zzt = i10;
    }

    public static zzao zzb(int i10) {
        switch (i10) {
            case 1:
                return ESCAPE_HTML;
            case 2:
                return ESCAPE_HTML_RCDATA;
            case 3:
                return ESCAPE_HTML_ATTRIBUTE;
            case 4:
                return ESCAPE_HTML_ATTRIBUTE_NOSPACE;
            case 5:
                return FILTER_HTML_ELEMENT_NAME;
            case 6:
                return FILTER_HTML_ATTRIBUTES;
            case 7:
                return ESCAPE_JS_STRING;
            case 8:
                return ESCAPE_JS_VALUE;
            case 9:
                return ESCAPE_JS_REGEX;
            case 10:
                return ESCAPE_CSS_STRING;
            case 11:
                return FILTER_CSS_VALUE;
            case 12:
                return ESCAPE_URI;
            case 13:
                return NORMALIZE_URI;
            case 14:
                return FILTER_NORMALIZE_URI;
            case 15:
                return NO_AUTOESCAPE;
            case 16:
                return CONVERT_JS_VALUE_TO_EXPRESSION;
            case 17:
                return TEXT;
            default:
                return null;
        }
    }

    public static zzvd zzc() {
        return zzan.zza;
    }

    public final String toString() {
        return Integer.toString(this.zzt);
    }

    public final int zza() {
        return this.zzt;
    }
}
