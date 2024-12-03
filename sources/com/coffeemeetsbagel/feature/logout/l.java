package com.coffeemeetsbagel.feature.logout;

import androidx.activity.result.c;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.t;
import com.coffeemeetsbagel.models.BannedReason;
import com.coffeemeetsbagel.models.VerificationStatus;
import com.withpersona.sdk2.inquiry.Inquiry;
import com.withpersona.sdk2.inquiry.InquiryResponse;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class l extends f0 {

    /* renamed from: d  reason: collision with root package name */
    private final n f13078d;

    /* renamed from: e  reason: collision with root package name */
    private final t<Pair<BannedReason, VerificationStatus>> f13079e;

    /* renamed from: f  reason: collision with root package name */
    private final t<InquiryResponse> f13080f;

    /* renamed from: g  reason: collision with root package name */
    private LiveData<Pair<BannedReason, VerificationStatus>> f13081g;

    /* renamed from: h  reason: collision with root package name */
    private LiveData<InquiryResponse> f13082h;

    public l(n nVar) {
        j.g(nVar, "personaRepository");
        this.f13078d = nVar;
        t<Pair<BannedReason, VerificationStatus>> tVar = new t<>();
        this.f13079e = tVar;
        t<InquiryResponse> tVar2 = new t<>();
        this.f13080f = tVar2;
        this.f13081g = tVar;
        this.f13082h = tVar2;
    }

    public final LiveData<InquiryResponse> f() {
        return this.f13082h;
    }

    public final LiveData<Pair<BannedReason, VerificationStatus>> g() {
        return this.f13081g;
    }

    public final void h(InquiryResponse inquiryResponse) {
        j.g(inquiryResponse, "inquiryResponse");
        this.f13078d.f(inquiryResponse);
        this.f13080f.o(inquiryResponse);
    }

    public final void i(BannedReason bannedReason, VerificationStatus verificationStatus) {
        j.g(bannedReason, "bannedReason");
        j.g(verificationStatus, "verificationStatus");
        this.f13079e.o(new Pair(bannedReason, verificationStatus));
    }

    public final void j(c<Inquiry> cVar, String str) {
        j.g(cVar, "getInquiryResult");
        j.g(str, "referenceId");
        this.f13078d.c(cVar, str);
    }
}
