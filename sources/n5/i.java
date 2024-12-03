package n5;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class i implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f16525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f16526b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProgressBar f16527c;

    public /* synthetic */ i(ImageView imageView, String str, ProgressBar progressBar) {
        this.f16525a = imageView;
        this.f16526b = str;
        this.f16527c = progressBar;
    }

    public final Object invoke(Object obj) {
        return k.w(this.f16525a, this.f16526b, this.f16527c, (Bitmap) obj);
    }
}
