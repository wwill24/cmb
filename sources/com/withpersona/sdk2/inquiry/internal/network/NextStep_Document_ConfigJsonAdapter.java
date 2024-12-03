package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Document_ConfigJsonAdapter extends h<NextStep.Document.Config> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26726a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Boolean> f26727b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Integer> f26728c;

    /* renamed from: d  reason: collision with root package name */
    private final h<String> f26729d;

    /* renamed from: e  reason: collision with root package name */
    private final h<NextStep.Document.StartPage> f26730e;

    /* renamed from: f  reason: collision with root package name */
    private final h<String> f26731f;

    /* renamed from: g  reason: collision with root package name */
    private final h<NextStep.Document.Localizations> f26732g;

    /* renamed from: h  reason: collision with root package name */
    private final h<NextStep.Document.Pages> f26733h;

    public NextStep_Document_ConfigJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("backStepEnabled", "cancelButtonEnabled", "documentFileLimit", "documentId", "startPage", "fieldKeyDocument", "kind", "localizations", "pages");
        j.f(a10, "of(\"backStepEnabled\",\n  …\"localizations\", \"pages\")");
        this.f26726a = a10;
        h<Boolean> f10 = sVar.f(Boolean.class, n0.e(), "backStepEnabled");
        j.f(f10, "moshi.adapter(Boolean::c…Set(), \"backStepEnabled\")");
        this.f26727b = f10;
        h<Integer> f11 = sVar.f(Integer.TYPE, n0.e(), "documentFileLimit");
        j.f(f11, "moshi.adapter(Int::class…     \"documentFileLimit\")");
        this.f26728c = f11;
        h<String> f12 = sVar.f(cls, n0.e(), "documentId");
        j.f(f12, "moshi.adapter(String::cl…emptySet(), \"documentId\")");
        this.f26729d = f12;
        h<NextStep.Document.StartPage> f13 = sVar.f(NextStep.Document.StartPage.class, n0.e(), "startPage");
        j.f(f13, "moshi.adapter(NextStep.D… emptySet(), \"startPage\")");
        this.f26730e = f13;
        h<String> f14 = sVar.f(cls, n0.e(), "fieldKeyDocument");
        j.f(f14, "moshi.adapter(String::cl…      \"fieldKeyDocument\")");
        this.f26731f = f14;
        h<NextStep.Document.Localizations> f15 = sVar.f(NextStep.Document.Localizations.class, n0.e(), "localizations");
        j.f(f15, "moshi.adapter(NextStep.D…tySet(), \"localizations\")");
        this.f26732g = f15;
        h<NextStep.Document.Pages> f16 = sVar.f(NextStep.Document.Pages.class, n0.e(), "pages");
        j.f(f16, "moshi.adapter(NextStep.D…ava, emptySet(), \"pages\")");
        this.f26733h = f16;
    }

    /* renamed from: a */
    public NextStep.Document.Config fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        Integer num = null;
        Boolean bool = null;
        Boolean bool2 = null;
        String str = null;
        NextStep.Document.StartPage startPage = null;
        String str2 = null;
        String str3 = null;
        NextStep.Document.Localizations localizations = null;
        NextStep.Document.Pages pages = null;
        while (true) {
            NextStep.Document.Pages pages2 = pages;
            if (jsonReader.g()) {
                switch (jsonReader2.L(this.f26726a)) {
                    case -1:
                        jsonReader.S();
                        jsonReader.Y();
                        break;
                    case 0:
                        bool = this.f26727b.fromJson(jsonReader2);
                        break;
                    case 1:
                        bool2 = this.f26727b.fromJson(jsonReader2);
                        break;
                    case 2:
                        num = this.f26728c.fromJson(jsonReader2);
                        if (num == null) {
                            JsonDataException x10 = c.x("documentFileLimit", "documentFileLimit", jsonReader2);
                            j.f(x10, "unexpectedNull(\"document…cumentFileLimit\", reader)");
                            throw x10;
                        }
                        break;
                    case 3:
                        str = this.f26729d.fromJson(jsonReader2);
                        break;
                    case 4:
                        startPage = this.f26730e.fromJson(jsonReader2);
                        if (startPage == null) {
                            JsonDataException x11 = c.x("startPage", "startPage", jsonReader2);
                            j.f(x11, "unexpectedNull(\"startPag…     \"startPage\", reader)");
                            throw x11;
                        }
                        break;
                    case 5:
                        str2 = this.f26731f.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException x12 = c.x("fieldKeyDocument", "fieldKeyDocument", jsonReader2);
                            j.f(x12, "unexpectedNull(\"fieldKey…ieldKeyDocument\", reader)");
                            throw x12;
                        }
                        break;
                    case 6:
                        str3 = this.f26731f.fromJson(jsonReader2);
                        if (str3 == null) {
                            JsonDataException x13 = c.x("kind", "kind", jsonReader2);
                            j.f(x13, "unexpectedNull(\"kind\", \"kind\",\n            reader)");
                            throw x13;
                        }
                        break;
                    case 7:
                        localizations = this.f26732g.fromJson(jsonReader2);
                        if (localizations == null) {
                            JsonDataException x14 = c.x("localizations", "localizations", jsonReader2);
                            j.f(x14, "unexpectedNull(\"localiza… \"localizations\", reader)");
                            throw x14;
                        }
                        break;
                    case 8:
                        pages = this.f26733h.fromJson(jsonReader2);
                        continue;
                }
                pages = pages2;
            } else {
                jsonReader.e();
                if (num != null) {
                    int intValue = num.intValue();
                    if (startPage == null) {
                        JsonDataException o10 = c.o("startPage", "startPage", jsonReader2);
                        j.f(o10, "missingProperty(\"startPage\", \"startPage\", reader)");
                        throw o10;
                    } else if (str2 == null) {
                        JsonDataException o11 = c.o("fieldKeyDocument", "fieldKeyDocument", jsonReader2);
                        j.f(o11, "missingProperty(\"fieldKe…ieldKeyDocument\", reader)");
                        throw o11;
                    } else if (str3 == null) {
                        JsonDataException o12 = c.o("kind", "kind", jsonReader2);
                        j.f(o12, "missingProperty(\"kind\", \"kind\", reader)");
                        throw o12;
                    } else if (localizations != null) {
                        return new NextStep.Document.Config(bool, bool2, intValue, str, startPage, str2, str3, localizations, pages2);
                    } else {
                        JsonDataException o13 = c.o("localizations", "localizations", jsonReader2);
                        j.f(o13, "missingProperty(\"localiz… \"localizations\", reader)");
                        throw o13;
                    }
                } else {
                    JsonDataException o14 = c.o("documentFileLimit", "documentFileLimit", jsonReader2);
                    j.f(o14, "missingProperty(\"documen…cumentFileLimit\", reader)");
                    throw o14;
                }
            }
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.Config config) {
        j.g(qVar, "writer");
        if (config != null) {
            qVar.c();
            qVar.u("backStepEnabled");
            this.f26727b.toJson(qVar, config.a());
            qVar.u("cancelButtonEnabled");
            this.f26727b.toJson(qVar, config.c());
            qVar.u("documentFileLimit");
            this.f26728c.toJson(qVar, Integer.valueOf(config.d()));
            qVar.u("documentId");
            this.f26729d.toJson(qVar, config.e());
            qVar.u("startPage");
            this.f26730e.toJson(qVar, config.j());
            qVar.u("fieldKeyDocument");
            this.f26731f.toJson(qVar, config.f());
            qVar.u("kind");
            this.f26731f.toJson(qVar, config.g());
            qVar.u("localizations");
            this.f26732g.toJson(qVar, config.h());
            qVar.u("pages");
            this.f26733h.toJson(qVar, config.i());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.Config");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
