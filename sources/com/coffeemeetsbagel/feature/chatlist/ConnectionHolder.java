package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.models.ConnectionDetails;
import com.coffeemeetsbagel.models.dto.MatchContract;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class ConnectionHolder {

    /* renamed from: a  reason: collision with root package name */
    private final MatchContract f12867a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionDetails f12868b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12869c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12870d;

    /* renamed from: e  reason: collision with root package name */
    private final String f12871e;

    /* renamed from: f  reason: collision with root package name */
    private final Integer f12872f;

    /* renamed from: g  reason: collision with root package name */
    private final ConnectionHolderType f12873g;

    public enum ConnectionHolderType {
        UPSELL_LIKES_YOU,
        UPSELL_LIKES_YOU_V2,
        ACTIVE,
        INACTIVE_HEADER,
        INACTIVE
    }

    public ConnectionHolder(MatchContract matchContract, ConnectionDetails connectionDetails, int i10, String str, String str2, Integer num, ConnectionHolderType connectionHolderType) {
        j.g(connectionHolderType, "type");
        this.f12867a = matchContract;
        this.f12868b = connectionDetails;
        this.f12869c = i10;
        this.f12870d = str;
        this.f12871e = str2;
        this.f12872f = num;
        this.f12873g = connectionHolderType;
    }

    public static /* synthetic */ ConnectionHolder b(ConnectionHolder connectionHolder, MatchContract matchContract, ConnectionDetails connectionDetails, int i10, String str, String str2, Integer num, ConnectionHolderType connectionHolderType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            matchContract = connectionHolder.f12867a;
        }
        if ((i11 & 2) != 0) {
            connectionDetails = connectionHolder.f12868b;
        }
        ConnectionDetails connectionDetails2 = connectionDetails;
        if ((i11 & 4) != 0) {
            i10 = connectionHolder.f12869c;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str = connectionHolder.f12870d;
        }
        String str3 = str;
        if ((i11 & 16) != 0) {
            str2 = connectionHolder.f12871e;
        }
        String str4 = str2;
        if ((i11 & 32) != 0) {
            num = connectionHolder.f12872f;
        }
        Integer num2 = num;
        if ((i11 & 64) != 0) {
            connectionHolderType = connectionHolder.f12873g;
        }
        return connectionHolder.a(matchContract, connectionDetails2, i12, str3, str4, num2, connectionHolderType);
    }

    public final ConnectionHolder a(MatchContract matchContract, ConnectionDetails connectionDetails, int i10, String str, String str2, Integer num, ConnectionHolderType connectionHolderType) {
        ConnectionHolderType connectionHolderType2 = connectionHolderType;
        j.g(connectionHolderType2, "type");
        return new ConnectionHolder(matchContract, connectionDetails, i10, str, str2, num, connectionHolderType2);
    }

    public final ConnectionDetails c() {
        return this.f12868b;
    }

    public final String d() {
        return this.f12870d;
    }

    public final String e() {
        return this.f12871e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionHolder)) {
            return false;
        }
        ConnectionHolder connectionHolder = (ConnectionHolder) obj;
        return j.b(this.f12867a, connectionHolder.f12867a) && j.b(this.f12868b, connectionHolder.f12868b) && this.f12869c == connectionHolder.f12869c && j.b(this.f12870d, connectionHolder.f12870d) && j.b(this.f12871e, connectionHolder.f12871e) && j.b(this.f12872f, connectionHolder.f12872f) && this.f12873g == connectionHolder.f12873g;
    }

    public final Integer f() {
        return this.f12872f;
    }

    public final MatchContract g() {
        return this.f12867a;
    }

    public final int h() {
        return this.f12869c;
    }

    public int hashCode() {
        MatchContract matchContract = this.f12867a;
        int i10 = 0;
        int hashCode = (matchContract == null ? 0 : matchContract.hashCode()) * 31;
        ConnectionDetails connectionDetails = this.f12868b;
        int hashCode2 = (((hashCode + (connectionDetails == null ? 0 : connectionDetails.hashCode())) * 31) + Integer.hashCode(this.f12869c)) * 31;
        String str = this.f12870d;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f12871e;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.f12872f;
        if (num != null) {
            i10 = num.hashCode();
        }
        return ((hashCode4 + i10) * 31) + this.f12873g.hashCode();
    }

    public final ConnectionHolderType i() {
        return this.f12873g;
    }

    public String toString() {
        MatchContract matchContract = this.f12867a;
        ConnectionDetails connectionDetails = this.f12868b;
        int i10 = this.f12869c;
        String str = this.f12870d;
        String str2 = this.f12871e;
        Integer num = this.f12872f;
        ConnectionHolderType connectionHolderType = this.f12873g;
        return "ConnectionHolder(match=" + matchContract + ", connectionDetails=" + connectionDetails + ", pendingMessages=" + i10 + ", firstName=" + str + ", imageUrl=" + str2 + ", likesYouCount=" + num + ", type=" + connectionHolderType + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionHolder(MatchContract matchContract, ConnectionDetails connectionDetails, int i10, String str, String str2, Integer num, ConnectionHolderType connectionHolderType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : matchContract, (i11 & 2) != 0 ? null : connectionDetails, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : str, (i11 & 16) != 0 ? null : str2, (i11 & 32) != 0 ? null : num, connectionHolderType);
    }
}
