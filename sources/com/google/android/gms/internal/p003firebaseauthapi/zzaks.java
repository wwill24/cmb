package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaks  reason: invalid package */
public class zzaks extends IOException {
    private zzalp zza = null;
    private boolean zzb;

    public zzaks(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzakr zza() {
        return new zzakr("Protocol message tag had invalid wire type.");
    }

    static zzaks zzb() {
        return new zzaks("Protocol message end-group tag did not match expected tag.");
    }

    static zzaks zzc() {
        return new zzaks("Protocol message contained an invalid tag (zero).");
    }

    static zzaks zzd() {
        return new zzaks("Protocol message had invalid UTF-8.");
    }

    static zzaks zze() {
        return new zzaks("CodedInputStream encountered a malformed varint.");
    }

    static zzaks zzf() {
        return new zzaks("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzaks zzg() {
        return new zzaks("Failed to parse the message.");
    }

    static zzaks zzi() {
        return new zzaks("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzaks zzj() {
        return new zzaks("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzaks zzh(zzalp zzalp) {
        this.zza = zzalp;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzl() {
        return this.zzb;
    }

    public zzaks(String str) {
        super(str);
    }
}
