package com.google.android.recaptcha.internal;

public final class zzlu extends zzgo implements zzhz {
    /* access modifiers changed from: private */
    public static final zzlu zzb;
    private int zzd = 0;
    private Object zze;

    static {
        zzlu zzlu = new zzlu();
        zzb = zzlu;
        zzgo.zzC(zzlu.class, zzlu);
    }

    private zzlu() {
    }

    /* access modifiers changed from: protected */
    public final Object zzh(int i10, Object obj, Object obj2) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0014\u0001\u0000\u0001\u0014\u0014\u0000\u0000\u0000\u0001?\u0000\u0002?\u0000\u0003?\u0000\u0004?\u0000\u0005?\u0000\u0006?\u0000\u0007?\u0000\b?\u0000\t?\u0000\n?\u0000\u000b?\u0000\f?\u0000\r?\u0000\u000e?\u0000\u000f?\u0000\u0010?\u0000\u0011?\u0000\u0012?\u0000\u0013?\u0000\u0014?\u0000", new Object[]{"zze", "zzd"});
        } else if (i11 == 3) {
            return new zzlu();
        } else {
            if (i11 == 4) {
                return new zzlt((zzls) null);
            }
            if (i11 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
