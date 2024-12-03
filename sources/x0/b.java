package x0;

import android.database.Cursor;
import android.widget.Filter;

class b extends Filter {

    /* renamed from: a  reason: collision with root package name */
    a f18357a;

    interface a {
        void a(Cursor cursor);

        Cursor b(CharSequence charSequence);

        Cursor c();

        CharSequence convertToString(Cursor cursor);
    }

    b(a aVar) {
        this.f18357a = aVar;
    }

    public CharSequence convertResultToString(Object obj) {
        return this.f18357a.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor b10 = this.f18357a.b(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (b10 != null) {
            filterResults.count = b10.getCount();
            filterResults.values = b10;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor c10 = this.f18357a.c();
        Object obj = filterResults.values;
        if (obj != null && obj != c10) {
            this.f18357a.a((Cursor) obj);
        }
    }
}
