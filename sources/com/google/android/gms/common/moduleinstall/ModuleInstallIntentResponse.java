package com.google.android.gms.common.moduleinstall;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import ie.f;

public class ModuleInstallIntentResponse extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f39095a;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.f39095a = pendingIntent;
    }

    public PendingIntent S() {
        return this.f39095a;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.A(parcel, 1, S(), i10, false);
        a.b(parcel, a10);
    }
}
