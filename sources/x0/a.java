package x0;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import x0.b;

public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f18347a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f18348b;

    /* renamed from: c  reason: collision with root package name */
    protected Cursor f18349c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f18350d;

    /* renamed from: e  reason: collision with root package name */
    protected int f18351e;

    /* renamed from: f  reason: collision with root package name */
    protected C0218a f18352f;

    /* renamed from: g  reason: collision with root package name */
    protected DataSetObserver f18353g;

    /* renamed from: h  reason: collision with root package name */
    protected b f18354h;

    /* renamed from: x0.a$a  reason: collision with other inner class name */
    private class C0218a extends ContentObserver {
        C0218a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z10) {
            a.this.h();
        }
    }

    private class b extends DataSetObserver {
        b() {
        }

        public void onChanged() {
            a aVar = a.this;
            aVar.f18347a = true;
            aVar.notifyDataSetChanged();
        }

        public void onInvalidated() {
            a aVar = a.this;
            aVar.f18347a = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z10) {
        int i10;
        if (z10) {
            i10 = 1;
        } else {
            i10 = 2;
        }
        e(context, cursor, i10);
    }

    public void a(Cursor cursor) {
        Cursor i10 = i(cursor);
        if (i10 != null) {
            i10.close();
        }
    }

    public Cursor c() {
        return this.f18349c;
    }

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract void d(View view, Context context, Cursor cursor);

    /* access modifiers changed from: package-private */
    public void e(Context context, Cursor cursor, int i10) {
        int i11;
        boolean z10 = false;
        if ((i10 & 1) == 1) {
            i10 |= 2;
            this.f18348b = true;
        } else {
            this.f18348b = false;
        }
        if (cursor != null) {
            z10 = true;
        }
        this.f18349c = cursor;
        this.f18347a = z10;
        this.f18350d = context;
        if (z10) {
            i11 = cursor.getColumnIndexOrThrow("_id");
        } else {
            i11 = -1;
        }
        this.f18351e = i11;
        if ((i10 & 2) == 2) {
            this.f18352f = new C0218a();
            this.f18353g = new b();
        } else {
            this.f18352f = null;
            this.f18353g = null;
        }
        if (z10) {
            C0218a aVar = this.f18352f;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f18353g;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View f(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    public int getCount() {
        Cursor cursor;
        if (!this.f18347a || (cursor = this.f18349c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f18347a) {
            return null;
        }
        this.f18349c.moveToPosition(i10);
        if (view == null) {
            view = f(this.f18350d, this.f18349c, viewGroup);
        }
        d(view, this.f18350d, this.f18349c);
        return view;
    }

    public Filter getFilter() {
        if (this.f18354h == null) {
            this.f18354h = new b(this);
        }
        return this.f18354h;
    }

    public Object getItem(int i10) {
        Cursor cursor;
        if (!this.f18347a || (cursor = this.f18349c) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f18349c;
    }

    public long getItemId(int i10) {
        Cursor cursor;
        if (!this.f18347a || (cursor = this.f18349c) == null || !cursor.moveToPosition(i10)) {
            return 0;
        }
        return this.f18349c.getLong(this.f18351e);
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f18347a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f18349c.moveToPosition(i10)) {
            if (view == null) {
                view = g(this.f18350d, this.f18349c, viewGroup);
            }
            d(view, this.f18350d, this.f18349c);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i10);
        }
    }

    /* access modifiers changed from: protected */
    public void h() {
        Cursor cursor;
        if (this.f18348b && (cursor = this.f18349c) != null && !cursor.isClosed()) {
            this.f18347a = this.f18349c.requery();
        }
    }

    public Cursor i(Cursor cursor) {
        Cursor cursor2 = this.f18349c;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0218a aVar = this.f18352f;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.f18353g;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f18349c = cursor;
        if (cursor != null) {
            C0218a aVar2 = this.f18352f;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.f18353g;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f18351e = cursor.getColumnIndexOrThrow("_id");
            this.f18347a = true;
            notifyDataSetChanged();
        } else {
            this.f18351e = -1;
            this.f18347a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
