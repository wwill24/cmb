package com.google.android.gms.internal.play_billing;

import java.io.IOException;

public class zzci extends IOException {
    private zzdf zza = null;

    public zzci(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzch zza() {
        return new zzch("Protocol message tag had invalid wire type.");
    }

    static zzci zzb() {
        return new zzci("Protocol message contained an invalid tag (zero).");
    }

    static zzci zzc() {
        return new zzci("Protocol message had invalid UTF-8.");
    }

    static zzci zzd() {
        return new zzci("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzci zze() {
        return new zzci("Failed to parse the message.");
    }

    static zzci zzg() {
        return new zzci("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzci zzf(zzdf zzdf) {
        this.zza = zzdf;
        return this;
    }

    public zzci(String str) {
        super(str);
    }
}
