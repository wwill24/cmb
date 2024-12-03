package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f8869a;

    /* renamed from: b  reason: collision with root package name */
    private final b f8870b;

    /* renamed from: c  reason: collision with root package name */
    private final List f8871c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f8872a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8873b;

        /* renamed from: c  reason: collision with root package name */
        private final String f8874c;

        /* synthetic */ a(b bVar, l1 l1Var) {
            this.f8872a = bVar.optString("productId");
            this.f8873b = bVar.optString("productType");
            String optString = bVar.optString("offerToken");
            this.f8874c = true == optString.isEmpty() ? null : optString;
        }

        @NonNull
        public String a() {
            return this.f8872a;
        }

        public String b() {
            return this.f8874c;
        }

        @NonNull
        public String c() {
            return this.f8873b;
        }

        public final boolean equals(Object obj) {
            String str;
            String b10;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f8872a.equals(aVar.a()) || !this.f8873b.equals(aVar.c()) || ((str = this.f8874c) != (b10 = aVar.b()) && (str == null || !str.equals(b10)))) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f8872a, this.f8873b, this.f8874c});
        }

        @NonNull
        public final String toString() {
            return String.format("{id: %s, type: %s, offer token: %s}", new Object[]{this.f8872a, this.f8873b, this.f8874c});
        }
    }

    d(String str) throws JSONException {
        this.f8869a = str;
        b bVar = new b(str);
        this.f8870b = bVar;
        org.json.a optJSONArray = bVar.optJSONArray("products");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.o(); i10++) {
                b s10 = optJSONArray.s(i10);
                if (s10 != null) {
                    arrayList.add(new a(s10, (l1) null));
                }
            }
        }
        this.f8871c = arrayList;
    }
}
