package org.apache.commons.collections;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.map.FixedSizeMap;
import org.apache.commons.collections.map.FixedSizeSortedMap;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.LazySortedMap;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.collections.map.PredicatedMap;
import org.apache.commons.collections.map.PredicatedSortedMap;
import org.apache.commons.collections.map.TransformedMap;
import org.apache.commons.collections.map.TransformedSortedMap;
import org.apache.commons.collections.map.TypedMap;
import org.apache.commons.collections.map.TypedSortedMap;
import org.apache.commons.collections.map.UnmodifiableMap;
import org.apache.commons.collections.map.UnmodifiableSortedMap;

public class MapUtils {
    public static final Map EMPTY_MAP = UnmodifiableMap.decorate(new HashMap(1));
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.decorate(new TreeMap());
    private static final String INDENT_STRING = "    ";

    public static void debugPrint(PrintStream printStream, Object obj, Map map) {
        verbosePrintInternal(printStream, obj, map, new ArrayStack(), true);
    }

    public static Map fixedSizeMap(Map map) {
        return FixedSizeMap.decorate(map);
    }

    public static SortedMap fixedSizeSortedMap(SortedMap sortedMap) {
        return FixedSizeSortedMap.decorate(sortedMap);
    }

    public static Boolean getBoolean(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return null;
        }
        if (obj2 instanceof Boolean) {
            return (Boolean) obj2;
        }
        if (obj2 instanceof String) {
            return new Boolean((String) obj2);
        }
        if (obj2 instanceof Number) {
            return ((Number) obj2).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static boolean getBooleanValue(Map map, Object obj) {
        Boolean bool = getBoolean(map, obj);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static Byte getByte(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Byte) {
            return (Byte) number;
        }
        return new Byte(number.byteValue());
    }

    public static byte getByteValue(Map map, Object obj) {
        Byte b10 = getByte(map, obj);
        if (b10 == null) {
            return 0;
        }
        return b10.byteValue();
    }

    public static Double getDouble(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Double) {
            return (Double) number;
        }
        return new Double(number.doubleValue());
    }

    public static double getDoubleValue(Map map, Object obj) {
        Double d10 = getDouble(map, obj);
        if (d10 == null) {
            return 0.0d;
        }
        return d10.doubleValue();
    }

