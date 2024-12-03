package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.mparticle.kits.AppsFlyerKit;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.ranges.IntRange;
import org.json.JSONException;
import org.json.a;
import org.json.b;
import uc.c;
import uc.d;
import uc.e;

@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002<=B\t\b\u0002¢\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J;\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0017H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b \u0010!J'\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010!R\"\u0010%\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020$0#8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001a\u00020\u00198\u0002XT¢\u0006\u0006\n\u0004\b0\u0010(R\u0014\u00102\u001a\u0002018\u0006XT¢\u0006\u0006\n\u0004\b2\u00103R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u0019048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u0019048\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b8\u00109¨\u0006>"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "", "enable", "", "timestamp", "", "isValidTimestamp", "Lorg/json/b;", "models", "addModels", "jsonObject", "parseRawJsonObject", "fetchModels", "enableMTML", "Lorg/json/a;", "jsonArray", "", "parseJsonArray", "Lcom/facebook/appevents/ml/ModelManager$Task;", "task", "Ljava/io/File;", "getRuleFile", "", "denses", "", "texts", "predict", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "Lcom/facebook/appevents/ml/MTensor;", "res", "thresholds", "processSuggestedEventResult", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processIntegrityDetectionResult", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "taskHandlers", "Ljava/util/Map;", "MODEL_ASSERT_STORE", "Ljava/lang/String;", "CACHE_KEY_MODELS", "MTML_USE_CASE", "USE_CASE_KEY", "VERSION_ID_KEY", "ASSET_URI_KEY", "RULES_URI_KEY", "THRESHOLD_KEY", "CACHE_KEY_REQUEST_TIMESTAMP", "", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "I", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "Ljava/util/List;", "MTML_INTEGRITY_DETECT_PREDICTION", "isLocaleEnglish", "()Z", "<init>", "()V", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ModelManager {
    private static final String ASSET_URI_KEY = "asset_uri";
    private static final String CACHE_KEY_MODELS = "models";
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    public static final ModelManager INSTANCE = new ModelManager();
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = q.m("none", "address", IntegrityManager.INTEGRITY_TYPE_HEALTH);
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = q.m("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
    private static final String MTML_USE_CASE = "MTML";
    private static final String RULES_URI_KEY = "rules_uri";
    private static final String THRESHOLD_KEY = "thresholds";
    private static final String USE_CASE_KEY = "use_case";
    private static final String VERSION_ID_KEY = "version_id";
    private static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Task.values().length];
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final String toKey() {
            int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i10 == 1) {
                return "integrity_detect";
            }
            if (i10 == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toUseCase() {
            int i10 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i10 == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i10 == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", "thresholds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TaskHandler {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String assetUri;
        private Model model;
        /* access modifiers changed from: private */
        public Runnable onPostExecute;
        private File ruleFile;
        private String ruleUri;
        private float[] thresholds;
        private String useCase;
        private int versionId;

        @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000fJ\u001c\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", "", "", "useCase", "", "versionId", "", "deleteOldFiles", "uri", "name", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "onComplete", "download", "Lorg/json/b;", "json", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "build", "handler", "execute", "master", "", "slaves", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final void deleteOldFiles(String str, int i10) {
                File[] listFiles;
                boolean z10;
                File mlDir = Utils.getMlDir();
                if (mlDir != null && (listFiles = mlDir.listFiles()) != null) {
                    if (listFiles.length == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        String str2 = str + '_' + i10;
                        int length = listFiles.length;
                        int i11 = 0;
                        while (i11 < length) {
                            File file = listFiles[i11];
                            i11++;
                            String name = file.getName();
                            j.f(name, "name");
                            if (r.J(name, str, false, 2, (Object) null) && !r.J(name, str2, false, 2, (Object) null)) {
                                file.delete();
                            }
                        }
                    }
                }
            }

            private final void download(String str, String str2, FileDownloadTask.Callback callback) {
                File file = new File(Utils.getMlDir(), str2);
                if (str == null || file.exists()) {
                    callback.onComplete(file);
                } else {
                    new FileDownloadTask(str, file, callback).execute(new String[0]);
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: execute$lambda-1  reason: not valid java name */
            public static final void m79execute$lambda1(List list, File file) {
                j.g(list, "$slaves");
                j.g(file, "file");
                Model build = Model.Companion.build(file);
                if (build != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.Companion.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", new e(taskHandler, build));
                    }
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: execute$lambda-1$lambda-0  reason: not valid java name */
            public static final void m80execute$lambda1$lambda0(TaskHandler taskHandler, Model model, File file) {
                j.g(taskHandler, "$slave");
                j.g(file, "file");
                taskHandler.setModel(model);
                taskHandler.setRuleFile(file);
                Runnable access$getOnPostExecute$p = taskHandler.onPostExecute;
                if (access$getOnPostExecute$p != null) {
                    access$getOnPostExecute$p.run();
                }
            }

            public final TaskHandler build(b bVar) {
                if (bVar == null) {
                    return null;
                }
                try {
                    String string = bVar.getString(ModelManager.USE_CASE_KEY);
                    String string2 = bVar.getString(ModelManager.ASSET_URI_KEY);
                    String optString = bVar.optString(ModelManager.RULES_URI_KEY, (String) null);
                    int i10 = bVar.getInt(ModelManager.VERSION_ID_KEY);
                    float[] access$parseJsonArray = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, bVar.getJSONArray(ModelManager.THRESHOLD_KEY));
                    j.f(string, "useCase");
                    j.f(string2, "assetUri");
                    return new TaskHandler(string, string2, optString, i10, access$parseJsonArray);
                } catch (Exception unused) {
                    return null;
                }
            }

            public final void execute(TaskHandler taskHandler) {
                j.g(taskHandler, "handler");
                execute(taskHandler, p.e(taskHandler));
            }

            public final void execute(TaskHandler taskHandler, List<TaskHandler> list) {
                j.g(taskHandler, "master");
                j.g(list, "slaves");
                deleteOldFiles(taskHandler.getUseCase(), taskHandler.getVersionId());
                download(taskHandler.getAssetUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId(), new d(list));
            }
        }

        public TaskHandler(String str, String str2, String str3, int i10, float[] fArr) {
            j.g(str, "useCase");
            j.g(str2, "assetUri");
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i10;
            this.thresholds = fArr;
        }

        public final String getAssetUri() {
            return this.assetUri;
        }

        public final Model getModel() {
            return this.model;
        }

        public final File getRuleFile() {
            return this.ruleFile;
        }

        public final String getRuleUri() {
            return this.ruleUri;
        }

        public final float[] getThresholds() {
            return this.thresholds;
        }

        public final String getUseCase() {
            return this.useCase;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setAssetUri(String str) {
            j.g(str, "<set-?>");
            this.assetUri = str;
        }

        public final void setModel(Model model2) {
            this.model = model2;
        }

        public final TaskHandler setOnPostExecute(Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        public final void setRuleFile(File file) {
            this.ruleFile = file;
        }

        public final void setRuleUri(String str) {
            this.ruleUri = str;
        }

        public final void setThresholds(float[] fArr) {
            this.thresholds = fArr;
        }

        public final void setUseCase(String str) {
            j.g(str, "<set-?>");
            this.useCase = str;
        }

        public final void setVersionId(int i10) {
            this.versionId = i10;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.values().length];
            iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelManager() {
    }

    public static final /* synthetic */ float[] access$parseJsonArray(ModelManager modelManager, a aVar) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return modelManager.parseJsonArray(aVar);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final void addModels(b bVar) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Iterator<String> keys = bVar.keys();
                while (keys.hasNext()) {
                    try {
                        TaskHandler build = TaskHandler.Companion.build(bVar.getJSONObject(keys.next()));
                        if (build != null) {
                            taskHandlers.put(build.getUseCase(), build);
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final void enable() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Utility utility = Utility.INSTANCE;
                Utility.runOnNonUiThread(new uc.a());
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ Exception -> 0x007f, all -> 0x007b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[Catch:{ Exception -> 0x007f, all -> 0x007b }] */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m76enable$lambda0() {
        /*
            java.lang.String r0 = "model_request_timestamp"
            java.lang.String r1 = "models"
            java.lang.Class<com.facebook.appevents.ml.ModelManager> r2 = com.facebook.appevents.ml.ModelManager.class
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r4 = "com.facebook.internal.MODEL_STORE"
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r4 = 0
            java.lang.String r4 = r3.getString(r1, r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            if (r4 == 0) goto L_0x002f
            int r6 = r4.length()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            if (r6 != 0) goto L_0x0026
            r5 = 1
        L_0x0026:
            if (r5 == 0) goto L_0x0029
            goto L_0x002f
        L_0x0029:
            org.json.b r5 = new org.json.b     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r5.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            goto L_0x0034
        L_0x002f:
            org.json.b r5 = new org.json.b     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r5.<init>()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
        L_0x0034:
            r6 = 0
            long r6 = r3.getLong(r0, r6)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            boolean r4 = com.facebook.internal.FeatureManager.isEnabled(r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            if (r4 == 0) goto L_0x0052
            int r4 = r5.length()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            if (r4 == 0) goto L_0x0052
            com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            boolean r4 = r4.isValidTimestamp(r6)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            if (r4 != 0) goto L_0x0072
        L_0x0052:
            com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            org.json.b r5 = r4.fetchModels()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            if (r5 != 0) goto L_0x005b
            return
        L_0x005b:
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            android.content.SharedPreferences$Editor r1 = r3.putString(r1, r4)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r3)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r0.apply()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
        L_0x0072:
            com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r0.addModels(r5)     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            r0.enableMTML()     // Catch:{ Exception -> 0x007f, all -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.m76enable$lambda0():void");
    }

    private final void enableMTML() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ArrayList arrayList = new ArrayList();
                String str = null;
                int i10 = 0;
                for (Map.Entry next : taskHandlers.entrySet()) {
                    String str2 = (String) next.getKey();
                    TaskHandler taskHandler = (TaskHandler) next.getValue();
                    if (j.b(str2, Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                        String assetUri = taskHandler.getAssetUri();
                        int max = Math.max(i10, taskHandler.getVersionId());
                        FeatureManager featureManager = FeatureManager.INSTANCE;
                        if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                            arrayList.add(taskHandler.setOnPostExecute(new uc.b()));
                        }
                        str = assetUri;
                        i10 = max;
                    }
                    if (j.b(str2, Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                        str = taskHandler.getAssetUri();
                        i10 = Math.max(i10, taskHandler.getVersionId());
                        FeatureManager featureManager2 = FeatureManager.INSTANCE;
                        if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                            arrayList.add(taskHandler.setOnPostExecute(new c()));
                        }
                    }
                }
                if (str != null && i10 > 0 && !arrayList.isEmpty()) {
                    TaskHandler.Companion.execute(new TaskHandler(MTML_USE_CASE, str, (String) null, i10, (float[]) null), arrayList);
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-1  reason: not valid java name */
    public static final void m77enableMTML$lambda1() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                SuggestedEventsManager.enable();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-2  reason: not valid java name */
    public static final void m78enableMTML$lambda2() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                IntegrityManager.enable();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    private final b fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString("fields", TextUtils.join(AppsFlyerKit.COMMA, strArr));
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app/model_asset", (GraphRequest.Callback) null);
            newGraphPathRequest.setParameters(bundle);
            b jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    public static final File getRuleFile(Task task) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(task, "task");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.getRuleFile();
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final boolean isLocaleEnglish() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale != null) {
                String language = resourceLocale.getLanguage();
                j.f(language, "locale.language");
                if (StringsKt__StringsKt.O(language, "en", false, 2, (Object) null)) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final boolean isValidTimestamp(long j10) {
        if (CrashShieldHandler.isObjectCrashing(this) || j10 == 0) {
            return false;
        }
        try {
            if (System.currentTimeMillis() - j10 < 259200000) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    private final float[] parseJsonArray(a aVar) {
        if (CrashShieldHandler.isObjectCrashing(this) || aVar == null) {
            return null;
        }
        try {
            float[] fArr = new float[aVar.o()];
            int i10 = 0;
            int o10 = aVar.o();
            if (o10 > 0) {
                while (true) {
                    int i11 = i10 + 1;
                    try {
                        String n10 = aVar.n(i10);
                        j.f(n10, "jsonArray.getString(i)");
                        fArr[i10] = Float.parseFloat(n10);
                    } catch (JSONException unused) {
                    }
                    if (i11 >= o10) {
                        break;
                    }
                    i10 = i11;
                }
            }
            return fArr;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return new org.json.b();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.b parseRawJsonObject(org.json.b r13) {
        /*
            r12 = this;
            java.lang.String r0 = "asset_uri"
            java.lang.String r1 = "thresholds"
            java.lang.String r2 = "version_id"
            java.lang.String r3 = "rules_uri"
            java.lang.String r4 = "use_case"
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r6 = 0
            if (r5 == 0) goto L_0x0012
            return r6
        L_0x0012:
            org.json.b r5 = new org.json.b     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r7 = "data"
            org.json.a r13 = r13.getJSONArray(r7)     // Catch:{ JSONException -> 0x0064 }
            r7 = 0
            int r8 = r13.o()     // Catch:{ JSONException -> 0x0064 }
            if (r8 <= 0) goto L_0x0069
        L_0x0024:
            int r9 = r7 + 1
            org.json.b r7 = r13.j(r7)     // Catch:{ JSONException -> 0x0064 }
            org.json.b r10 = new org.json.b     // Catch:{ JSONException -> 0x0064 }
            r10.<init>()     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r2)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r2, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r4, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            org.json.a r11 = r7.getJSONArray(r1)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r1, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r0)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r0, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            boolean r11 = r7.has(r3)     // Catch:{ JSONException -> 0x0064 }
            if (r11 == 0) goto L_0x0058
            java.lang.String r11 = r7.getString(r3)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r3, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
        L_0x0058:
            java.lang.String r7 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
            r5.put((java.lang.String) r7, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x0064 }
            if (r9 < r8) goto L_0x0062
            goto L_0x0069
        L_0x0062:
            r7 = r9
            goto L_0x0024
        L_0x0064:
            org.json.b r5 = new org.json.b     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
        L_0x0069:
            return r5
        L_0x006a:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.parseRawJsonObject(org.json.b):org.json.b");
    }

    public static final String[] predict(Task task, float[][] fArr, String[] strArr) {
        Model model;
        boolean z10;
        float[][] fArr2 = fArr;
        String[] strArr2 = strArr;
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            j.g(task, "task");
            j.g(fArr2, "denses");
            j.g(strArr2, "texts");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                model = null;
            } else {
                model = taskHandler.getModel();
            }
            if (model == null) {
                return null;
            }
            float[] thresholds = taskHandler.getThresholds();
            int length = strArr2.length;
            boolean z11 = false;
            int length2 = fArr2[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    System.arraycopy(fArr2[i10], 0, mTensor.getData(), i10 * length2, length2);
                    if (i11 >= length) {
                        break;
                    }
                    i10 = i11;
                }
            }
            MTensor predictOnMTML = model.predictOnMTML(mTensor, strArr2, task.toKey());
            if (!(predictOnMTML == null || thresholds == null)) {
                if (predictOnMTML.getData().length == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    if (thresholds.length == 0) {
                        z11 = true;
                    }
                    if (!z11) {
                        int i12 = WhenMappings.$EnumSwitchMapping$0[task.ordinal()];
                        if (i12 == 1) {
                            return INSTANCE.processSuggestedEventResult(predictOnMTML, thresholds);
                        }
                        if (i12 == 2) {
                            return INSTANCE.processIntegrityDetectionResult(predictOnMTML, thresholds);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    private final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            if (shape2 != fArr.length) {
                return null;
            }
            IntRange o10 = j.o(0, shape);
            ArrayList arrayList = new ArrayList(r.t(o10, 10));
            Iterator it = o10.iterator();
            while (it.hasNext()) {
                int nextInt = ((b0) it).nextInt();
                String str = "none";
                int length = fArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    if (data[(nextInt * shape2) + i11] >= fArr[i10]) {
                        str = MTML_INTEGRITY_DETECT_PREDICTION.get(i11);
                    }
                    i10++;
                    i11 = i12;
                }
                arrayList.add(str);
            }
            Object[] array2 = arrayList.toArray(new String[0]);
            if (array2 != null) {
                return (String[]) array2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }

    private final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            if (shape2 != fArr.length) {
                return null;
            }
            IntRange o10 = j.o(0, shape);
            ArrayList arrayList = new ArrayList(r.t(o10, 10));
            Iterator it = o10.iterator();
            while (it.hasNext()) {
                int nextInt = ((b0) it).nextInt();
                String str = "other";
                int length = fArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    if (data[(nextInt * shape2) + i11] >= fArr[i10]) {
                        str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i11);
                    }
                    i10++;
                    i11 = i12;
                }
                arrayList.add(str);
            }
            Object[] array2 = arrayList.toArray(new String[0]);
            if (array2 != null) {
                return (String[]) array2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return null;
        }
    }
}
