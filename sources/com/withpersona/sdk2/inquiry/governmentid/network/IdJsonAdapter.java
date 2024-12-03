package com.withpersona.sdk2.inquiry.governmentid.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;

public final class IdJsonAdapter extends h<Id> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25865a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25866b;

    /* renamed from: c  reason: collision with root package name */
    private final h<List<String>> f25867c;

    /* renamed from: d  reason: collision with root package name */
    private final h<Id.IdIcon> f25868d;

    /* renamed from: e  reason: collision with root package name */
    private final h<List<CapturePageConfig>> f25869e;

    /* renamed from: f  reason: collision with root package name */
    private final h<Boolean> f25870f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Constructor<Id> f25871g;

    public IdJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("class", "requiresSides", SoftwareInfoForm.ICON, "capturePageConfigs", "supportsPassportNfc");
        j.f(a10, "of(\"class\", \"requiresSid…\", \"supportsPassportNfc\")");
        this.f25865a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "class");
        j.f(f10, "moshi.adapter(String::cl…mptySet(),\n      \"class\")");
        this.f25866b = f10;
        h<List<String>> f11 = sVar.f(w.j(List.class, cls), n0.e(), "requiresSides");
        j.f(f11, "moshi.adapter(Types.newP…),\n      \"requiresSides\")");
        this.f25867c = f11;
        h<Id.IdIcon> f12 = sVar.f(Id.IdIcon.class, n0.e(), SoftwareInfoForm.ICON);
        j.f(f12, "moshi.adapter(Id.IdIcon:…      emptySet(), \"icon\")");
        this.f25868d = f12;
        h<List<CapturePageConfig>> f13 = sVar.f(w.j(List.class, CapturePageConfig.class), n0.e(), "capturePageConfigs");
        j.f(f13, "moshi.adapter(Types.newP…(), \"capturePageConfigs\")");
        this.f25869e = f13;
        h<Boolean> f14 = sVar.f(Boolean.class, n0.e(), "supportsPassportNfc");
        j.f(f14, "moshi.adapter(Boolean::c…), \"supportsPassportNfc\")");
        this.f25870f = f14;
    }

    /* renamed from: a */
    public Id fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        List list = null;
        Id.IdIcon idIcon = null;
        List list2 = null;
        Boolean bool = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f25865a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25866b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("class_", "class", jsonReader2);
                    j.f(x10, "unexpectedNull(\"class_\",…ass\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                list = this.f25867c.fromJson(jsonReader2);
                if (list == null) {
                    JsonDataException x11 = c.x("requiresSides", "requiresSides", jsonReader2);
                    j.f(x11, "unexpectedNull(\"requires… \"requiresSides\", reader)");
                    throw x11;
                }
            } else if (L == 2) {
                idIcon = this.f25868d.fromJson(jsonReader2);
            } else if (L == 3) {
                list2 = this.f25869e.fromJson(jsonReader2);
            } else if (L == 4) {
                bool = this.f25870f.fromJson(jsonReader2);
                i10 &= -17;
            }
        }
        jsonReader.e();
        if (i10 != -17) {
            Constructor<Id> constructor = this.f25871g;
            if (constructor == null) {
                constructor = Id.class.getDeclaredConstructor(new Class[]{String.class, List.class, Id.IdIcon.class, List.class, Boolean.class, Integer.TYPE, c.f18958c});
                this.f25871g = constructor;
                j.f(constructor, "Id::class.java.getDeclar…his.constructorRef = it }");
            }
            Object[] objArr = new Object[7];
            if (str != null) {
                objArr[0] = str;
                if (list != null) {
                    objArr[1] = list;
                    objArr[2] = idIcon;
                    objArr[3] = list2;
                    objArr[4] = bool;
                    objArr[5] = Integer.valueOf(i10);
                    objArr[6] = null;
                    Id newInstance = constructor.newInstance(objArr);
                    j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException o10 = c.o("requiresSides", "requiresSides", jsonReader2);
                j.f(o10, "missingProperty(\"require… \"requiresSides\", reader)");
                throw o10;
            }
            JsonDataException o11 = c.o("class_", "class", jsonReader2);
            j.f(o11, "missingProperty(\"class_\", \"class\", reader)");
            throw o11;
        } else if (str == null) {
            JsonDataException o12 = c.o("class_", "class", jsonReader2);
            j.f(o12, "missingProperty(\"class_\", \"class\", reader)");
            throw o12;
        } else if (list != null) {
            return new Id(str, list, idIcon, list2, bool);
        } else {
            JsonDataException o13 = c.o("requiresSides", "requiresSides", jsonReader2);
            j.f(o13, "missingProperty(\"require… \"requiresSides\", reader)");
            throw o13;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, Id id2) {
        j.g(qVar, "writer");
        if (id2 != null) {
            qVar.c();
            qVar.u("class");
            this.f25866b.toJson(qVar, id2.c());
            qVar.u("requiresSides");
            this.f25867c.toJson(qVar, id2.e());
            qVar.u(SoftwareInfoForm.ICON);
            this.f25868d.toJson(qVar, id2.d());
            qVar.u("capturePageConfigs");
            this.f25869e.toJson(qVar, id2.a());
            qVar.u("supportsPassportNfc");
            this.f25870f.toJson(qVar, id2.f());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("Id");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
