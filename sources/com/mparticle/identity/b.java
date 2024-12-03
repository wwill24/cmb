package com.mparticle.identity;

import android.content.Context;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.MParticle;
import com.mparticle.UserAttributeListenerType;
import com.mparticle.consent.ConsentState;
import com.mparticle.h;
import com.mparticle.internal.KitManager;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.internal.a;
import com.mparticle.internal.j;
import com.mparticle.o;
import com.mparticle.s0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

class b {

    /* renamed from: a  reason: collision with root package name */
    private a f22356a;

    /* renamed from: b  reason: collision with root package name */
    private com.mparticle.internal.b f22357b;

    /* renamed from: c  reason: collision with root package name */
    private j f22358c;

    /* renamed from: d  reason: collision with root package name */
    private KitManager f22359d;

    b(a aVar, com.mparticle.internal.b bVar, j jVar, KitManager kitManager) {
        this.f22356a = aVar;
        this.f22357b = bVar;
        this.f22358c = jVar;
        this.f22359d = kitManager;
    }

    public Map<String, Object> a(UserAttributeListenerType userAttributeListenerType, long j10) {
        return this.f22358c.a(new s0(userAttributeListenerType), j10);
    }

    public Map<String, Object> b(long j10) {
        return this.f22358c.a((s0) null, j10);
    }

    public Map<MParticle.IdentityType, String> c(long j10) {
        return this.f22358c.a(j10);
    }

    public boolean a(String str, MParticle.IdentityType identityType, long j10) {
        int i10;
        org.json.b bVar;
        int i11;
        org.json.b bVar2;
        boolean z10;
        String str2 = str;
        MParticle.IdentityType identityType2 = identityType;
        if (identityType2 != null) {
            if (str2 == null) {
                Logger.debug("Removing User Identity type: " + identityType.name());
            } else {
                Logger.debug("Setting User Identity: " + str2);
            }
            if (MPUtility.isEmpty((CharSequence) str) || str.length() <= 4096) {
                org.json.a b10 = this.f22358c.b(j10);
                int i12 = -1;
                int i13 = 0;
                while (true) {
                    try {
                        if (i13 >= b10.o()) {
                            bVar = null;
                            break;
                        } else if (identityType.getValue() == b10.j(i13).optInt("n")) {
                            bVar = b10.j(i13);
                            i12 = i13;
                            break;
                        } else {
                            i13++;
                        }
                    } catch (JSONException unused) {
                        i10 = 1;
                        String[] strArr = new String[i10];
                        strArr[0] = "Error setting identity: " + str2;
                        Logger.error(strArr);
                        return false;
                    }
                }
                if (str2 != null) {
                    org.json.b bVar3 = new org.json.b();
                    bVar3.put("n", identityType.getValue());
                    bVar3.put("i", (Object) str2);
                    if (bVar != null) {
                        z10 = !str2.equals(bVar.optString("i"));
                        int i14 = i12;
                        try {
                            bVar3.put("dfs", bVar.optLong("dfs", System.currentTimeMillis()));
                            bVar3.put(NetworkProfile.FEMALE, false);
                            b10.C(i14, bVar3);
                        } catch (JSONException unused2) {
                            i10 = 1;
                            String[] strArr2 = new String[i10];
                            strArr2[0] = "Error setting identity: " + str2;
                            Logger.error(strArr2);
                            return false;
                        }
                    } else {
                        bVar3.put("dfs", System.currentTimeMillis());
                        i11 = 1;
                        try {
                            bVar3.put(NetworkProfile.FEMALE, true);
                            b10.E(bVar3);
                            z10 = true;
                        } catch (JSONException unused3) {
                            i10 = i11;
                            String[] strArr22 = new String[i10];
                            strArr22[0] = "Error setting identity: " + str2;
                            Logger.error(strArr22);
                            return false;
                        }
                    }
                    bVar2 = bVar3;
                } else {
                    if (bVar != null) {
                        if (i12 >= 0) {
                            o.a(b10, i12);
                            bVar2 = null;
                            z10 = true;
                        }
                    }
                    i11 = 1;
                    String[] strArr3 = new String[1];
                    strArr3[0] = "Attempted to remove ID type that didn't exist: " + identityType.name();
                    Logger.debug(strArr3);
                    return false;
                }
                if (z10) {
                    this.f22358c.a(bVar2, bVar, b10, j10);
                }
                if (str2 == null) {
                    this.f22359d.removeUserIdentity(identityType2);
                    return true;
                }
                this.f22359d.setUserIdentity(str2, identityType2);
                return true;
            }
            Logger.warning("User Identity value length exceeds limit. Will not set id: " + str2);
            return false;
        }
        return false;
    }

    public boolean b(String str, Object obj, long j10) {
        if (obj != null) {
            return a(str, obj, j10);
        }
        Logger.warning("setUserAttributeList called with a null list, this is a no-op.");
        return false;
    }

    public boolean c(Long l10) {
        return this.f22357b.f(l10.longValue()).F();
    }

