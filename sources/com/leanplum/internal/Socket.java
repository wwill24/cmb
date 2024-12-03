package com.leanplum.internal;

import android.app.AlertDialog;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.actions.internal.ActionManagerExecutionKt;
import com.leanplum.callbacks.VariablesChangedCallback;
import com.leanplum.internal.Constants;
import com.leanplum.internal.SocketIOClient;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.jivesoftware.smack.sasl.packet.SaslNonza;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class Socket {
    private static final String EVENT_APPLY_VARS = "applyVars";
    private static final String EVENT_CONTENT_RESPONSE = "getContentResponse";
    private static final String EVENT_GET_ACTIONS = "getActions";
    private static final String EVENT_GET_VARIABLES = "getVariables";
    private static final String EVENT_REGISTER_DEVICE = "registerDevice";
    private static final String EVENT_TRIGGER = "trigger";
    private static final String EVENT_UPDATE_VARS = "updateVars";
    private static final String TAG = "Leanplum";
    private static Socket instance;
    private static boolean requestNewConnection;
    /* access modifiers changed from: private */
    public boolean authSent;
    /* access modifiers changed from: private */
    public boolean connected = false;
    private boolean connecting = false;
    private Timer reconnectTimer;
    /* access modifiers changed from: private */
    public volatile SocketIOClient sio;
    /* access modifiers changed from: private */
    public String socketHost;
    /* access modifiers changed from: private */
    public int socketPort;

    public Socket() {
        createSocketClient();
    }

    private void connect() {
        updateConnectionStatus(true);
        if (this.sio != null) {
            this.sio.connect();
        }
    }

    public static synchronized void connectSocket() {
        synchronized (Socket.class) {
            if (instance == null) {
                instance = new Socket();
            } else {
                String socketHost2 = APIConfig.getInstance().getSocketHost();
                int socketPort2 = APIConfig.getInstance().getSocketPort();
                Socket socket = instance;
                String str = socket.socketHost;
                int i10 = socket.socketPort;
                boolean z10 = false;
                boolean z11 = true;
                if (!TextUtils.isEmpty(str) && !str.equals(socketHost2)) {
                    z10 = true;
                }
                if (i10 == 0 || i10 == socketPort2) {
                    z11 = z10;
                }
                if (z11) {
                    reconnectSocket();
                }
            }
        }
    }

    private void createSocketClient() {
        AnonymousClass1 r02 = new SocketIOClient.Handler() {
            public void on(String str, a aVar) {
                char c10 = 65535;
                try {
                    switch (str.hashCode()) {
                        case -2075611462:
                            if (str.equals(Socket.EVENT_APPLY_VARS)) {
                                c10 = 5;
                                break;
                            }
                            break;
                        case -1059891784:
                            if (str.equals(Socket.EVENT_TRIGGER)) {
                                c10 = 1;
                                break;
                            }
                            break;
                        case -924224807:
                            if (str.equals("registerDevice")) {
                                c10 = 4;
                                break;
                            }
                            break;
                        case -295879019:
                            if (str.equals(Socket.EVENT_UPDATE_VARS)) {
                                c10 = 0;
                                break;
                            }
                            break;
                        case -124943161:
                            if (str.equals(Socket.EVENT_GET_ACTIONS)) {
                                c10 = 3;
                                break;
                            }
                            break;
                        case -92082495:
                            if (str.equals(Socket.EVENT_GET_VARIABLES)) {
                                c10 = 2;
                                break;
                            }
                            break;
                    }
                    if (c10 == 0) {
                        Leanplum.forceContentUpdate();
                    } else if (c10 == 1) {
                        Socket.this.handleTriggerEvent(aVar);
                    } else if (c10 == 2) {
                        Socket.this.handleGetVariablesEvent();
                    } else if (c10 == 3) {
                        Socket.this.handleGetActionsEvent();
                    } else if (c10 == 4) {
                        Socket.this.handleRegisterDeviceEvent(aVar);
                    } else if (c10 == 5) {
                        Socket.handleApplyVarsEvent(aVar);
                    }
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }

            public void onConnect() {
                if (!Socket.this.authSent) {
                    Log.d("Connected to development server " + Socket.this.socketHost + CertificateUtil.DELIMITER + Socket.this.socketPort, new Object[0]);
                    try {
                        Map newMap = Util.newMap("appId", APIConfig.getInstance().appId(), Constants.Params.DEVICE_ID, APIConfig.getInstance().deviceId());
                        if (Socket.this.sio != null) {
                            Socket.this.sio.emit(SaslNonza.AuthMechanism.ELEMENT, new a((Collection<?>) Collections.singletonList(new b((Map<?, ?>) newMap))));
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    } catch (Throwable th2) {
                        Log.exception(th2);
                    }
                    boolean unused = Socket.this.authSent = true;
                    boolean unused2 = Socket.this.connected = true;
                    Socket.this.updateConnectionStatus(false);
                }
            }

            public void onDisconnect(int i10, String str) {
                Log.d("Disconnected from development server", new Object[0]);
                boolean unused = Socket.this.connected = false;
                Socket.this.updateConnectionStatus(false);
                boolean unused2 = Socket.this.authSent = false;
            }

            public void onError(Exception exc) {
                Log.e("Development socket error", (Throwable) exc);
                Socket.this.updateConnectionStatus(false);
            }
        };
        try {
            this.socketHost = APIConfig.getInstance().getSocketHost();
            this.socketPort = APIConfig.getInstance().getSocketPort();
            this.sio = new SocketIOClient(new URI("https://" + this.socketHost + CertificateUtil.DELIMITER + this.socketPort), r02);
        } catch (URISyntaxException e10) {
            Log.e(e10.getMessage(), new Object[0]);
        }
        connect();
        Timer timer = new Timer();
        this.reconnectTimer = timer;
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    Socket.this.reconnect();
                } catch (Throwable th2) {
                    Log.exception(th2);
                }
            }
        }, 0, 5000);
    }

    private void disconnect() {
        try {
            Timer timer = this.reconnectTimer;
            if (timer != null) {
                timer.cancel();
                this.reconnectTimer = null;
            }
            if (this.sio != null) {
                this.sio.disconnect();
                this.sio = null;
            }
        } catch (IOException e10) {
            Log.e("Disconnect error", (Throwable) e10);
        }
    }

    public static synchronized void disconnectSocket() {
        synchronized (Socket.class) {
            Socket socket = instance;
            if (socket != null) {
                socket.disconnect();
                instance = null;
            }
        }
    }

    static void handleApplyVarsEvent(a aVar) {
        if (aVar != null) {
            try {
                b j10 = aVar.j(0);
                if (j10 != null) {
                    VarCache.applyVariableDiffs(JsonConverter.mapFromJson(j10), (Map<String, Object>) null, (Map<String, Object>) null, (List<Map<String, Object>>) null, (List<Map<String, Object>>) null, (Map<String, Object>) null, (String) null, (String) null);
                }
            } catch (JSONException e10) {
                Log.e("Couldn't applyVars for preview.", (Throwable) e10);
            } catch (Throwable th2) {
                Log.exception(th2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void reconnect() {
        if (!this.connected && !this.connecting) {
            connect();
        }
    }

    private static synchronized void reconnectSocket() {
        synchronized (Socket.class) {
            Socket socket = instance;
            if (socket != null) {
                if (socket.connecting) {
                    requestNewConnection = true;
                } else {
                    socket.disconnect();
                    instance = new Socket();
                    requestNewConnection = false;
                }
            }
        }
    }

    private void showDeviceRegisteredDialog(final String str) {
        OperationQueue.sharedInstance().addUiOperation(new Runnable() {
            public void run() {
                LeanplumActivityHelper.queueActionUponActive(new VariablesChangedCallback() {
                    public void variablesChanged() {
                        boolean isPaused = ActionManager.getInstance().isPaused();
                        ActionManager.getInstance().setPaused(true);
                        ActionManagerExecutionKt.dismissCurrentAction(ActionManager.getInstance());
                        AlertDialog.Builder title = new AlertDialog.Builder(LeanplumActivityHelper.getCurrentActivity()).setTitle("Leanplum");
                        title.setMessage("Your device is registered to " + str + ".").setCancelable(false).setPositiveButton(MessageTemplateConstants.Values.OK_TEXT, new d(isPaused)).show();
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateConnectionStatus(boolean z10) {
        this.connecting = z10;
        if (!z10 && requestNewConnection) {
            reconnectSocket();
        }
    }

    /* access modifiers changed from: package-private */
    public void handleGetActionsEvent() {
        boolean sendActionsIfChanged = VarCache.sendActionsIfChanged();
        VarCache.maybeUploadNewFiles();
        sendEvent(EVENT_CONTENT_RESPONSE, Util.newMap("updated", Boolean.valueOf(sendActionsIfChanged), new Object[0]));
    }

    public void handleGetVariablesEvent() {
        boolean sendVariablesIfChanged = VarCache.sendVariablesIfChanged();
        VarCache.maybeUploadNewFiles();
        sendEvent(EVENT_CONTENT_RESPONSE, Util.newMap("updated", Boolean.valueOf(sendVariablesIfChanged), new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void handleRegisterDeviceEvent(a aVar) {
        String str;
        LeanplumInternal.onHasStartedAndRegisteredAsDeveloper();
        try {
            str = aVar.j(0).getString("email");
        } catch (JSONException unused) {
            Log.d("Socket - No developer e-mail provided.", new Object[0]);
            str = null;
        }
        if (str == null) {
            str = "a Leanplum account";
        }
        showDeviceRegisteredDialog(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.util.Map} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleTriggerEvent(org.json.a r6) {
        /*
            r5 = this;
            r0 = 0
            org.json.b r6 = r6.j(r0)     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r0 = "action"
            org.json.b r0 = r6.getJSONObject(r0)     // Catch:{ JSONException -> 0x0069 }
            if (r0 == 0) goto L_0x006f
            java.lang.String r1 = "messageId"
            java.lang.String r1 = r6.getString(r1)     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r2 = "isRooted"
            boolean r6 = r6.getBoolean(r2)     // Catch:{ JSONException -> 0x0069 }
            java.lang.String r2 = "__name__"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x0069 }
            com.leanplum.internal.ActionManager r3 = com.leanplum.internal.ActionManager.getInstance()     // Catch:{ JSONException -> 0x0069 }
            java.util.Map r3 = com.leanplum.actions.internal.ActionManagerDefinitionKt.getActionDefinitionMap(r3, r2)     // Catch:{ JSONException -> 0x0069 }
            java.lang.Object r3 = com.leanplum.internal.CollectionUtil.uncheckedCast(r3)     // Catch:{ JSONException -> 0x0069 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ JSONException -> 0x0069 }
            r4 = 0
            if (r3 == 0) goto L_0x003d
            java.lang.String r4 = "values"
            java.lang.Object r3 = r3.get(r4)     // Catch:{ JSONException -> 0x0069 }
            java.lang.Object r3 = com.leanplum.internal.CollectionUtil.uncheckedCast(r3)     // Catch:{ JSONException -> 0x0069 }
            r4 = r3
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ JSONException -> 0x0069 }
        L_0x003d:
            java.util.Map r0 = com.leanplum.internal.JsonConverter.mapFromJson(r0)     // Catch:{ JSONException -> 0x0069 }
            java.lang.Object r0 = com.leanplum.internal.VarCache.mergeHelper(r4, r0)     // Catch:{ JSONException -> 0x0069 }
            java.lang.Object r0 = com.leanplum.internal.CollectionUtil.uncheckedCast(r0)     // Catch:{ JSONException -> 0x0069 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ JSONException -> 0x0069 }
            com.leanplum.ActionContext r3 = new com.leanplum.ActionContext     // Catch:{ JSONException -> 0x0069 }
            r3.<init>(r2, r0, r1)     // Catch:{ JSONException -> 0x0069 }
            r3.preventRealtimeUpdating()     // Catch:{ JSONException -> 0x0069 }
            r3.setIsRooted(r6)     // Catch:{ JSONException -> 0x0069 }
            r6 = 1
            r3.setIsPreview(r6)     // Catch:{ JSONException -> 0x0069 }
            r3.update()     // Catch:{ JSONException -> 0x0069 }
            com.leanplum.internal.ActionManager r6 = com.leanplum.internal.ActionManager.getInstance()     // Catch:{ JSONException -> 0x0069 }
            com.leanplum.actions.internal.Action r0 = com.leanplum.actions.internal.Action.create(r3)     // Catch:{ JSONException -> 0x0069 }
            com.leanplum.actions.internal.ActionManagerExecutionKt.appendAction(r6, r0)     // Catch:{ JSONException -> 0x0069 }
            goto L_0x006f
        L_0x0069:
            r6 = move-exception
            java.lang.String r0 = "Error getting action info"
            com.leanplum.internal.Log.e((java.lang.String) r0, (java.lang.Throwable) r6)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.Socket.handleTriggerEvent(org.json.a):void");
    }

    public boolean isConnected() {
        return this.connected;
    }

    public <T> void sendEvent(String str, Map<String, T> map) {
        try {
            Log.d("Sending event: %s with data: %s over socket", str, map);
            if (this.sio != null) {
                this.sio.emit(str, new a((Collection<?>) Collections.singletonList(JsonConverter.mapToJsonObject(map))));
            }
        } catch (JSONException e10) {
            Log.d("Failed to create JSON data object: " + e10.getMessage(), new Object[0]);
        }
    }
}
