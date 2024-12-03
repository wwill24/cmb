package coil.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcoil/target/ImageViewTarget;", "Lcoil/target/GenericViewTarget;", "Landroid/widget/ImageView;", "", "other", "", "equals", "", "hashCode", "b", "Landroid/widget/ImageView;", "j", "()Landroid/widget/ImageView;", "view", "Landroid/graphics/drawable/Drawable;", "value", "d", "()Landroid/graphics/drawable/Drawable;", "f", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "<init>", "(Landroid/widget/ImageView;)V", "coil-base_release"}, k = 1, mv = {1, 7, 1})
public class ImageViewTarget extends GenericViewTarget<ImageView> {

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f8418b;

    public ImageViewTarget(ImageView imageView) {
        this.f8418b = imageView;
    }

    public Drawable d() {
        return getView().getDrawable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImageViewTarget) && j.b(getView(), ((ImageViewTarget) obj).getView());
    }

    public void f(Drawable drawable) {
        getView().setImageDrawable(drawable);
    }

    public int hashCode() {
        return getView().hashCode();
    }

    /* renamed from: j */
    public ImageView getView() {
        return this.f8418b;
    }
}
