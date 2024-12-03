package mg;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.g;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

public final class d<T extends Date> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b<T> f23665a;

    /* renamed from: b  reason: collision with root package name */
    private final List<DateFormat> f23666b;

    public static abstract class b<T extends Date> {

        /* renamed from: b  reason: collision with root package name */
        public static final b<Date> f23667b = new a(Date.class);

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f23668a;

        class a extends b<Date> {
            a(Class cls) {
                super(cls);
            }

            /* access modifiers changed from: protected */
            public Date d(Date date) {
                return date;
            }
        }

        protected b(Class<T> cls) {
            this.f23668a = cls;
        }

        private r c(d<T> dVar) {
            return o.a(this.f23668a, dVar);
        }

        public final r a(int i10, int i11) {
            return c(new d(this, i10, i11));
        }

        public final r b(String str) {
            return c(new d(this, str));
        }

        /* access modifiers changed from: protected */
        public abstract T d(Date date);
    }

    private Date e(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.f23666b) {
            for (DateFormat parse : this.f23666b) {
                try {
                    Date parse2 = parse.parse(nextString);
                    return parse2;
                } catch (ParseException unused) {
                }
            }
            try {
                return ng.a.c(nextString, new ParsePosition(0));
            } catch (ParseException e10) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e10);
            }
        }
    }

    /* renamed from: f */
    public T b(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.f23665a.d(e(jsonReader));
    }

    /* renamed from: g */
    public void d(JsonWriter jsonWriter, Date date) throws IOException {
        String format2;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.f23666b.get(0);
        synchronized (this.f23666b) {
            format2 = dateFormat.format(date);
        }
        jsonWriter.value(format2);
    }

    public String toString() {
        DateFormat dateFormat = this.f23666b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + PropertyUtils.MAPPED_DELIM2;
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + PropertyUtils.MAPPED_DELIM2;
    }

    private d(b<T> bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.f23666b = arrayList;
        Objects.requireNonNull(bVar);
        this.f23665a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(new SimpleDateFormat(str));
        }
    }

    private d(b<T> bVar, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f23666b = arrayList;
        Objects.requireNonNull(bVar);
        this.f23665a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (com.google.gson.internal.d.d()) {
            arrayList.add(g.c(i10, i11));
        }
    }
}
