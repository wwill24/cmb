package cf;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import bf.f;

public class d extends Property<ViewGroup, Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final Property<ViewGroup, Float> f18983a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @NonNull
    /* renamed from: a */
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f10 = (Float) viewGroup.getTag(f.mtrl_internal_children_alpha_tag);
        if (f10 != null) {
            return f10;
        }
        return Float.valueOf(1.0f);
    }

    /* renamed from: b */
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f10) {
        float floatValue = f10.floatValue();
        viewGroup.setTag(f.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).setAlpha(floatValue);
        }
    }
}
