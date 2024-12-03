package com.google.android.gms.internal.gtm;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import net.bytebuddy.utility.JavaConstant;

final class zzwm {
    static String zza(zzwk zzwk, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(str);
        zzd(zzwk, sb2, 0);
        return sb2.toString();
    }

    static final void zzb(StringBuilder sb2, int i10, String str, Object obj) {
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
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                sb2.append(' ');
            }
            sb2.append(str);
            if (obj instanceof String) {
                sb2.append(": \"");
                sb2.append(zzxm.zza(zztd.zzo((String) obj)));
                sb2.append('\"');
            } else if (obj instanceof zztd) {
                sb2.append(": \"");
                sb2.append(zzxm.zza((zztd) obj));
                sb2.append('\"');
            } else if (obj instanceof zzuz) {
                sb2.append(" {");
                zzd((zzuz) obj, sb2, i10 + 2);
                sb2.append("\n");
                while (i11 < i10) {
                    sb2.append(' ');
                    i11++;
                }
                sb2.append("}");
            } else if (obj instanceof Map.Entry) {
                sb2.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i13 = i10 + 2;
                zzb(sb2, i13, SDKConstants.PARAM_KEY, entry.getKey());
                zzb(sb2, i13, "value", entry.getValue());
                sb2.append("\n");
                while (i11 < i10) {
                    sb2.append(' ');
                    i11++;
                }
                sb2.append("}");
            } else {
                sb2.append(": ");
                sb2.append(obj.toString());
            }
        }
    }

    private static final String zzc(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (Character.isUpperCase(charAt)) {
                sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
            }
            sb2.append(Character.toLowerCase(charAt));
        }
        return sb2.toString();
    }

    private static void zzd(zzwk zzwk, StringBuilder sb2, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z10;
        String str6;
        String str7;
        String str8;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzwk.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str9 : treeSet) {
            if (str9.startsWith("get")) {
                str = str9.substring(3);
            } else {
                str = str9;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String valueOf = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(str.substring(1, str.length() - 4));
                if (valueOf2.length() != 0) {
                    str8 = valueOf.concat(valueOf2);
                } else {
                    str8 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str9);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb2, i10, zzc(str8), zzuz.zzai(method2, zzwk, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String valueOf3 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(str.substring(1, str.length() - 3));
                if (valueOf4.length() != 0) {
                    str7 = valueOf3.concat(valueOf4);
                } else {
                    str7 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str9);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb2, i10, zzc(str7), zzuz.zzai(method3, zzwk, new Object[0]));
                }
            }
            if (str.length() != 0) {
                str2 = "set".concat(str);
            } else {
                str2 = new String("set");
            }
            if (((Method) hashMap2.get(str2)) != null) {
                if (str.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(str.substring(0, str.length() - 5));
                    if (valueOf5.length() != 0) {
                        str6 = "get".concat(valueOf5);
                    } else {
                        str6 = new String("get");
                    }
                    if (hashMap.containsKey(str6)) {
                    }
                }
                String valueOf6 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(str.substring(1));
                if (valueOf7.length() != 0) {
                    str3 = valueOf6.concat(valueOf7);
                } else {
                    str3 = new String(valueOf6);
                }
                if (str.length() != 0) {
                    str4 = "get".concat(str);
                } else {
                    str4 = new String("get");
                }
                Method method4 = (Method) hashMap.get(str4);
                if (str.length() != 0) {
                    str5 = "has".concat(str);
                } else {
                    str5 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str5);
                if (method4 != null) {
                    Object zzai = zzuz.zzai(method4, zzwk, new Object[0]);
                    if (method5 == null) {
                        if (zzai instanceof Boolean) {
                            if (!((Boolean) zzai).booleanValue()) {
                            }
                        } else if (zzai instanceof Integer) {
                            if (((Integer) zzai).intValue() == 0) {
                            }
                        } else if (zzai instanceof Float) {
                            if (((Float) zzai).floatValue() == 0.0f) {
                            }
                        } else if (!(zzai instanceof Double)) {
                            if (zzai instanceof String) {
                                z10 = zzai.equals("");
                            } else if (zzai instanceof zztd) {
                                z10 = zzai.equals(zztd.zzb);
                            } else if (zzai instanceof zzwk) {
                                if (zzai == ((zzwk) zzai).zzar()) {
                                }
                            } else if ((zzai instanceof Enum) && ((Enum) zzai).ordinal() == 0) {
                            }
                            if (z10) {
                            }
                        } else if (((Double) zzai).doubleValue() == 0.0d) {
                        }
                    } else if (!((Boolean) zzuz.zzai(method5, zzwk, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i10, zzc(str3), zzai);
                }
            }
        }
        if (zzwk instanceof zzuv) {
            Iterator<Map.Entry<zzuw, Object>> zzf = ((zzuv) zzwk).zza.zzf();
            while (zzf.hasNext()) {
                Map.Entry next = zzf.next();
                int i11 = ((zzuw) next.getKey()).zzb;
                StringBuilder sb3 = new StringBuilder(13);
                sb3.append("[");
                sb3.append(i11);
                sb3.append("]");
                zzb(sb2, i10, sb3.toString(), next.getValue());
            }
        }
        zzxp zzxp = ((zzuz) zzwk).zzc;
        if (zzxp != null) {
            zzxp.zzg(sb2, i10);
        }
    }
}
