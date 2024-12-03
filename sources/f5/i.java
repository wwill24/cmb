package f5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.School;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class i extends BaseAdapter implements Filterable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public List<School> f14754a = q.j();

    /* renamed from: b  reason: collision with root package name */
    private List<School> f14755b;

    public static final class a extends Filter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f14756a;

        a(i iVar) {
            this.f14756a = iVar;
        }

        /* access modifiers changed from: protected */
        public Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (!(charSequence == null || this.f14756a.b() == null)) {
                List<School> b10 = this.f14756a.b();
                j.d(b10);
                ArrayList arrayList = new ArrayList();
                for (T next : b10) {
                    String name = ((School) next).getName();
                    Locale locale = Locale.ROOT;
                    String lowerCase = name.toLowerCase(locale);
                    j.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    String lowerCase2 = charSequence.toString().toLowerCase(locale);
                    j.f(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (StringsKt__StringsKt.O(lowerCase, lowerCase2, false, 2, (Object) null)) {
                        arrayList.add(next);
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        /* access modifiers changed from: protected */
        public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            if (filterResults == null || filterResults.count <= 0) {
                this.f14756a.notifyDataSetInvalidated();
                return;
            }
            i iVar = this.f14756a;
            Object obj = filterResults.values;
            j.e(obj, "null cannot be cast to non-null type kotlin.collections.List<com.coffeemeetsbagel.models.School>");
            iVar.f14754a = (List) obj;
            this.f14756a.notifyDataSetChanged();
        }
    }

    public final List<School> b() {
        return this.f14755b;
    }

    public final void c(List<School> list) {
        this.f14755b = list;
    }

    public int getCount() {
        return this.f14754a.size();
    }

    public Filter getFilter() {
        return new a(this);
    }

    public Object getItem(int i10) {
        return this.f14754a.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_multi_line, viewGroup, false);
        }
        j.d(view);
        View findViewById = view.findViewById(R.id.list_item_multi_line_item);
        j.e(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(this.f14754a.get(i10).getName());
        return view;
    }
}
