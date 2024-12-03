package com.google.android.gms.internal.mlkit_common;

import android.system.OsConstants;
import android.system.StructStat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.Callable;

final class zzq {
    final long zza;
    final long zzb;
    final boolean zzc;

    private zzq(long j10, long j11, boolean z10) {
        this.zza = j10;
        this.zzb = j11;
        this.zzc = z10;
    }

    static zzq zza(FileDescriptor fileDescriptor) throws IOException {
        StructStat structStat = (StructStat) zzc(new zzl(fileDescriptor));
        return new zzq(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    static zzq zzb(String str) throws IOException {
        StructStat structStat = (StructStat) zzc(new zzk(str));
        return new zzq(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    private static Object zzc(Callable callable) throws IOException {
        try {
            return callable.call();
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }
}
