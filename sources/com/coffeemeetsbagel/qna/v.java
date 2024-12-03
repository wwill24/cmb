package com.coffeemeetsbagel.qna;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EmptyResultSetException;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.k0;
import androidx.room.l0;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.coffeemeetsbagel.models.dto.Location;
import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.models.enums.QuestionType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Pair;
import net.bytebuddy.description.type.TypeDescription;
import qj.w;

public final class v extends QuestionDaoV2Impl {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f36311a;

    /* renamed from: b  reason: collision with root package name */
    private final androidx.room.h<za.g> f36312b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.room.h<za.f> f36313c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g6.l f36314d = new g6.l();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final g6.m f36315e = new g6.m();

    /* renamed from: f  reason: collision with root package name */
    private final androidx.room.h<za.c> f36316f;

    /* renamed from: g  reason: collision with root package name */
    private final androidx.room.h<za.b> f36317g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final g6.e f36318h = new g6.e();

    /* renamed from: i  reason: collision with root package name */
    private final androidx.room.h<za.g> f36319i;

    /* renamed from: j  reason: collision with root package name */
    private final androidx.room.h<za.f> f36320j;

    /* renamed from: k  reason: collision with root package name */
    private final androidx.room.h<za.c> f36321k;

    /* renamed from: l  reason: collision with root package name */
    private final SharedSQLiteStatement f36322l;

    /* renamed from: m  reason: collision with root package name */
    private final SharedSQLiteStatement f36323m;

    class a implements Callable<List<za.h>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36324a;

        a(k0 k0Var) {
            this.f36324a = k0Var;
        }

