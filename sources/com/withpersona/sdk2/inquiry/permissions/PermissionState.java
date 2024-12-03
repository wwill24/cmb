package com.withpersona.sdk2.inquiry.permissions;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.mam.element.MamElements;

public final class PermissionState implements Parcelable {
    public static final Parcelable.Creator<PermissionState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Permission f27144a;

    /* renamed from: b  reason: collision with root package name */
    private final PermissionResult f27145b;

    public static final class a implements Parcelable.Creator<PermissionState> {
        /* renamed from: a */
        public final PermissionState createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new PermissionState(Permission.valueOf(parcel.readString()), PermissionResult.valueOf(parcel.readString()));
        }

        /* renamed from: b */
        public final PermissionState[] newArray(int i10) {
            return new PermissionState[i10];
        }
    }

    public PermissionState(Permission permission, PermissionResult permissionResult) {
        j.g(permission, "permission");
        j.g(permissionResult, MamElements.MamResultExtension.ELEMENT);
        this.f27144a = permission;
        this.f27145b = permissionResult;
    }

    public final PermissionResult a() {
        return this.f27145b;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionState)) {
            return false;
        }
        PermissionState permissionState = (PermissionState) obj;
        return this.f27144a == permissionState.f27144a && this.f27145b == permissionState.f27145b;
    }

    public int hashCode() {
        return (this.f27144a.hashCode() * 31) + this.f27145b.hashCode();
    }

    public String toString() {
        return "PermissionState(permission=" + this.f27144a + ", result=" + this.f27145b + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f27144a.name());
        parcel.writeString(this.f27145b.name());
    }
}