    public static Float getFloat(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Float) {
            return (Float) number;
        }
        return new Float(number.floatValue());
    }

    public static float getFloatValue(Map map, Object obj) {
        Float f10 = getFloat(map, obj);
        if (f10 == null) {
            return 0.0f;
        }
        return f10.floatValue();
    }

    public static int getIntValue(Map map, Object obj) {
        Integer integer = getInteger(map, obj);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public static Integer getInteger(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Integer) {
            return (Integer) number;
        }
        return new Integer(number.intValue());
    }

    public static Long getLong(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Long) {
            return (Long) number;
        }
        return new Long(number.longValue());
    }

    public static long getLongValue(Map map, Object obj) {
        Long l10 = getLong(map, obj);
        if (l10 == null) {
            return 0;
        }
        return l10.longValue();
    }

    public static Map getMap(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null || !(obj2 instanceof Map)) {
            return null;
        }
        return (Map) obj2;
    }

    public static Number getNumber(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return null;
        }
        if (obj2 instanceof Number) {
            return (Number) obj2;
        }
        if (!(obj2 instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj2);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static Object getObject(Map map, Object obj) {
        if (map != null) {
            return map.get(obj);
        }
        return null;
    }

    public static Short getShort(Map map, Object obj) {
        Number number = getNumber(map, obj);
        if (number == null) {
            return null;
        }
        if (number instanceof Short) {
            return (Short) number;
        }
        return new Short(number.shortValue());
    }

    public static short getShortValue(Map map, Object obj) {
        Short sh2 = getShort(map, obj);
        if (sh2 == null) {
            return 0;
        }
        return sh2.shortValue();
    }

    public static String getString(Map map, Object obj) {
        Object obj2;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return null;
        }
        return obj2.toString();
    }

    public static Map invertMap(Map map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            hashMap.put(entry.getValue(), entry.getKey());
        }
        return hashMap;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

    public static Map lazyMap(Map map, Factory factory) {
        return LazyMap.decorate(map, factory);
    }

    public static SortedMap lazySortedMap(SortedMap sortedMap, Factory factory) {
        return LazySortedMap.decorate(sortedMap, factory);
    }

    protected static void logInfo(Exception exc) {
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("INFO: Exception: ");
        stringBuffer.append(exc);
        printStream.println(stringBuffer.toString());
    }

    public static Map multiValueMap(Map map) {
        return MultiValueMap.decorate(map);
    }

    public static Map orderedMap(Map map) {
        return ListOrderedMap.decorate(map);
    }

    public static Map predicatedMap(Map map, Predicate predicate, Predicate predicate2) {
        return PredicatedMap.decorate(map, predicate, predicate2);
    }

    public static SortedMap predicatedSortedMap(SortedMap sortedMap, Predicate predicate, Predicate predicate2) {
        return PredicatedSortedMap.decorate(sortedMap, predicate, predicate2);
    }

    private static void printIndent(PrintStream printStream, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            printStream.print(INDENT_STRING);
        }
    }

    public static Map putAll(Map map, Object[] objArr) {
        map.size();
        if (!(objArr == null || objArr.length == 0)) {
            int i10 = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                while (i10 < objArr.length) {
                    Map.Entry entry = objArr[i10];
                    map.put(entry.getKey(), entry.getValue());
                    i10++;
                }
            } else if (obj instanceof KeyValue) {
                while (i10 < objArr.length) {
                    KeyValue keyValue = objArr[i10];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i10++;
                }
            } else if (obj instanceof Object[]) {
                for (int i11 = 0; i11 < objArr.length; i11++) {
                    Object[] objArr2 = objArr[i11];
                    if (objArr2 == null || objArr2.length < 2) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Invalid array element: ");
                        stringBuffer.append(i11);
                        throw new IllegalArgumentException(stringBuffer.toString());
                    }
                    map.put(objArr2[0], objArr2[1]);
                }
            } else {
                while (i10 < objArr.length - 1) {
                    int i12 = i10 + 1;
                    map.put(objArr[i10], objArr[i12]);
                    i10 = i12 + 1;
                }
            }
        }
        return map;
    }

    public static void safeAddToMap(Map map, Object obj, Object obj2) throws NullPointerException {
        if (obj2 == null) {
            map.put(obj, "");
        } else {
            map.put(obj, obj2);
        }
    }

    public static Map synchronizedMap(Map map) {
        return Collections.synchronizedMap(map);
    }

    public static Map synchronizedSortedMap(SortedMap sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static Map toMap(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap hashMap = new HashMap();
        while (keys.hasMoreElements()) {
            String nextElement = keys.nextElement();
            hashMap.put(nextElement, resourceBundle.getObject(nextElement));
        }
        return hashMap;
    }

    public static Properties toProperties(Map map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static Map transformedMap(Map map, Transformer transformer, Transformer transformer2) {
        return TransformedMap.decorate(map, transformer, transformer2);
    }

    public static SortedMap transformedSortedMap(SortedMap sortedMap, Transformer transformer, Transformer transformer2) {
        return TransformedSortedMap.decorate(sortedMap, transformer, transformer2);
    }

    public static Map typedMap(Map map, Class cls, Class cls2) {
        return TypedMap.decorate(map, cls, cls2);
    }

    public static SortedMap typedSortedMap(SortedMap sortedMap, Class cls, Class cls2) {
        return TypedSortedMap.decorate(sortedMap, cls, cls2);
    }

    public static Map unmodifiableMap(Map map) {
        return UnmodifiableMap.decorate(map);
    }

    public static Map unmodifiableSortedMap(SortedMap sortedMap) {
        return UnmodifiableSortedMap.decorate(sortedMap);
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map map) {
        verbosePrintInternal(printStream, obj, map, new ArrayStack(), false);
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map map, ArrayStack arrayStack, boolean z10) {
        String str;
        printIndent(printStream, arrayStack.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println("null");
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, arrayStack.size());
        printStream.println("{");
        arrayStack.push(map);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof Map) || arrayStack.contains(value)) {
                printIndent(printStream, arrayStack.size());
                printStream.print(key);
                printStream.print(" = ");
                int indexOf = arrayStack.indexOf(value);
                if (indexOf == -1) {
                    printStream.print(value);
                } else if (arrayStack.size() - 1 == indexOf) {
                    printStream.print("(this Map)");
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("(ancestor[");
                    stringBuffer.append(((arrayStack.size() - 1) - indexOf) - 1);
                    stringBuffer.append("] Map)");
                    printStream.print(stringBuffer.toString());
                }
                if (!z10 || value == null) {
                    printStream.println();
                } else {
                    printStream.print(' ');
                    printStream.println(value.getClass().getName());
                }
            } else {
                if (key == null) {
                    key = "null";
                }
                verbosePrintInternal(printStream, key, (Map) value, arrayStack, z10);
            }
        }
        arrayStack.pop();
        printIndent(printStream, arrayStack.size());
        if (z10) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("} ");
            stringBuffer2.append(map.getClass().getName());
            str = stringBuffer2.toString();
        } else {
            str = "}";
        }
        printStream.println(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getObject(java.util.Map r0, java.lang.Object r1, java.lang.Object r2) {
        /*
            if (r0 == 0) goto L_0x0009
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.collections.MapUtils.getObject(java.util.Map, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public static Map lazyMap(Map map, Transformer transformer) {
        return LazyMap.decorate(map, transformer);
    }

    public static SortedMap lazySortedMap(SortedMap sortedMap, Transformer transformer) {
        return LazySortedMap.decorate(sortedMap, transformer);
    }

    public static Map multiValueMap(Map map, Class cls) {
        return MultiValueMap.decorate(map, cls);
    }

    public static boolean getBooleanValue(Map map, Object obj, boolean z10) {
        Boolean bool = getBoolean(map, obj);
        if (bool == null) {
            return z10;
        }
        return bool.booleanValue();
    }

    public static byte getByteValue(Map map, Object obj, byte b10) {
        Byte b11 = getByte(map, obj);
        if (b11 == null) {
            return b10;
        }
        return b11.byteValue();
    }

    public static double getDoubleValue(Map map, Object obj, double d10) {
        Double d11 = getDouble(map, obj);
        if (d11 == null) {
            return d10;
        }
        return d11.doubleValue();
    }

    public static float getFloatValue(Map map, Object obj, float f10) {
        Float f11 = getFloat(map, obj);
        if (f11 == null) {
            return f10;
        }
        return f11.floatValue();
    }

    public static int getIntValue(Map map, Object obj, int i10) {
        Integer integer = getInteger(map, obj);
        if (integer == null) {
            return i10;
        }
        return integer.intValue();
    }

    public static long getLongValue(Map map, Object obj, long j10) {
        Long l10 = getLong(map, obj);
        if (l10 == null) {
            return j10;
        }
        return l10.longValue();
    }

    public static short getShortValue(Map map, Object obj, short s10) {
        Short sh2 = getShort(map, obj);
        if (sh2 == null) {
            return s10;
        }
        return sh2.shortValue();
    }

    public static String getString(Map map, Object obj, String str) {
        String string = getString(map, obj);
        return string == null ? str : string;
    }

    public static Map multiValueMap(Map map, Factory factory) {
        return MultiValueMap.decorate(map, factory);
    }

    public static Map getMap(Map map, Object obj, Map map2) {
        Map map3 = getMap(map, obj);
        return map3 == null ? map2 : map3;
    }

    public static Byte getByte(Map map, Object obj, Byte b10) {
        Byte b11 = getByte(map, obj);
        return b11 == null ? b10 : b11;
    }

    public static Double getDouble(Map map, Object obj, Double d10) {
        Double d11 = getDouble(map, obj);
        return d11 == null ? d10 : d11;
    }

    public static Float getFloat(Map map, Object obj, Float f10) {
        Float f11 = getFloat(map, obj);
        return f11 == null ? f10 : f11;
    }

    public static Integer getInteger(Map map, Object obj, Integer num) {
        Integer integer = getInteger(map, obj);
        return integer == null ? num : integer;
    }

    public static Long getLong(Map map, Object obj, Long l10) {
        Long l11 = getLong(map, obj);
        return l11 == null ? l10 : l11;
    }

    public static Short getShort(Map map, Object obj, Short sh2) {
        Short sh3 = getShort(map, obj);
        return sh3 == null ? sh2 : sh3;
    }

    public static Number getNumber(Map map, Object obj, Number number) {
        Number number2 = getNumber(map, obj);
        return number2 == null ? number : number2;
    }

    public static Boolean getBoolean(Map map, Object obj, Boolean bool) {
        Boolean bool2 = getBoolean(map, obj);
        return bool2 == null ? bool : bool2;
    }
}
