package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;

public class UserProfileChangeRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzaw();
    private final String zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final Uri zze;

    public static class Builder {
        private String zza;
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;

        @NonNull
        public UserProfileChangeRequest build() {
            String str;
            String str2 = this.zza;
            Uri uri = this.zzb;
            if (uri == null) {
                str = null;
            } else {
                str = uri.toString();
            }
            return new UserProfileChangeRequest(str2, str, this.zzc, this.zzd);
        }

        public String getDisplayName() {
            return this.zza;
        }

        public Uri getPhotoUri() {
            return this.zzb;
        }

        @NonNull
        public Builder setDisplayName(String str) {
            if (str == null) {
                this.zzc = true;
            } else {
                this.zza = str;
            }
            return this;
        }

        @NonNull
        public Builder setPhotoUri(Uri uri) {
            if (uri == null) {
                this.zzd = true;
            } else {
                this.zzb = uri;
            }
            return this;
        }
    }

    UserProfileChangeRequest(String str, String str2, boolean z10, boolean z11) {
        Uri uri;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z10;
        this.zzd = z11;
        if (TextUtils.isEmpty(str2)) {
            uri = null;
        } else {
            uri = Uri.parse(str2);
        }
        this.zze = uri;
    }

    public String getDisplayName() {
        return this.zza;
    }

    public Uri getPhotoUri() {
        return this.zze;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.C(parcel, 2, getDisplayName(), false);
        a.C(parcel, 3, this.zzb, false);
        a.g(parcel, 4, this.zzc);
        a.g(parcel, 5, this.zzd);
        a.b(parcel, a10);
    }

    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