    public long b(Long l10) {
        if (l10.longValue() == this.f22357b.E()) {
            return System.currentTimeMillis();
        }
        return this.f22357b.f(l10.longValue()).i();
    }

    public boolean a(String str, Object obj, long j10) {
        return a(str, obj, j10, false);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, Object obj, long j10, boolean z10) {
        String str2 = str;
        Object obj2 = obj;
        long j11 = j10;
        if (!this.f22357b.V()) {
            return false;
        }
        this.f22356a.e();
        if (MPUtility.isEmpty((CharSequence) str)) {
            Logger.warning("Error while setting user attribute - called with null key. This is a no-op.");
            return false;
        } else if (str.length() > 256) {
            Logger.warning("Error while setting user attribute - attribute keys cannot be longer than 256 characters. Attribute not set: " + str);
            return false;
        } else {
            if (obj2 instanceof List) {
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList();
                int i10 = 0;
                int i11 = 0;
                while (i10 < list.size()) {
                    try {
                        i11 += list.get(i10).toString().length();
                        if (i11 > 4096) {
                            Logger.warning("Error while setting user attribute - attribute lists cannot contain values of combined length greater than 4096 characters. Attribute not set.");
                            return false;
                        }
                        arrayList.add(list.get(i10).toString());
                        i10++;
                    } catch (Exception e10) {
                        Logger.warning("Error while setting user attribute - " + e10.toString());
                        return false;
                    }
                }
                Logger.debug("Setting user attribute list: " + str + " with values: " + list.toString());
                this.f22358c.a(str, (Object) arrayList, j10, z10);
                this.f22359d.setUserAttributeList(str, arrayList, j11);
            } else if (obj2 != null) {
                String obj3 = obj.toString();
                if (obj3.length() > 4096) {
                    Logger.warning("Error while setting user attribute - attribute values cannot be longer than 4096 characters. Attribute not set.");
                    return false;
                }
                Logger.debug("Setting user attribute: " + str + " with value: " + obj3);
                this.f22358c.a(str, (Object) obj3, j10, z10);
                this.f22359d.setUserAttribute(str, obj3, j11);
            } else {
                Logger.debug("Setting user tag: " + str);
                this.f22358c.a(str, (Object) null, j10, z10);
                this.f22359d.setUserTag(str, j11);
            }
            return true;
        }
    }

    public boolean a(String str, Number number, long j10) {
        if (str == null) {
            Logger.warning("incrementUserAttribute called with a null key. Ignoring...");
            return false;
        }
        Logger.debug("Incrementing user attribute: " + str + " with value " + number);
        this.f22358c.a(str, number, j10);
        return true;
    }

    public boolean a(String str, long j10) {
        if (MPUtility.isEmpty((CharSequence) str)) {
            Logger.debug("removeUserAttribute called with an empty key.");
            return false;
        }
        Logger.debug("Removing user attribute: \"" + str + "\" for mpId: " + j10);
        this.f22358c.b(str, j10);
        this.f22359d.removeUserAttribute(str, j10);
        return true;
    }

    static void a(b bVar, Map<MParticle.IdentityType, String> map, long j10) {
        if (map != null) {
            MParticle.IdentityType identityType = MParticle.IdentityType.CustomerId;
            if (map.containsKey(identityType)) {
                bVar.a(map.get(identityType), identityType, j10);
            }
            MParticle.IdentityType identityType2 = MParticle.IdentityType.Email;
            if (map.containsKey(identityType2)) {
                bVar.a(map.get(identityType2), identityType2, j10);
            }
            for (Map.Entry next : map.entrySet()) {
                MParticle.IdentityType identityType3 = (MParticle.IdentityType) next.getKey();
                if (!(identityType3 == MParticle.IdentityType.CustomerId || identityType3 == MParticle.IdentityType.Email)) {
                    bVar.a((String) next.getValue(), identityType3, j10);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, long j10, long j11, Map<MParticle.IdentityType, String> map, UserAliasHandler userAliasHandler, boolean z10) {
        a(this, map, j11);
        Long l10 = h.f22319b;
        if (j11 == l10.longValue()) {
            return false;
        }
        this.f22357b.a(l10.longValue(), j11);
        this.f22358c.l().a(l10.longValue(), j11);
        this.f22357b.a(l10.longValue());
        if (!(userAliasHandler == null || j10 == j11)) {
            try {
                userAliasHandler.onUserAlias(c.a(context, j10, this), c.a(context, j11, this));
            } catch (Exception e10) {
                Logger.error("Error while executing UserAliasHandler: " + e10.toString());
            }
        }
        this.f22357b.a(j11, z10);
        return true;
    }

    public ConsentState a(long j10) {
        return this.f22357b.b(j10);
    }

    public void a(ConsentState consentState, long j10) {
        ConsentState a10 = a(j10);
        this.f22357b.a(consentState, j10);
        this.f22359d.onConsentStateUpdated(a10, consentState, j10);
    }

    public long a(Long l10) {
        return this.f22357b.f(l10.longValue()).h();
    }
}
