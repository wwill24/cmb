package r5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.google.android.material.bottomsheet.b;
import kotlin.jvm.internal.j;
import q5.l;
import q5.m;

public final class e extends b {

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f17282b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17283c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17284d;

    /* renamed from: e  reason: collision with root package name */
    private final a f17285e;

    public interface a {
        void a();

        void b();
    }

    public e(FragmentManager fragmentManager, String str, String str2, a aVar) {
        j.g(fragmentManager, "fm");
        j.g(str, "firstButtonText");
        j.g(str2, "secondButtonText");
        j.g(aVar, "buttonClickListener");
        this.f17282b = fragmentManager;
        this.f17283c = str;
        this.f17284d = str2;
        this.f17285e = aVar;
    }

    /* access modifiers changed from: private */
    public static final void F0(e eVar, View view) {
        j.g(eVar, "this$0");
        eVar.f17285e.b();
    }

    /* access modifiers changed from: private */
    public static final void G0(e eVar, View view) {
        j.g(eVar, "this$0");
        eVar.f17285e.a();
    }

    public final void H0() {
        show(this.f17282b, getTag());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(m.dialog_two_buttons, viewGroup, false);
        CmbTextView cmbTextView = (CmbTextView) inflate.findViewById(l.first_button);
        cmbTextView.setText(this.f17283c);
        cmbTextView.setOnClickListener(new c(this));
        CmbTextView cmbTextView2 = (CmbTextView) inflate.findViewById(l.second_button);
        cmbTextView2.setText(this.f17284d);
        cmbTextView2.setOnClickListener(new d(this));
        return inflate;
    }
}
