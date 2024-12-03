package com.google.android.gms.internal.gtm;

import java.io.IOException;

public class zzvk extends IOException {
    private zzwk zza = null;
    private boolean zzb;

    public zzvk(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzvj zza() {
        return new zzvj("Protocol message tag had invalid wire type.");
    }

    static zzvk zzb() {
        return new zzvk("Protocol message end-group tag did not match expected tag.");
    }

    static zzvk zzc() {
        return new zzvk("Protocol message contained an invalid tag (zero).");
    }

    static zzvk zzd() {
        return new zzvk("Protocol message had invalid UTF-8.");
    }

    static zzvk zze() {
        return new zzvk("CodedInputStream encountered a malformed varint.");
    }

    static zzvk zzf() {
        return new zzvk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzvk zzg() {
        return new zzvk("Failed to parse the message.");
    }

    static zzvk zzi() {
        return new zzvk("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzvk zzj() {
        return new zzvk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzvk zzh(zzwk zzwk) {
        this.zza = zzwk;
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

    public zzvk(String str) {
        super(str);
    }
}
