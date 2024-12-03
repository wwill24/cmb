package com.google.android.recaptcha.internal;

public final class zzbk {
    public static final zzbk zza = new zzbk();

    private zzbk() {
    }

    public static final Class zza(Object obj) {
        Class<zzcr> cls;
        if (obj instanceof Class) {
            return (Class) obj;
        }
        if (obj instanceof Integer) {
            int intValue = ((Number) obj).intValue();
            if (intValue == 1) {
                cls = Integer.TYPE;
            } else if (intValue == 2) {
                cls = Short.TYPE;
            } else if (intValue == 3) {
                cls = Byte.TYPE;
            } else if (intValue == 4) {
                cls = Long.TYPE;
            } else if (intValue == 5) {
                cls = Character.TYPE;
            } else if (intValue == 6) {
                cls = Float.TYPE;
            } else if (intValue == 7) {
                cls = Double.TYPE;
            } else if (intValue == 8) {
                cls = Boolean.TYPE;
            } else if (intValue == 9) {
                cls = zzcr.class;
            } else {
                cls = null;
            }
            if (cls != null) {
                return cls;
            }
            throw new zzt(4, 6, (Throwable) null);
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (zzbj.zzc(str)) {
                try {
                    return Class.forName(str);
                } catch (Exception e10) {
                    throw new zzt(6, 8, e10);
                }
            } else {
                throw new zzt(6, 47, (Throwable) null);
            }
        } else {
            throw new zzt(6, 8, (Throwable) null);
        }
    }
}
