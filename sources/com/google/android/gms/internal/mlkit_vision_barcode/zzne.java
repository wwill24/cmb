package com.google.android.gms.internal.mlkit_vision_barcode;

import com.coffeemeetsbagel.models.Height;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.stetho.server.http.HttpStatus;
import com.leanplum.internal.ResourceQualifiers;
import com.withpersona.sdk2.inquiry.network.HttpStatusCode;
import net.bytebuddy.jar.asm.Opcodes;

public enum zzne implements zzdi {
    UNKNOWN_EVENT(0),
    ON_DEVICE_FACE_DETECT(1),
    ON_DEVICE_FACE_CREATE(2),
    ON_DEVICE_FACE_CLOSE(3),
    ON_DEVICE_FACE_LOAD(4),
    ON_DEVICE_TEXT_DETECT(11),
    ON_DEVICE_TEXT_CREATE(12),
    ON_DEVICE_TEXT_CLOSE(13),
    ON_DEVICE_TEXT_LOAD(14),
    ON_DEVICE_BARCODE_DETECT(21),
    ON_DEVICE_BARCODE_CREATE(22),
    ON_DEVICE_BARCODE_CLOSE(23),
    ON_DEVICE_BARCODE_LOAD(24),
    ON_DEVICE_IMAGE_LABEL_DETECT(Opcodes.F2D),
    ON_DEVICE_IMAGE_LABEL_CREATE(Opcodes.D2I),
    ON_DEVICE_IMAGE_LABEL_CLOSE(Opcodes.D2L),
    ON_DEVICE_IMAGE_LABEL_LOAD(Opcodes.D2F),
    ON_DEVICE_SMART_REPLY_DETECT(Opcodes.DCMPL),
    ON_DEVICE_SMART_REPLY_CREATE(Opcodes.DCMPG),
    ON_DEVICE_SMART_REPLY_CLOSE(Opcodes.IFEQ),
    ON_DEVICE_SMART_REPLY_BLACKLIST_UPDATE(Opcodes.IFNE),
    ON_DEVICE_SMART_REPLY_LOAD(Opcodes.IFLT),
    ON_DEVICE_LANGUAGE_IDENTIFICATION_DETECT(Opcodes.IF_ICMPLT),
    ON_DEVICE_LANGUAGE_IDENTIFICATION_CREATE(Opcodes.IF_ICMPGE),
    ON_DEVICE_LANGUAGE_IDENTIFICATION_LOAD(Opcodes.IF_ICMPLE),
    ON_DEVICE_LANGUAGE_IDENTIFICATION_CLOSE(Opcodes.IF_ICMPGT),
    ON_DEVICE_TRANSLATOR_TRANSLATE(Opcodes.LOOKUPSWITCH),
    ON_DEVICE_TRANSLATOR_CREATE(Opcodes.IRETURN),
    ON_DEVICE_TRANSLATOR_LOAD(Opcodes.LRETURN),
    ON_DEVICE_TRANSLATOR_CLOSE(Opcodes.FRETURN),
    ON_DEVICE_TRANSLATOR_DOWNLOAD(Opcodes.DRETURN),
    ON_DEVICE_ENTITY_EXTRACTION_ANNOTATE(241),
    ON_DEVICE_ENTITY_EXTRACTION_CREATE(242),
    ON_DEVICE_ENTITY_EXTRACTION_LOAD(243),
    ON_DEVICE_ENTITY_EXTRACTION_CLOSE(244),
    ON_DEVICE_ENTITY_EXTRACTION_DOWNLOAD(245),
    ON_DEVICE_OBJECT_CREATE(Opcodes.ATHROW),
    ON_DEVICE_OBJECT_LOAD(192),
    ON_DEVICE_OBJECT_INFERENCE(Opcodes.INSTANCEOF),
    ON_DEVICE_OBJECT_CLOSE(Opcodes.MONITORENTER),
    ON_DEVICE_DI_CREATE(311),
    ON_DEVICE_DI_LOAD(312),
    ON_DEVICE_DI_DOWNLOAD(313),
    ON_DEVICE_DI_RECOGNIZE(314),
    ON_DEVICE_DI_CLOSE(315),
    ON_DEVICE_POSE_CREATE(321),
    ON_DEVICE_POSE_LOAD(322),
    ON_DEVICE_POSE_INFERENCE(323),
    ON_DEVICE_POSE_CLOSE(324),
    ON_DEVICE_POSE_PRELOAD(325),
    ON_DEVICE_SEGMENTATION_CREATE(331),
    ON_DEVICE_SEGMENTATION_LOAD(332),
    ON_DEVICE_SEGMENTATION_INFERENCE(333),
    ON_DEVICE_SEGMENTATION_CLOSE(334),
    CUSTOM_OBJECT_CREATE(FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS),
    CUSTOM_OBJECT_LOAD(342),
    CUSTOM_OBJECT_INFERENCE(343),
    CUSTOM_OBJECT_CLOSE(344),
    CUSTOM_IMAGE_LABEL_CREATE(351),
    CUSTOM_IMAGE_LABEL_LOAD(352),
    CUSTOM_IMAGE_LABEL_DETECT(353),
    CUSTOM_IMAGE_LABEL_CLOSE(354),
    CLOUD_FACE_DETECT(31),
    CLOUD_FACE_CREATE(32),
    CLOUD_FACE_CLOSE(33),
    CLOUD_CROP_HINTS_CREATE(41),
    CLOUD_CROP_HINTS_DETECT(42),
    CLOUD_CROP_HINTS_CLOSE(43),
    CLOUD_DOCUMENT_TEXT_CREATE(51),
    CLOUD_DOCUMENT_TEXT_DETECT(52),
    CLOUD_DOCUMENT_TEXT_CLOSE(53),
    CLOUD_IMAGE_PROPERTIES_CREATE(61),
    CLOUD_IMAGE_PROPERTIES_DETECT(62),
    CLOUD_IMAGE_PROPERTIES_CLOSE(63),
    CLOUD_IMAGE_LABEL_CREATE(71),
    CLOUD_IMAGE_LABEL_DETECT(72),
    CLOUD_IMAGE_LABEL_CLOSE(73),
    CLOUD_LANDMARK_CREATE(81),
    CLOUD_LANDMARK_DETECT(82),
    CLOUD_LANDMARK_CLOSE(83),
    CLOUD_LOGO_CREATE(91),
    CLOUD_LOGO_DETECT(92),
    CLOUD_LOGO_CLOSE(93),
    CLOUD_SAFE_SEARCH_CREATE(111),
    CLOUD_SAFE_SEARCH_DETECT(112),
    CLOUD_SAFE_SEARCH_CLOSE(113),
    CLOUD_TEXT_CREATE(121),
    CLOUD_TEXT_DETECT(122),
    CLOUD_TEXT_CLOSE(123),
    CLOUD_WEB_SEARCH_CREATE(Opcodes.LXOR),
    CLOUD_WEB_SEARCH_DETECT(Opcodes.IINC),
    CLOUD_WEB_SEARCH_CLOSE(Opcodes.I2L),
    CUSTOM_MODEL_RUN(102),
    CUSTOM_MODEL_CREATE(103),
    CUSTOM_MODEL_CLOSE(104),
    CUSTOM_MODEL_LOAD(105),
    AUTOML_IMAGE_LABELING_RUN(Opcodes.PUTFIELD),
    AUTOML_IMAGE_LABELING_CREATE(Opcodes.INVOKEVIRTUAL),
    AUTOML_IMAGE_LABELING_CLOSE(Opcodes.INVOKESPECIAL),
    AUTOML_IMAGE_LABELING_LOAD(Opcodes.INVOKESTATIC),
    MODEL_DOWNLOAD(100),
    MODEL_UPDATE(101),
    REMOTE_MODEL_IS_DOWNLOADED(251),
    REMOTE_MODEL_DELETE_ON_DEVICE(252),
    ACCELERATION_ANALYTICS(260),
    PIPELINE_ACCELERATION_ANALYTICS(261),
    AGGREGATED_AUTO_ML_IMAGE_LABELING_INFERENCE(200),
    AGGREGATED_CUSTOM_MODEL_INFERENCE(201),
    AGGREGATED_ON_DEVICE_BARCODE_DETECTION(202),
    AGGREGATED_ON_DEVICE_FACE_DETECTION(203),
    AGGREGATED_ON_DEVICE_IMAGE_LABEL_DETECTION(204),
    AGGREGATED_ON_DEVICE_OBJECT_INFERENCE(205),
    AGGREGATED_ON_DEVICE_TEXT_DETECTION(206),
    AGGREGATED_ON_DEVICE_POSE_DETECTION(207),
    AGGREGATED_ON_DEVICE_SEGMENTATION(208),
    AGGREGATED_CUSTOM_OBJECT_INFERENCE(209),
    AGGREGATED_CUSTOM_IMAGE_LABEL_DETECTION(210),
    AGGREGATED_ON_DEVICE_EXPLICIT_CONTENT_DETECTION(211),
    AGGREGATED_ON_DEVICE_FACE_MESH_DETECTION(212),
    AGGREGATED_ON_DEVICE_IMAGE_QUALITY_ANALYSIS_DETECTION(ResourceQualifiers.Qualifier.AnonymousClass14.DENSITY_TV),
    AGGREGATED_ON_DEVICE_IMAGE_CAPTIONING_INFERENCE(214),
    AGGREGATED_ON_DEVICE_DOCUMENT_DETECT_PROCESS(215),
    AGGREGATED_ON_DEVICE_DOCUMENT_CROP_PROCESS(216),
    AGGREGATED_ON_DEVICE_DOCUMENT_ENHANCE_PROCESS(217),
    REMOTE_CONFIG_FETCH(271),
    REMOTE_CONFIG_ACTIVATE(Height.CENTIMETRES_MAX),
    REMOTE_CONFIG_LOAD(273),
    REMOTE_CONFIG_FRC_FETCH(281),
    INSTALLATION_ID_INIT(291),
    INSTALLATION_ID_REGISTER_NEW_ID(292),
    INSTALLATION_ID_REFRESH_TEMPORARY_TOKEN(293),
    INSTALLATION_ID_FIS_CREATE_INSTALLATION(301),
    INSTALLATION_ID_FIS_GENERATE_AUTH_TOKEN(302),
    INPUT_IMAGE_CONSTRUCTION(361),
    HANDLE_LEAKED(371),
    CAMERA_SOURCE(381),
    OPTIONAL_MODULE_IMAGE_LABELING(391),
    OPTIONAL_MODULE_LANGUAGE_ID(401),
    OPTIONAL_MODULE_LANGUAGE_ID_CREATE(402),
    OPTIONAL_MODULE_LANGUAGE_ID_INIT(403),
    OPTIONAL_MODULE_LANGUAGE_ID_INFERENCE(404),
    OPTIONAL_MODULE_LANGUAGE_ID_RELEASE(405),
    OPTIONAL_MODULE_NLCLASSIFIER(411),
    OPTIONAL_MODULE_NLCLASSIFIER_CREATE(FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED),
    OPTIONAL_MODULE_NLCLASSIFIER_INIT(HttpStatusCode.PAYLOAD_TOO_LARGE_413),
    OPTIONAL_MODULE_NLCLASSIFIER_INFERENCE(414),
    OPTIONAL_MODULE_NLCLASSIFIER_RELEASE(415),
    NLCLASSIFIER_CLIENT_LIBRARY(421),
    NLCLASSIFIER_CLIENT_LIBRARY_CREATE(HttpStatusCode.UNPROCESSABLE_ENTITY_422),
    NLCLASSIFIER_CLIENT_LIBRARY_CLASSIFY(423),
    NLCLASSIFIER_CLIENT_LIBRARY_CLOSE(424),
    OPTIONAL_MODULE_FACE_DETECTION(441),
    OPTIONAL_MODULE_FACE_DETECTION_CREATE(461),
    OPTIONAL_MODULE_FACE_DETECTION_INIT(462),
    OPTIONAL_MODULE_FACE_DETECTION_INFERENCE(463),
    OPTIONAL_MODULE_FACE_DETECTION_RELEASE(464),
    ACCELERATION_ALLOWLIST_GET(431),
    ACCELERATION_ALLOWLIST_FETCH(432),
    ODML_IMAGE(442),
    OPTIONAL_MODULE_BARCODE_DETECTION(443),
    OPTIONAL_MODULE_BARCODE_DETECTION_CREATE(471),
    OPTIONAL_MODULE_BARCODE_DETECTION_INIT(472),
    OPTIONAL_MODULE_BARCODE_DETECTION_INFERENCE(473),
    OPTIONAL_MODULE_BARCODE_DETECTION_RELEASE(474),
    OPTIONAL_MODULE_BARCODE_DETECTION_INFERENCE_AFTER_RELEASE(475),
    TOXICITY_DETECTION_CREATE_EVENT(451),
    TOXICITY_DETECTION_LOAD_EVENT(452),
    TOXICITY_DETECTION_INFERENCE_EVENT(453),
    TOXICITY_DETECTION_DOWNLOAD_EVENT(454),
    OPTIONAL_MODULE_CUSTOM_IMAGE_LABELING_CREATE(481),
    OPTIONAL_MODULE_CUSTOM_IMAGE_LABELING_INIT(482),
    OPTIONAL_MODULE_CUSTOM_IMAGE_LABELING_INFERENCE(483),
    OPTIONAL_MODULE_CUSTOM_IMAGE_LABELING_RELEASE(484),
    CODE_SCANNER_SCAN_API(491),
    CODE_SCANNER_OPTIONAL_MODULE(492),
    ON_DEVICE_EXPLICIT_CONTENT_CREATE(HttpStatus.HTTP_NOT_IMPLEMENTED),
    ON_DEVICE_EXPLICIT_CONTENT_LOAD(HttpStatusCode.BAD_GATEWAY_502),
    ON_DEVICE_EXPLICIT_CONTENT_DETECT(503),
    ON_DEVICE_EXPLICIT_CONTENT_CLOSE(504),
    ON_DEVICE_FACE_MESH_CREATE(511),
    ON_DEVICE_FACE_MESH_LOAD(512),
    ON_DEVICE_FACE_MESH_DETECT(513),
    ON_DEVICE_FACE_MESH_CLOSE(514),
    OPTIONAL_MODULE_SMART_REPLY_CREATE(521),
    OPTIONAL_MODULE_SMART_REPLY_INIT(522),
    OPTIONAL_MODULE_SMART_REPLY_INFERENCE(523),
    OPTIONAL_MODULE_SMART_REPLY_RELEASE(524),
    OPTIONAL_MODULE_TEXT_CREATE(531),
    OPTIONAL_MODULE_TEXT_INIT(532),
    OPTIONAL_MODULE_TEXT_INFERENCE(533),
    OPTIONAL_MODULE_TEXT_RELEASE(534),
    ON_DEVICE_IMAGE_QUALITY_ANALYSIS_CREATE(541),
    ON_DEVICE_IMAGE_QUALITY_ANALYSIS_LOAD(542),
    ON_DEVICE_IMAGE_QUALITY_ANALYSIS_DETECT(543),
    ON_DEVICE_IMAGE_QUALITY_ANALYSIS_CLOSE(544),
    OPTIONAL_MODULE_DOCUMENT_DETECT_CREATE(551),
    OPTIONAL_MODULE_DOCUMENT_DETECT_INIT(552),
    OPTIONAL_MODULE_DOCUMENT_DETECT_PROCESS(553),
    OPTIONAL_MODULE_DOCUMENT_DETECT_RELEASE(554),
    OPTIONAL_MODULE_DOCUMENT_CROP_CREATE(561),
    OPTIONAL_MODULE_DOCUMENT_CROP_INIT(562),
    OPTIONAL_MODULE_DOCUMENT_CROP_PROCESS(563),
    OPTIONAL_MODULE_DOCUMENT_CROP_RELEASE(564),
    OPTIONAL_MODULE_DOCUMENT_ENHANCE_CREATE(571),
    OPTIONAL_MODULE_DOCUMENT_ENHANCE_INIT(572),
    OPTIONAL_MODULE_DOCUMENT_ENHANCE_PROCESS(573),
    OPTIONAL_MODULE_DOCUMENT_ENHANCE_RELEASE(574),
    OPTIONAL_MODULE_IMAGE_QUALITY_ANALYSIS_CREATE(581),
    OPTIONAL_MODULE_IMAGE_QUALITY_ANALYSIS_INIT(582),
    OPTIONAL_MODULE_IMAGE_QUALITY_ANALYSIS_INFERENCE(583),
    OPTIONAL_MODULE_IMAGE_QUALITY_ANALYSIS_RELEASE(584),
    OPTIONAL_MODULE_IMAGE_CAPTIONING_CREATE(591),
    OPTIONAL_MODULE_IMAGE_CAPTIONING_INIT(592),
    OPTIONAL_MODULE_IMAGE_CAPTIONING_INFERENCE(593),
    OPTIONAL_MODULE_IMAGE_CAPTIONING_RELEASE(594),
    ON_DEVICE_IMAGE_CAPTIONING_CREATE(601),
    ON_DEVICE_IMAGE_CAPTIONING_LOAD(602),
    ON_DEVICE_IMAGE_CAPTIONING_INFERENCE(603),
    ON_DEVICE_IMAGE_CAPTIONING_CLOSE(604),
    ON_DEVICE_IMAGE_CAPTIONING_MODEL_DOWNLOAD(605),
    ON_DEVICE_DOCUMENT_DETECT_CREATE(611),
    ON_DEVICE_DOCUMENT_DETECT_LOAD(612),
    ON_DEVICE_DOCUMENT_DETECT_PROCESS(613),
    ON_DEVICE_DOCUMENT_DETECT_CLOSE(614),
    ON_DEVICE_DOCUMENT_CROP_CREATE(621),
    ON_DEVICE_DOCUMENT_CROP_LOAD(622),
    ON_DEVICE_DOCUMENT_CROP_PROCESS(623),
    ON_DEVICE_DOCUMENT_CROP_CLOSE(624),
    ON_DEVICE_DOCUMENT_ENHANCE_CREATE(631),
    ON_DEVICE_DOCUMENT_ENHANCE_LOAD(632),
    ON_DEVICE_DOCUMENT_ENHANCE_PROCESS(633),
    ON_DEVICE_DOCUMENT_ENHANCE_CLOSE(634),
    OPTIONAL_MODULE_IMAGE_LABELING_CREATE(641),
    OPTIONAL_MODULE_IMAGE_LABELING_INIT(642),
    OPTIONAL_MODULE_IMAGE_LABELING_INFERENCE(643),
    OPTIONAL_MODULE_IMAGE_LABELING_RELEASE(644);
    
    private final int zzdD;

    private zzne(int i10) {
        this.zzdD = i10;
    }

    public final int zza() {
        return this.zzdD;
    }
}
