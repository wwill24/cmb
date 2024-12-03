package w4;

public class c {
    public static b a(int i10) {
        return b(i10, -1, new String[0]);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static w4.b b(int r9, int r10, java.lang.String... r11) {
        /*
            w4.b r0 = new w4.b
            r0.<init>()
            r0.d(r9)
            r1 = 531(0x213, float:7.44E-43)
            java.lang.String r2 = ""
            if (r9 == r1) goto L_0x02a2
            r1 = 2
            java.lang.String r3 = " characters. Trimmed"
            java.lang.String r4 = "... exceeds the limit of "
            java.lang.String r5 = ")"
            java.lang.String r6 = " wasn't a primitive ("
            r7 = 1
            r8 = 0
            switch(r9) {
                case 510: goto L_0x027a;
                case 511: goto L_0x0228;
                case 512: goto L_0x0138;
                case 513: goto L_0x0104;
                case 514: goto L_0x00b9;
                default: goto L_0x001c;
            }
        L_0x001c:
            switch(r9) {
                case 520: goto L_0x027a;
                case 521: goto L_0x0059;
                case 522: goto L_0x0055;
                case 523: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x02a4
        L_0x0021:
            r9 = 23
            if (r10 == r9) goto L_0x003f
            r9 = 24
            if (r10 == r9) goto L_0x002b
            goto L_0x02a4
        L_0x002b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "... is a restricted key for multi-value properties. Operation aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x003f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Invalid multi-value property key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
        L_0x0052:
            r2 = r9
            goto L_0x02a4
        L_0x0055:
            java.lang.String r2 = "Charged event contained more than 50 items."
            goto L_0x02a4
        L_0x0059:
            switch(r10) {
                case 11: goto L_0x009f;
                case 12: goto L_0x007c;
                case 13: goto L_0x005e;
                default: goto L_0x005c;
            }     // Catch:{ Exception -> 0x02a4 }
        L_0x005c:
            goto L_0x02a4
        L_0x005e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Invalid user profile property array count - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " max is - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x007c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Multi value property for key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " exceeds the limit of "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " items. Trimmed"
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x009f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r4)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r3)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x00b9:
            switch(r10) {
                case 18: goto L_0x0100;
                case 19: goto L_0x00fc;
                case 20: goto L_0x00dd;
                case 21: goto L_0x00be;
                default: goto L_0x00bc;
            }     // Catch:{ Exception -> 0x02a4 }
        L_0x00bc:
            goto L_0x02a4
        L_0x00be:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Attempted to set invalid custom CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = ", falling back to default error CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x00dd:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " already exists. Unable to set custom CleverTap ID - "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x00fc:
            java.lang.String r9 = "CLEVERTAP_USE_CUSTOM_ID has not been specified in the AndroidManifest.xml. Custom CleverTap ID passed will not be used."
            goto L_0x0052
        L_0x0100:
            java.lang.String r9 = "CLEVERTAP_USE_CUSTOM_ID has been specified in the AndroidManifest.xml/Instance Configuration. CleverTap SDK will create a fallback device ID"
            goto L_0x0052
        L_0x0104:
            r9 = 16
            if (r10 == r9) goto L_0x0123
            r9 = 17
            if (r10 == r9) goto L_0x010e
            goto L_0x02a4
        L_0x010e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " is a discarded event name. Last event aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0123:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " is a restricted event name. Last event aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0138:
            r9 = 25
            if (r10 == r9) goto L_0x020e
            switch(r10) {
                case 1: goto L_0x01f4;
                case 2: goto L_0x01f0;
                case 3: goto L_0x01d1;
                case 4: goto L_0x01b7;
                case 5: goto L_0x01b3;
                case 6: goto L_0x01af;
                case 7: goto L_0x0185;
                case 8: goto L_0x0170;
                case 9: goto L_0x0156;
                case 10: goto L_0x0141;
                default: goto L_0x013f;
            }     // Catch:{ Exception -> 0x02a4 }
        L_0x013f:
            goto L_0x02a4
        L_0x0141:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Recording of Notification Viewed is disabled in the CleverTap Dashboard for notification payload: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0156:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Unable to render notification, channelId: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " not registered by the app."
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0170:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Unable to render notification, channelId is required but not provided in the notification payload: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0185:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "For event \""
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "\": Property value for property "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r6)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r1]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r5)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x01af:
            java.lang.String r9 = "Key is empty, profile removeValueForKey aborted."
            goto L_0x0052
        L_0x01b3:
            java.lang.String r9 = "Invalid phone number"
            goto L_0x0052
        L_0x01b7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Device country code not available and profile phone: "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = " does not appear to start with country code"
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x01d1:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Object value wasn't a primitive ("
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = ") for profile field "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x01f0:
            java.lang.String r9 = "Profile push key is empty"
            goto L_0x0052
        L_0x01f4:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Invalid multi value for key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = ", profile multi value operation aborted."
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x020e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "Increment/Decrement value for profile key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = ", cannot be zero or negative"
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0228:
            r9 = 7
            if (r10 == r9) goto L_0x0250
            r9 = 15
            if (r10 == r9) goto L_0x0230
            goto L_0x02a4
        L_0x0230:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "An item's object value for key "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r6)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r5)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x0250:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = "For event "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r10 = ": Property value for property "
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r6)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r1]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r5)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x027a:
            r9 = 11
            if (r10 == r9) goto L_0x0287
            r9 = 14
            if (r10 == r9) goto L_0x0283
            goto L_0x02a4
        L_0x0283:
            java.lang.String r9 = "Event Name is null"
            goto L_0x0052
        L_0x0287:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r9.<init>()     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r8]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r4)     // Catch:{ Exception -> 0x02a4 }
            r10 = r11[r7]     // Catch:{ Exception -> 0x02a4 }
            r9.append(r10)     // Catch:{ Exception -> 0x02a4 }
            r9.append(r3)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0052
        L_0x02a2:
            java.lang.String r2 = "Profile Identifiers mismatch with the previously saved ones"
        L_0x02a4:
            r0.e(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w4.c.b(int, int, java.lang.String[]):w4.b");
    }
}
