package com.withpersona.sdk2.inquiry.shared.ui;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class NavigationUiState implements Parcelable {
    public static final Parcelable.Creator<NavigationUiState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27508a;

    /* renamed from: b  reason: collision with root package name */
    private final Function0<Unit> f27509b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27510c;

    /* renamed from: d  reason: collision with root package name */
    private final Function0<Unit> f27511d;

    public static final class a implements Parcelable.Creator<NavigationUiState> {
        /* renamed from: a */
        public final NavigationUiState createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            boolean z10 = true;
            boolean z11 = parcel.readInt() != 0;
            Function0 function0 = (Function0) parcel.readSerializable();
            if (parcel.readInt() == 0) {
                z10 = false;
            }
            return new NavigationUiState(z11, function0, z10, (Function0) parcel.readSerializable());
        }

        /* renamed from: b */
        public final NavigationUiState[] newArray(int i10) {
            return new NavigationUiState[i10];
        }
    }

    public NavigationUiState(boolean z10, Function0<Unit> function0, boolean z11, Function0<Unit> function02) {
        this.f27508a = z10;
        this.f27509b = function0;
        this.f27510c = z11;
        this.f27511d = function02;
    }

    public final Function0<Unit> a() {
        return this.f27509b;
    }

    public final Function0<Unit> c() {
        return this.f27511d;
    }

    public final boolean d() {
        return this.f27508a;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f27510c;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeInt(this.f27508a ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f27509b);
        parcel.writeInt(this.f27510c ? 1 : 0);
        parcel.writeSerializable((Serializable) this.f27511d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavigationUiState(boolean z10, Function0 function0, boolean z11, Function0 function02, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, (i10 & 2) != 0 ? null : function0, z11, (i10 & 8) != 0 ? null : function02);
    }
}
