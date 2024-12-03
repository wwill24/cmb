package sc;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import b6.p;
import com.coffemeetsbagel.hide_report.HideReportType;
import com.coffemeetsbagel.hide_report.a0;
import kotlin.jvm.internal.j;

public final class e extends p<View> {
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final rc.b f41921e;

    /* renamed from: f  reason: collision with root package name */
    private final j f41922f;

    /* renamed from: g  reason: collision with root package name */
    private final HideReportType f41923g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f41924h;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41925a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffemeetsbagel.hide_report.HideReportType[] r0 = com.coffemeetsbagel.hide_report.HideReportType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffemeetsbagel.hide_report.HideReportType r1 = com.coffemeetsbagel.hide_report.HideReportType.HIDE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffemeetsbagel.hide_report.HideReportType r1 = com.coffemeetsbagel.hide_report.HideReportType.REPORT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f41925a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sc.e.a.<clinit>():void");
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f41926a;

        b(e eVar) {
            this.f41926a = eVar;
        }

        public void afterTextChanged(Editable editable) {
            j.g(editable, "s");
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "s");
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            j.g(charSequence, "s");
            this.f41926a.f41921e.f41821b.setEnabled(charSequence.length() > 0);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(rc.b bVar, j jVar, HideReportType hideReportType, boolean z10) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        j.g(jVar, "listener");
        j.g(hideReportType, "type");
        this.f41921e = bVar;
        this.f41922f = jVar;
        this.f41923g = hideReportType;
        this.f41924h = z10;
    }

    /* access modifiers changed from: private */
    public static final void l(e eVar, View view) {
        j.g(eVar, "this$0");
        eVar.f41922f.D0(String.valueOf(eVar.f41921e.f41825f.getText()));
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        this.f41921e.f41821b.setEnabled(false);
        int i10 = a.f41925a[this.f41923g.ordinal()];
        if (i10 == 1) {
            this.f41921e.f41822c.setVisibility(8);
            this.f41921e.f41823d.setVisibility(8);
            if (this.f41924h) {
                this.f41921e.f41821b.setText(this.f7869c.getResources().getString(a0.hide_post_connection_cta_title));
            } else {
                this.f41921e.f41821b.setText(this.f7869c.getResources().getString(a0.hide_pre_connection_cta_title));
            }
        } else if (i10 == 2) {
            this.f41921e.f41822c.setVisibility(0);
            this.f41921e.f41823d.setVisibility(0);
            if (this.f41924h) {
                this.f41921e.f41821b.setText(this.f7869c.getResources().getString(a0.report_post_connection_cta_title));
            } else {
                this.f41921e.f41821b.setText(this.f7869c.getResources().getString(a0.report_pre_connection_cta_title));
            }
        }
        this.f41921e.f41825f.addTextChangedListener(new b(this));
        this.f41921e.f41821b.setOnClickListener(new d(this));
        this.f41921e.f41825f.l();
    }
}
