package com.leanplum.migration.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/leanplum/migration/model/ResponseData;", "", "state", "", "hash", "accountId", "token", "regionCode", "attributeMappings", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/String;", "getAttributeMappings", "getHash", "getRegionCode", "getState", "getToken", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class ResponseData {
    private final String accountId;
    private final String attributeMappings;
    private final String hash;
    private final String regionCode;
    private final String state;
    private final String token;

    public ResponseData(String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "state");
        j.g(str2, "hash");
        this.state = str;
        this.hash = str2;
        this.accountId = str3;
        this.token = str4;
        this.regionCode = str5;
        this.attributeMappings = str6;
    }

    public static /* synthetic */ ResponseData copy$default(ResponseData responseData, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = responseData.state;
        }
        if ((i10 & 2) != 0) {
            str2 = responseData.hash;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = responseData.accountId;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = responseData.token;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = responseData.regionCode;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = responseData.attributeMappings;
        }
        return responseData.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.state;
    }

    public final String component2() {
        return this.hash;
    }

    public final String component3() {
        return this.accountId;
    }

    public final String component4() {
        return this.token;
    }

    public final String component5() {
        return this.regionCode;
    }

    public final String component6() {
        return this.attributeMappings;
    }

    public final ResponseData copy(String str, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "state");
        j.g(str2, "hash");
        return new ResponseData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseData)) {
            return false;
        }
        ResponseData responseData = (ResponseData) obj;
        return j.b(this.state, responseData.state) && j.b(this.hash, responseData.hash) && j.b(this.accountId, responseData.accountId) && j.b(this.token, responseData.token) && j.b(this.regionCode, responseData.regionCode) && j.b(this.attributeMappings, responseData.attributeMappings);
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getAttributeMappings() {
        return this.attributeMappings;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getRegionCode() {
        return this.regionCode;
    }

    public final String getState() {
        return this.state;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.state;
        int i10 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hash;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountId;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.token;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.regionCode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.attributeMappings;
        if (str6 != null) {
            i10 = str6.hashCode();
        }
        return hashCode5 + i10;
    }

    public String toString() {
        return "ResponseData(state=" + this.state + ", hash=" + this.hash + ", accountId=" + this.accountId + ", token=" + this.token + ", regionCode=" + this.regionCode + ", attributeMappings=" + this.attributeMappings + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ResponseData(String str, String str2, String str3, String str4, String str5, String str6, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6);
    }
}
