package u5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class a extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private final int f18017a;

    public a(int i10) {
        this.f18017a = i10 / 2;
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        j.g(rect, "outRect");
        j.g(view, "view");
        j.g(recyclerView, Message.Thread.PARENT_ATTRIBUTE_NAME);
        j.g(zVar, "state");
        int i10 = this.f18017a;
        rect.bottom = i10;
        rect.top = i10;
        rect.right = i10;
        rect.left = i10;
    }
}
