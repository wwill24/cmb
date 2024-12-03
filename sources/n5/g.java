package n5;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class g implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f16471a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressBar f16472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f16473c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f16474d;

    public /* synthetic */ g(k kVar, ProgressBar progressBar, ImageView imageView, String str) {
        this.f16471a = kVar;
        this.f16472b = progressBar;
        this.f16473c = imageView;
        this.f16474d = str;
    }

    public final Object invoke(Object obj) {
        return this.f16471a.u(this.f16472b, this.f16473c, this.f16474d, (Bitmap) obj);
    }
}
