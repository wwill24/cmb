package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f38236a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38237b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f38238c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38239d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f38240a = false;

        /* renamed from: b  reason: collision with root package name */
        private boolean f38241b = true;

        /* renamed from: c  reason: collision with root package name */
        private int f38242c = 1;

        @NonNull
        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(2, this.f38240a, this.f38241b, false, this.f38242c);
        }
    }

    CredentialPickerConfig(int i10, boolean z10, boolean z11, boolean z12, int i11) {
        this.f38236a = i10;
        this.f38237b = z10;
        this.f38238c = z11;
        if (i10 < 2) {
            this.f38239d = true == z12 ? 3 : 1;
        } else {
            this.f38239d = i11;
        }
    }

    @Deprecated
    public boolean S() {
        return this.f38239d == 3;
    }

    public boolean Y() {
        return this.f38237b;
    }

    public boolean c0() {
        return this.f38238c;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.g(parcel, 1, Y());
        fe.a.g(parcel, 2, c0());
        fe.a.g(parcel, 3, S());
        fe.a.s(parcel, 4, this.f38239d);
        fe.a.s(parcel, 1000, this.f38236a);
        fe.a.b(parcel, a10);
    }
}
