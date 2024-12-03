package com.coffeemeetsbagel.feature_flag_toggle.interactor;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.c;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.experiment.r;
import com.coffeemeetsbagel.feature_flag_toggle.b;

public class f extends c<p, b.a> {

    public interface a extends j<l> {
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        private final l f13483a;

        /* renamed from: b  reason: collision with root package name */
        private final FeatureFlagToggleView f13484b;

        public b(l lVar, FeatureFlagToggleView featureFlagToggleView) {
            this.f13483a = lVar;
            this.f13484b = featureFlagToggleView;
        }

        /* access modifiers changed from: package-private */
        public o a(d dVar, r rVar) {
            return new o(dVar, this.f13484b, rVar);
        }
    }

    public f(b.a aVar) {
        super(aVar);
    }

    public p b(ViewGroup viewGroup) {
        FeatureFlagToggleView featureFlagToggleView = (FeatureFlagToggleView) LayoutInflater.from(((b.a) a()).a()).inflate(R.layout.feature_flag_toggle, viewGroup, false);
        l lVar = new l();
        return new p(featureFlagToggleView, b.a().b(new b(lVar, featureFlagToggleView)).c((b.a) a()).a(), lVar);
    }
}
