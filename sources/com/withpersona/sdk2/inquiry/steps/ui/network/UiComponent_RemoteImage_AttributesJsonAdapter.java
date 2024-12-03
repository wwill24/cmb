package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_RemoteImage_AttributesJsonAdapter extends h<UiComponent.RemoteImage.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28306a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28307b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.RemoteImage.ContentType> f28308c;

    /* renamed from: d  reason: collision with root package name */
    private final h<String> f28309d;

    /* renamed from: e  reason: collision with root package name */
    private final h<UiComponent.RemoteImage.ContentType> f28310e;

    /* renamed from: f  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28311f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Constructor<UiComponent.RemoteImage.Attributes> f28312g;

    public UiComponent_RemoteImage_AttributesJsonAdapter(s sVar) {
        Class<UiComponent.RemoteImage.ContentType> cls = UiComponent.RemoteImage.ContentType.class;
        Class<String> cls2 = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("localAssetName", "localAssetContentType", "url", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "contentType", "hidden");
        j.f(a10, "of(\"localAssetName\",\n   … \"contentType\", \"hidden\")");
        this.f28306a = a10;
        h<String> f10 = sVar.f(cls2, n0.e(), "localAssetName");
        j.f(f10, "moshi.adapter(String::cl…ySet(), \"localAssetName\")");
        this.f28307b = f10;
        h<UiComponent.RemoteImage.ContentType> f11 = sVar.f(cls, n0.e(), "localAssetContentType");
        j.f(f11, "moshi.adapter(UiComponen… \"localAssetContentType\")");
        this.f28308c = f11;
        h<String> f12 = sVar.f(cls2, n0.e(), "url");
        j.f(f12, "moshi.adapter(String::cl… emptySet(),\n      \"url\")");
        this.f28309d = f12;
        h<UiComponent.RemoteImage.ContentType> f13 = sVar.f(cls, n0.e(), "contentType");
        j.f(f13, "moshi.adapter(UiComponen…mptySet(), \"contentType\")");
        this.f28310e = f13;
        h<JsonLogicBoolean> f14 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f14, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28311f = f14;
    }

    /* renamed from: a */
    public UiComponent.RemoteImage.Attributes fromJson(JsonReader jsonReader) {
        String str;
        JsonReader jsonReader2 = jsonReader;
        Class<UiComponent.RemoteImage.ContentType> cls = UiComponent.RemoteImage.ContentType.class;
        Class<String> cls2 = String.class;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str2 = null;
        UiComponent.RemoteImage.ContentType contentType = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        UiComponent.RemoteImage.ContentType contentType2 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28306a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str2 = this.f28307b.fromJson(jsonReader2);
                    break;
                case 1:
                    contentType = this.f28308c.fromJson(jsonReader2);
                    break;
                case 2:
                    str3 = this.f28309d.fromJson(jsonReader2);
                    if (str3 != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x("url", "url", jsonReader2);
                        j.f(x10, "unexpectedNull(\"url\", \"url\", reader)");
                        throw x10;
                    }
                case 3:
                    str4 = this.f28307b.fromJson(jsonReader2);
                    break;
                case 4:
                    str5 = this.f28307b.fromJson(jsonReader2);
                    break;
                case 5:
                    contentType2 = this.f28310e.fromJson(jsonReader2);
                    if (contentType2 != null) {
                        i10 &= -33;
                        break;
                    } else {
                        JsonDataException x11 = c.x("contentType", "contentType", jsonReader2);
                        j.f(x11, "unexpectedNull(\"contentT…\", \"contentType\", reader)");
                        throw x11;
                    }
                case 6:
                    jsonLogicBoolean = this.f28311f.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        if (i10 != -33) {
            Constructor<UiComponent.RemoteImage.Attributes> constructor = this.f28312g;
            if (constructor == null) {
                str = "missingProperty(\"url\", \"url\", reader)";
                constructor = UiComponent.RemoteImage.Attributes.class.getDeclaredConstructor(new Class[]{cls2, cls, cls2, cls2, cls2, cls, JsonLogicBoolean.class, Integer.TYPE, c.f18958c});
                this.f28312g = constructor;
                j.f(constructor, "UiComponent.RemoteImage.…his.constructorRef = it }");
            } else {
                str = "missingProperty(\"url\", \"url\", reader)";
            }
            Object[] objArr = new Object[9];
            objArr[0] = str2;
            objArr[1] = contentType;
            if (str3 != null) {
                objArr[2] = str3;
                objArr[3] = str4;
                objArr[4] = str5;
                objArr[5] = contentType2;
                objArr[6] = jsonLogicBoolean;
                objArr[7] = Integer.valueOf(i10);
                objArr[8] = null;
                UiComponent.RemoteImage.Attributes newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("url", "url", jsonReader2);
            j.f(o10, str);
            throw o10;
        } else if (str3 != null) {
            j.e(contentType2, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent.RemoteImage.ContentType");
            return new UiComponent.RemoteImage.Attributes(str2, contentType, str3, str4, str5, contentType2, jsonLogicBoolean);
        } else {
            JsonDataException o11 = c.o("url", "url", jsonReader2);
            j.f(o11, "missingProperty(\"url\", \"url\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.RemoteImage.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("localAssetName");
            this.f28307b.toJson(qVar, attributes.g());
            qVar.u("localAssetContentType");
            this.f28308c.toJson(qVar, attributes.f());
            qVar.u("url");
            this.f28309d.toJson(qVar, attributes.h());
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28307b.toJson(qVar, attributes.i());
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f28307b.toJson(qVar, attributes.e());
            qVar.u("contentType");
            this.f28310e.toJson(qVar, attributes.d());
            qVar.u("hidden");
            this.f28311f.toJson(qVar, attributes.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.RemoteImage.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
