package coil.size;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import coil.size.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\"\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002R\u0014\u0010\u0015\u001a\u00028\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcoil/size/ViewSizeResolver;", "Landroid/view/View;", "T", "Lcoil/size/h;", "", "paramSize", "viewSize", "paddingSize", "Lcoil/size/c;", "getDimension", "getHeight", "Lcoil/size/g;", "getSize", "getWidth", "Landroid/view/ViewTreeObserver;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "victim", "", "removePreDrawListenerSafe", "getView", "()Landroid/view/View;", "view", "", "a", "()Z", "subtractPadding", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public interface ViewSizeResolver<T extends View> extends h {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {

        @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"coil/size/ViewSizeResolver$DefaultImpls$a", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "a", "Z", "isResumed", "coil-base_release"}, k = 1, mv = {1, 7, 1})
        public static final class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private boolean f8403a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewSizeResolver<T> f8404b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver f8405c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ n<g> f8406d;

            a(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, n<? super g> nVar) {
                this.f8404b = viewSizeResolver;
                this.f8405c = viewTreeObserver;
                this.f8406d = nVar;
            }

            public boolean onPreDraw() {
                g a10 = DefaultImpls.e(this.f8404b);
                if (a10 != null) {
                    DefaultImpls.g(this.f8404b, this.f8405c, this);
                    if (!this.f8403a) {
                        this.f8403a = true;
                        this.f8406d.resumeWith(Result.b(a10));
                    }
                }
                return true;
            }
        }

        private static <T extends View> c c(ViewSizeResolver<T> viewSizeResolver, int i10, int i11, int i12) {
            if (i10 == -2) {
                return c.b.f8408a;
            }
            int i13 = i10 - i12;
            if (i13 > 0) {
                return a.a(i13);
            }
            int i14 = i11 - i12;
            if (i14 > 0) {
                return a.a(i14);
            }
            return null;
        }

        private static <T extends View> c d(ViewSizeResolver<T> viewSizeResolver) {
            int i10;
            int i11;
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.height;
            } else {
                i10 = -1;
            }
            int height = viewSizeResolver.getView().getHeight();
            if (viewSizeResolver.a()) {
                i11 = viewSizeResolver.getView().getPaddingTop() + viewSizeResolver.getView().getPaddingBottom();
            } else {
                i11 = 0;
            }
            return c(viewSizeResolver, i10, height, i11);
        }

        /* access modifiers changed from: private */
        public static <T extends View> g e(ViewSizeResolver<T> viewSizeResolver) {
            c d10;
            c f10 = f(viewSizeResolver);
            if (f10 == null || (d10 = d(viewSizeResolver)) == null) {
                return null;
            }
            return new g(f10, d10);
        }

        private static <T extends View> c f(ViewSizeResolver<T> viewSizeResolver) {
            int i10;
            int i11;
            ViewGroup.LayoutParams layoutParams = viewSizeResolver.getView().getLayoutParams();
            if (layoutParams != null) {
                i10 = layoutParams.width;
            } else {
                i10 = -1;
            }
            int width = viewSizeResolver.getView().getWidth();
            if (viewSizeResolver.a()) {
                i11 = viewSizeResolver.getView().getPaddingLeft() + viewSizeResolver.getView().getPaddingRight();
            } else {
                i11 = 0;
            }
            return c(viewSizeResolver, i10, width, i11);
        }

        /* access modifiers changed from: private */
        public static <T extends View> void g(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            } else {
                viewSizeResolver.getView().getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
        }

        public static <T extends View> Object h(ViewSizeResolver<T> viewSizeResolver, kotlin.coroutines.c<? super g> cVar) {
            g e10 = e(viewSizeResolver);
            if (e10 != null) {
                return e10;
            }
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
            oVar.y();
            ViewTreeObserver viewTreeObserver = viewSizeResolver.getView().getViewTreeObserver();
            a aVar = new a(viewSizeResolver, viewTreeObserver, oVar);
            viewTreeObserver.addOnPreDrawListener(aVar);
            oVar.o(new ViewSizeResolver$size$3$1(viewSizeResolver, viewTreeObserver, aVar));
            Object v10 = oVar.v();
            if (v10 == b.d()) {
                f.c(cVar);
            }
            return v10;
        }
    }

    boolean a();

    T getView();
}
