package com.clevertap.android.sdk.validation;

import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.a;
import w4.b;
import w4.c;

public final class Validator {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f10815b = {".", CertificateUtil.DELIMITER, "$", "'", "\"", "\\"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f10816c = {".", CertificateUtil.DELIMITER, "$", "'", "\"", "\\"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f10817d = {"'", "\"", "\\"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f10818e = {"Stayed", "Notification Clicked", "Notification Viewed", "UTM Visited", "Notification Sent", "App Launched", "wzrk_d", "App Uninstalled", "Notification Bounced", "Geocluster Entered", "Geocluster Exited", "SCOutgoing", "SCIncoming", "SCEnd"};

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f10819a;

    private enum RestrictedMultiValueFields {
        Name,
        Email,
        Education,
        Married,
        DOB,
        Gender,
        Phone,
        Age,
        FBID,
        GPID,
        Birthday
    }

    public enum ValidationContext {
        Profile,
        Event
    }

    private b a(String str, a aVar, a aVar2, boolean z10, b bVar) {
        int i10;
        a aVar3 = aVar;
        a aVar4 = aVar2;
        b bVar2 = bVar;
        BitSet bitSet = null;
        if (aVar3 == null) {
            bVar2.f((Object) null);
            return bVar2;
        } else if (aVar4 == null) {
            bVar2.f(aVar3);
            return bVar2;
        } else {
            a aVar5 = new a();
            HashSet hashSet = new HashSet();
            int o10 = aVar.o();
            int o11 = aVar2.o();
            if (!z10) {
                bitSet = new BitSet(o10 + o11);
            }
            int k10 = k(aVar4, hashSet, bitSet, o10);
            if (z10 || hashSet.size() >= 100) {
                i10 = 0;
            } else {
                i10 = k(aVar3, hashSet, bitSet, 0);
            }
            for (int i11 = i10; i11 < o10; i11++) {
                if (z10) {
                    try {
                        String str2 = (String) aVar3.get(i11);
                        if (!hashSet.contains(str2)) {
                            aVar5.E(str2);
                        }
                    } catch (Throwable unused) {
                    }
                } else if (!bitSet.get(i11)) {
                    aVar5.E(aVar3.get(i11));
                }
            }
            if (!z10 && aVar5.o() < 100) {
                for (int i12 = k10; i12 < o11; i12++) {
                    try {
                        if (!bitSet.get(i12 + o10)) {
                            aVar5.E(aVar4.get(i12));
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
            if (k10 > 0 || i10 > 0) {
                b b10 = c.b(521, 12, str, 100 + "");
                bVar2.d(b10.a());
                bVar2.e(b10.b());
            }
            bVar2.f(aVar5);
            return bVar2;
        }
    }

    private ArrayList<String> g() {
        return this.f10819a;
    }

    private int k(a aVar, Set<String> set, BitSet bitSet, int i10) {
        String str;
        if (aVar == null) {
            return 0;
        }
        for (int o10 = aVar.o() - 1; o10 >= 0; o10--) {
            try {
                Object obj = aVar.get(o10);
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = null;
                }
                if (bitSet != null) {
                    if (str != null) {
                        if (!set.contains(str)) {
                            set.add(str);
                            if (set.size() == 100) {
                                return o10;
                            }
                        }
                    }
                    bitSet.set(o10 + i10, true);
                } else if (str != null) {
                    set.add(str);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public b b(String str) {
        b bVar = new b();
        String trim = str.trim();
        for (String replace : f10815b) {
            trim = trim.replace(replace, "");
        }
        if (trim.length() > 512) {
            trim = trim.substring(0, 511);
            b b10 = c.b(510, 11, trim.trim(), "512");
            bVar.e(b10.b());
            bVar.d(b10.a());
        }
        bVar.f(trim.trim());
        return bVar;
    }

    public b c(String str) {
        b e10 = e(str);
        String str2 = (String) e10.c();
        try {
            if (RestrictedMultiValueFields.valueOf(str2) != null) {
                b b10 = c.b(523, 24, str2);
                e10.e(b10.b());
                e10.d(b10.a());
                e10.f((Object) null);
            }
        } catch (Throwable unused) {
        }
        return e10;
    }

    public b d(@NonNull String str) {
        b bVar = new b();
        String lowerCase = str.trim().toLowerCase();
        for (String replace : f10817d) {
            lowerCase = lowerCase.replace(replace, "");
        }
        try {
            if (lowerCase.length() > 512) {
                lowerCase = lowerCase.substring(0, 511);
                b b10 = c.b(521, 11, lowerCase, "512");
                bVar.e(b10.b());
                bVar.d(b10.a());
            }
        } catch (Exception unused) {
        }
        bVar.f(lowerCase);
        return bVar;
    }

    public b e(String str) {
        b bVar = new b();
        String trim = str.trim();
        for (String replace : f10816c) {
            trim = trim.replace(replace, "");
        }
        if (trim.length() > 120) {
            trim = trim.substring(0, 119);
            b b10 = c.b(520, 11, trim.trim(), "120");
            bVar.e(b10.b());
            bVar.d(b10.a());
        }
        bVar.f(trim.trim());
        return bVar;
    }

    public b f(Object obj, ValidationContext validationContext) throws IllegalArgumentException {
        String str;
        ArrayList arrayList;
        b bVar = new b();
        if ((obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Long)) {
            bVar.f(obj);
            return bVar;
        }
        if ((obj instanceof String) || (obj instanceof Character)) {
            if (obj instanceof Character) {
                str = String.valueOf(obj);
            } else {
                str = (String) obj;
            }
            String trim = str.trim();
            for (String replace : f10817d) {
                trim = trim.replace(replace, "");
            }
            try {
                if (trim.length() > 512) {
                    trim = trim.substring(0, 511);
                    b b10 = c.b(521, 11, trim.trim(), "512");
                    bVar.e(b10.b());
                    bVar.d(b10.a());
                }
            } catch (Exception unused) {
            }
            bVar.f(trim.trim());
            return bVar;
        } else if (obj instanceof Date) {
            bVar.f("$D_" + (((Date) obj).getTime() / 1000));
            return bVar;
        } else {
            boolean z10 = obj instanceof String[];
            if ((z10 || (obj instanceof ArrayList)) && validationContext.equals(ValidationContext.Profile)) {
                String[] strArr = null;
                if (obj instanceof ArrayList) {
                    arrayList = (ArrayList) obj;
                } else {
                    arrayList = null;
                }
                if (z10) {
                    strArr = (String[]) obj;
                }
                ArrayList arrayList2 = new ArrayList();
                if (strArr != null) {
                    for (String add : strArr) {
                        try {
                            arrayList2.add(add);
                        } catch (Exception unused2) {
                        }
                    }
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList2.add((String) it.next());
                        } catch (Exception unused3) {
                        }
                    }
                }
                String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                if (strArr2.length <= 0 || strArr2.length > 100) {
                    b b11 = c.b(521, 13, strArr2.length + "", "100");
                    bVar.e(b11.b());
                    bVar.d(b11.a());
                } else {
                    a aVar = new a();
                    org.json.b bVar2 = new org.json.b();
                    for (String E : strArr2) {
                        aVar.E(E);
                    }
                    try {
                        bVar2.put("$set", (Object) aVar);
                    } catch (JSONException unused4) {
                    }
                    bVar.f(bVar2);
                }
                return bVar;
            }
            throw new IllegalArgumentException("Not a String, Boolean, Long, Integer, Float, Double, or Date");
        }
    }

    public b h(String str) {
        b bVar = new b();
        if (str == null) {
            b b10 = c.b(510, 14, new String[0]);
            bVar.d(b10.a());
            bVar.e(b10.b());
            return bVar;
        }
        if (g() != null) {
            Iterator<String> it = g().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str.equalsIgnoreCase(it.next())) {
                        b b11 = c.b(513, 17, str);
                        bVar.d(b11.a());
                        bVar.e(b11.b());
                        p.a(str + " s a discarded event name as per CleverTap. Dropping event at SDK level. Check discarded events in CleverTap Dashboard settings.");
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return bVar;
    }

    public b i(String str) {
        b bVar = new b();
        if (str == null) {
            b b10 = c.b(510, 14, new String[0]);
            bVar.d(b10.a());
            bVar.e(b10.b());
            return bVar;
        }
        for (String equalsIgnoreCase : f10818e) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                b b11 = c.b(513, 16, str);
                bVar.d(b11.a());
                bVar.e(b11.b());
                p.o(b11.b());
                return bVar;
            }
        }
        return bVar;
    }

    public b j(a aVar, a aVar2, String str, String str2) {
        return a(str2, aVar, aVar2, "multiValuePropertyRemoveValues".equals(str), new b());
    }

    public void l(ArrayList<String> arrayList) {
        this.f10819a = arrayList;
    }
}
