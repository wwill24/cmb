package com.leanplum.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CollectionUtil {
    static <T> String concatenateArray(T[] tArr, String str) {
        if (tArr == null) {
            return null;
        }
        return concatenateList(Arrays.asList(tArr), str);
    }

    static String concatenateList(List<?> list, String str) {
        if (list == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Object next : list) {
            if (next != null) {
                sb2.append(next.toString());
                sb2.append(str);
            }
        }
        String sb3 = sb2.toString();
        if (sb3.length() > 0) {
            return sb3.substring(0, sb3.length() - str.length());
        }
        return sb3;
    }

    public static <K, V> V getOrDefault(Map<K, V> map, K k10, V v10) {
        return (map != null && map.containsKey(k10)) ? map.get(k10) : v10;
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... tArr) {
        int i10;
        if (tArr != null) {
            i10 = tArr.length;
        } else {
            i10 = 0;
        }
        ArrayList<T> arrayList = new ArrayList<>(i10);
        if (tArr != null) {
            Collections.addAll(arrayList, tArr);
        }
        return arrayList;
    }

    public static <T, U> HashMap<T, U> newHashMap(Object... objArr) {
        int i10;
        if (objArr != null) {
            i10 = objArr.length;
        } else {
            i10 = 0;
        }
        HashMap hashMap = new HashMap(i10);
        if (objArr == null) {
            objArr = null;
        }
        return (HashMap) newMap(hashMap, objArr);
    }

    @SafeVarargs
    static <T> HashSet<T> newHashSet(T... tArr) {
        int i10;
        if (tArr != null) {
            i10 = tArr.length;
        } else {
            i10 = 0;
        }
        HashSet<T> hashSet = new HashSet<>(i10);
        if (tArr != null) {
            Collections.addAll(hashSet, tArr);
        }
        return hashSet;
    }

    static <T, U> LinkedHashMap<T, U> newLinkedHashMap(Object... objArr) {
        int i10;
        if (objArr != null) {
            i10 = objArr.length;
        } else {
            i10 = 0;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(i10);
        if (objArr == null) {
            objArr = null;
        }
        return (LinkedHashMap) newMap(linkedHashMap, objArr);
    }

    private static <T, U> Map<T, U> newMap(Map<T, U> map, T[] tArr) {
        if (tArr == null || tArr.length == 0) {
            return map;
        }
        if (tArr.length % 2 == 0) {
            for (int i10 = 0; i10 < tArr.length; i10 += 2) {
                map.put(tArr[i10], tArr[i10 + 1]);
            }
            return map;
        }
        throw new IllegalArgumentException("newMap requires an even number of items.");
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    public static <T> T uncheckedCast(Object obj) {
        return obj;
    }
}
