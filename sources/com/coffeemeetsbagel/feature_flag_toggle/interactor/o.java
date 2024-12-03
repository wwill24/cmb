package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import b6.d;
import b6.p;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.features.models.FeatureFlag;
import j5.x;
import java.util.List;

public class o extends p<FeatureFlagToggleView> implements i {

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f13489e;

    /* renamed from: f  reason: collision with root package name */
    private r f13490f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public e f13491g;

    /* renamed from: h  reason: collision with root package name */
    private d f13492h;

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            o.this.f13491g.getFilter().filter(charSequence);
        }
    }

    public o(d dVar, FeatureFlagToggleView featureFlagToggleView, r rVar) {
        super(featureFlagToggleView);
        this.f13492h = dVar;
        this.f13490f = rVar;
        this.f13489e = (RecyclerView) featureFlagToggleView.findViewById(R.id.feature_flag_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(dVar);
        this.f13489e.setLayoutManager(linearLayoutManager);
        e eVar = new e(this);
        this.f13491g = eVar;
        this.f13489e.setAdapter(eVar);
        this.f13489e.h(new i(this.f13489e.getContext(), linearLayoutManager.n2()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(x xVar) throws Exception {
        ((FeatureFlagToggleView) g()).setSearchText("");
    }

    public void a() {
        this.f13490f.b();
        this.f13492h.finish();
    }

    public void b(String str, boolean z10) {
        this.f13490f.d(str, z10);
    }

    /* access modifiers changed from: protected */
    public void d() {
        super.d();
        ((FeatureFlagToggleView) g()).b(new a());
        ((com.uber.autodispose.p) ((FeatureFlagToggleView) g()).c().a0(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new n(this));
    }

    public void m(List<FeatureFlag> list) {
        this.f13491g.H(list);
        this.f13491g.l();
    }
}
