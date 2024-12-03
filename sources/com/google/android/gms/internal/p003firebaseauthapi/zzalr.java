package com.google.android.gms.internal.p003firebaseauthapi;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.bytebuddy.utility.JavaConstant;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalr  reason: invalid package */
final class zzalr {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzalp zzalp, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzalp, sb2, 0);
        return sb2.toString();
    }

    static void zzb(StringBuilder sb2, int i10, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb2, i10, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb2, i10, str, zzb2);
            }
        } else {
            sb2.append(10);
            zzc(i10, sb2);
            if (!str.isEmpty()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(Character.toLowerCase(str.charAt(0)));
                for (int i11 = 1; i11 < str.length(); i11++) {
                    char charAt = str.charAt(i11);
                    if (Character.isUpperCase(charAt)) {
                        sb3.append(JavaConstant.Dynamic.DEFAULT_NAME);
                    }
                    sb3.append(Character.toLowerCase(charAt));
                }
                str = sb3.toString();
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzamq.zza(new zzajc(((String) obj).getBytes(zzakq.zzb))));
                sb2.append('\"');
            } else if (obj instanceof zzajf) {
                sb2.append(": \"");
                sb2.append(zzamq.zza((zzajf) obj));
                sb2.append('\"');
            } else if (obj instanceof zzakk) {
                sb2.append(" {");
                zzd((zzakk) obj, sb2, i10 + 2);
                sb2.append("\n");
                zzc(i10, sb2);
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                int i12 = i10 + 2;
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                zzb(sb2, i12, SDKConstants.PARAM_KEY, entry.getKey());
                zzb(sb2, i12, "value", entry.getValue());
                sb2.append("\n");
                zzc(i10, sb2);
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj);
            }
        }
    }

    private static void zzc(int i10, StringBuilder sb2) {
        while (i10 > 0) {
            int i11 = 80;
            if (i10 <= 80) {
                i11 = i10;
            }
            sb2.append(zza, 0, i11);
            i10 -= i11;
        }
    }

    private static void zzd(zzalp zzalp, StringBuilder sb2, int i10) {
        int i11;
        boolean z10;
        Method method;
        Method method2;
        zzalp zzalp2 = zzalp;
        StringBuilder sb3 = sb2;
        int i12 = i10;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzalp.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i13 = 0;
        while (true) {
            i11 = 3;
            if (i13 >= length) {
                break;
            }
            Method method3 = declaredMethods[i13];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i13++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i11);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb3, i12, substring.substring(0, substring.length() - 4), zzakk.zzD(method2, zzalp2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb3, i12, substring.substring(0, substring.length() - 3), zzakk.zzD(method, zzalp2, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzD = zzakk.zzD(method4, zzalp2, new Object[0]);
                    if (method5 == null) {
                        if (zzD instanceof Boolean) {
                            if (!((Boolean) zzD).booleanValue()) {
                            }
                        } else if (zzD instanceof Integer) {
                            if (((Integer) zzD).intValue() == 0) {
                            }
                        } else if (zzD instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzD).floatValue()) == 0) {
                            }
                        } else if (!(zzD instanceof Double)) {
                            if (zzD instanceof String) {
                                z10 = zzD.equals("");
                            } else if (zzD instanceof zzajf) {
                                z10 = zzD.equals(zzajf.zzb);
                            } else if (zzD instanceof zzalp) {
                                if (zzD == ((zzalp) zzD).zzM()) {
                                }
                            } else if ((zzD instanceof Enum) && ((Enum) zzD).ordinal() == 0) {
                            }
                            if (z10) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzD).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzakk.zzD(method5, zzalp2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb3, i12, substring, zzD);
                }
            }
            i11 = 3;
        }
        if (!(zzalp2 instanceof zzakh)) {
            zzamw zzamw = ((zzakk) zzalp2).zzc;
            if (zzamw != null) {
                zzamw.zzi(sb3, i12);
                return;
            }
            return;
        }
        zzakh zzakh = (zzakh) zzalp2;
        throw null;
    }
}
