package x0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class c extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f18358j;

    /* renamed from: k  reason: collision with root package name */
    private int f18359k;

    /* renamed from: l  reason: collision with root package name */
    private LayoutInflater f18360l;

    @Deprecated
    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f18359k = i10;
        this.f18358j = i10;
        this.f18360l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View f(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f18360l.inflate(this.f18359k, viewGroup, false);
    }

    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f18360l.inflate(this.f18358j, viewGroup, false);
    }
}
