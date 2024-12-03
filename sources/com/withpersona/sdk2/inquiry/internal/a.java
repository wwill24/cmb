package com.withpersona.sdk2.inquiry.internal;

import android.os.Build;
import android.os.Bundle;
import com.withpersona.sdk2.inquiry.document.DocumentFile;
import com.withpersona.sdk2.inquiry.document.network.DocumentStepData;
import com.withpersona.sdk2.inquiry.governmentid.Frame;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdDetails;
import com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdStepData;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.network.SelfieStepData;
import com.withpersona.sdk2.inquiry.shared.data_collection.StepData;
import com.withpersona.sdk2.inquiry.types.collected_data.GovernmentIdCapture;
import com.withpersona.sdk2.inquiry.types.collected_data.SelfieCapture;
import com.withpersona.sdk2.inquiry.types.collected_data.a;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import com.withpersona.sdk2.inquiry.ui.network.UiStepData;
import dj.b;
import dj.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.j;

public final class a {

    /* renamed from: com.withpersona.sdk2.inquiry.internal.a$a  reason: collision with other inner class name */
    public /* synthetic */ class C0317a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26283a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f26284b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f26285c;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        static {
            /*
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side[] r0 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side r2 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.FRONT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side r3 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.BACK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$Side r4 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.Side.FRONT_AND_BACK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f26283a = r0
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$CaptureMethod[] r0 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.CaptureMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$CaptureMethod r4 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.CaptureMethod.f25318a     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$CaptureMethod r4 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.CaptureMethod.f25319b     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.withpersona.sdk2.inquiry.governmentid.GovernmentId$CaptureMethod r4 = com.withpersona.sdk2.inquiry.governmentid.GovernmentId.CaptureMethod.f25320c     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                f26284b = r0
                com.withpersona.sdk2.inquiry.selfie.Selfie$CaptureMethod[] r0 = com.withpersona.sdk2.inquiry.selfie.Selfie.CaptureMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.withpersona.sdk2.inquiry.selfie.Selfie$CaptureMethod r3 = com.withpersona.sdk2.inquiry.selfie.Selfie.CaptureMethod.AUTO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.withpersona.sdk2.inquiry.selfie.Selfie$CaptureMethod r1 = com.withpersona.sdk2.inquiry.selfie.Selfie.CaptureMethod.MANUAL     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                f26285c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.internal.a.C0317a.<clinit>():void");
        }
    }

    public static final dj.a a(Bundle bundle) {
        ArrayList<StepData> arrayList;
        ArrayList arrayList2;
        j.g(bundle, "<this>");
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList = bundle.getParcelableArrayList("COLLECTED_DATA", StepData.class);
        } else {
            arrayList = bundle.getParcelableArrayList("COLLECTED_DATA");
        }
        if (arrayList != null) {
            arrayList2 = new ArrayList();
            for (StepData stepData : arrayList) {
                j.f(stepData, "it");
                com.withpersona.sdk2.inquiry.types.collected_data.a h10 = h(stepData);
                if (h10 != null) {
                    arrayList2.add(h10);
                }
            }
        } else {
            arrayList2 = null;
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            return null;
        }
        return new dj.a(arrayList2);
    }

    private static final GovernmentIdCapture b(GovernmentId governmentId) {
        GovernmentIdCapture.Side side;
        GovernmentIdCapture.CaptureMethod captureMethod;
        GovernmentIdCapture.a aVar;
        String g12 = governmentId.g1();
        int i10 = C0317a.f26283a[governmentId.I0().ordinal()];
        if (i10 == 1) {
            side = GovernmentIdCapture.Side.Front;
        } else if (i10 == 2) {
            side = GovernmentIdCapture.Side.Back;
        } else if (i10 == 3) {
            side = GovernmentIdCapture.Side.FrontAndBack;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int i11 = C0317a.f26284b[governmentId.M1().ordinal()];
        if (i11 == 1) {
            captureMethod = GovernmentIdCapture.CaptureMethod.Auto;
        } else if (i11 == 2) {
            captureMethod = GovernmentIdCapture.CaptureMethod.Manual;
        } else if (i11 == 3) {
            captureMethod = GovernmentIdCapture.CaptureMethod.Upload;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        List<Frame> U1 = governmentId.U1();
        ArrayList arrayList = new ArrayList();
        for (Frame frame : U1) {
            File file = new File(frame.a());
            if (file.exists()) {
                aVar = new GovernmentIdCapture.a(file, frame.c());
            } else {
                aVar = null;
            }
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        return new GovernmentIdCapture(g12, side, captureMethod, arrayList);
    }

    private static final SelfieCapture c(Selfie selfie) {
        SelfieCapture.CaptureMethod captureMethod;
        if (!new File(selfie.a()).exists()) {
            return null;
        }
        int i10 = C0317a.f26285c[selfie.c().ordinal()];
        if (i10 == 1) {
            captureMethod = SelfieCapture.CaptureMethod.Auto;
        } else if (i10 == 2) {
            captureMethod = SelfieCapture.CaptureMethod.Manual;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new SelfieCapture(captureMethod, new File(selfie.a()));
    }

    private static final b d(List<GovernmentIdDetails> list) {
        Iterator<GovernmentIdDetails> it = list.iterator();
        while (true) {
            Date date = null;
            if (!it.hasNext()) {
                return new b((Date) null, (Date) null);
            }
            GovernmentIdDetails next = it.next();
            if (next != null) {
                date = next.a();
            }
            if (date != null && next.c() != null) {
                return new b(next.a(), next.c());
            }
        }
    }

    private static final com.withpersona.sdk2.inquiry.types.collected_data.a e(DocumentStepData documentStepData) {
        c cVar;
        String c10 = documentStepData.c();
        List<DocumentFile> a10 = documentStepData.a();
        ArrayList arrayList = new ArrayList();
        for (DocumentFile documentFile : a10) {
            if (documentFile instanceof DocumentFile.Local) {
                cVar = new c(new File(((DocumentFile.Local) documentFile).d()));
            } else if (documentFile instanceof DocumentFile.Remote) {
                String a11 = ((DocumentFile.Remote) documentFile).a();
                if (a11 != null) {
                    cVar = new c(new File(a11));
                } else {
                    cVar = null;
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return new a.C0332a(c10, arrayList);
    }

    private static final com.withpersona.sdk2.inquiry.types.collected_data.a f(GovernmentIdStepData governmentIdStepData) {
        String c10 = governmentIdStepData.c();
        List<GovernmentId> a10 = governmentIdStepData.a();
        ArrayList arrayList = new ArrayList(r.t(a10, 10));
        for (GovernmentId b10 : a10) {
            arrayList.add(b(b10));
        }
        List<GovernmentId> a11 = governmentIdStepData.a();
        ArrayList<GovernmentId.GovernmentIdImage> arrayList2 = new ArrayList<>();
        for (T next : a11) {
            if (next instanceof GovernmentId.GovernmentIdImage) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(r.t(arrayList2, 10));
        for (GovernmentId.GovernmentIdImage d10 : arrayList2) {
            arrayList3.add(d10.d());
        }
        return new a.b(c10, arrayList, d(arrayList3));
    }

    private static final com.withpersona.sdk2.inquiry.types.collected_data.a g(SelfieStepData selfieStepData) {
        SelfieCapture selfieCapture;
        SelfieCapture selfieCapture2;
        String c10 = selfieStepData.c();
        Selfie a10 = selfieStepData.a();
        SelfieCapture selfieCapture3 = null;
        if (a10 != null) {
            selfieCapture = c(a10);
        } else {
            selfieCapture = null;
        }
        Selfie a11 = selfieStepData.a();
        if (a11 != null) {
            selfieCapture2 = c(a11);
        } else {
            selfieCapture2 = null;
        }
        Selfie a12 = selfieStepData.a();
        if (a12 != null) {
            selfieCapture3 = c(a12);
        }
        return new a.c(c10, selfieCapture, selfieCapture2, selfieCapture3);
    }

    public static final com.withpersona.sdk2.inquiry.types.collected_data.a h(StepData stepData) {
        j.g(stepData, "<this>");
        if (stepData instanceof UiStepData) {
            return i((UiStepData) stepData);
        }
        if (stepData instanceof SelfieStepData) {
            return g((SelfieStepData) stepData);
        }
        if (stepData instanceof GovernmentIdStepData) {
            return f((GovernmentIdStepData) stepData);
        }
        if (stepData instanceof DocumentStepData) {
            return e((DocumentStepData) stepData);
        }
        return null;
    }

    public static final com.withpersona.sdk2.inquiry.types.collected_data.a i(UiStepData uiStepData) {
        j.g(uiStepData, "<this>");
        String c10 = uiStepData.c();
        Map<String, ComponentParam> a10 = uiStepData.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.e(a10.size()));
        for (Map.Entry entry : a10.entrySet()) {
            linkedHashMap.put(entry.getKey(), com.withpersona.sdk2.inquiry.ui.network.a.a((ComponentParam) entry.getValue()));
        }
        return new a.d(c10, linkedHashMap);
    }
}
