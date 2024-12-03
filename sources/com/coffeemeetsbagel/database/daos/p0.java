package com.coffeemeetsbagel.database.daos;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.g;
import androidx.room.h;
import androidx.room.k0;
import com.coffeemeetsbagel.models.dto.RetryCall;
import com.coffeemeetsbagel.models.dto.RetryCallPartial;
import com.coffeemeetsbagel.models.entities.RetryCallEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t1.m;

public final class p0 extends o0 {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f11849a;

    /* renamed from: b  reason: collision with root package name */
    private final h<RetryCallPartial> f11850b;

    /* renamed from: c  reason: collision with root package name */
    private final g<RetryCall> f11851c;

    class a extends h<RetryCallPartial> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "INSERT OR ABORT INTO `retry_calls` (`internalTag`,`payloadObject`,`lastTimeTried`,`timesTriedSoFar`) VALUES (?,?,?,?)";
        }

        /* renamed from: n */
        public void i(m mVar, RetryCallPartial retryCallPartial) {
            if (retryCallPartial.getInternalTag() == null) {
                mVar.B1(1);
            } else {
                mVar.P0(1, retryCallPartial.getInternalTag());
            }
            if (retryCallPartial.getPayloadObject() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, retryCallPartial.getPayloadObject());
            }
            mVar.f1(3, retryCallPartial.getLastTimeTried());
            mVar.f1(4, (long) retryCallPartial.getTimesTriedSoFar());
        }
    }

    class b extends g<RetryCall> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        public String e() {
            return "DELETE FROM `retry_calls` WHERE `id` = ? AND `internalTag` = ? AND `payloadObject` = ? AND `lastTimeTried` = ? AND `timesTriedSoFar` = ?";
        }

        /* renamed from: l */
        public void i(m mVar, RetryCall retryCall) {
            mVar.f1(1, retryCall.getId());
            if (retryCall.getInternalTag() == null) {
                mVar.B1(2);
            } else {
                mVar.P0(2, retryCall.getInternalTag());
            }
            if (retryCall.getPayloadObject() == null) {
                mVar.B1(3);
            } else {
                mVar.P0(3, retryCall.getPayloadObject());
            }
            mVar.f1(4, retryCall.getLastTimeTried());
            mVar.f1(5, (long) retryCall.getTimesTriedSoFar());
        }
    }

    public p0(RoomDatabase roomDatabase) {
        this.f11849a = roomDatabase;
        this.f11850b = new a(roomDatabase);
        this.f11851c = new b(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    public int d(RetryCall retryCall) {
        this.f11849a.d();
        this.f11849a.e();
        try {
            int j10 = this.f11851c.j(retryCall) + 0;
            this.f11849a.C();
            return j10;
        } finally {
            this.f11849a.j();
        }
    }

    public void e(RetryCallPartial retryCallPartial) {
        this.f11849a.d();
        this.f11849a.e();
        try {
            this.f11850b.k(retryCallPartial);
            this.f11849a.C();
        } finally {
            this.f11849a.j();
        }
    }

    public List<RetryCallEntity> f() {
        String str;
        String str2;
        k0 c10 = k0.c("select * from retry_calls", 0);
        this.f11849a.d();
        Cursor b10 = q1.b.b(this.f11849a, c10, false, (CancellationSignal) null);
        try {
            int e10 = q1.a.e(b10, "internalTag");
            int e11 = q1.a.e(b10, "payloadObject");
            int e12 = q1.a.e(b10, "lastTimeTried");
            int e13 = q1.a.e(b10, "timesTriedSoFar");
            int e14 = q1.a.e(b10, "id");
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
                arrayList.add(new RetryCallEntity(str, str2, b10.getLong(e12), b10.getInt(e13), b10.getLong(e14)));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.g();
        }
    }
}
