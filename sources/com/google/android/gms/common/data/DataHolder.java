package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

@KeepName
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @NonNull
    public static final Parcelable.Creator<DataHolder> CREATOR = new c();

    /* renamed from: l  reason: collision with root package name */
    private static final a f38882l = new b(new String[0], (String) null);

    /* renamed from: a  reason: collision with root package name */
    final int f38883a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f38884b;

    /* renamed from: c  reason: collision with root package name */
    Bundle f38885c;

    /* renamed from: d  reason: collision with root package name */
    private final CursorWindow[] f38886d;

    /* renamed from: e  reason: collision with root package name */
    private final int f38887e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f38888f;

    /* renamed from: g  reason: collision with root package name */
    int[] f38889g;

    /* renamed from: h  reason: collision with root package name */
    int f38890h;

    /* renamed from: j  reason: collision with root package name */
    boolean f38891j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f38892k = true;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f38893a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList f38894b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final HashMap f38895c = new HashMap();

        /* synthetic */ a(String[] strArr, String str, ee.a aVar) {
            this.f38893a = (String[]) p.k(strArr);
        }
    }

    DataHolder(int i10, String[] strArr, CursorWindow[] cursorWindowArr, int i11, Bundle bundle) {
        this.f38883a = i10;
        this.f38884b = strArr;
        this.f38886d = cursorWindowArr;
        this.f38887e = i11;
        this.f38888f = bundle;
    }

    public Bundle S() {
        return this.f38888f;
    }

    public int Y() {
        return this.f38887e;
    }

    public final void c0() {
        this.f38885c = new Bundle();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = this.f38884b;
            if (i11 >= strArr.length) {
                break;
            }
            this.f38885c.putInt(strArr[i11], i11);
            i11++;
        }
        this.f38889g = new int[this.f38886d.length];
        int i12 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f38886d;
            if (i10 < cursorWindowArr.length) {
                this.f38889g[i10] = i12;
                i12 += this.f38886d[i10].getNumRows() - (i12 - cursorWindowArr[i10].getStartPosition());
                i10++;
            } else {
                this.f38890h = i12;
                return;
            }
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.f38891j) {
                this.f38891j = true;
                int i10 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f38886d;
                    if (i10 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i10].close();
                    i10++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.f38892k && this.f38886d.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb2.append(obj);
                sb2.append(")");
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isClosed() {
        boolean z10;
        synchronized (this) {
            z10 = this.f38891j;
        }
        return z10;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int a10 = fe.a.a(parcel);
        fe.a.D(parcel, 1, this.f38884b, false);
        fe.a.F(parcel, 2, this.f38886d, i10, false);
        fe.a.s(parcel, 3, Y());
        fe.a.j(parcel, 4, S(), false);
        fe.a.s(parcel, 1000, this.f38883a);
        fe.a.b(parcel, a10);
        if ((i10 & 1) != 0) {
            close();
        }
    }
}
