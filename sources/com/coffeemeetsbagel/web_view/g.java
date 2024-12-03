package com.coffeemeetsbagel.web_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import b6.d;
import b6.j;
import com.coffeemeetsbagel.R;
import pc.f;
import pc.h;

public class g extends b6.c<i, a> {

    public interface a {
        d a();

        qc.a c();
    }

    public interface b extends j<f> {
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final WebViewMainView f37609a;

        c(WebViewMainView webViewMainView) {
            this.f37609a = webViewMainView;
        }

        /* access modifiers changed from: package-private */
        public h a() {
            return new h(this.f37609a);
        }
    }

    public g(a aVar) {
        super(aVar);
    }

    public i b(ViewGroup viewGroup) {
        f fVar = new f();
        WebViewMainView webViewMainView = (WebViewMainView) LayoutInflater.from(((a) a()).a()).inflate(R.layout.web_view_component, viewGroup, false);
        return new i(webViewMainView, b.a().c(new c(webViewMainView)).b((a) a()).a(), fVar);
    }
}
