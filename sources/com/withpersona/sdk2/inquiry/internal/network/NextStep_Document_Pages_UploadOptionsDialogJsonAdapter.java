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

public final class NextStep_Document_Pages_UploadOptionsDialogJsonAdapter extends h<NextStep.Document.Pages.UploadOptionsDialog> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26748a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Ui> f26749b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping> f26750c;

    public NextStep_Document_Pages_UploadOptionsDialogJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("uiStep", "componentNameMapping");
        j.f(a10, "of(\"uiStep\", \"componentNameMapping\")");
        this.f26748a = a10;
        h<NextStep.Ui> f10 = sVar.f(NextStep.Ui.class, n0.e(), "uiStep");
        j.f(f10, "moshi.adapter(NextStep.U…    emptySet(), \"uiStep\")");
        this.f26749b = f10;
        h<NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping> f11 = sVar.f(NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping.class, n0.e(), "componentNameMapping");
        j.f(f11, "moshi.adapter(NextStep.D…, \"componentNameMapping\")");
        this.f26750c = f11;
    }

    /* renamed from: a */
    public NextStep.Document.Pages.UploadOptionsDialog fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Ui ui2 = null;
        NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping componentNameMapping = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26748a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                ui2 = this.f26749b.fromJson(jsonReader);
                if (ui2 == null) {
                    JsonDataException x10 = c.x("uiStep", "uiStep", jsonReader);
                    j.f(x10, "unexpectedNull(\"uiStep\",…tep\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                componentNameMapping = this.f26750c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (ui2 != null) {
            return new NextStep.Document.Pages.UploadOptionsDialog(ui2, componentNameMapping);
        }
        JsonDataException o10 = c.o("uiStep", "uiStep", jsonReader);
        j.f(o10, "missingProperty(\"uiStep\", \"uiStep\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.Pages.UploadOptionsDialog uploadOptionsDialog) {
        j.g(qVar, "writer");
        if (uploadOptionsDialog != null) {
            qVar.c();
            qVar.u("uiStep");
            this.f26749b.toJson(qVar, uploadOptionsDialog.c());
            qVar.u("componentNameMapping");
            this.f26750c.toJson(qVar, uploadOptionsDialog.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(65);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.Pages.UploadOptionsDialog");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
