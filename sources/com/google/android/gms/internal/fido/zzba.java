package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Set;

public abstract class zzba extends zzaw implements Set {
    private transient zzaz zza;

    zzba() {
    }

    static int zzf(int i10) {
        int max = Math.max(i10, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    public static zzba zzi(Object obj, Object obj2) {
        return zzk(2, obj, obj2);
    }

    private static zzba zzk(int i10, Object... objArr) {
        if (i10 == 0) {
            return zzbd.zza;
        }
        if (i10 != 1) {
            int zzf = zzf(i10);
            Object[] objArr2 = new Object[zzf];
            int i11 = zzf - 1;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i12 < i10) {
                Object obj = objArr[i12];
                if (obj != null) {
                    int hashCode = obj.hashCode();
                    int zza2 = zzav.zza(hashCode);
                    while (true) {
                        int i15 = zza2 & i11;
                        Object obj2 = objArr2[i15];
                        if (obj2 != null) {
                            if (obj2.equals(obj)) {
                                break;
                            }
                            zza2++;
                        } else {
                            objArr[i14] = obj;
                            objArr2[i15] = obj;
                            i13 += hashCode;
                            i14++;
                            break;
                        }
                    }
                    i12++;
                } else {
                    throw new NullPointerException("at index " + i12);
                }
            }
            Arrays.fill(objArr, i14, i10, (Object) null);
            if (i14 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new zzbe(obj3);
            }
            if (zzf(i14) < zzf / 2) {
                return zzk(i14, objArr);
            }
            if (i14 <= 0) {
                objArr = Arrays.copyOf(objArr, i14);
            }
            return new zzbd(objArr, i13, objArr2, i11, i14);
        }
        Object obj4 = objArr[0];
        obj4.getClass();
        return new zzbe(obj4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzba) && zzj() && ((zzba) obj).zzj() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11 = 0;
        for (Object next : this) {
            if (next != null) {
                i10 = next.hashCode();
            } else {
                i10 = 0;
            }
            i11 += i10;
        }
        return i11;
    }

    /* renamed from: zzd */
    public abstract zzbf iterator();

    public final zzaz zzg() {
        zzaz zzaz = this.zza;
        if (zzaz != null) {
            return zzaz;
        }
        zzaz zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* access modifiers changed from: package-private */
    public zzaz zzh() {
        return zzaz.zzg(toArray());
    }

    /* access modifiers changed from: package-private */
    public boolean zzj() {
        return false;
    }
}
