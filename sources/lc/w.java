package lc;

import kotlin.jvm.internal.j;
import kotlin.text.Regex;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final Regex f41116a = new Regex("([0-9:*?<>|!@#$%^()+={};•¥£€~_.\\\\/\\[\\]]+)");

    public static final boolean a(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        j.f(charArray, "this as java.lang.String).toCharArray()");
        for (char type : charArray) {
            int type2 = Character.getType(type);
            if (type2 == 19 || type2 == 28) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(String str) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        j.f(charArray, "this as java.lang.String).toCharArray()");
        for (char type : charArray) {
            int type2 = Character.getType(type);
            if (type2 == 19 || type2 == 28) {
                return true;
            }
        }
        return f41116a.a(str);
    }
}
