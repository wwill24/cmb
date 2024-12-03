package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_PassportNfcJsonAdapter extends h<NextStep.PassportNfc> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26857a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26858b;

    public NextStep_PassportNfcJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("enableNfcPrompt", "enableNfcBtnConfirm", "enableNfcBtnCancel", "connectionLostPrompt", "connectionLostBtnConfirm", "authenticationErrorPrompt", "authenticationErrorBtnConfirm", "genericErrorPrompt", "genericErrorBtnConfirm");
        j.f(a10, "of(\"enableNfcPrompt\",\n  …\"genericErrorBtnConfirm\")");
        this.f26857a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "enableNfcPrompt");
        j.f(f10, "moshi.adapter(String::cl…Set(), \"enableNfcPrompt\")");
        this.f26858b = f10;
    }

    /* renamed from: a */
    public NextStep.PassportNfc fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26857a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f26858b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f26858b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f26858b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f26858b.fromJson(jsonReader);
                    break;
                case 4:
                    str5 = this.f26858b.fromJson(jsonReader);
                    break;
                case 5:
                    str6 = this.f26858b.fromJson(jsonReader);
                    break;
                case 6:
                    str7 = this.f26858b.fromJson(jsonReader);
                    break;
                case 7:
                    str8 = this.f26858b.fromJson(jsonReader);
                    break;
                case 8:
                    str9 = this.f26858b.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new NextStep.PassportNfc(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.PassportNfc passportNfc) {
        j.g(qVar, "writer");
        if (passportNfc != null) {
            qVar.c();
            qVar.u("enableNfcPrompt");
            this.f26858b.toJson(qVar, passportNfc.h());
            qVar.u("enableNfcBtnConfirm");
            this.f26858b.toJson(qVar, passportNfc.g());
            qVar.u("enableNfcBtnCancel");
            this.f26858b.toJson(qVar, passportNfc.f());
            qVar.u("connectionLostPrompt");
            this.f26858b.toJson(qVar, passportNfc.e());
            qVar.u("connectionLostBtnConfirm");
            this.f26858b.toJson(qVar, passportNfc.d());
            qVar.u("authenticationErrorPrompt");
            this.f26858b.toJson(qVar, passportNfc.c());
            qVar.u("authenticationErrorBtnConfirm");
            this.f26858b.toJson(qVar, passportNfc.a());
            qVar.u("genericErrorPrompt");
            this.f26858b.toJson(qVar, passportNfc.j());
            qVar.u("genericErrorBtnConfirm");
            this.f26858b.toJson(qVar, passportNfc.i());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.PassportNfc");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
