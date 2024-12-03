package k8;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.functions.Function1;
import yn.d;

public final /* synthetic */ class a implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ImageView f15963a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f15964b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f15965c;

    public /* synthetic */ a(ImageView imageView, d dVar, View view) {
        this.f15963a = imageView;
        this.f15964b = dVar;
        this.f15965c = view;
    }

    public final Object invoke(Object obj) {
        return d.B(this.f15963a, this.f15964b, this.f15965c, (Bitmap) obj);
    }
}
