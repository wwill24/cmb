package we;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzha;
import java.util.EnumMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class o {

    /* renamed from: c  reason: collision with root package name */
    public static final o f42122c = new o((Boolean) null, (Boolean) null, 100);

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f42123a;

    /* renamed from: b  reason: collision with root package name */
    private final int f42124b;

    public o(Boolean bool, Boolean bool2, int i10) {
        EnumMap enumMap = new EnumMap(zzha.class);
        this.f42123a = enumMap;
        enumMap.put(zzha.AD_STORAGE, bool);
        enumMap.put(zzha.ANALYTICS_STORAGE, bool2);
        this.f42124b = i10;
    }

    public static o b(Bundle bundle, int i10) {
        if (bundle == null) {
            return new o((Boolean) null, (Boolean) null, i10);
        }
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzha : zzha.values()) {
            enumMap.put(zzha, p(bundle.getString(zzha.zzd)));
        }
        return new o(enumMap, i10);
    }

    public static o c(String str, int i10) {
        EnumMap enumMap = new EnumMap(zzha.class);
        if (str != null) {
            int i11 = 0;
            while (true) {
                zzha[] zzhaArr = zzha.f40497c;
                int length = zzhaArr.length;
                if (i11 >= 2) {
                    break;
                }
                zzha zzha = zzhaArr[i11];
                int i12 = i11 + 2;
                if (i12 < str.length()) {
                    char charAt = str.charAt(i12);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (charAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(zzha, bool);
                }
                i11++;
            }
        }
        return new o(enumMap, i10);
    }

    public static String h(Bundle bundle) {
        String string;
        for (zzha zzha : zzha.values()) {
            if (bundle.containsKey(zzha.zzd) && (string = bundle.getString(zzha.zzd)) != null && p(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean k(int i10, int i11) {
        return i10 <= i11;
    }

    static final int o(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    private static Boolean p(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final int a() {
        return this.f42124b;
    }

    public final o d(o oVar) {
        boolean z10;
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzha : zzha.values()) {
            Boolean bool = (Boolean) this.f42123a.get(zzha);
            Boolean bool2 = (Boolean) oVar.f42123a.get(zzha);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                if (!bool.booleanValue() || !bool2.booleanValue()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                bool = Boolean.valueOf(z10);
            }
            enumMap.put(zzha, bool);
        }
        return new o(enumMap, 100);
    }

    public final o e(o oVar) {
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzha : zzha.values()) {
            Boolean bool = (Boolean) this.f42123a.get(zzha);
            if (bool == null) {
                bool = (Boolean) oVar.f42123a.get(zzha);
            }
            enumMap.put(zzha, bool);
        }
        return new o(enumMap, this.f42124b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        for (zzha zzha : zzha.values()) {
            if (o((Boolean) this.f42123a.get(zzha)) != o((Boolean) oVar.f42123a.get(zzha))) {
                return false;
            }
        }
        if (this.f42124b == oVar.f42124b) {
            return true;
        }
        return false;
    }

    public final Boolean f() {
        return (Boolean) this.f42123a.get(zzha.AD_STORAGE);
    }

    public final Boolean g() {
        return (Boolean) this.f42123a.get(zzha.ANALYTICS_STORAGE);
    }

    public final int hashCode() {
        int i10 = this.f42124b * 17;
        for (Boolean o10 : this.f42123a.values()) {
            i10 = (i10 * 31) + o(o10);
        }
        return i10;
    }

    public final String i() {
        char c10;
        StringBuilder sb2 = new StringBuilder("G1");
        zzha[] zzhaArr = zzha.f40497c;
        int length = zzhaArr.length;
        for (int i10 = 0; i10 < 2; i10++) {
            Boolean bool = (Boolean) this.f42123a.get(zzhaArr[i10]);
            if (bool == null) {
                c10 = SignatureVisitor.SUPER;
            } else if (bool.booleanValue()) {
                c10 = '1';
            } else {
                c10 = '0';
            }
            sb2.append(c10);
        }
        return sb2.toString();
    }

    public final boolean j(zzha zzha) {
        Boolean bool = (Boolean) this.f42123a.get(zzha);
        if (bool == null || bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        for (Boolean bool : this.f42123a.values()) {
            if (bool != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean m(o oVar) {
        return n(oVar, (zzha[]) this.f42123a.keySet().toArray(new zzha[0]));
    }

    public final boolean n(o oVar, zzha... zzhaArr) {
        for (zzha zzha : zzhaArr) {
            Boolean bool = (Boolean) this.f42123a.get(zzha);
            Boolean bool2 = (Boolean) oVar.f42123a.get(zzha);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("settings: source=");
        sb2.append(this.f42124b);
        for (zzha zzha : zzha.values()) {
            sb2.append(", ");
            sb2.append(zzha.name());
            sb2.append("=");
            Boolean bool = (Boolean) this.f42123a.get(zzha);
            if (bool == null) {
                sb2.append("uninitialized");
            } else {
                if (true != bool.booleanValue()) {
                    str = "denied";
                } else {
                    str = "granted";
                }
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public o(EnumMap enumMap, int i10) {
        EnumMap enumMap2 = new EnumMap(zzha.class);
        this.f42123a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f42124b = i10;
    }
}
