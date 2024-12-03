package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.n;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import fe.a;
import java.util.Locale;

public final class WebImage extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<WebImage> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f38908a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f38909b;

    /* renamed from: c  reason: collision with root package name */
    private final int f38910c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38911d;

    WebImage(int i10, Uri uri, int i11, int i12) {
        this.f38908a = i10;
        this.f38909b = uri;
        this.f38910c = i11;
        this.f38911d = i12;
    }

    @NonNull
    public Uri S() {
        return this.f38909b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (n.b(this.f38909b, webImage.f38909b) && this.f38910c == webImage.f38910c && this.f38911d == webImage.f38911d) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getHeight() {
        return this.f38911d;
    }

    public int getWidth() {
        return this.f38910c;
    }

    public int hashCode() {
        return n.c(this.f38909b, Integer.valueOf(this.f38910c), Integer.valueOf(this.f38911d));
    }

    @NonNull
    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f38910c), Integer.valueOf(this.f38911d), this.f38909b.toString()});
    }

    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.s(parcel, 1, this.f38908a);
        a.A(parcel, 2, S(), i10, false);
        a.s(parcel, 3, getWidth());
        a.s(parcel, 4, getHeight());
        a.b(parcel, a10);
    }
}
