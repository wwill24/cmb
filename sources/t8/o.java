package t8;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import com.coffeemeetsbagel.photo.Photo;
import java.util.List;
import jc.b;
import t8.l;

public class o implements m {

    /* renamed from: a  reason: collision with root package name */
    l f17908a;

    /* renamed from: b  reason: collision with root package name */
    n f17909b;

    class a implements l.a {
        a() {
        }

        public void a() {
            n nVar = o.this.f17909b;
            if (nVar != null) {
                nVar.d0();
            }
        }
    }

    public o(l lVar, n nVar) {
        this.f17908a = lVar;
        this.f17909b = nVar;
    }

    public String a(int i10) {
        return this.f17908a.a(i10);
    }

    public void b(b<Integer> bVar, String str, int i10) {
        this.f17908a.c(bVar, str, i10);
    }

    public void c(Activity activity, int i10, boolean z10, String str, String str2) {
        this.f17908a.h(activity, i10, z10, str, str2);
    }

    public String d() {
        return this.f17908a.d();
    }

    public String e() {
        return this.f17908a.e();
    }

    public boolean f(Uri uri, String str, int i10, Activity activity, boolean z10, String str2, String str3, String str4, boolean z11) {
        return this.f17908a.k(uri, str, i10, activity, z10, str2, str3, str4, z11, false);
    }

    public void g(Activity activity, int i10, boolean z10, String str, String str2, View view) {
        n nVar = this.f17909b;
        if (nVar != null) {
            nVar.y0();
        }
        this.f17908a.l(activity, i10, z10, str, str2, view, new a());
    }

    public void h(List<Photo> list) {
        this.f17908a.b(list);
    }

    public void i(int i10) {
        this.f17908a.f(i10);
    }

    public void j(Activity activity, int i10, String str) {
        this.f17908a.j(activity, i10, str);
    }
}
