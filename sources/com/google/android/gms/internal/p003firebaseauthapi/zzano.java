package com.google.android.gms.internal.p003firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzano  reason: invalid package */
public final class zzano {
    public static final zzamt zza;
    public static final zzamt zzb;
    public static final zzamt zzc;
    private static final ThreadLocal zzd = new zzann();
    private static final Method zze = zzc("now");
    private static final Method zzf = zzc("getEpochSecond");
    private static final Method zzg = zzc("getNano");

    static {
        zzams zzc2 = zzamt.zzc();
        zzc2.zzb(-62135596800L);
        zzc2.zza(0);
        zza = (zzamt) zzc2.zzi();
        zzams zzc3 = zzamt.zzc();
        zzc3.zzb(253402300799L);
        zzc3.zza(999999999);
        zzb = (zzamt) zzc3.zzi();
        zzams zzc4 = zzamt.zzc();
        zzc4.zzb(0);
        zzc4.zza(0);
        zzc = (zzamt) zzc4.zzi();
    }

    public static zzamt zza(zzamt zzamt) {
        long zzb2 = zzamt.zzb();
        int i10 = (zzb2 > -62135596800L ? 1 : (zzb2 == -62135596800L ? 0 : -1));
        int zza2 = zzamt.zza();
        if (i10 >= 0 && zzb2 <= 253402300799L && zza2 >= 0 && zza2 < 1000000000) {
            return zzamt;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzb2), Integer.valueOf(zza2)}));
    }

    public static zzamt zzb(String str) throws ParseException {
        String str2;
        int i10;
        int indexOf = str.indexOf(84);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 != -1) {
                String substring = str.substring(0, indexOf2);
                int indexOf3 = substring.indexOf(46);
                if (indexOf3 != -1) {
                    String substring2 = substring.substring(0, indexOf3);
                    str2 = substring.substring(indexOf3 + 1);
                    substring = substring2;
                } else {
                    str2 = "";
                }
                long time = ((SimpleDateFormat) zzd.get()).parse(substring).getTime() / 1000;
                if (str2.isEmpty()) {
                    i10 = 0;
                } else {
                    i10 = 0;
                    for (int i11 = 0; i11 < 9; i11++) {
                        i10 *= 10;
                        if (i11 < str2.length()) {
                            if (str2.charAt(i11) < '0' || str2.charAt(i11) > '9') {
                                throw new ParseException("Invalid nanoseconds.", 0);
                            }
                            i10 += str2.charAt(i11) - '0';
                        }
                    }
                }
                int i12 = indexOf2 + 1;
                if (str.charAt(indexOf2) != 'Z') {
                    String substring3 = str.substring(i12);
                    int indexOf4 = substring3.indexOf(58);
                    if (indexOf4 != -1) {
                        String substring4 = substring3.substring(0, indexOf4);
                        String substring5 = substring3.substring(indexOf4 + 1);
                        char charAt = str.charAt(indexOf2);
                        long parseLong = ((Long.parseLong(substring4) * 60) + Long.parseLong(substring5)) * 60;
                        if (charAt == '+') {
                            time -= parseLong;
                        } else {
                            time += parseLong;
                        }
                    } else {
                        throw new ParseException("Invalid offset value: ".concat(substring3), 0);
                    }
                } else if (str.length() != i12) {
                    throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(indexOf2) + "\"", 0);
                }
                if (i10 <= -1000000000 || i10 >= 1000000000) {
                    try {
                        time = zzbb.zza(time, (long) (i10 / 1000000000));
                        i10 %= 1000000000;
                    } catch (IllegalArgumentException e10) {
                        ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
                        parseException.initCause(e10);
                        throw parseException;
                    }
                }
                if (i10 < 0) {
                    i10 += 1000000000;
                    time = zzbb.zzb(time, 1);
                }
                zzams zzc2 = zzamt.zzc();
                zzc2.zzb(time);
                zzc2.zza(i10);
                zzamt zzamt = (zzamt) zzc2.zzi();
                zza(zzamt);
                return zzamt;
            }
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
    }

    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
