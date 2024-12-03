package com.google.firebase.database.connection;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtils {
    public static void hardAssert(boolean z10) {
        hardAssert(z10, "", new Object[0]);
    }

    public static Long longFromObject(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static String pathToString(List<String> list) {
        if (list.isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (String next : list) {
            if (!z10) {
                sb2.append(RemoteSettings.FORWARD_SLASH_STRING);
            }
            z10 = false;
            sb2.append(next);
        }
        return sb2.toString();
    }

    public static List<String> stringToPath(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        for (int i10 = 0; i10 < split.length; i10++) {
            if (!split[i10].isEmpty()) {
                arrayList.add(split[i10]);
            }
        }
        return arrayList;
    }

    public static void hardAssert(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new AssertionError("hardAssert failed: " + String.format(str, objArr));
        }
    }
}