        /* renamed from: a */
        public List<za.h> call() throws Exception {
            Cursor b10;
            String str;
            String str2;
            Integer num;
            Integer num2;
            v.this.f36311a.e();
            try {
                b10 = q1.b.b(v.this.f36311a, this.f36324a, true, (CancellationSignal) null);
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "name");
                int e12 = q1.a.e(b10, "maxAllowed");
                int e13 = q1.a.e(b10, "max_sub_options");
                androidx.collection.a aVar = new androidx.collection.a();
                while (b10.moveToNext()) {
                    String string = b10.getString(e11);
                    if (((ArrayList) aVar.get(string)) == null) {
                        aVar.put(string, new ArrayList());
                    }
                }
                b10.moveToPosition(-1);
                v.this.Q(aVar);
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    if (b10.isNull(e11)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e11);
                    }
                    if (b10.isNull(e12)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e12));
                    }
                    if (b10.isNull(e13)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(e13));
                    }
                    za.g gVar = new za.g(str, str2, num, num2);
                    ArrayList arrayList2 = (ArrayList) aVar.get(b10.getString(e11));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList.add(new za.h(gVar, arrayList2));
                }
                v.this.f36311a.C();
                b10.close();
                v.this.f36311a.j();
                return arrayList;
            } catch (Throwable th2) {
                v.this.f36311a.j();
                throw th2;
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36324a.g();
        }
    }

    class b implements Callable<List<za.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36326a;

        b(k0 k0Var) {
            this.f36326a = k0Var;
        }

        /* renamed from: a */
        public List<za.b> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Integer num;
            Float f10;
            Float f11;
            Float f12;
            int i10;
            String str6;
            Integer num2;
            Boolean bool;
            String str7;
            boolean z10;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36326a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "answer_id");
                int e11 = q1.a.e(b10, "option_id");
                int e12 = q1.a.e(b10, Extra.PROFILE_ID);
                int e13 = q1.a.e(b10, "question_id");
                int e14 = q1.a.e(b10, "text_value");
                int e15 = q1.a.e(b10, "integer_value");
                int e16 = q1.a.e(b10, "float_value");
                int e17 = q1.a.e(b10, "max_value");
                int e18 = q1.a.e(b10, "min_value");
                int e19 = q1.a.e(b10, "location");
                int e20 = q1.a.e(b10, "is_dealbreaker");
                int e21 = q1.a.e(b10, "json_type");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    if (b10.isNull(e11)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e11);
                    }
                    if (b10.isNull(e12)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e14);
                    }
                    if (b10.isNull(e15)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e15));
                    }
                    if (b10.isNull(e16)) {
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(e16));
                    }
                    if (b10.isNull(e17)) {
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(e17));
                    }
                    if (b10.isNull(e18)) {
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(e18));
                    }
                    if (b10.isNull(e19)) {
                        i10 = e10;
                        str6 = null;
                    } else {
                        str6 = b10.getString(e19);
                        i10 = e10;
                    }
                    Location b11 = v.this.f36318h.b(str6);
                    if (b10.isNull(e20)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(e20));
                    }
                    if (num2 == null) {
                        bool = null;
                    } else {
                        if (num2.intValue() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        bool = Boolean.valueOf(z10);
                    }
                    if (b10.isNull(e21)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e21);
                    }
                    arrayList.add(new za.b(str, str2, str3, str4, str5, num, f10, f11, f12, b11, bool, str7));
                    e10 = i10;
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36326a.g();
        }
    }

    class c implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36328a;

        c(k0 k0Var) {
            this.f36328a = k0Var;
        }

        /* renamed from: a */
        public Boolean call() throws Exception {
            Integer num;
            boolean z10 = false;
            Boolean bool = null;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36328a, false, (CancellationSignal) null);
            try {
                if (b10.moveToFirst()) {
                    if (b10.isNull(0)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(0));
                    }
                    if (num != null) {
                        if (num.intValue() != 0) {
                            z10 = true;
                        }
                        bool = Boolean.valueOf(z10);
                    }
                }
                if (bool != null) {
                    return bool;
                }
                throw new EmptyResultSetException("Query returned empty result set: " + this.f36328a.a());
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36328a.g();
        }
    }

    class d implements Callable<List<za.i>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36330a;

        d(k0 k0Var) {
            this.f36330a = k0Var;
        }

        /* renamed from: a */
        public List<za.i> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            QuestionInteractionPolicy questionInteractionPolicy;
            Integer num;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36330a, true, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "id");
                int e11 = q1.a.e(b10, "group");
                int e12 = q1.a.e(b10, "placeholder");
                int e13 = q1.a.e(b10, "type");
                int e14 = q1.a.e(b10, "label");
                int e15 = q1.a.e(b10, "text");
                int e16 = q1.a.e(b10, "name");
                int e17 = q1.a.e(b10, "max_options");
                androidx.collection.a aVar = new androidx.collection.a();
                while (b10.moveToNext()) {
                    String string = b10.getString(e10);
                    if (((ArrayList) aVar.get(string)) == null) {
                        aVar.put(string, new ArrayList());
                    }
                }
                b10.moveToPosition(-1);
                v.this.P(aVar);
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    if (b10.isNull(e11)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e11);
                    }
                    QuestionGroupType b11 = v.this.f36314d.b(str2);
                    if (b10.isNull(e12)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e13);
                    }
                    QuestionType b12 = v.this.f36315e.b(str4);
                    if (b10.isNull(e14)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e14);
                    }
                    if (b10.isNull(e15)) {
                        str6 = null;
                    } else {
                        str6 = b10.getString(e15);
                    }
                    if (b10.isNull(e16)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e16);
                    }
                    if (!b10.isNull(e17)) {
                        if (b10.isNull(e17)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(b10.getInt(e17));
                        }
                        questionInteractionPolicy = new QuestionInteractionPolicy(num);
                    } else {
                        questionInteractionPolicy = null;
                    }
                    za.f fVar = new za.f(str, b11, str3, b12, str5, str6, questionInteractionPolicy, str7);
                    ArrayList arrayList2 = (ArrayList) aVar.get(b10.getString(e10));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList.add(new za.i(fVar, arrayList2));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36330a.g();
        }
    }

    class e implements Callable<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36332a;

        e(k0 k0Var) {
            this.f36332a = k0Var;
        }

        /* renamed from: a */
        public List<String> call() throws Exception {
            String str;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36332a, false, (CancellationSignal) null);
            try {
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(0)) {
                        str = null;
                    } else {
                        str = b10.getString(0);
                    }
                    arrayList.add(str);
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36332a.g();
        }
    }

    class f implements Callable<List<QnaPair>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36334a;

        f(k0 k0Var) {
            this.f36334a = k0Var;
        }

        /* renamed from: a */
        public List<QnaPair> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36334a, false, (CancellationSignal) null);
            try {
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(0)) {
                        str = null;
                    } else {
                        str = b10.getString(0);
                    }
                    if (b10.isNull(1)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(1);
                    }
                    if (b10.isNull(2)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(2);
                    }
                    if (b10.isNull(3)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(3);
                    }
                    arrayList.add(new QnaPair(str2, str, str4, str3));
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36334a.g();
        }
    }

    class g implements Callable<List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36336a;

        g(k0 k0Var) {
            this.f36336a = k0Var;
        }

        /* renamed from: a */
        public List<Integer> call() throws Exception {
            Integer num;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36336a, false, (CancellationSignal) null);
            try {
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(0)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(0));
                    }
                    arrayList.add(num);
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36336a.g();
        }
    }

    class h implements Callable<List<za.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f36338a;

        h(k0 k0Var) {
            this.f36338a = k0Var;
        }

        /* renamed from: a */
        public List<za.b> call() throws Exception {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            Integer num;
            Float f10;
            Float f11;
            Float f12;
            int i10;
            String str6;
            Integer num2;
            Boolean bool;
            String str7;
            boolean z10;
            Cursor b10 = q1.b.b(v.this.f36311a, this.f36338a, false, (CancellationSignal) null);
            try {
                int e10 = q1.a.e(b10, "answer_id");
                int e11 = q1.a.e(b10, "option_id");
                int e12 = q1.a.e(b10, Extra.PROFILE_ID);
                int e13 = q1.a.e(b10, "question_id");
                int e14 = q1.a.e(b10, "text_value");
                int e15 = q1.a.e(b10, "integer_value");
                int e16 = q1.a.e(b10, "float_value");
                int e17 = q1.a.e(b10, "max_value");
                int e18 = q1.a.e(b10, "min_value");
                int e19 = q1.a.e(b10, "location");
                int e20 = q1.a.e(b10, "is_dealbreaker");
                int e21 = q1.a.e(b10, "json_type");
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    if (b10.isNull(e10)) {
                        str = null;
                    } else {
                        str = b10.getString(e10);
                    }
                    if (b10.isNull(e11)) {
                        str2 = null;
                    } else {
                        str2 = b10.getString(e11);
                    }
                    if (b10.isNull(e12)) {
                        str3 = null;
                    } else {
                        str3 = b10.getString(e12);
                    }
                    if (b10.isNull(e13)) {
                        str4 = null;
                    } else {
                        str4 = b10.getString(e13);
                    }
                    if (b10.isNull(e14)) {
                        str5 = null;
                    } else {
                        str5 = b10.getString(e14);
                    }
                    if (b10.isNull(e15)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(b10.getInt(e15));
                    }
                    if (b10.isNull(e16)) {
                        f10 = null;
                    } else {
                        f10 = Float.valueOf(b10.getFloat(e16));
                    }
                    if (b10.isNull(e17)) {
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(b10.getFloat(e17));
                    }
                    if (b10.isNull(e18)) {
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(b10.getFloat(e18));
                    }
                    if (b10.isNull(e19)) {
                        i10 = e10;
                        str6 = null;
                    } else {
                        str6 = b10.getString(e19);
                        i10 = e10;
                    }
                    Location b11 = v.this.f36318h.b(str6);
                    if (b10.isNull(e20)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(b10.getInt(e20));
                    }
                    if (num2 == null) {
                        bool = null;
                    } else {
                        if (num2.intValue() != 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        bool = Boolean.valueOf(z10);
                    }
                    if (b10.isNull(e21)) {
                        str7 = null;
                    } else {
                        str7 = b10.getString(e21);
                    }
                    arrayList.add(new za.b(str, str2, str3, str4, str5, num, f10, f11, f12, b11, bool, str7));
                    e10 = i10;
                }
                return arrayList;
            } finally {
                b10.close();
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            this.f36338a.g();
        }
    }

    class i extends androidx.room.h<za.g> {
        i(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `question_groups` (`id`,`name`,`maxAllowed`,`max_sub_options`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.g gVar) {
            if (gVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, gVar.a());
            }
            if (gVar.d() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, gVar.d());
            }
            if (gVar.b() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) gVar.b().intValue());
            }
            if (gVar.c() == null) {
                mVar.B1(4);
            } else {
                mVar.f1(4, (long) gVar.c().intValue());
            }
        }
    }

    class j extends androidx.room.h<za.f> {
        j(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `questions` (`id`,`group`,`placeholder`,`type`,`label`,`text`,`name`,`max_options`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.f fVar) {
            if (fVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, fVar.b());
            }
            String a10 = v.this.f36314d.a(fVar.a());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (fVar.g() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, fVar.g());
            }
            String a11 = v.this.f36315e.a(fVar.i());
            if (a11 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a11);
            }
            if (fVar.d() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, fVar.d());
            }
            if (fVar.h() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, fVar.h());
            }
            if (fVar.e() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, fVar.e());
            }
            QuestionInteractionPolicy c10 = fVar.c();
            if (c10 == null) {
                mVar.B1(8);
            } else if (c10.getMaxOptions() == null) {
                mVar.B1(8);
            } else {
                mVar.f1(8, (long) c10.getMaxOptions().intValue());
            }
        }
    }

    class k extends androidx.room.h<za.c> {
        k(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `options` (`id`,`question_id`,`title`,`name`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.c cVar) {
            if (cVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, cVar.a());
            }
            if (cVar.c() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, cVar.c());
            }
            if (cVar.d() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, cVar.d());
            }
            if (cVar.b() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, cVar.b());
            }
        }
    }

    class l extends androidx.room.h<za.b> {
        l(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR REPLACE INTO `answers` (`answer_id`,`option_id`,`profile_id`,`question_id`,`text_value`,`integer_value`,`float_value`,`max_value`,`min_value`,`location`,`is_dealbreaker`,`json_type`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.b bVar) {
            Integer num;
            if (bVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, bVar.b());
            }
            if (bVar.h() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, bVar.h());
            }
            if (bVar.i() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, bVar.i());
            }
            if (bVar.j() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, bVar.j());
            }
            if (bVar.k() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, bVar.k());
            }
            if (bVar.c() == null) {
                mVar.B1(6);
            } else {
                mVar.f1(6, (long) bVar.c().intValue());
            }
            if (bVar.a() == null) {
                mVar.B1(7);
            } else {
                mVar.K(7, (double) bVar.a().floatValue());
            }
            if (bVar.f() == null) {
                mVar.B1(8);
            } else {
                mVar.K(8, (double) bVar.f().floatValue());
            }
            if (bVar.g() == null) {
                mVar.B1(9);
            } else {
                mVar.K(9, (double) bVar.g().floatValue());
            }
            String a10 = v.this.f36318h.a(bVar.e());
            if (a10 == null) {
                mVar.B1(10);
            } else {
                mVar.P0(10, a10);
            }
            if (bVar.l() == null) {
                num = null;
            } else {
                num = Integer.valueOf(bVar.l().booleanValue() ? 1 : 0);
            }
            if (num == null) {
                mVar.B1(11);
            } else {
                mVar.f1(11, (long) num.intValue());
            }
            if (bVar.d() == null) {
                mVar.B1(12);
            } else {
                mVar.P0(12, bVar.d());
            }
        }
    }

    class m extends androidx.room.h<za.g> {
        m(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `question_groups` (`id`,`name`,`maxAllowed`,`max_sub_options`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.g gVar) {
            if (gVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, gVar.a());
            }
            if (gVar.d() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, gVar.d());
            }
            if (gVar.b() == null) {
                mVar.B1(3);
            } else {
                mVar.f1(3, (long) gVar.b().intValue());
            }
            if (gVar.c() == null) {
                mVar.B1(4);
            } else {
                mVar.f1(4, (long) gVar.c().intValue());
            }
        }
    }

    class n extends androidx.room.h<za.f> {
        n(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `questions` (`id`,`group`,`placeholder`,`type`,`label`,`text`,`name`,`max_options`) VALUES (?,?,?,?,?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.f fVar) {
            if (fVar.b() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, fVar.b());
            }
            String a10 = v.this.f36314d.a(fVar.a());
            if (a10 == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, a10);
            }
            if (fVar.g() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, fVar.g());
            }
            String a11 = v.this.f36315e.a(fVar.i());
            if (a11 == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, a11);
            }
            if (fVar.d() == null) {
                mVar.B1(5);
            } else {
                mVar.P0(5, fVar.d());
            }
            if (fVar.h() == null) {
                mVar.B1(6);
            } else {
                mVar.P0(6, fVar.h());
            }
            if (fVar.e() == null) {
                mVar.B1(7);
            } else {
                mVar.P0(7, fVar.e());
            }
            QuestionInteractionPolicy c10 = fVar.c();
            if (c10 == null) {
                mVar.B1(8);
            } else if (c10.getMaxOptions() == null) {
                mVar.B1(8);
            } else {
                mVar.f1(8, (long) c10.getMaxOptions().intValue());
            }
        }
    }

    class o extends androidx.room.h<za.c> {
        o(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR IGNORE INTO `options` (`id`,`question_id`,`title`,`name`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(t1.m mVar, za.c cVar) {
            if (cVar.a() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, cVar.a());
            }
            if (cVar.c() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, cVar.c());
            }
            if (cVar.d() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, cVar.d());
            }
            if (cVar.b() == null) {
                mVar.B1(4);
            } else {
                mVar.P0(4, cVar.b());
            }
        }
    }

    class p extends SharedSQLiteStatement {
        p(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM answers where profile_id = ? AND question_id = ?";
        }
    }

    class q extends SharedSQLiteStatement {
        q(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM answers where profile_id = ? AND question_id IN (SELECT id FROM questions WHERE `group` = ?)";
        }
    }

    public v(RoomDatabase roomDatabase) {
        this.f36311a = roomDatabase;
        this.f36312b = new i(roomDatabase);
        this.f36313c = new j(roomDatabase);
        this.f36316f = new k(roomDatabase);
        this.f36317g = new l(roomDatabase);
        this.f36319i = new m(roomDatabase);
        this.f36320j = new n(roomDatabase);
        this.f36321k = new o(roomDatabase);
        this.f36322l = new p(roomDatabase);
        this.f36323m = new q(roomDatabase);
    }

    /* access modifiers changed from: private */
    public void P(androidx.collection.a<String, ArrayList<za.c>> aVar) {
        String str;
        String str2;
        String str3;
        String str4;
        Set<String> keySet = aVar.keySet();
        if (!keySet.isEmpty()) {
            if (aVar.size() > 999) {
                androidx.collection.a aVar2 = new androidx.collection.a(999);
                int size = aVar.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    aVar2.put(aVar.j(i10), aVar.n(i10));
                    i10++;
                    i11++;
                    if (i11 == 999) {
                        P(aVar2);
                        aVar2 = new androidx.collection.a(999);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    P(aVar2);
                    return;
                }
                return;
            }
            StringBuilder b10 = q1.d.b();
            b10.append("SELECT `id`,`question_id`,`title`,`name` FROM `options` WHERE `question_id` IN (");
            int size2 = keySet.size();
            q1.d.a(b10, size2);
            b10.append(")");
            k0 c10 = k0.c(b10.toString(), size2 + 0);
            int i12 = 1;
            for (String next : keySet) {
                if (next == null) {
                    c10.B1(i12);
                } else {
                    c10.P0(i12, next);
                }
                i12++;
            }
            Cursor b11 = q1.b.b(this.f36311a, c10, false, (CancellationSignal) null);
            try {
                int d10 = q1.a.d(b11, "question_id");
                if (d10 != -1) {
                    while (b11.moveToNext()) {
                        ArrayList arrayList = aVar.get(b11.getString(d10));
                        if (arrayList != null) {
                            if (b11.isNull(0)) {
                                str = null;
                            } else {
                                str = b11.getString(0);
                            }
                            if (b11.isNull(1)) {
                                str2 = null;
                            } else {
                                str2 = b11.getString(1);
                            }
                            if (b11.isNull(2)) {
                                str3 = null;
                            } else {
                                str3 = b11.getString(2);
                            }
                            if (b11.isNull(3)) {
                                str4 = null;
                            } else {
                                str4 = b11.getString(3);
                            }
                            arrayList.add(new za.c(str, str2, str3, str4));
                        }
                    }
                    b11.close();
                }
            } finally {
                b11.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void Q(androidx.collection.a<String, ArrayList<za.i>> aVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        QuestionInteractionPolicy questionInteractionPolicy;
        Integer num;
        androidx.collection.a<String, ArrayList<za.i>> aVar2 = aVar;
        Set<String> keySet = aVar.keySet();
        if (!keySet.isEmpty()) {
            if (aVar.size() > 999) {
                androidx.collection.a aVar3 = new androidx.collection.a(999);
                int size = aVar.size();
                int i10 = 0;
                int i11 = 0;
                while (i10 < size) {
                    aVar3.put(aVar2.j(i10), aVar2.n(i10));
                    i10++;
                    i11++;
                    if (i11 == 999) {
                        Q(aVar3);
                        aVar3 = new androidx.collection.a(999);
                        i11 = 0;
                    }
                }
                if (i11 > 0) {
                    Q(aVar3);
                    return;
                }
                return;
            }
            StringBuilder b10 = q1.d.b();
            b10.append("SELECT `id`,`group`,`placeholder`,`type`,`label`,`text`,`name`,`max_options` FROM `questions` WHERE `group` IN (");
            int size2 = keySet.size();
            q1.d.a(b10, size2);
            b10.append(")");
            k0 c10 = k0.c(b10.toString(), size2 + 0);
            int i12 = 1;
            for (String next : keySet) {
                if (next == null) {
                    c10.B1(i12);
                } else {
                    c10.P0(i12, next);
                }
                i12++;
            }
            Cursor b11 = q1.b.b(this.f36311a, c10, true, (CancellationSignal) null);
            try {
                int d10 = q1.a.d(b11, "group");
                if (d10 != -1) {
                    androidx.collection.a aVar4 = new androidx.collection.a();
                    while (b11.moveToNext()) {
                        String string = b11.getString(0);
                        if (((ArrayList) aVar4.get(string)) == null) {
                            aVar4.put(string, new ArrayList());
                        }
                    }
                    b11.moveToPosition(-1);
                    P(aVar4);
                    while (b11.moveToNext()) {
                        ArrayList arrayList = aVar2.get(b11.getString(d10));
                        if (arrayList != null) {
                            if (b11.isNull(0)) {
                                str = null;
                            } else {
                                str = b11.getString(0);
                            }
                            if (b11.isNull(1)) {
                                str2 = null;
                            } else {
                                str2 = b11.getString(1);
                            }
                            QuestionGroupType b12 = this.f36314d.b(str2);
                            if (b11.isNull(2)) {
                                str3 = null;
                            } else {
                                str3 = b11.getString(2);
                            }
                            if (b11.isNull(3)) {
                                str4 = null;
                            } else {
                                str4 = b11.getString(3);
                            }
                            QuestionType b13 = this.f36315e.b(str4);
                            if (b11.isNull(4)) {
                                str5 = null;
                            } else {
                                str5 = b11.getString(4);
                            }
                            if (b11.isNull(5)) {
                                str6 = null;
                            } else {
                                str6 = b11.getString(5);
                            }
                            if (b11.isNull(6)) {
                                str7 = null;
                            } else {
                                str7 = b11.getString(6);
                            }
                            if (!b11.isNull(7)) {
                                if (b11.isNull(7)) {
                                    num = null;
                                } else {
                                    num = Integer.valueOf(b11.getInt(7));
                                }
                                questionInteractionPolicy = new QuestionInteractionPolicy(num);
                            } else {
                                questionInteractionPolicy = null;
                            }
                            za.f fVar = new za.f(str, b12, str3, b13, str5, str6, questionInteractionPolicy, str7);
                            ArrayList arrayList2 = (ArrayList) aVar4.get(b11.getString(0));
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList.add(new za.i(fVar, arrayList2));
                        }
                    }
                    b11.close();
                }
            } finally {
                b11.close();
            }
        }
    }

    public static List<Class<?>> U() {
        return Collections.emptyList();
    }

    public List<Long> A(List<za.f> list) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            List<Long> m10 = this.f36320j.m(list);
            this.f36311a.C();
            return m10;
        } finally {
            this.f36311a.j();
        }
    }

    public long B(za.g gVar) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            long l10 = this.f36312b.l(gVar);
            this.f36311a.C();
            return l10;
        } finally {
            this.f36311a.j();
        }
    }

    public List<Long> C(List<za.b> list) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            List<Long> m10 = this.f36317g.m(list);
            this.f36311a.C();
            return m10;
        } finally {
            this.f36311a.j();
        }
    }

    public List<Long> D(List<za.c> list) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            List<Long> m10 = this.f36316f.m(list);
            this.f36311a.C();
            return m10;
        } finally {
            this.f36311a.j();
        }
    }

    public List<Long> E(List<za.f> list) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            List<Long> m10 = this.f36313c.m(list);
            this.f36311a.C();
            return m10;
        } finally {
            this.f36311a.j();
        }
    }

    public Integer F(String str) {
        k0 c10 = k0.c("select maxAllowed from question_groups where name = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        this.f36311a.d();
        Integer num = null;
        Cursor b10 = q1.b.b(this.f36311a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                if (!b10.isNull(0)) {
                    num = Integer.valueOf(b10.getInt(0));
                }
            }
            return num;
        } finally {
            b10.close();
            c10.g();
        }
    }

    public qj.h<List<String>> G(String str, String str2) {
        k0 c10 = k0.c("SELECT options.title from answers, options WHERE answers.question_id IN (SELECT id from questions WHERE `group` = ?) AND answers.profile_id = ? AND answers.option_id = options.id", 2);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        if (str2 == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str2);
        }
        return l0.a(this.f36311a, false, new String[]{"answers", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, ProfileConstants.Field.QUESTIONS}, new e(c10));
    }

    public qj.h<List<QnaPair>> H(String str, String str2) {
        k0 c10 = k0.c("select questions.label as question, questions.id as questionId, questions.placeholder as placeholder, answers.text_value as answer from questions join answers on answers.question_id = questions.id where questions.`group` = ? and answers.profile_id = ?", 2);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        if (str2 == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str2);
        }
        return l0.a(this.f36311a, false, new String[]{ProfileConstants.Field.QUESTIONS, "answers"}, new f(c10));
    }

    public w<List<Integer>> I(String str) {
        k0 c10 = k0.c("select max_sub_options from question_groups where name = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.c(new g(c10));
    }

    public List<Long> b(String str, za.g gVar, boolean z10) {
        this.f36311a.e();
        try {
            List<Long> R = super.b(str, gVar, z10);
            this.f36311a.C();
            return R;
        } finally {
            this.f36311a.j();
        }
    }

    public int c(String str, String str2) {
        this.f36311a.d();
        t1.m b10 = this.f36322l.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        if (str2 == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str2);
        }
        this.f36311a.e();
        try {
            int H = b10.H();
            this.f36311a.C();
            return H;
        } finally {
            this.f36311a.j();
            this.f36322l.h(b10);
        }
    }

    public qj.h<List<za.h>> d(String str) {
        k0 c10 = k0.c("SELECT * FROM question_groups WHERE `name` = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f36311a, true, new String[]{SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, ProfileConstants.Field.QUESTIONS, "question_groups"}, new a(c10));
    }

    public List<Long> e(List<? extends Pair<String, ? extends List<za.g>>> list) {
        this.f36311a.e();
        try {
            List<Long> T = super.e(list);
            this.f36311a.C();
            return T;
        } finally {
            this.f36311a.j();
        }
    }

    public w<Boolean> f(String str) {
        k0 c10 = k0.c("select (select count(*) from questions where `group` = ?) > 0", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.c(new c(c10));
    }

    public void h(String str, String str2, List<za.b> list) {
        this.f36311a.e();
        try {
            super.h(str, str2, list);
            this.f36311a.C();
        } finally {
            this.f36311a.j();
        }
    }

    public qj.h<List<za.b>> j(String str, String str2) {
        k0 c10 = k0.c("SELECT * FROM answers where profile_id = ? AND question_id IN (SELECT id FROM questions WHERE `group` = ?)", 2);
        if (str2 == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str2);
        }
        if (str == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str);
        }
        return l0.a(this.f36311a, false, new String[]{"answers", ProfileConstants.Field.QUESTIONS}, new b(c10));
    }

    public int p(String str, String str2) {
        this.f36311a.d();
        t1.m b10 = this.f36323m.b();
        if (str == null) {
            b10.B1(1);
        } else {
            b10.P0(1, str);
        }
        if (str2 == null) {
            b10.B1(2);
        } else {
            b10.P0(2, str2);
        }
        this.f36311a.e();
        try {
            int H = b10.H();
            this.f36311a.C();
            return H;
        } finally {
            this.f36311a.j();
            this.f36323m.h(b10);
        }
    }

    public int q(String str, List<String> list) {
        this.f36311a.d();
        StringBuilder b10 = q1.d.b();
        b10.append("DELETE FROM answers where profile_id = ");
        b10.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
        b10.append(" AND question_id IN (SELECT id FROM questions WHERE `group` IN (");
        q1.d.a(b10, list.size());
        b10.append("))");
        t1.m g10 = this.f36311a.g(b10.toString());
        if (str == null) {
            g10.B1(1);
        } else {
            g10.P0(1, str);
        }
        int i10 = 2;
        for (String next : list) {
            if (next == null) {
                g10.B1(i10);
            } else {
                g10.P0(i10, next);
            }
            i10++;
        }
        this.f36311a.e();
        try {
            int H = g10.H();
            this.f36311a.C();
            return H;
        } finally {
            this.f36311a.j();
        }
    }

    public int r(List<String> list) {
        this.f36311a.d();
        StringBuilder b10 = q1.d.b();
        b10.append("DELETE FROM options where question_id IN (SELECT id FROM questions WHERE `group` IN (");
        q1.d.a(b10, list.size());
        b10.append("))");
        t1.m g10 = this.f36311a.g(b10.toString());
        int i10 = 1;
        for (String next : list) {
            if (next == null) {
                g10.B1(i10);
            } else {
                g10.P0(i10, next);
            }
            i10++;
        }
        this.f36311a.e();
        try {
            int H = g10.H();
            this.f36311a.C();
            return H;
        } finally {
            this.f36311a.j();
        }
    }

    public int s(List<String> list) {
        this.f36311a.d();
        StringBuilder b10 = q1.d.b();
        b10.append("DELETE FROM questions WHERE `group` IN (");
        q1.d.a(b10, list.size());
        b10.append(")");
        t1.m g10 = this.f36311a.g(b10.toString());
        int i10 = 1;
        for (String next : list) {
            if (next == null) {
                g10.B1(i10);
            } else {
                g10.P0(i10, next);
            }
            i10++;
        }
        this.f36311a.e();
        try {
            int H = g10.H();
            this.f36311a.C();
            return H;
        } finally {
            this.f36311a.j();
        }
    }

    public qj.h<List<za.b>> t(String str, String str2) {
        k0 c10 = k0.c("SELECT * FROM answers where profile_id = ? AND question_id = ?", 2);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        if (str2 == null) {
            c10.B1(2);
        } else {
            c10.P0(2, str2);
        }
        return l0.a(this.f36311a, false, new String[]{"answers"}, new h(c10));
    }

    public qj.h<List<za.i>> u(String str) {
        k0 c10 = k0.c("select * from questions where `id` = ?", 1);
        if (str == null) {
            c10.B1(1);
        } else {
            c10.P0(1, str);
        }
        return l0.a(this.f36311a, false, new String[]{SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, ProfileConstants.Field.QUESTIONS}, new d(c10));
    }

    public List<Long> y(List<za.g> list) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            List<Long> m10 = this.f36319i.m(list);
            this.f36311a.C();
            return m10;
        } finally {
            this.f36311a.j();
        }
    }

    public List<Long> z(List<za.c> list) {
        this.f36311a.d();
        this.f36311a.e();
        try {
            List<Long> m10 = this.f36321k.m(list);
            this.f36311a.C();
            return m10;
        } finally {
            this.f36311a.j();
        }
    }
}
