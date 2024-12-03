package rd;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import rd.m;

public abstract class m<T extends m> {
    public static String zza(Object obj) {
        return zzd(obj, 0);
    }

    public static String zzb(Map map) {
        return zzd(map, 1);
    }

    private static String zzd(Object obj, int i10) {
        if (i10 > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            if (TextUtils.isEmpty((String) obj)) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Long) {
            if (((Long) obj).longValue() == 0) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof Boolean) {
            if (!((Boolean) obj).booleanValue()) {
                return "";
            }
            return obj.toString();
        } else if (obj instanceof List) {
            StringBuilder sb2 = new StringBuilder();
            if (i10 > 0) {
                sb2.append("[");
            }
            int length = sb2.length();
            for (Object next : (List) obj) {
                if (sb2.length() > length) {
                    sb2.append(", ");
                }
                sb2.append(zzd(next, i10 + 1));
            }
            if (i10 > 0) {
                sb2.append("]");
            }
            return sb2.toString();
        } else if (!(obj instanceof Map)) {
            return obj.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            boolean z10 = false;
            int i11 = 0;
            for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
                String zzd = zzd(entry.getValue(), i10 + 1);
                if (!TextUtils.isEmpty(zzd)) {
                    if (i10 > 0 && !z10) {
                        sb3.append("{");
                        i11 = sb3.length();
                        z10 = true;
                    }
                    if (sb3.length() > i11) {
                        sb3.append(", ");
                    }
                    sb3.append((String) entry.getKey());
                    sb3.append(SignatureVisitor.INSTANCEOF);
                    sb3.append(zzd);
                }
            }
            if (z10) {
                sb3.append("}");
            }
            return sb3.toString();
        }
    }

    public abstract void zzc(T t10);
}
