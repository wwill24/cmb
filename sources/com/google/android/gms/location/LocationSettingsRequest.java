package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new u0();

    /* renamed from: a  reason: collision with root package name */
    private final List f39549a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39550b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f39551c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f39552a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private boolean f39553b = false;

        /* renamed from: c  reason: collision with root package name */
        private boolean f39554c = false;

        @NonNull
        public a a(@NonNull LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f39552a.add(locationRequest);
            }
            return this;
        }

        @NonNull
        public LocationSettingsRequest b() {
            return new LocationSettingsRequest(this.f39552a, this.f39553b, this.f39554c);
        }
    }

    LocationSettingsRequest(List list, boolean z10, boolean z11) {
        this.f39549a = list;
        this.f39550b = z10;
        this.f39551c = z11;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.G(parcel, 1, Collections.unmodifiableList(this.f39549a), false);
        fe.a.g(parcel, 2, this.f39550b);
        fe.a.g(parcel, 3, this.f39551c);
        fe.a.b(parcel, a10);
    }
}
