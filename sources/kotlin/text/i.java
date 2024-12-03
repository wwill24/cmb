package kotlin.text;

import org.apache.commons.beanutils.PropertyUtils;

final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f32234a = new i();

    /* renamed from: b  reason: collision with root package name */
    public static final Regex f32235b;

    static {
        String str = "[eE][+-]?" + "(\\p{Digit}+)";
        f32235b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + (PropertyUtils.MAPPED_DELIM + "(\\p{Digit}+)" + "(\\.)?(" + "(\\p{Digit}+)" + "?)(" + str + ")?)|(\\.(" + "(\\p{Digit}+)" + ")(" + str + ")?)|((" + ("(0[xX]" + "(\\p{XDigit}+)" + "(\\.)?)|(0[xX]" + "(\\p{XDigit}+)" + "?(\\.)" + "(\\p{XDigit}+)" + PropertyUtils.MAPPED_DELIM2) + ")[pP][+-]?" + "(\\p{Digit}+)" + PropertyUtils.MAPPED_DELIM2) + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private i() {
    }
}
