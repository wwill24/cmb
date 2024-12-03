package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.camera.AutoCaptureRule;
import com.withpersona.sdk2.camera.AutoCaptureRuleSet;
import com.withpersona.sdk2.camera.ExtractedTexts;
import com.withpersona.sdk2.camera.e;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.governmentid.network.IdClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class o {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26002a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f26003b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f26004c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f26005d;

        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|(2:51|52)|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|51|52|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|51|52|53|55) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|43|44|45|46|47|48|49|50|51|52|53|55) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0055 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0076 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00a7 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00b7 */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$RuleType[] r0 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.RuleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$RuleType r2 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.RuleType.ID_FRONT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$RuleType r3 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.RuleType.ID_FRONT_OR_BACK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$RuleType r4 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.RuleType.BARCODE_PDF417     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$RuleType r5 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.RuleType.PASSPORT_MRZ     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$RuleType r6 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.RuleType.TEXT_EXTRACTION     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f26002a = r0
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayLocalIcon[] r0 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.OverlayLocalIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.OverlayLocalIcon.BARCODE     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.OverlayLocalIcon.PASSPORT     // Catch:{ NoSuchFieldError -> 0x004d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.OverlayLocalIcon.ID_FRONT     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.OverlayLocalIcon.ID_BACK     // Catch:{ NoSuchFieldError -> 0x005d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig.OverlayLocalIcon.EMPTY     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                f26003b = r0
                com.withpersona.sdk2.inquiry.governmentid.network.Id$IdLocalIcon[] r0 = com.withpersona.sdk2.inquiry.governmentid.network.Id.IdLocalIcon.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.network.Id$IdLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.Id.IdLocalIcon.WORLD     // Catch:{ NoSuchFieldError -> 0x0076 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0076 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0076 }
            L_0x0076:
                com.withpersona.sdk2.inquiry.governmentid.network.Id$IdLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.Id.IdLocalIcon.CARD     // Catch:{ NoSuchFieldError -> 0x007e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                com.withpersona.sdk2.inquiry.governmentid.network.Id$IdLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.Id.IdLocalIcon.FLAG     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                com.withpersona.sdk2.inquiry.governmentid.network.Id$IdLocalIcon r6 = com.withpersona.sdk2.inquiry.governmentid.network.Id.IdLocalIcon.HOUSE     // Catch:{ NoSuchFieldError -> 0x008e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r0[r6] = r4     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                f26004c = r0
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side[] r0 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r6 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Front     // Catch:{ NoSuchFieldError -> 0x009f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.Back     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.BarcodePdf417     // Catch:{ NoSuchFieldError -> 0x00af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.FrontOrBack     // Catch:{ NoSuchFieldError -> 0x00b7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b7 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00b7 }
            L_0x00b7:
                com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.PassportSignature     // Catch:{ NoSuchFieldError -> 0x00bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bf }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00bf }
            L_0x00bf:
                f26005d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.o.a.<clinit>():void");
        }
    }

    private static final IdConfig.AutoCaptureConfig a(IdConfig.Side side) {
        int i10 = a.f26005d[side.ordinal()];
        if (i10 == 1) {
            return new IdConfig.AutoCaptureConfig(new AutoCaptureRuleSet(p.e(new AutoCaptureRule.FrontRule(false, 1, (DefaultConstructorMarker) null))));
        }
        if (i10 == 2) {
            return new IdConfig.AutoCaptureConfig(new AutoCaptureRuleSet(p.e(new AutoCaptureRule.BarcodePdf417Rule(false, 1, (DefaultConstructorMarker) null))));
        }
        if (i10 == 3) {
            return new IdConfig.AutoCaptureConfig(new AutoCaptureRuleSet(p.e(new AutoCaptureRule.BarcodePdf417Rule(false, 1, (DefaultConstructorMarker) null))));
        }
        if (i10 == 4) {
            return new IdConfig.AutoCaptureConfig(new AutoCaptureRuleSet(p.e(new AutoCaptureRule.FrontOrBackRule(false, 1, (DefaultConstructorMarker) null))));
        }
        if (i10 == 5) {
            return new IdConfig.AutoCaptureConfig((AutoCaptureRuleSet) null, 1, (DefaultConstructorMarker) null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final IdConfig.ManualCaptureConfig b(long j10) {
        return new IdConfig.ManualCaptureConfig(true, j10);
    }

    private static final GovernmentIdWorkflow.Screen.Overlay c(IdClass idClass, IdConfig.Side side, String str) {
        if (side == IdConfig.Side.BarcodePdf417) {
            return GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a;
        }
        if (side == IdConfig.Side.PassportSignature) {
            return GovernmentIdWorkflow.Screen.Overlay.Rectangle.f25561a;
        }
        IdClass idClass2 = IdClass.DriverLicense;
        if (idClass == idClass2 && side == IdConfig.Side.Back && j.b(str, "US")) {
            return GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a;
        }
        if (idClass == IdClass.Passport) {
            return GovernmentIdWorkflow.Screen.Overlay.Passport.f25560a;
        }
        if (idClass == IdClass.Visa) {
            return GovernmentIdWorkflow.Screen.Overlay.Passport.f25560a;
        }
        if (idClass == idClass2) {
            return GovernmentIdWorkflow.Screen.Overlay.GenericFront.f25559a;
        }
        if (idClass == IdClass.StateID) {
            return GovernmentIdWorkflow.Screen.Overlay.GenericFront.f25559a;
        }
        if (idClass == IdClass.ResidencyPermit) {
            return GovernmentIdWorkflow.Screen.Overlay.GenericFront.f25559a;
        }
        return GovernmentIdWorkflow.Screen.Overlay.Rectangle.f25561a;
    }

    private static final boolean d(CapturePageConfig.RuleSet ruleSet) {
        boolean z10;
        boolean z11;
        List<CapturePageConfig.Rule> a10 = ruleSet.a();
        if (a10 != null) {
            z10 = false;
            z11 = true;
            for (CapturePageConfig.Rule rule : a10) {
                if (j.b(rule.c(), Boolean.TRUE) && rule.a() == null) {
                    z11 = false;
                } else if (rule.a() != null) {
                    z10 = true;
                }
            }
        } else {
            z10 = false;
            z11 = true;
        }
        if (!z11 || !z10) {
            return false;
        }
        return true;
    }

    private static final AutoCaptureRule e(CapturePageConfig.Rule rule) {
        int i10;
        CapturePageConfig.RuleType a10 = rule.a();
        if (a10 == null) {
            i10 = -1;
        } else {
            i10 = a.f26002a[a10.ordinal()];
        }
        if (i10 == -1) {
            return null;
        }
        if (i10 == 1) {
            return new AutoCaptureRule.FrontRule(j.b(rule.c(), Boolean.TRUE));
        }
        if (i10 == 2) {
            return new AutoCaptureRule.FrontOrBackRule(j.b(rule.c(), Boolean.TRUE));
        }
        if (i10 == 3) {
            return new AutoCaptureRule.BarcodePdf417Rule(j.b(rule.c(), Boolean.TRUE));
        }
        if (i10 == 4) {
            return new AutoCaptureRule.MrzRule(j.b(rule.c(), Boolean.TRUE));
        }
        if (i10 == 5) {
            return new AutoCaptureRule.TextExtractionRule(j.b(rule.c(), Boolean.TRUE));
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final AutoCaptureRuleSet f(CapturePageConfig.RuleSet ruleSet) {
        List list;
        List<CapturePageConfig.Rule> a10 = ruleSet.a();
        if (a10 != null) {
            list = new ArrayList();
            for (CapturePageConfig.Rule e10 : a10) {
                AutoCaptureRule e11 = e(e10);
                if (e11 != null) {
                    list.add(e11);
                }
            }
        } else {
            list = q.j();
        }
        return new AutoCaptureRuleSet(list);
    }

    private static final GovernmentIdWorkflow.Screen.Overlay g(CapturePageConfig.OverlayConfig overlayConfig) {
        int i10;
        if (overlayConfig.a() != null) {
            return new GovernmentIdWorkflow.Screen.Overlay.Custom(overlayConfig.a());
        }
        CapturePageConfig.OverlayLocalIcon c10 = overlayConfig.c();
        if (c10 == null) {
            i10 = -1;
        } else {
            i10 = a.f26003b[c10.ordinal()];
        }
        if (i10 == -1) {
            return GovernmentIdWorkflow.Screen.Overlay.Rectangle.f25561a;
        }
        if (i10 == 1) {
            return GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a;
        }
        if (i10 == 2) {
            return GovernmentIdWorkflow.Screen.Overlay.Passport.f25560a;
        }
        if (i10 == 3) {
            return GovernmentIdWorkflow.Screen.Overlay.GenericFront.f25559a;
        }
        if (i10 == 4) {
            return GovernmentIdWorkflow.Screen.Overlay.Barcode.f25557a;
        }
        if (i10 == 5) {
            return GovernmentIdWorkflow.Screen.Overlay.Rectangle.f25561a;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final IdConfig.AutoCaptureConfig h(CapturePageConfig.AutoCaptureConfig autoCaptureConfig) {
        T t10;
        j.g(autoCaptureConfig, "<this>");
        if (autoCaptureConfig.a() == null) {
            return null;
        }
        if (autoCaptureConfig.a().isEmpty()) {
            return new IdConfig.AutoCaptureConfig((AutoCaptureRuleSet) null, 1, (DefaultConstructorMarker) null);
        }
        Iterator<T> it = autoCaptureConfig.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                t10 = null;
                break;
            }
            t10 = it.next();
            if (d((CapturePageConfig.RuleSet) t10)) {
                break;
            }
        }
        CapturePageConfig.RuleSet ruleSet = (CapturePageConfig.RuleSet) t10;
        if (ruleSet == null) {
            return new IdConfig.AutoCaptureConfig((AutoCaptureRuleSet) null, 1, (DefaultConstructorMarker) null);
        }
        return new IdConfig.AutoCaptureConfig(f(ruleSet));
    }

    public static final IdConfig.ManualCaptureConfig i(CapturePageConfig.ManualCaptureConfig manualCaptureConfig, long j10) {
        boolean z10;
        j.g(manualCaptureConfig, "<this>");
        Boolean c10 = manualCaptureConfig.c();
        if (c10 != null) {
            z10 = c10.booleanValue();
        } else {
            z10 = true;
        }
        Long a10 = manualCaptureConfig.a();
        if (a10 != null) {
            j10 = a10.longValue();
        }
        return new IdConfig.ManualCaptureConfig(z10, j10);
    }

    public static final GovernmentIdDetails j(e eVar) {
        Date date;
        j.g(eVar, "<this>");
        if (eVar instanceof e.a) {
            e.a aVar = (e.a) eVar;
            return new GovernmentIdDetails(aVar.b(), aVar.c());
        } else if (eVar instanceof e.b) {
            e.b bVar = (e.b) eVar;
            com.withpersona.sdk2.camera.a b10 = bVar.b();
            Date date2 = null;
            if (b10 != null) {
                date = b10.n();
            } else {
                date = null;
            }
            com.withpersona.sdk2.camera.a b11 = bVar.b();
            if (b11 != null) {
                date2 = b11.o();
            }
            return new GovernmentIdDetails(date, date2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final GovernmentIdDetails k(ExtractedTexts extractedTexts) {
        j.g(extractedTexts, "<this>");
        return new GovernmentIdDetails(extractedTexts.a(), extractedTexts.c());
    }

    private static final int l(Id.IdLocalIcon idLocalIcon) {
        int i10;
        if (idLocalIcon == null) {
            i10 = -1;
        } else {
            i10 = a.f26004c[idLocalIcon.ordinal()];
        }
        if (i10 == -1) {
            return k0.pi2_governmentid_card;
        }
        if (i10 == 1) {
            return k0.pi2_governmentid_world;
        }
        if (i10 == 2) {
            return k0.pi2_governmentid_card;
        }
        if (i10 == 3) {
            return k0.pi2_governmentid_flag;
        }
        if (i10 == 4) {
            return k0.pi2_governmentid_house;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c2, code lost:
        if (r10 == null) goto L_0x00c8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.withpersona.sdk2.inquiry.governmentid.IdConfig m(com.withpersona.sdk2.inquiry.governmentid.network.Id r16, java.lang.String r17, long r18, com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig r20) {
        /*
            r0 = r17
            java.lang.String r1 = "<this>"
            r2 = r16
            kotlin.jvm.internal.j.g(r2, r1)
            java.lang.String r1 = "countryCode"
            kotlin.jvm.internal.j.g(r0, r1)
            java.lang.String r1 = "passportNfcConfig"
            r3 = r20
            kotlin.jvm.internal.j.g(r3, r1)
            com.withpersona.sdk2.inquiry.governmentid.network.IdClass$a r1 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.f25844a
            java.lang.String r4 = r16.c()
            com.withpersona.sdk2.inquiry.governmentid.network.IdClass r1 = r1.a(r4)
            com.withpersona.sdk2.inquiry.governmentid.network.IdClass r4 = com.withpersona.sdk2.inquiry.governmentid.network.IdClass.I
            r5 = 0
            if (r1 != r4) goto L_0x002b
            boolean r4 = r16.g()
            if (r4 != 0) goto L_0x002b
            return r5
        L_0x002b:
            com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig$PassportNfcOption r3 = r20.c()
            com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig$PassportNfcOption r4 = com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig.PassportNfcOption.Required
            if (r3 != r4) goto L_0x0048
            java.lang.Boolean r3 = r16.f()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.jvm.internal.j.b(r3, r4)
            if (r3 == 0) goto L_0x0048
            com.withpersona.sdk2.inquiry.nfc.a r3 = com.withpersona.sdk2.inquiry.nfc.a.f27071a
            boolean r3 = r3.c()
            if (r3 != 0) goto L_0x0048
            return r5
        L_0x0048:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            java.util.List r4 = r16.a()
            if (r4 == 0) goto L_0x0071
            java.util.Iterator r4 = r4.iterator()
        L_0x0057:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0071
            java.lang.Object r6 = r4.next()
            com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig r6 = (com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig) r6
            java.lang.String r7 = r6.e()
            if (r7 == 0) goto L_0x0057
            java.lang.String r7 = r6.e()
            r3.put(r7, r6)
            goto L_0x0057
        L_0x0071:
            java.util.List r4 = r16.e()
            java.util.ArrayList r9 = new java.util.ArrayList
            r6 = 10
            int r7 = kotlin.collections.r.t(r4, r6)
            r9.<init>(r7)
            java.util.Iterator r4 = r4.iterator()
        L_0x0084:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0108
            java.lang.Object r7 = r4.next()
            r11 = r7
            java.lang.String r11 = (java.lang.String) r11
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side$a r7 = com.withpersona.sdk2.inquiry.governmentid.IdConfig.Side.f25666a
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r12 = r7.a(r11)
            if (r12 != 0) goto L_0x009a
            return r5
        L_0x009a:
            java.lang.Object r8 = r3.get(r11)
            com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig r8 = (com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig) r8
            if (r8 == 0) goto L_0x00ae
            com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$AutoCaptureConfig r10 = r8.a()
            if (r10 == 0) goto L_0x00ae
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$AutoCaptureConfig r10 = h(r10)
            if (r10 != 0) goto L_0x00b2
        L_0x00ae:
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$AutoCaptureConfig r10 = a(r12)
        L_0x00b2:
            r14 = r10
            if (r8 == 0) goto L_0x00c5
            com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$ManualCaptureConfig r10 = r8.c()
            if (r10 == 0) goto L_0x00c5
            r13 = r7
            r6 = r18
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$ManualCaptureConfig r10 = i(r10, r6)
            if (r10 != 0) goto L_0x00cc
            goto L_0x00c8
        L_0x00c5:
            r13 = r7
            r6 = r18
        L_0x00c8:
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$ManualCaptureConfig r10 = b(r18)
        L_0x00cc:
            r15 = r10
            com.withpersona.sdk2.camera.AutoCaptureRuleSet r10 = r14.a()
            java.util.List r10 = r10.a()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00e2
            boolean r10 = r15.c()
            if (r10 != 0) goto L_0x00e2
            return r5
        L_0x00e2:
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$IdSideConfig r10 = new com.withpersona.sdk2.inquiry.governmentid.IdConfig$IdSideConfig
            if (r8 == 0) goto L_0x00f2
            com.withpersona.sdk2.inquiry.governmentid.network.CapturePageConfig$OverlayConfig r8 = r8.d()
            if (r8 == 0) goto L_0x00f2
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$Overlay r8 = g(r8)
            if (r8 != 0) goto L_0x00fb
        L_0x00f2:
            r8 = r13
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r8 = r8.a(r11)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$Overlay r8 = c(r1, r8, r0)
        L_0x00fb:
            r13 = r8
            r8 = r10
            r10 = r8
            r10.<init>(r11, r12, r13, r14, r15)
            r9.add(r8)
            r6 = 10
            goto L_0x0084
        L_0x0108:
            java.lang.String r7 = r16.c()
            boolean r0 = r16.g()
            if (r0 == 0) goto L_0x0121
            com.withpersona.sdk2.inquiry.governmentid.network.Id$IdIcon r0 = r16.d()
            if (r0 == 0) goto L_0x011c
            com.withpersona.sdk2.inquiry.governmentid.network.Id$IdLocalIcon r5 = r0.a()
        L_0x011c:
            int r0 = l(r5)
            goto L_0x0125
        L_0x0121:
            int r0 = r1.c()
        L_0x0125:
            r8 = r0
            java.util.ArrayList r10 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.r.t(r9, r0)
            r10.<init>(r0)
            java.util.Iterator r0 = r9.iterator()
        L_0x0135:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x014e
            java.lang.Object r1 = r0.next()
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$IdSideConfig r1 = (com.withpersona.sdk2.inquiry.governmentid.IdConfig.IdSideConfig) r1
            com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart r3 = new com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r1 = r1.e()
            r3.<init>(r1)
            r10.add(r3)
            goto L_0x0135
        L_0x014e:
            java.lang.Boolean r0 = r16.f()
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r11 = kotlin.jvm.internal.j.b(r0, r1)
            com.withpersona.sdk2.inquiry.governmentid.IdConfig r0 = new com.withpersona.sdk2.inquiry.governmentid.IdConfig
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.o.m(com.withpersona.sdk2.inquiry.governmentid.network.Id, java.lang.String, long, com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig):com.withpersona.sdk2.inquiry.governmentid.IdConfig");
    }
}
