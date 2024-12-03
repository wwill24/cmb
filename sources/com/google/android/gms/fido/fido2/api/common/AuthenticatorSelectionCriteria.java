package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;
import fe.a;

public class AuthenticatorSelectionCriteria extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AuthenticatorSelectionCriteria> CREATOR = new s();

    /* renamed from: a  reason: collision with root package name */
    private final Attachment f39267a;

    /* renamed from: b  reason: collision with root package name */
    private final Boolean f39268b;

    /* renamed from: c  reason: collision with root package name */
    private final zzat f39269c;

    /* renamed from: d  reason: collision with root package name */
    private final ResidentKeyRequirement f39270d;

    AuthenticatorSelectionCriteria(String str, Boolean bool, String str2, String str3) {
        Attachment attachment;
        zzat zzat;
        ResidentKeyRequirement residentKeyRequirement = null;
        if (str == null) {
            attachment = null;
        } else {
            try {
                attachment = Attachment.a(str);
            } catch (Attachment.UnsupportedAttachmentException | ResidentKeyRequirement.UnsupportedResidentKeyRequirementException | zzas e10) {
                throw new IllegalArgumentException(e10);
            }
        }
        this.f39267a = attachment;
        this.f39268b = bool;
        if (str2 == null) {
            zzat = null;
        } else {
            zzat = zzat.a(str2);
        }
        this.f39269c = zzat;
        if (str3 != null) {
            residentKeyRequirement = ResidentKeyRequirement.a(str3);
        }
        this.f39270d = residentKeyRequirement;
    }

    public String S() {
        Attachment attachment = this.f39267a;
        if (attachment == null) {
            return null;
        }
        return attachment.toString();
    }

    public Boolean Y() {
        return this.f39268b;
    }

    public String c0() {
        ResidentKeyRequirement residentKeyRequirement = this.f39270d;
        if (residentKeyRequirement == null) {
            return null;
        }
        return residentKeyRequirement.toString();
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AuthenticatorSelectionCriteria)) {
            return false;
        }
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
        if (!n.b(this.f39267a, authenticatorSelectionCriteria.f39267a) || !n.b(this.f39268b, authenticatorSelectionCriteria.f39268b) || !n.b(this.f39269c, authenticatorSelectionCriteria.f39269c) || !n.b(this.f39270d, authenticatorSelectionCriteria.f39270d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return n.c(this.f39267a, this.f39268b, this.f39269c, this.f39270d);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        String str;
        int a10 = a.a(parcel);
        a.C(parcel, 2, S(), false);
        a.i(parcel, 3, Y(), false);
        zzat zzat = this.f39269c;
        if (zzat == null) {
            str = null;
        } else {
            str = zzat.toString();
        }
        a.C(parcel, 4, str, false);
        a.C(parcel, 5, c0(), false);
        a.b(parcel, a10);
    }
}
