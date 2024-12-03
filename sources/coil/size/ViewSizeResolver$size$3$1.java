package coil.size;

import android.view.ViewTreeObserver;
import coil.size.ViewSizeResolver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", "T", "", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 7, 1})
final class ViewSizeResolver$size$3$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ ViewSizeResolver.DefaultImpls.a $preDrawListener;
    final /* synthetic */ ViewTreeObserver $viewTreeObserver;
    final /* synthetic */ ViewSizeResolver<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewSizeResolver$size$3$1(ViewSizeResolver<T> viewSizeResolver, ViewTreeObserver viewTreeObserver, ViewSizeResolver.DefaultImpls.a aVar) {
        super(1);
        this.this$0 = viewSizeResolver;
        this.$viewTreeObserver = viewTreeObserver;
        this.$preDrawListener = aVar;
    }

    public final void a(Throwable th2) {
        ViewSizeResolver.DefaultImpls.g(this.this$0, this.$viewTreeObserver, this.$preDrawListener);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
