package me;

import android.text.TextUtils;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f41276a = Pattern.compile("\\$\\{(.*?)\\}");

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean b(String str) {
        return str == null || str.trim().isEmpty();
    }
}
