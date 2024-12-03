package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class d extends i {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f38095a;

    d(List<k> list) {
        if (list != null) {
            this.f38095a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public List<k> c() {
        return this.f38095a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return this.f38095a.equals(((i) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f38095a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f38095a + "}";
    }
}
