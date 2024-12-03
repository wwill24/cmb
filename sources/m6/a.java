package m6;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;
import lc.m;

public final class a {
    public static final void a(RecyclerView recyclerView, float f10, int i10) {
        j.g(recyclerView, "<this>");
        Context context = recyclerView.getContext();
        i iVar = new i(context, 1);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        m mVar = m.f41114a;
        j.f(context, IdentityHttpResponse.CONTEXT);
        shapeDrawable.setIntrinsicHeight(mVar.a(context, f10));
        shapeDrawable.getPaint().setColor(androidx.core.content.a.getColor(context, i10));
        iVar.o(shapeDrawable);
        recyclerView.h(iVar);
    }
}
