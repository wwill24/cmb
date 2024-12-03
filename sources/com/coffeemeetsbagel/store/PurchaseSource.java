package com.coffeemeetsbagel.store;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class PurchaseSource implements Parcelable {
    public static final Parcelable.Creator<PurchaseSource> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f36721a;

    /* renamed from: b  reason: collision with root package name */
    private String f36722b;

    class a implements Parcelable.Creator<PurchaseSource> {
        a() {
        }

        /* renamed from: a */
        public PurchaseSource createFromParcel(Parcel parcel) {
            return new PurchaseSource(parcel);
        }

        /* renamed from: b */
        public PurchaseSource[] newArray(int i10) {
            return new PurchaseSource[i10];
        }
    }

    public PurchaseSource() {
    }

    public String a() {
        return this.f36722b;
    }

    public String c() {
        return this.f36721a;
    }

    public void d(String str) {
        this.f36722b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void e(String str) {
        this.f36721a = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PurchaseSource)) {
            return false;
        }
        PurchaseSource purchaseSource = (PurchaseSource) obj;
        if (!this.f36722b.equals(purchaseSource.f36722b) || !this.f36721a.equals(purchaseSource.f36721a)) {
            return false;
        }
        return true;
    }

    @NonNull
    public String toString() {
        return "PurchaseSource{screenSource='" + this.f36721a + '\'' + ", featureSource='" + this.f36722b + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f36721a);
        parcel.writeString(this.f36722b);
    }

    public PurchaseSource(String str, String str2) {
        this.f36721a = str;
        this.f36722b = str2;
    }

    protected PurchaseSource(Parcel parcel) {
        this.f36721a = parcel.readString();
        this.f36722b = parcel.readString();
    }
}
