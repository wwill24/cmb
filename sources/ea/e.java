package ea;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import da.b;
import kotlin.jvm.internal.j;

public final class e extends RecyclerView.d0 {

    /* renamed from: u  reason: collision with root package name */
    private final b f40648u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(b bVar) {
        super(bVar.getRoot());
        j.g(bVar, "binding");
        this.f40648u = bVar;
    }

    /* access modifiers changed from: private */
    public static final void X(f fVar, View view) {
        j.g(fVar, "$itemClickListener");
        fVar.b();
    }

    public final void W(f fVar) {
        j.g(fVar, "itemClickListener");
        this.f40648u.f40564b.setOnClickListener(new d(fVar));
    }
}
