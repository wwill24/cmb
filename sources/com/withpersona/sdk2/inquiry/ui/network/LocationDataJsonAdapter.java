package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LocationDataJsonAdapter extends h<LocationData> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29435a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29436b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f29437c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<LocationData> f29438d;

    public LocationDataJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("id", "address_street_1", "address_street_2", "address_city", "address_subdivision", "address_postal_code", "address_country_code", "address_business_name");
        j.f(a10, "of(\"id\", \"address_street… \"address_business_name\")");
        this.f29435a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "id");
        j.f(f10, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.f29436b = f10;
        h<String> f11 = sVar.f(cls, n0.e(), "addressStreet1");
        j.f(f11, "moshi.adapter(String::cl…ySet(), \"addressStreet1\")");
        this.f29437c = f11;
    }

    /* renamed from: a */
    public LocationData fromJson(JsonReader jsonReader) {
        String str;
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f29435a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str2 = this.f29436b.fromJson(jsonReader2);
                    if (str2 != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x("id", "id", jsonReader2);
                        j.f(x10, "unexpectedNull(\"id\", \"id\", reader)");
                        throw x10;
                    }
                case 1:
                    str3 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -3;
                    break;
                case 2:
                    str4 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -5;
                    break;
                case 3:
                    str5 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -9;
                    break;
                case 4:
                    str6 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -17;
                    break;
                case 5:
                    str7 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -33;
                    break;
                case 6:
                    str8 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -65;
                    break;
                case 7:
                    str9 = this.f29437c.fromJson(jsonReader2);
                    i10 &= -129;
                    break;
            }
        }
        jsonReader.e();
        if (i10 != -255) {
            Constructor<LocationData> constructor = this.f29438d;
            if (constructor == null) {
                str = "missingProperty(\"id\", \"id\", reader)";
                constructor = LocationData.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls, cls, cls, cls, cls, Integer.TYPE, c.f18958c});
                this.f29438d = constructor;
                j.f(constructor, "LocationData::class.java…his.constructorRef = it }");
            } else {
                str = "missingProperty(\"id\", \"id\", reader)";
            }
            Object[] objArr = new Object[10];
            if (str2 != null) {
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = str5;
                objArr[4] = str6;
                objArr[5] = str7;
                objArr[6] = str8;
                objArr[7] = str9;
                objArr[8] = Integer.valueOf(i10);
                objArr[9] = null;
                LocationData newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("id", "id", jsonReader2);
            j.f(o10, str);
            throw o10;
        } else if (str2 != null) {
            return new LocationData(str2, str3, str4, str5, str6, str7, str8, str9);
        } else {
            JsonDataException o11 = c.o("id", "id", jsonReader2);
            j.f(o11, "missingProperty(\"id\", \"id\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, LocationData locationData) {
        j.g(qVar, "writer");
        if (locationData != null) {
            qVar.c();
            qVar.u("id");
            this.f29436b.toJson(qVar, locationData.h());
            qVar.u("address_street_1");
            this.f29437c.toJson(qVar, locationData.e());
            qVar.u("address_street_2");
            this.f29437c.toJson(qVar, locationData.f());
            qVar.u("address_city");
            this.f29437c.toJson(qVar, locationData.b());
            qVar.u("address_subdivision");
            this.f29437c.toJson(qVar, locationData.g());
            qVar.u("address_postal_code");
            this.f29437c.toJson(qVar, locationData.d());
            qVar.u("address_country_code");
            this.f29437c.toJson(qVar, locationData.c());
            qVar.u("address_business_name");
            this.f29437c.toJson(qVar, locationData.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("LocationData");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
