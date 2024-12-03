package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.fido.zzar;
import fe.a;
import java.util.Arrays;

public class TokenBinding extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<TokenBinding> CREATOR = new i();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final TokenBinding f39361c = new TokenBinding(TokenBindingStatus.SUPPORTED.toString(), (String) null);
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final TokenBinding f39362d = new TokenBinding(TokenBindingStatus.NOT_SUPPORTED.toString(), (String) null);
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TokenBindingStatus f39363a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39364b;

    public enum TokenBindingStatus implements Parcelable {
        PRESENT("present"),
        SUPPORTED("supported"),
        NOT_SUPPORTED("not-supported");
        
        @NonNull
        public static final Parcelable.Creator<TokenBindingStatus> CREATOR = null;
        @NonNull
        private final String zzb;

        static {
            CREATOR = new h();
        }

        private TokenBindingStatus(@NonNull String str) {
            this.zzb = str;
        }

        @NonNull
        public static TokenBindingStatus a(@NonNull String str) throws UnsupportedTokenBindingStatusException {
            for (TokenBindingStatus tokenBindingStatus : values()) {
                if (str.equals(tokenBindingStatus.zzb)) {
                    return tokenBindingStatus;
                }
            }
            throw new UnsupportedTokenBindingStatusException(str);
        }

        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return this.zzb;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i10) {
            parcel.writeString(this.zzb);
        }
    }

    public static class UnsupportedTokenBindingStatusException extends Exception {
        public UnsupportedTokenBindingStatusException(@NonNull String str) {
            super(String.format("TokenBindingStatus %s not supported", new Object[]{str}));
        }
    }

    TokenBinding(@NonNull String str, String str2) {
        p.k(str);
        try {
            this.f39363a = TokenBindingStatus.a(str);
            this.f39364b = str2;
        } catch (UnsupportedTokenBindingStatusException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public String S() {
        return this.f39364b;
    }

    @NonNull
    public String Y() {
        return this.f39363a.toString();
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof TokenBinding)) {
            return false;
        }
        TokenBinding tokenBinding = (TokenBinding) obj;
        if (!zzar.zza(this.f39363a, tokenBinding.f39363a) || !zzar.zza(this.f39364b, tokenBinding.f39364b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39363a, this.f39364b});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, Y(), false);
        a.C(parcel, 3, S(), false);
        a.b(parcel, a10);
    }
}
