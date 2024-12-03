package c8;

import android.text.TextUtils;
import com.coffeemeetsbagel.feature.instagram.InstagramContract$InstagramError;
import com.coffeemeetsbagel.feature.instagram.api.models.InstagramEnvelope;
import com.coffeemeetsbagel.feature.instagram.b;

abstract class b<T> implements com.coffeemeetsbagel.feature.instagram.b<T, InstagramContract$InstagramError> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7988a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7989b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7990c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7991d;

    /* renamed from: e  reason: collision with root package name */
    private String f7992e;

    /* renamed from: f  reason: collision with root package name */
    private b.a<T, InstagramContract$InstagramError> f7993f;

    b(b.a<T, InstagramContract$InstagramError> aVar) {
        this.f7993f = aVar;
    }

    public boolean a() {
        return this.f7988a || !TextUtils.isEmpty(this.f7992e) || !this.f7989b;
    }

    public void b() {
        if (!this.f7988a) {
            this.f7991d = !this.f7989b;
            this.f7989b = true;
            this.f7988a = true;
            if (TextUtils.isEmpty(this.f7992e)) {
                c();
            } else {
                d(this.f7992e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public abstract void d(String str);

    /* access modifiers changed from: package-private */
    public void e(InstagramContract$InstagramError instagramContract$InstagramError) {
        this.f7988a = false;
        if (this.f7991d) {
            this.f7991d = false;
            this.f7989b = false;
        }
        if (!this.f7990c) {
            this.f7993f.d(instagramContract$InstagramError);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(InstagramEnvelope<T> instagramEnvelope) {
        this.f7988a = false;
        if (!this.f7990c) {
            InstagramEnvelope.Pagination pagination = instagramEnvelope.pagination;
            if (pagination != null && !TextUtils.isEmpty(pagination.nextUrl)) {
                this.f7992e = instagramEnvelope.pagination.nextUrl;
            }
            this.f7993f.a(instagramEnvelope.data);
            if (!a()) {
                this.f7993f.c();
            }
        }
    }
}
