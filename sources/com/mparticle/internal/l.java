package com.mparticle.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.kits.ReportingMessage;
import java.security.SecureRandom;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.cli.HelpFormatter;
import org.json.JSONException;
import org.json.a;
import org.json.b;

class l extends b {
    l(b bVar, Context context) throws JSONException {
        a aVar;
        a jSONArray = bVar.getJSONArray("cms");
        int i10 = 0;
        while (i10 < jSONArray.o()) {
            b bVar2 = new b();
            if (jSONArray.j(i10).has(ReportingMessage.MessageType.PUSH_REGISTRATION)) {
                a jSONArray2 = jSONArray.j(i10).getJSONArray(ReportingMessage.MessageType.PUSH_REGISTRATION);
                int i11 = 0;
                while (i11 < jSONArray2.o()) {
                    b j10 = jSONArray2.j(i11);
                    SharedPreferences sharedPreferences = context.getSharedPreferences(j10.getString(NetworkProfile.FEMALE), j10.getInt(NetworkProfile.MALE));
                    a jSONArray3 = j10.getJSONArray("ps");
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    int i12 = 0;
                    while (i12 < jSONArray3.o()) {
                        int i13 = jSONArray3.j(i12).getInt("t");
                        String string = jSONArray3.j(i12).getString("k");
                        String string2 = jSONArray3.j(i12).getString("n");
                        String str = "mp::" + string2;
                        String str2 = null;
                        if (sharedPreferences.contains(str)) {
                            bVar2.put(string2, (Object) sharedPreferences.getString(str, (String) null));
                            aVar = jSONArray;
                        } else {
                            if (!sharedPreferences.contains(string)) {
                                aVar = jSONArray;
                                str2 = a(jSONArray3.j(i12).getString("d"));
                            } else if (i13 == 1) {
                                aVar = jSONArray;
                                str2 = sharedPreferences.getString(string, (String) null);
                            } else if (i13 == 2) {
                                aVar = jSONArray;
                                str2 = Integer.toString(sharedPreferences.getInt(string, 0));
                            } else if (i13 == 3) {
                                aVar = jSONArray;
                                str2 = Boolean.toString(sharedPreferences.getBoolean(string, false));
                            } else if (i13 == 4) {
                                aVar = jSONArray;
                                str2 = Float.toString(sharedPreferences.getFloat(string, 0.0f));
                            } else if (i13 != 5) {
                                aVar = jSONArray;
                            } else {
                                aVar = jSONArray;
                                str2 = Long.toString(sharedPreferences.getLong(string, 0));
                            }
                            edit.putString(str, str2);
                            edit.apply();
                            bVar2.put(string2, (Object) str2);
                        }
                        i12++;
                        jSONArray = aVar;
                    }
                    i11++;
                    jSONArray = jSONArray;
                }
            }
            Context context2 = context;
            a aVar2 = jSONArray;
            put(Integer.toString(aVar2.j(i10).getInt("id")), (Object) bVar2);
            i10++;
            jSONArray = aVar2;
        }
    }

    private static String a(String str) {
        if (MPUtility.isEmpty((CharSequence) str) || !str.startsWith("%")) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.equalsIgnoreCase("%gn%")) {
            return UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "");
        }
        if (lowerCase.equals("%oaid%")) {
            return a();
        }
        if (lowerCase.equals("%g%")) {
            return UUID.randomUUID().toString();
        }
        if (lowerCase.equals("%ts%")) {
            return Long.toString(System.currentTimeMillis());
        }
        return lowerCase.equals("%glsb%") ? Long.toString(UUID.randomUUID().getLeastSignificantBits()) : lowerCase;
    }

    private static String a() {
        String upperCase = UUID.randomUUID().toString().replace(HelpFormatter.DEFAULT_OPT_PREFIX, "").toUpperCase();
        Pattern compile = Pattern.compile("^[89A-F]");
        Pattern compile2 = Pattern.compile("^[4-9A-F]");
        Matcher matcher = compile.matcher(upperCase.substring(0, 16));
        Matcher matcher2 = compile2.matcher(upperCase.substring(16, 32));
        SecureRandom secureRandom = new SecureRandom();
        String replaceAll = matcher.replaceAll(String.valueOf(secureRandom.nextInt(7)));
        String replaceAll2 = matcher2.replaceAll(String.valueOf(secureRandom.nextInt(3)));
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append(replaceAll);
        sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        sb2.append(replaceAll2);
        return sb2.toString();
    }
}
