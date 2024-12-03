package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.features.models.FeatureFlag;
import java.util.ArrayList;
import java.util.List;

public class e extends RecyclerView.Adapter<RecyclerView.d0> implements Filterable {

    /* renamed from: d  reason: collision with root package name */
    private List<FeatureFlag> f13475d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public i f13476e;

    /* renamed from: f  reason: collision with root package name */
    private d f13477f;

    public class a extends RecyclerView.d0 implements h {

        /* renamed from: u  reason: collision with root package name */
        private final r9.b f13478u;

        a(View view) {
            super(view);
            r9.b bVar = (r9.b) view;
            this.f13478u = bVar;
            bVar.b(this);
        }

        public void a() {
            e.this.f13476e.a();
        }

        public void e(boolean z10) {
        }
    }

    public class b extends RecyclerView.d0 implements h {

        /* renamed from: u  reason: collision with root package name */
        private final r9.e f13480u;

        /* renamed from: v  reason: collision with root package name */
        private String f13481v;

        b(View view) {
            super(view);
            r9.e eVar = (r9.e) view;
            this.f13480u = eVar;
            eVar.c(this);
        }

        /* access modifiers changed from: package-private */
        public void V(FeatureFlag featureFlag, String str) {
            this.f13481v = str;
            this.f13480u.d(featureFlag);
        }

        public void a() {
        }

        public void e(boolean z10) {
            e.this.f13476e.b(this.f13481v, z10);
        }
    }

    e(i iVar) {
        this.f13476e = iVar;
        this.f13477f = new d(this, this.f13475d);
    }

    public void H(List<FeatureFlag> list) {
        this.f13475d = list;
        this.f13477f.a(list);
    }

    public void I(List<FeatureFlag> list) {
        this.f13475d = list;
    }

    public int g() {
        if (this.f13475d.size() == 0) {
            return 0;
        }
        return this.f13475d.size() + 1;
    }

    public Filter getFilter() {
        return this.f13477f;
    }

    public int i(int i10) {
        return i10 < this.f13475d.size() ? 0 : 1;
    }

    public void v(RecyclerView.d0 d0Var, int i10) {
        if (d0Var instanceof b) {
            FeatureFlag featureFlag = this.f13475d.get(i10);
            ((b) d0Var).V(featureFlag, featureFlag.getKey());
        }
    }

    public RecyclerView.d0 x(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            return new b(new r9.e(viewGroup.getContext()));
        }
        return new a(new r9.b(viewGroup.getContext()));
    }
}
