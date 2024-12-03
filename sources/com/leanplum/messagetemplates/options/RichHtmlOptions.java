package com.leanplum.messagetemplates.options;

import android.app.Activity;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.ActionArgs;
import com.leanplum.ActionContext;
import com.leanplum.Leanplum;
import com.leanplum.internal.Constants;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import com.leanplum.utils.SizeUtil;
import java.io.File;
import java.util.Map;
import org.json.JSONException;

public class RichHtmlOptions {
    private ActionContext actionContext;
    private String actionUrl;
    private String closeUrl;
    private String htmlAlign;
    private int htmlHeight;
    private boolean htmlTabOutsideToClose;
    private String htmlTemplate;
    private Size htmlWidth;
    private Size htmlYOffset;
    private String openUrl;
    private String trackActionUrl;
    private String trackUrl;

    public static class Size {
        public String type;
        public int value;
    }

    public RichHtmlOptions(ActionContext actionContext2) {
        setActionContext(actionContext2);
        setHtmlTemplate(getTemplate(actionContext2));
        setCloseUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.CLOSE_URL));
        setOpenUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.OPEN_URL));
        setTrackUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.TRACK_URL));
        setActionUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.ACTION_URL));
        setTrackActionUrl(actionContext2.stringNamed(MessageTemplateConstants.Args.TRACK_ACTION_URL));
        setHtmlAlign(actionContext2.stringNamed(MessageTemplateConstants.Args.HTML_ALIGN));
        setHtmlHeight(actionContext2.numberNamed(MessageTemplateConstants.Args.HTML_HEIGHT).intValue());
        setHtmlWidth(actionContext2.stringNamed(MessageTemplateConstants.Args.HTML_WIDTH));
        setHtmlYOffset(actionContext2.stringNamed(MessageTemplateConstants.Args.HTML_Y_OFFSET));
        setHtmlTabOutsideToClose(actionContext2.booleanNamed(MessageTemplateConstants.Args.HTML_TAP_OUTSIDE_TO_CLOSE));
    }

    private Size getSizeValueAndType(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Size size = new Size();
        if (str.contains("px")) {
            String[] split = str.split("px");
            if (split.length != 0) {
                size.value = Integer.parseInt(split[0]);
            }
            size.type = "px";
        } else if (str.contains("%")) {
            String[] split2 = str.split("%");
            if (split2.length != 0) {
                size.value = Integer.parseInt(split2[0]);
            }
            size.type = "%";
        }
        return size;
    }

    private static String getTemplate(ActionContext actionContext2) {
        String str;
        if (actionContext2 == null) {
            return null;
        }
        String readFileAsString = readFileAsString(actionContext2, MessageTemplateConstants.Values.HTML_TEMPLATE_PREFIX);
        Map<String, Object> replaceFileToLocalPath = replaceFileToLocalPath(actionContext2.getArgs(), MessageTemplateConstants.Values.HTML_TEMPLATE_PREFIX);
        if (replaceFileToLocalPath == null || TextUtils.isEmpty(readFileAsString)) {
            return null;
        }
        replaceFileToLocalPath.put(Constants.Params.MESSAGE_ID, actionContext2.getMessageId());
        if (!(actionContext2.getContextualValues() == null || actionContext2.getContextualValues().arguments == null)) {
            replaceFileToLocalPath.put("displayEvent", actionContext2.getContextualValues().arguments);
        }
        try {
            str = readFileAsString.replace("##Vars##", ActionContext.mapToJsonObject(replaceFileToLocalPath).toString());
            try {
                str = actionContext2.fillTemplate(str);
            } catch (Throwable unused) {
            }
        } catch (JSONException unused2) {
            str = "";
        }
        return str.replace("\\/", RemoteSettings.FORWARD_SLASH_STRING);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e A[SYNTHETIC, Splitter:B:25:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0056 A[Catch:{ Exception -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068 A[SYNTHETIC, Splitter:B:35:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0070 A[Catch:{ Exception -> 0x006c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String readFileAsString(com.leanplum.ActionContext r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "Failed to close InputStream or BufferedReader: "
            r1 = 0
            if (r5 == 0) goto L_0x0084
            boolean r2 = android.text.TextUtils.isEmpty(r6)
            if (r2 == 0) goto L_0x000d
            goto L_0x0084
        L_0x000d:
            java.io.InputStream r5 = r5.streamNamed(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0066, all -> 0x004b }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0066, all -> 0x004b }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r5, r4)     // Catch:{ IOException -> 0x0066, all -> 0x004b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0066, all -> 0x004b }
        L_0x0022:
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            if (r1 == 0) goto L_0x0031
            r6.append(r1)     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            java.lang.String r1 = "\n"
            r6.append(r1)     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            goto L_0x0022
        L_0x0031:
            r2.close()     // Catch:{ IOException -> 0x0049, all -> 0x0046 }
            if (r5 == 0) goto L_0x003c
            r5.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003c
        L_0x003a:
            r5 = move-exception
            goto L_0x0040
        L_0x003c:
            r2.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x007f
        L_0x0040:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x0079
        L_0x0046:
            r6 = move-exception
            r1 = r2
            goto L_0x004c
        L_0x0049:
            r1 = r2
            goto L_0x0066
        L_0x004b:
            r6 = move-exception
        L_0x004c:
            if (r5 == 0) goto L_0x0054
            r5.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0054
        L_0x0052:
            r5 = move-exception
            goto L_0x005a
        L_0x0054:
            if (r1 == 0) goto L_0x0065
            r1.close()     // Catch:{ Exception -> 0x0052 }
            goto L_0x0065
        L_0x005a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r5)
        L_0x0065:
            throw r6
        L_0x0066:
            if (r5 == 0) goto L_0x006e
            r5.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x006e
        L_0x006c:
            r5 = move-exception
            goto L_0x0074
        L_0x006e:
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x007f
        L_0x0074:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L_0x0079:
            r1.append(r0)
            r1.append(r5)
        L_0x007f:
            java.lang.String r5 = r6.toString()
            return r5
        L_0x0084:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.messagetemplates.options.RichHtmlOptions.readFileAsString(com.leanplum.ActionContext, java.lang.String):java.lang.String");
    }

    private static Map<String, Object> replaceFileToLocalPath(Map<String, Object> map, String str) {
        String filePath;
        if (map == null) {
            return null;
        }
        for (String str2 : (String[]) map.keySet().toArray(new String[map.keySet().size()])) {
            if (map.get(str2) instanceof Map) {
                replaceFileToLocalPath((Map) map.get(str2), str);
            } else if (str2.contains("__file__") && !str2.equals(str) && (filePath = ActionContext.filePath((String) map.get(str2))) != null) {
                File file = new File(filePath);
                String str3 = "file://" + file.getAbsolutePath();
                if (str3.contains(Leanplum.getContext().getPackageName())) {
                    map.put(str2.replace("__file__", ""), str3.replace(" ", "%20"));
                }
                map.remove(str2);
            }
        }
        return map;
    }

    private void setActionContext(ActionContext actionContext2) {
        this.actionContext = actionContext2;
    }

    private void setActionUrl(String str) {
        this.actionUrl = str;
    }

    private void setCloseUrl(String str) {
        this.closeUrl = str;
    }

    private void setHtmlAlign(String str) {
        this.htmlAlign = str;
    }

    private void setHtmlHeight(int i10) {
        this.htmlHeight = i10;
    }

    private void setHtmlTabOutsideToClose(boolean z10) {
        this.htmlTabOutsideToClose = z10;
    }

    private void setHtmlTemplate(String str) {
        this.htmlTemplate = str;
    }

    private void setHtmlWidth(String str) {
        this.htmlWidth = getSizeValueAndType(str);
    }

    private void setHtmlYOffset(String str) {
        this.htmlYOffset = getSizeValueAndType(str);
    }

    private void setOpenUrl(String str) {
        this.openUrl = str;
    }

    private void setTrackActionUrl(String str) {
        this.trackActionUrl = str;
    }

    private void setTrackUrl(String str) {
        this.trackUrl = str;
    }

    public static ActionArgs toArgs() {
        return new ActionArgs().with(MessageTemplateConstants.Args.CLOSE_URL, MessageTemplateConstants.Values.DEFAULT_CLOSE_URL).with(MessageTemplateConstants.Args.OPEN_URL, MessageTemplateConstants.Values.DEFAULT_OPEN_URL).with(MessageTemplateConstants.Args.ACTION_URL, MessageTemplateConstants.Values.DEFAULT_ACTION_URL).with(MessageTemplateConstants.Args.TRACK_ACTION_URL, MessageTemplateConstants.Values.DEFAULT_TRACK_ACTION_URL).with(MessageTemplateConstants.Args.TRACK_URL, MessageTemplateConstants.Values.DEFAULT_TRACK_URL).with(MessageTemplateConstants.Args.HTML_ALIGN, "Top").with(MessageTemplateConstants.Args.HTML_HEIGHT, 0);
    }

    public void dismiss() {
        this.actionContext.runActionNamed(MessageTemplateConstants.Args.DISMISS_ACTION);
    }

    public ActionContext getActionContext() {
        return this.actionContext;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public String getCloseUrl() {
        return this.closeUrl;
    }

    public String getHtmlAlign() {
        return this.htmlAlign;
    }

    public int getHtmlHeight() {
        return this.htmlHeight;
    }

    public String getHtmlTemplate() {
        return this.htmlTemplate;
    }

    public Size getHtmlWidth() {
        return this.htmlWidth;
    }

    public int getHtmlYOffset(Activity activity) {
        Size size;
        if (activity == null || (size = this.htmlYOffset) == null || TextUtils.isEmpty(size.type)) {
            return 0;
        }
        Size size2 = this.htmlYOffset;
        int i10 = size2.value;
        if ("%".equals(size2.type)) {
            return ((SizeUtil.getDisplaySize(activity).y - SizeUtil.getStatusBarHeight(activity)) * i10) / 100;
        }
        return SizeUtil.dpToPx(activity, i10);
    }

    public String getOpenUrl() {
        return this.openUrl;
    }

    public String getTrackActionUrl() {
        return this.trackActionUrl;
    }

    public String getTrackUrl() {
        return this.trackUrl;
    }

    public boolean isBanner() {
        return getActionContext().getArgs().get(MessageTemplateConstants.Values.HTML_TEMPLATE_PREFIX).toString().toLowerCase().contains("banner");
    }

    public boolean isBannerWithTapOutsideFalse() {
        if (!getActionContext().getArgs().get(MessageTemplateConstants.Values.HTML_TEMPLATE_PREFIX).toString().toLowerCase().contains("banner") || isHtmlTabOutsideToClose()) {
            return false;
        }
        return true;
    }

    public boolean isFullScreen() {
        return this.htmlHeight == 0;
    }

    public boolean isHtmlAlignBottom() {
        return MessageTemplateConstants.Args.HTML_ALIGN_BOTTOM.equals(getHtmlAlign());
    }

    public boolean isHtmlTabOutsideToClose() {
        return this.htmlTabOutsideToClose;
    }
}
