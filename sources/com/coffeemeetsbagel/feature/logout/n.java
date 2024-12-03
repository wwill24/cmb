package com.coffeemeetsbagel.feature.logout;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.withpersona.sdk2.inquiry.Environment;
import com.withpersona.sdk2.inquiry.Inquiry;
import com.withpersona.sdk2.inquiry.InquiryResponse;
import fa.a;
import hb.c;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Session;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final c f13084a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13085b = "persona_session_token";

    /* renamed from: c  reason: collision with root package name */
    private final String f13086c = "persona_inquiry_id";

    /* renamed from: d  reason: collision with root package name */
    private final String f13087d = "PersonaRepository";

    /* renamed from: e  reason: collision with root package name */
    private final String f13088e = "itmpl_eCJy2EWkS2Q2JFvZJeCy6JrD";

    public n(c cVar) {
        j.g(cVar, "sharedPrefs");
        this.f13084a = cVar;
    }

    private final void a() {
        a.f40771d.a(this.f13087d, "clearSession()");
        this.f13084a.remove(this.f13085b);
        this.f13084a.remove(this.f13086c);
    }

    private final Inquiry b(String str) {
        a.C0491a aVar = a.f40771d;
        String str2 = this.f13087d;
        aVar.a(str2, "createNewSession: " + str);
        return Inquiry.Companion.fromTemplate(this.f13088e).environment(d()).referenceId(str).theme((int) R.style.CmbPersonaTheme).build();
    }

    private final Environment d() {
        if (Bakery.p() == Bakery.CmbEndpointsPointToType.PRODUCTION) {
            return Environment.PRODUCTION;
        }
        return Environment.SANDBOX;
    }

    private final Pair<String, String> e() {
        boolean z10;
        String r10 = this.f13084a.r(this.f13086c);
        String r11 = this.f13084a.r(this.f13085b);
        boolean z11 = false;
        if (r10 == null || r10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            if (r11 == null || r11.length() == 0) {
                z11 = true;
            }
            if (!z11) {
                j.f(r10, IQ.IQ_ELEMENT);
                j.f(r11, Session.ELEMENT);
                return new Pair<>(r10, r11);
            }
        }
        return new Pair<>("", "");
    }

    private final Inquiry g(String str, String str2) {
        a.C0491a aVar = a.f40771d;
        String str3 = this.f13087d;
        aVar.a(str3, "resumeSession: id=" + str + ", session=" + str2);
        return Inquiry.Companion.fromInquiry(str).sessionToken(str2).theme((int) R.style.CmbPersonaTheme).build();
    }

    private final void h(String str, String str2) {
        a.C0491a aVar = a.f40771d;
        String str3 = this.f13087d;
        aVar.a(str3, "saveSession: id=" + str + ", session=" + str2);
        if (str2 != null) {
            this.f13084a.w(this.f13085b, str2);
        }
        if (str != null) {
            this.f13084a.w(this.f13086c, str);
        }
    }

    public final void c(androidx.activity.result.c<Inquiry> cVar, String str) {
        boolean z10;
        Inquiry inquiry;
        j.g(cVar, "launcher");
        j.g(str, "referenceId");
        Pair<String, String> e10 = e();
        String c10 = e10.c();
        String d10 = e10.d();
        boolean z11 = true;
        if (c10.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (d10.length() <= 0) {
                z11 = false;
            }
            if (z11) {
                inquiry = g(c10, d10);
                cVar.b(inquiry);
            }
        }
        inquiry = b(str);
        cVar.b(inquiry);
    }

    public final void f(InquiryResponse inquiryResponse) {
        j.g(inquiryResponse, "inquiryResponse");
        if (inquiryResponse instanceof InquiryResponse.Complete) {
            a.f40771d.a(this.f13087d, "Persona session complete.");
            a();
        } else if (inquiryResponse instanceof InquiryResponse.Cancel) {
            a.C0491a aVar = a.f40771d;
            String str = this.f13087d;
            InquiryResponse.Cancel cancel = (InquiryResponse.Cancel) inquiryResponse;
            String inquiryId = cancel.getInquiryId();
            aVar.a(str, "Persona session cancelled: " + inquiryId);
            h(cancel.getInquiryId(), cancel.getSessionToken());
        } else if (inquiryResponse instanceof InquiryResponse.Error) {
            a.C0491a aVar2 = a.f40771d;
            String str2 = this.f13087d;
            InquiryResponse.Error error = (InquiryResponse.Error) inquiryResponse;
            String cause = error.getCause();
            aVar2.c(str2, "Error with Persona inquiry. " + cause, new Exception(error.getDebugMessage()));
            a();
        }
    }
}
