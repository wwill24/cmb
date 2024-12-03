package com.google.android.gms.tagmanager;

final class zzfu extends Number implements Comparable<zzfu> {
    private double zza;
    private long zzb;
    private final boolean zzc = true;

    private zzfu(long j10) {
        this.zzb = j10;
    }

    public static zzfu zzd(long j10) {
        return new zzfu(j10);
    }

    public final byte byteValue() {
        return (byte) ((int) zzb());
    }

    public final double doubleValue() {
        return this.zzc ? (double) this.zzb : this.zza;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzfu) && compareTo((zzfu) obj) == 0;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(zzb()).hashCode();
    }

    public final int intValue() {
        return (int) zzb();
    }

    public final long longValue() {
        return zzb();
    }

    public final short shortValue() {
        return (short) ((int) zzb());
    }

    public final String toString() {
        return this.zzc ? Long.toString(this.zzb) : Double.toString(this.zza);
    }

    /* renamed from: zza */
    public final int compareTo(zzfu zzfu) {
        if (!this.zzc || !zzfu.zzc) {
            return Double.compare(doubleValue(), zzfu.doubleValue());
        }
        return new Long(this.zzb).compareTo(Long.valueOf(zzfu.zzb));
    }

    public final long zzb() {
        return this.zzc ? this.zzb : (long) this.zza;
    }

    public final boolean zzf() {
        return !this.zzc;
    }

    public final boolean zzg() {
        return this.zzc;
    }
}
