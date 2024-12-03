package com.withpersona.sdk2.inquiry.steps.ui.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.g;
import com.squareup.moshi.h;
import com.squareup.moshi.i;
import com.squareup.moshi.q;
import com.squareup.moshi.v;
import com.withpersona.sdk2.inquiry.steps.ui.network.d;
import defpackage.e;
import gk.f;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.amp.packet.AMPExtension;

@i(generateAdapter = false)
public final class JsonLogicBoolean implements Parcelable {
    public static final Parcelable.Creator<JsonLogicBoolean> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f27598c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f27599a;

    /* renamed from: b  reason: collision with root package name */
    private final f f27600b = b.b(new JsonLogicBoolean$parsedRules$2(this));

    public static final class Companion extends h<JsonLogicBoolean> {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @v
        public void toJson(q qVar, JsonLogicBoolean jsonLogicBoolean) {
            j.g(qVar, "writer");
        }

        @com.squareup.moshi.f
        public JsonLogicBoolean fromJson(JsonReader jsonReader) {
            j.g(jsonReader, "reader");
            return new JsonLogicBoolean(jsonReader.x().y1().Q());
        }
    }

    public static final class a implements Parcelable.Creator<JsonLogicBoolean> {
        /* renamed from: a */
        public final JsonLogicBoolean createFromParcel(Parcel parcel) {
            j.g(parcel, "parcel");
            return new JsonLogicBoolean(parcel.readString());
        }

        /* renamed from: b */
        public final JsonLogicBoolean[] newArray(int i10) {
            return new JsonLogicBoolean[i10];
        }
    }

    public JsonLogicBoolean(String str) {
        j.g(str, AMPExtension.Rule.ELEMENT);
        this.f27599a = str;
    }

    private final d a() {
        return (d) this.f27600b.getValue();
    }

    @g(ignore = true)
    private static /* synthetic */ void getParsedRules$annotations() {
    }

    public final String c() {
        return this.f27599a;
    }

    public final Boolean d(Map<String, ? extends Object> map, Object obj) {
        boolean z10;
        j.g(map, "formValues");
        d a10 = a();
        if (a10 == null) {
            return null;
        }
        if (a10 instanceof d.a) {
            d a11 = JsonLogicFieldKt.b();
            Map<String, Object> a12 = ((d.a) a10).a();
            Pair a13 = gk.h.a("value", obj);
            boolean z11 = true;
            e a14 = a11.a(a12, h0.l(gk.h.a("form", map), a13));
            if (a14 instanceof e.b) {
                Object a15 = ((e.b) a14).a();
                if (a15 instanceof Boolean) {
                    return (Boolean) a15;
                }
                return null;
            }
            if (j.b(a14, e.a.c.f29580a)) {
                z10 = true;
            } else {
                z10 = j.b(a14, e.a.C0340a.f29578a);
            }
            if (!z10) {
                z11 = j.b(a14, e.a.b.f29579a);
            }
            if (z11) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        } else if (a10 instanceof d.b) {
            d.b bVar = (d.b) a10;
            if (bVar.a() instanceof Boolean) {
                return (Boolean) bVar.a();
            }
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof JsonLogicBoolean) && j.b(this.f27599a, ((JsonLogicBoolean) obj).f27599a);
    }

    public int hashCode() {
        return this.f27599a.hashCode();
    }

    public String toString() {
        return "JsonLogicBoolean(rule=" + this.f27599a + PropertyUtils.MAPPED_DELIM2;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        j.g(parcel, "out");
        parcel.writeString(this.f27599a);
    }
}
