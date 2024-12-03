package com.withpersona.sdk2.inquiry.internal.network;

import com.withpersona.sdk2.inquiry.document.DocumentPages;
import com.withpersona.sdk2.inquiry.document.DocumentStartPage;
import com.withpersona.sdk2.inquiry.document.UploadOptionsDialog;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcConfirmDetailsPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcModuleMissingPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcNfcNotSupportedPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcPromptPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcScanPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcStartPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.InquiryState;
import com.withpersona.sdk2.inquiry.internal.TransitionStatus;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcScanCompletePage;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcScanReadyPage;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$GovernmentIdStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$SelfieStepStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StepStyles$UiStepStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class a {

    /* renamed from: com.withpersona.sdk2.inquiry.internal.network.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0319a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26898a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PassportNfcOption[] r0 = com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.PassportNfcOption.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PassportNfcOption r1 = com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.PassportNfcOption.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PassportNfcOption r1 = com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.PassportNfcOption.OPTIONAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.withpersona.sdk2.inquiry.internal.network.NextStep$GovernmentId$PassportNfcOption r1 = com.withpersona.sdk2.inquiry.internal.network.NextStep.GovernmentId.PassportNfcOption.REQUIRED_IF_SUPPORTED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f26898a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.network.a.C0319a.<clinit>():void");
        }
    }

    public static final DocumentPages a(NextStep.Document.Pages pages, NextStep.Document.Localizations localizations) {
        DocumentStartPage documentStartPage;
        UploadOptionsDialog uploadOptionsDialog;
        NextStep.Document.Pages.DocumentPages a10;
        NextStep.Document.Pages.UploadOptionsDialog c10;
        NextStep.Document.Pages.DocumentPages a11;
        NextStep.Document.Pages.DocumentStartPage a12;
        j.g(localizations, "localizations");
        if (pages == null || (a11 = pages.a()) == null || (a12 = a11.a()) == null || (documentStartPage = b(a12)) == null) {
            documentStartPage = DocumentStartPage.f24999g.a(localizations.d().l(), localizations.d().k(), localizations.d().d(), localizations.d().a());
        }
        if (pages == null || (a10 = pages.a()) == null || (c10 = a10.c()) == null || (uploadOptionsDialog = c(c10)) == null) {
            uploadOptionsDialog = UploadOptionsDialog.f25130g.a(localizations.d().i(), localizations.d().a(), localizations.d().d());
        }
        return new DocumentPages(documentStartPage, uploadOptionsDialog);
    }

    private static final DocumentStartPage b(NextStep.Document.Pages.DocumentStartPage documentStartPage) {
        String str;
        String str2;
        String str3;
        String str4;
        List<UiComponent> components = documentStartPage.c().c().getComponents();
        StepStyles$UiStepStyle b10 = documentStartPage.c().b();
        NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping a10 = documentStartPage.a();
        if (a10 != null) {
            str = a10.d();
        } else {
            str = null;
        }
        NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping a11 = documentStartPage.a();
        if (a11 != null) {
            str2 = a11.c();
        } else {
            str2 = null;
        }
        NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping a12 = documentStartPage.a();
        if (a12 != null) {
            str3 = a12.a();
        } else {
            str3 = null;
        }
        NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping a13 = documentStartPage.a();
        if (a13 != null) {
            str4 = a13.e();
        } else {
            str4 = null;
        }
        return new DocumentStartPage(components, b10, str2, str, str3, str4);
    }

    private static final UploadOptionsDialog c(NextStep.Document.Pages.UploadOptionsDialog uploadOptionsDialog) {
        String str;
        String str2;
        String str3;
        String str4;
        List<UiComponent> components = uploadOptionsDialog.c().c().getComponents();
        StepStyles$UiStepStyle b10 = uploadOptionsDialog.c().b();
        NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping a10 = uploadOptionsDialog.a();
        if (a10 != null) {
            str = a10.e();
        } else {
            str = null;
        }
        NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping a11 = uploadOptionsDialog.a();
        if (a11 != null) {
            str2 = a11.d();
        } else {
            str2 = null;
        }
        NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping a12 = uploadOptionsDialog.a();
        if (a12 != null) {
            str3 = a12.a();
        } else {
            str3 = null;
        }
        NextStep.Document.Pages.UploadOptionsDialog.ComponentNameMapping a13 = uploadOptionsDialog.a();
        if (a13 != null) {
            str4 = a13.c();
        } else {
            str4 = null;
        }
        return new UploadOptionsDialog(components, b10, str2, str, str3, str4);
    }

    public static final GovernmentIdPages d(NextStep.GovernmentId.Pages pages) {
        PassportNfcStartPage passportNfcStartPage;
        PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage;
        PassportNfcScanPage passportNfcScanPage;
        PassportNfcPromptPage passportNfcPromptPage;
        PassportNfcScanReadyPage passportNfcScanReadyPage;
        PassportNfcScanCompletePage passportNfcScanCompletePage;
        PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage;
        PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage;
        PassportNfcModuleMissingPage passportNfcModuleMissingPage;
        NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage b10;
        NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage c10;
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage a10;
        NextStep.GovernmentId.Pages.PassportNfcScanCompletePage f10;
        NextStep.GovernmentId.Pages.PassportNfcScanReadyPage g10;
        NextStep.GovernmentId.Pages.PassportNfcPromptPage d10;
        NextStep.GovernmentId.Pages.PassportNfcScanPage e10;
        NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage i10;
        NextStep.GovernmentId.Pages.PassportNfcStartPage h10;
        j.g(pages, "<this>");
        NextStep.GovernmentId.Pages.PassportNfc a11 = pages.a();
        if (a11 == null || (h10 = a11.h()) == null) {
            passportNfcStartPage = null;
        } else {
            passportNfcStartPage = k(h10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a12 = pages.a();
        if (a12 == null || (i10 = a12.i()) == null) {
            passportNfcVerifyDetailsPage = null;
        } else {
            passportNfcVerifyDetailsPage = l(i10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a13 = pages.a();
        if (a13 == null || (e10 = a13.e()) == null) {
            passportNfcScanPage = null;
        } else {
            passportNfcScanPage = j(e10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a14 = pages.a();
        if (a14 == null || (d10 = a14.d()) == null) {
            passportNfcPromptPage = null;
        } else {
            passportNfcPromptPage = i(d10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a15 = pages.a();
        if (a15 == null || (g10 = a15.g()) == null) {
            passportNfcScanReadyPage = null;
        } else {
            passportNfcScanReadyPage = o(g10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a16 = pages.a();
        if (a16 == null || (f10 = a16.f()) == null) {
            passportNfcScanCompletePage = null;
        } else {
            passportNfcScanCompletePage = n(f10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a17 = pages.a();
        if (a17 == null || (a10 = a17.a()) == null) {
            passportNfcConfirmDetailsPage = null;
        } else {
            passportNfcConfirmDetailsPage = f(a10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a18 = pages.a();
        if (a18 == null || (c10 = a18.c()) == null) {
            passportNfcNfcNotSupportedPage = null;
        } else {
            passportNfcNfcNotSupportedPage = h(c10);
        }
        NextStep.GovernmentId.Pages.PassportNfc a19 = pages.a();
        if (a19 == null || (b10 = a19.b()) == null) {
            passportNfcModuleMissingPage = null;
        } else {
            passportNfcModuleMissingPage = g(b10);
        }
        return new GovernmentIdPages(passportNfcStartPage, passportNfcVerifyDetailsPage, passportNfcScanPage, passportNfcPromptPage, passportNfcScanReadyPage, passportNfcScanCompletePage, passportNfcConfirmDetailsPage, passportNfcNfcNotSupportedPage, passportNfcModuleMissingPage);
    }

    public static final GovernmentIdWorkflow.a.C0309a e(NextStep.GovernmentId.Localizations localizations, List<NextStep.GovernmentId.LocalizationOverride> list) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        List<NextStep.GovernmentId.LocalizationOverride> list2 = list;
        j.g(localizations, "<this>");
        String f10 = localizations.j().f();
        String e10 = localizations.j().e();
        String a10 = localizations.j().a();
        String c10 = localizations.j().c();
        if (c10 == null) {
            str = "";
        } else {
            str = c10;
        }
        String u10 = localizations.c().u();
        String t10 = localizations.c().t();
        String x10 = localizations.c().x();
        String w10 = localizations.c().w();
        String z10 = localizations.c().z();
        String g10 = localizations.c().g();
        String h10 = localizations.c().h();
        String i10 = localizations.c().i();
        if (i10 == null) {
            str2 = "";
        } else {
            str2 = i10;
        }
        String c11 = localizations.d().c();
        String a11 = localizations.d().a();
        String c12 = localizations.f().c();
        String a12 = localizations.f().a();
        Map<String, String> q10 = q(list2, "selectPage", localizations.j().d());
        Map<String, String> r10 = r(list2, "requestPage", localizations.h().j());
        Map<String, String> r11 = r(list2, "requestPage", localizations.h().d());
        String h11 = localizations.h().h();
        String a13 = localizations.h().a();
        Map<IdConfig.Side, String> j10 = localizations.i().j();
        Map<IdConfig.Side, String> e11 = localizations.i().e();
        String c13 = localizations.i().c();
        String a14 = localizations.i().a();
        NextStep.PassportNfc e12 = localizations.e();
        if (e12 != null) {
            str3 = e12.h();
        } else {
            str3 = null;
        }
        NextStep.PassportNfc e13 = localizations.e();
        if (e13 != null) {
            str4 = e13.g();
        } else {
            str4 = null;
        }
        NextStep.PassportNfc e14 = localizations.e();
        if (e14 != null) {
            str5 = e14.f();
        } else {
            str5 = null;
        }
        NextStep.PassportNfc e15 = localizations.e();
        if (e15 != null) {
            str6 = e15.e();
        } else {
            str6 = null;
        }
        NextStep.PassportNfc e16 = localizations.e();
        if (e16 != null) {
            str7 = e16.d();
        } else {
            str7 = null;
        }
        NextStep.PassportNfc e17 = localizations.e();
        if (e17 != null) {
            str8 = e17.c();
        } else {
            str8 = null;
        }
        NextStep.PassportNfc e18 = localizations.e();
        if (e18 != null) {
            str9 = e18.a();
        } else {
            str9 = null;
        }
        NextStep.PassportNfc e19 = localizations.e();
        if (e19 != null) {
            str10 = e19.j();
        } else {
            str10 = null;
        }
        NextStep.PassportNfc e20 = localizations.e();
        if (e20 != null) {
            str11 = e20.i();
        } else {
            str11 = null;
        }
        return new GovernmentIdWorkflow.a.C0309a(f10, e10, a10, str, u10, t10, x10, w10, z10, g10, h10, str2, c11, a11, c12, a12, q10, r10, r11, h11, a13, j10, e11, c13, a14, str3, str4, str5, str6, str7, str8, str9, str10, str11, localizations.g().e(), localizations.g().d(), localizations.g().a(), localizations.g().c(), localizations.g().i(), localizations.g().h(), localizations.g().g(), localizations.g().f(), localizations.c().j(), localizations.c().k(), localizations.c().f(), localizations.c().e(), localizations.c().d(), localizations.c().c(), localizations.c().a(), localizations.c().s(), localizations.c().r(), localizations.c().q(), localizations.c().p(), localizations.c().o(), localizations.c().n(), localizations.c().m(), localizations.c().l());
    }

    private static final PassportNfcConfirmDetailsPage f(NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        List<UiComponent> components = passportNfcConfirmDetailsPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcConfirmDetailsPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a10 = passportNfcConfirmDetailsPage.a();
        if (a10 != null) {
            str = a10.g();
        } else {
            str = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a11 = passportNfcConfirmDetailsPage.a();
        if (a11 != null) {
            str2 = a11.k();
        } else {
            str2 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a12 = passportNfcConfirmDetailsPage.a();
        if (a12 != null) {
            str3 = a12.c();
        } else {
            str3 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a13 = passportNfcConfirmDetailsPage.a();
        if (a13 != null) {
            str4 = a13.d();
        } else {
            str4 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a14 = passportNfcConfirmDetailsPage.a();
        if (a14 != null) {
            str5 = a14.e();
        } else {
            str5 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a15 = passportNfcConfirmDetailsPage.a();
        if (a15 != null) {
            str6 = a15.i();
        } else {
            str6 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a16 = passportNfcConfirmDetailsPage.a();
        if (a16 != null) {
            str7 = a16.f();
        } else {
            str7 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a17 = passportNfcConfirmDetailsPage.a();
        if (a17 != null) {
            str8 = a17.h();
        } else {
            str8 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a18 = passportNfcConfirmDetailsPage.a();
        if (a18 != null) {
            str9 = a18.j();
        } else {
            str9 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a19 = passportNfcConfirmDetailsPage.a();
        if (a19 != null) {
            str10 = a19.a();
        } else {
            str10 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a20 = passportNfcConfirmDetailsPage.a();
        if (a20 != null) {
            str11 = a20.b();
        } else {
            str11 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping a21 = passportNfcConfirmDetailsPage.a();
        if (a21 != null) {
            str12 = a21.l();
        } else {
            str12 = null;
        }
        return new PassportNfcConfirmDetailsPage(components, b10, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    private static final PassportNfcModuleMissingPage g(NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage passportNfcModuleMissingPage) {
        String str;
        List<UiComponent> components = passportNfcModuleMissingPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcModuleMissingPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping a10 = passportNfcModuleMissingPage.a();
        if (a10 != null) {
            str = a10.a();
        } else {
            str = null;
        }
        return new PassportNfcModuleMissingPage(components, b10, str);
    }

    private static final PassportNfcNfcNotSupportedPage h(NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage passportNfcNfcNotSupportedPage) {
        String str;
        List<UiComponent> components = passportNfcNfcNotSupportedPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcNfcNotSupportedPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcNfcNotSupportedPage.ComponentNameMapping a10 = passportNfcNfcNotSupportedPage.a();
        if (a10 != null) {
            str = a10.a();
        } else {
            str = null;
        }
        return new PassportNfcNfcNotSupportedPage(components, b10, str);
    }

    private static final PassportNfcPromptPage i(NextStep.GovernmentId.Pages.PassportNfcPromptPage passportNfcPromptPage) {
        String str;
        List<UiComponent> components = passportNfcPromptPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcPromptPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcPromptPage.ComponentNameMapping a10 = passportNfcPromptPage.a();
        String str2 = null;
        if (a10 != null) {
            str = a10.b();
        } else {
            str = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcPromptPage.ComponentNameMapping a11 = passportNfcPromptPage.a();
        if (a11 != null) {
            str2 = a11.a();
        }
        return new PassportNfcPromptPage(components, b10, str, str2);
    }

    private static final PassportNfcScanPage j(NextStep.GovernmentId.Pages.PassportNfcScanPage passportNfcScanPage) {
        String str;
        List<UiComponent> components = passportNfcScanPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcScanPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcScanPage.ComponentNameMapping a10 = passportNfcScanPage.a();
        if (a10 != null) {
            str = a10.a();
        } else {
            str = null;
        }
        return new PassportNfcScanPage(components, b10, str);
    }

    private static final PassportNfcStartPage k(NextStep.GovernmentId.Pages.PassportNfcStartPage passportNfcStartPage) {
        String str;
        List<UiComponent> components = passportNfcStartPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcStartPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcStartPage.ComponentNameMapping a10 = passportNfcStartPage.a();
        if (a10 != null) {
            str = a10.a();
        } else {
            str = null;
        }
        return new PassportNfcStartPage(components, b10, str);
    }

    private static final PassportNfcVerifyDetailsPage l(NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage) {
        String str;
        String str2;
        String str3;
        String str4;
        List<UiComponent> components = passportNfcVerifyDetailsPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcVerifyDetailsPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping a10 = passportNfcVerifyDetailsPage.a();
        if (a10 != null) {
            str = a10.c();
        } else {
            str = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping a11 = passportNfcVerifyDetailsPage.a();
        if (a11 != null) {
            str2 = a11.b();
        } else {
            str2 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping a12 = passportNfcVerifyDetailsPage.a();
        if (a12 != null) {
            str3 = a12.d();
        } else {
            str3 = null;
        }
        NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping a13 = passportNfcVerifyDetailsPage.a();
        if (a13 != null) {
            str4 = a13.a();
        } else {
            str4 = null;
        }
        return new PassportNfcVerifyDetailsPage(components, b10, str, str2, str3, str4);
    }

    public static final PassportNfcConfig m(NextStep.GovernmentId.NfcPassport nfcPassport) {
        String str;
        boolean z10;
        int i10;
        PassportNfcConfig.PassportNfcOption passportNfcOption;
        Boolean c10;
        NextStep.GovernmentId.PassportNfcOption passportNfcOption2 = null;
        if (nfcPassport != null) {
            str = nfcPassport.a();
        } else {
            str = null;
        }
        if (nfcPassport == null || (c10 = nfcPassport.c()) == null) {
            z10 = false;
        } else {
            z10 = c10.booleanValue();
        }
        if (nfcPassport != null) {
            passportNfcOption2 = nfcPassport.b();
        }
        if (passportNfcOption2 == null) {
            i10 = -1;
        } else {
            i10 = C0319a.f26898a[passportNfcOption2.ordinal()];
        }
        if (i10 == -1) {
            passportNfcOption = PassportNfcConfig.PassportNfcOption.Optional;
        } else if (i10 == 1) {
            passportNfcOption = PassportNfcConfig.PassportNfcOption.Required;
        } else if (i10 == 2) {
            passportNfcOption = PassportNfcConfig.PassportNfcOption.Optional;
        } else if (i10 == 3) {
            passportNfcOption = PassportNfcConfig.PassportNfcOption.RequiredIfSupported;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new PassportNfcConfig(str, z10, passportNfcOption);
    }

    private static final PassportNfcScanCompletePage n(NextStep.GovernmentId.Pages.PassportNfcScanCompletePage passportNfcScanCompletePage) {
        return new PassportNfcScanCompletePage(passportNfcScanCompletePage.a().c().getComponents(), passportNfcScanCompletePage.a().b());
    }

    private static final PassportNfcScanReadyPage o(NextStep.GovernmentId.Pages.PassportNfcScanReadyPage passportNfcScanReadyPage) {
        String str;
        List<UiComponent> components = passportNfcScanReadyPage.b().c().getComponents();
        StepStyles$UiStepStyle b10 = passportNfcScanReadyPage.b().b();
        NextStep.GovernmentId.Pages.PassportNfcScanReadyPage.ComponentNameMapping a10 = passportNfcScanReadyPage.a();
        if (a10 != null) {
            str = a10.a();
        } else {
            str = null;
        }
        return new PassportNfcScanReadyPage(components, b10, str);
    }

    public static final SelfieWorkflow.b.a p(NextStep.Selfie.Localizations localizations, boolean z10) {
        String str;
        NextStep.Selfie.Localizations localizations2 = localizations;
        j.g(localizations, "<this>");
        String n10 = localizations.e().n();
        if (z10) {
            str = localizations.e().m();
        } else {
            str = localizations.e().l();
        }
        return new SelfieWorkflow.b.a(n10, str, localizations.e().g(), localizations.e().a(), localizations.c().h(), localizations.c().a(), localizations.c().c(), localizations.c().g(), localizations.c().e(), localizations.c().f(), localizations.c().d(), localizations.d().c(), localizations.d().a());
    }

    private static final Map<String, String> q(List<NextStep.GovernmentId.LocalizationOverride> list, String str, Map<String, String> map) {
        ArrayList arrayList;
        Object obj;
        String k10;
        boolean z10;
        if (list != null) {
            arrayList = new ArrayList();
            for (T next : list) {
                if (j.b(((NextStep.GovernmentId.LocalizationOverride) next).h(), str)) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.e(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    NextStep.GovernmentId.LocalizationOverride localizationOverride = (NextStep.GovernmentId.LocalizationOverride) obj;
                    if ((j.b(localizationOverride.d(), str2) || localizationOverride.d() == null) && j.b(localizationOverride.e(), str2)) {
                        z10 = true;
                        continue;
                    } else {
                        z10 = false;
                        continue;
                    }
                    if (z10) {
                        break;
                    }
                }
                NextStep.GovernmentId.LocalizationOverride localizationOverride2 = (NextStep.GovernmentId.LocalizationOverride) obj;
                if (!(localizationOverride2 == null || (k10 = localizationOverride2.k()) == null)) {
                    str3 = k10;
                }
            }
            linkedHashMap.put(key, str3);
        }
        return linkedHashMap;
    }

    private static final Map<String, String> r(List<NextStep.GovernmentId.LocalizationOverride> list, String str, Map<Pair<IdConfig.Side, String>, String> map) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z10;
        Object obj;
        String k10;
        boolean z11;
        boolean z12;
        if (list != null) {
            arrayList = new ArrayList();
            for (T next : list) {
                if (j.b(((NextStep.GovernmentId.LocalizationOverride) next).h(), str)) {
                    arrayList.add(next);
                }
            }
        } else {
            arrayList = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next2 : map.entrySet()) {
            Pair pair = (Pair) next2.getKey();
            String str2 = (String) next2.getValue();
            IdConfig.Side side = (IdConfig.Side) pair.c();
            String str3 = (String) pair.d();
            if (arrayList != null) {
                arrayList2 = new ArrayList();
                for (Object next3 : arrayList) {
                    NextStep.GovernmentId.LocalizationOverride localizationOverride = (NextStep.GovernmentId.LocalizationOverride) next3;
                    if ((j.b(localizationOverride.j(), side.c()) || localizationOverride.j() == null) && j.b(localizationOverride.e(), str3)) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        arrayList2.add(next3);
                    }
                }
            } else {
                arrayList2 = null;
            }
            String c10 = side.c();
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((NextStep.GovernmentId.LocalizationOverride) obj).d() == null) {
                        z11 = true;
                        continue;
                    } else {
                        z11 = false;
                        continue;
                    }
                    if (z11) {
                        break;
                    }
                }
                NextStep.GovernmentId.LocalizationOverride localizationOverride2 = (NextStep.GovernmentId.LocalizationOverride) obj;
                if (!(localizationOverride2 == null || (k10 = localizationOverride2.k()) == null)) {
                    str2 = k10;
                }
            }
            linkedHashMap.put(c10, str2);
            if (arrayList2 != null) {
                ArrayList<NextStep.GovernmentId.LocalizationOverride> arrayList3 = new ArrayList<>();
                for (Object next4 : arrayList2) {
                    if (((NextStep.GovernmentId.LocalizationOverride) next4).d() != null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        arrayList3.add(next4);
                    }
                }
                for (NextStep.GovernmentId.LocalizationOverride localizationOverride3 : arrayList3) {
                    String str4 = side.c() + SignatureVisitor.SUPER + localizationOverride3.d();
                    if (linkedHashMap.get(str4) == null) {
                        linkedHashMap.put(str4, localizationOverride3.k());
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final InquiryState s(NextStep.Complete complete, String str, String str2, String str3, Map<String, ? extends InquiryField> map) {
        j.g(complete, "<this>");
        j.g(str, "sessionToken");
        j.g(str2, "inquiryId");
        if (map == null) {
            map = h0.i();
        }
        return new InquiryState.Complete(str2, str, (TransitionStatus) null, str3, map, 4, (DefaultConstructorMarker) null);
    }

    public static final InquiryState t(NextStep.Document document, String str, String str2) {
        j.g(document, "<this>");
        j.g(str, "sessionToken");
        j.g(str2, "inquiryId");
        return new InquiryState.DocumentStepRunning(str2, str, (TransitionStatus) null, document.d(), document.c().h().a(), document, document.a(), a(document.c().i(), document.c().h()), document.a(), 4, (DefaultConstructorMarker) null);
    }

    public static final InquiryState u(NextStep.GovernmentId governmentId, String str, String str2, String str3) {
        String str4;
        boolean z10;
        boolean z11;
        int i10;
        long j10;
        GovernmentIdPages governmentIdPages;
        boolean z12;
        j.g(governmentId, "<this>");
        j.g(str, "sessionToken");
        j.g(str2, "inquiryId");
        List<Id> g10 = governmentId.c().g();
        if (g10 == null) {
            g10 = q.j();
        }
        List<Id> list = g10;
        if (str3 == null) {
            str4 = "US";
        } else {
            str4 = str3;
        }
        String a10 = governmentId.a();
        String a11 = governmentId.a();
        Boolean a12 = governmentId.c().a();
        if (a12 != null) {
            z10 = a12.booleanValue();
        } else {
            z10 = false;
        }
        Boolean b10 = governmentId.c().b();
        if (b10 != null) {
            z11 = b10.booleanValue();
        } else {
            z11 = true;
        }
        boolean z13 = z11;
        NextStep.GovernmentId.Localizations j11 = governmentId.c().j();
        List<NextStep.GovernmentId.LocalizationOverride> i11 = governmentId.c().i();
        List<CaptureOptionNativeMobile> d10 = governmentId.c().d();
        if (d10 == null) {
            d10 = p.e(CaptureOptionNativeMobile.MOBILE_CAMERA);
        }
        List<CaptureOptionNativeMobile> list2 = d10;
        StepStyles$GovernmentIdStepStyle d11 = governmentId.d();
        Integer h10 = governmentId.c().h();
        if (h10 != null) {
            i10 = h10.intValue();
        } else {
            i10 = 3;
        }
        int i12 = i10;
        Long k10 = governmentId.c().k();
        if (k10 != null) {
            j10 = k10.longValue();
        } else {
            j10 = 8000;
        }
        String e10 = governmentId.c().e();
        String f10 = governmentId.c().f();
        NextStep.GovernmentId.Pages m10 = governmentId.c().m();
        if (m10 != null) {
            governmentIdPages = d(m10);
        } else {
            governmentIdPages = null;
        }
        GovernmentIdPages governmentIdPages2 = governmentIdPages;
        NextStep.CancelDialog a13 = governmentId.c().j().a();
        PassportNfcConfig m11 = m(governmentId.c().l());
        Boolean n10 = governmentId.c().n();
        if (n10 != null) {
            z12 = n10.booleanValue();
        } else {
            z12 = false;
        }
        List<NextStep.GovernmentId.CaptureFileType> c10 = governmentId.c().c();
        if (c10 == null) {
            c10 = q.j();
        }
        return new InquiryState.GovernmentIdStepRunning(str2, str, (TransitionStatus) null, d11, a13, str4, list, a10, a11, z10, z13, j11, i11, list2, i12, j10, e10, f10, governmentIdPages2, m11, z12, c10, 4, (DefaultConstructorMarker) null);
    }

    public static final InquiryState v(NextStep.Selfie selfie, String str, String str2) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        j.g(selfie, "<this>");
        j.g(str, "sessionToken");
        j.g(str2, "inquiryId");
        if (selfie.c().f() == NextStep.Selfie.CaptureMethod.ONLY_CENTER) {
            z10 = true;
        } else {
            z10 = false;
        }
        String a10 = selfie.a();
        String a11 = selfie.a();
        Boolean a12 = selfie.c().a();
        if (a12 != null) {
            z11 = a12.booleanValue();
        } else {
            z11 = false;
        }
        Boolean b10 = selfie.c().b();
        if (b10 != null) {
            z12 = b10.booleanValue();
        } else {
            z12 = true;
        }
        String d10 = selfie.c().d();
        Boolean g10 = selfie.c().g();
        if (g10 != null) {
            z13 = g10.booleanValue();
        } else {
            z13 = false;
        }
        NextStep.Selfie.Localizations e10 = selfie.c().e();
        StepStyles$SelfieStepStyle d11 = selfie.d();
        NextStep.CancelDialog a13 = selfie.c().e().a();
        List<NextStep.Selfie.CaptureFileType> c10 = selfie.c().c();
        if (c10 == null) {
            c10 = q.j();
        }
        return new InquiryState.SelfieStepRunning(str2, str, (TransitionStatus) null, d11, a13, z10, a10, a11, z11, z12, d10, z13, e10, c10, 4, (DefaultConstructorMarker) null);
    }

    public static final InquiryState w(NextStep.Ui ui2, String str, String str2, String str3, Map<String, ? extends InquiryField> map) {
        boolean z10;
        boolean z11;
        boolean z12;
        Map<String, ? extends InquiryField> map2;
        NextStep.CancelDialog cancelDialog;
        j.g(ui2, "<this>");
        j.g(str, "sessionToken");
        j.g(str2, "inquiryId");
        String a10 = ui2.a();
        List<UiComponent> components = ui2.c().getComponents();
        if (components == null) {
            components = q.j();
        }
        List<UiComponent> list = components;
        Boolean a11 = ui2.c().a();
        if (a11 != null) {
            z10 = a11.booleanValue();
        } else {
            z10 = false;
        }
        Boolean c10 = ui2.c().c();
        if (c10 != null) {
            z11 = c10.booleanValue();
        } else {
            z11 = true;
        }
        boolean z13 = z11;
        Boolean e10 = ui2.c().e();
        if (e10 != null) {
            z12 = e10.booleanValue();
        } else {
            z12 = false;
        }
        if (map == null) {
            map2 = h0.i();
        } else {
            map2 = map;
        }
        StepStyles$UiStepStyle b10 = ui2.b();
        String uuid = UUID.randomUUID().toString();
        NextStep.Ui.Localizations d10 = ui2.c().d();
        if (d10 != null) {
            cancelDialog = d10.a();
        } else {
            cancelDialog = null;
        }
        j.f(uuid, "toString()");
        return new InquiryState.UiStepRunning(str2, str, (TransitionStatus) null, b10, cancelDialog, str3, a10, list, z10, z13, z12, map2, uuid, 4, (DefaultConstructorMarker) null);
    }
}
