package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class da {

    /* renamed from: a  reason: collision with root package name */
    final String f39726a;

    /* renamed from: b  reason: collision with root package name */
    final int f39727b;

    /* renamed from: c  reason: collision with root package name */
    Boolean f39728c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f39729d;

    /* renamed from: e  reason: collision with root package name */
    Long f39730e;

    /* renamed from: f  reason: collision with root package name */
    Long f39731f;

    da(String str, int i10) {
        this.f39726a = str;
        this.f39727b = i10;
    }

    private static Boolean d(String str, int i10, boolean z10, String str2, List list, String str3, q3 q3Var) {
        int i11;
        if (i10 == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && i10 != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i10 - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (true != z10) {
                    i11 = 66;
                } else {
                    i11 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i11).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (q3Var != null) {
                        q3Var.w().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean e(BigDecimal bigDecimal, zzer zzer, double d10) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        p.k(zzer);
        if (zzer.zzg()) {
            boolean z10 = true;
            if (zzer.zzm() != 1) {
                if (zzer.zzm() == 5) {
                    if (!zzer.zzk() || !zzer.zzj()) {
                        return null;
                    }
                } else if (!zzer.zzh()) {
                    return null;
                }
                int zzm = zzer.zzm();
                if (zzer.zzm() == 5) {
                    if (p9.P(zzer.zze()) && p9.P(zzer.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzer.zze());
                            bigDecimal3 = new BigDecimal(zzer.zzd());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!p9.P(zzer.zzc())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(zzer.zzc());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                }
                int i10 = zzm - 1;
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4 || bigDecimal2 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                z10 = false;
                            }
                            return Boolean.valueOf(z10);
                        } else if (bigDecimal4 == null) {
                            return null;
                        } else {
                            if (d10 != 0.0d) {
                                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d10).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d10).multiply(new BigDecimal(2)))) >= 0) {
                                    z10 = false;
                                }
                                return Boolean.valueOf(z10);
                            }
                            if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                z10 = false;
                            }
                            return Boolean.valueOf(z10);
                        }
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z10 = false;
                        }
                        return Boolean.valueOf(z10);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                        z10 = false;
                    }
                    return Boolean.valueOf(z10);
                }
            }
        }
        return null;
    }

    static Boolean f(String str, zzey zzey, q3 q3Var) {
        String str2;
        List list;
        String str3;
        p.k(zzey);
        if (str == null || !zzey.zzi() || zzey.zzj() == 1) {
            return null;
        }
        if (zzey.zzj() == 7) {
            if (zzey.zza() == 0) {
                return null;
            }
        } else if (!zzey.zzh()) {
            return null;
        }
        int zzj = zzey.zzj();
        boolean zzf = zzey.zzf();
        if (zzf || zzj == 2 || zzj == 7) {
            str2 = zzey.zzd();
        } else {
            str2 = zzey.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str4 = str2;
        if (zzey.zza() == 0) {
            list = null;
        } else {
            List<String> zze = zzey.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                for (String upperCase : zze) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
            list = zze;
        }
        if (zzj == 2) {
            str3 = str4;
        } else {
            str3 = null;
        }
        return d(str, zzj, zzf, str4, list, str3, q3Var);
    }

    static Boolean g(double d10, zzer zzer) {
        try {
            return e(new BigDecimal(d10), zzer, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean h(long j10, zzer zzer) {
        try {
            return e(new BigDecimal(j10), zzer, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean i(String str, zzer zzer) {
        if (!p9.P(str)) {
            return null;
        }
        try {
            return e(new BigDecimal(str), zzer, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean j(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    /* access modifiers changed from: package-private */
    public abstract int a();

    /* access modifiers changed from: package-private */
    public abstract boolean b();

    /* access modifiers changed from: package-private */
    public abstract boolean c();
}
