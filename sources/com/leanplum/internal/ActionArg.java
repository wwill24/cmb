package com.leanplum.internal;

import android.text.TextUtils;
import com.leanplum.internal.Constants;
import java.io.InputStream;

public class ActionArg<T> {
    private T defaultValue;
    private boolean isAsset;
    private String kind;
    private String name;

    private ActionArg() {
    }

    public static ActionArg<String> actionArgNamed(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return argNamed(str, str2, "action");
    }

    private static <T> ActionArg<T> argNamed(String str, T t10, String str2) {
        ActionArg<T> actionArg = new ActionArg<>();
        actionArg.name = str;
        actionArg.kind = str2;
        actionArg.defaultValue = t10;
        return actionArg;
    }

    public static ActionArg<String> assetArgNamed(String str, String str2) {
        ActionArg<String> argNamed = argNamed(str, str2, "file");
        argNamed.isAsset = true;
        T t10 = argNamed.defaultValue;
        VarCache.registerFile((String) t10, (String) t10, new a(argNamed));
        return argNamed;
    }

    public static ActionArg<Integer> colorArgNamed(String str, int i10) {
        return argNamed(str, Integer.valueOf(i10), Constants.Kinds.COLOR);
    }

    public static ActionArg<String> fileArgNamed(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        ActionArg<String> argNamed = argNamed(str, str2, "file");
        T t10 = argNamed.defaultValue;
        VarCache.registerFile((String) t10, (String) t10, new a(argNamed));
        return argNamed;
    }

    public InputStream defaultStream() {
        if (!this.kind.equals("file")) {
            return null;
        }
        Boolean valueOf = Boolean.valueOf(this.isAsset);
        Boolean valueOf2 = Boolean.valueOf(this.isAsset);
        T t10 = this.defaultValue;
        return FileManager.stream(false, valueOf, valueOf2, (String) t10, (String) t10, (byte[]) null);
    }

    public T defaultValue() {
        return this.defaultValue;
    }

    public String kind() {
        return this.kind;
    }

    public String name() {
        return this.name;
    }

    public static <T> ActionArg<T> argNamed(String str, T t10) {
        return argNamed(str, t10, VarCache.kindFromValue(t10));
    }
}
