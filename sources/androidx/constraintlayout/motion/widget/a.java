package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.mparticle.identity.IdentityHttpResponse;
import net.bytebuddy.description.type.TypeDescription;

@SuppressLint({"LogConditional"})
public class a {
    public static String a(Context context, int i10) {
        if (i10 == -1) {
            return IdentityHttpResponse.UNKNOWN;
        }
        try {
            return context.getResources().getResourceEntryName(i10);
        } catch (Exception unused) {
            return TypeDescription.Generic.OfWildcardType.SYMBOL + i10;
        }
    }

    public static String b(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return IdentityHttpResponse.UNKNOWN;
        }
    }
}
