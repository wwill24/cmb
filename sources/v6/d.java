package v6;

import com.coffeemeetsbagel.models.NetworkPhoto;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.ProfileDtoImplementation;
import com.coffeemeetsbagel.models.entities.PhotoEntity;
import com.coffeemeetsbagel.models.entities.ProfileEntity;
import com.coffeemeetsbagel.qna.data.network.NetworkAnswer;
import com.coffeemeetsbagel.qna.data.network.NetworkQuestionGroup;
import com.coffeemeetsbagel.qna.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f18075a = new d();

    private d() {
    }

    public final ProfileEntity a(NetworkProfile networkProfile) {
        List list;
        j.g(networkProfile, "networkProfile");
        ProfileDtoImplementation b10 = b(networkProfile);
        List<NetworkPhoto> photos = networkProfile.getPhotos();
        j.f(photos, "networkProfile.photos");
        ArrayList arrayList = new ArrayList();
        for (NetworkPhoto networkPhoto : photos) {
            b bVar = b.f18074a;
            j.f(networkPhoto, "it");
            String id2 = networkProfile.getId();
            j.f(id2, "networkProfile.id");
            PhotoEntity a10 = bVar.a(networkPhoto, id2);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        List<NetworkQuestionGroup> questionGroups = networkProfile.getQuestionGroups();
        j.f(questionGroups, "networkProfile.questionGroups");
        ArrayList arrayList2 = new ArrayList(r.t(questionGroups, 10));
        for (NetworkQuestionGroup answers : questionGroups) {
            List<NetworkAnswer> answers2 = answers.getAnswers();
            if (answers2 != null) {
                ArrayList arrayList3 = new ArrayList(r.t(answers2, 10));
                for (NetworkAnswer a11 : answers2) {
                    String id3 = networkProfile.getId();
                    j.f(id3, "networkProfile.id");
                    arrayList3.add(r.a(a11, id3));
                }
                list = r.u(arrayList3);
                if (list != null) {
                    arrayList2.add(list);
                }
            }
            list = q.j();
            arrayList2.add(list);
        }
        return new ProfileEntity(b10.getId(), b10.getAge(), b10.getCity(), b10.getCountry(), b10.getEducation(), b10.getEmployer(), b10.getEthnicities(), b10.getFirstName(), b10.getGender(), b10.getHeight(), b10.getLastName(), b10.getOccupation(), b10.getReligion(), b10.getSecondaryEducation(), b10.getState(), arrayList, r.u(arrayList2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.coffeemeetsbagel.models.ProfileDtoImplementation b(com.coffeemeetsbagel.models.NetworkProfile r23) {
        /*
            r22 = this;
            java.lang.String r0 = "networkProfile"
            r1 = r23
            kotlin.jvm.internal.j.g(r1, r0)
            java.util.List r0 = r23.getListSchools()
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = r2
            goto L_0x0019
        L_0x0018:
            r0 = r3
        L_0x0019:
            r4 = 0
            if (r0 != 0) goto L_0x0053
            java.util.List r0 = r23.getListDegrees()
            if (r0 == 0) goto L_0x002b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r0 = r2
            goto L_0x002c
        L_0x002b:
            r0 = r3
        L_0x002c:
            if (r0 != 0) goto L_0x0053
            com.coffeemeetsbagel.models.entities.ProfileEducationEntity r0 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity
            java.util.List r5 = r23.getListSchools()
            java.lang.Object r5 = r5.get(r2)
            java.lang.String r6 = "networkProfile.listSchools[0]"
            kotlin.jvm.internal.j.f(r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            java.util.List r6 = r23.getListDegrees()
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r6 = "networkProfile.listDegrees[0]"
            kotlin.jvm.internal.j.f(r2, r6)
            java.lang.String r2 = (java.lang.String) r2
            r0.<init>(r5, r2)
            r11 = r0
            goto L_0x0054
        L_0x0053:
            r11 = r4
        L_0x0054:
            java.util.List r0 = r23.getEthnicityAsApiParamsList()
            java.lang.String r2 = "networkProfile.ethnicityAsApiParamsList"
            kotlin.jvm.internal.j.f(r0, r2)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x0066:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x007e
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.coffeemeetsbagel.models.entities.EthnicityType$Companion r5 = com.coffeemeetsbagel.models.entities.EthnicityType.Companion
            com.coffeemeetsbagel.models.entities.EthnicityType r2 = r5.fromApiKey(r2)
            if (r2 == 0) goto L_0x0066
            r13.add(r2)
            goto L_0x0066
        L_0x007e:
            com.coffeemeetsbagel.models.entities.Height r0 = new com.coffeemeetsbagel.models.entities.Height
            int r2 = r23.getHeightCm()
            int r5 = r23.getHeightFeet()
            int r6 = r23.getHeightInches()
            r0.<init>(r2, r5, r6)
            java.util.List r2 = r23.getListSchools()
            if (r2 == 0) goto L_0x00d2
            java.util.List r2 = r23.getListSchools()
            int r2 = r2.size()
            if (r2 <= r3) goto L_0x00d2
            java.util.List r2 = r23.getListDegrees()
            if (r2 == 0) goto L_0x00d2
            java.util.List r2 = r23.getListDegrees()
            int r2 = r2.size()
            if (r2 <= r3) goto L_0x00d2
            com.coffeemeetsbagel.models.entities.ProfileEducationEntity r4 = new com.coffeemeetsbagel.models.entities.ProfileEducationEntity
            java.util.List r2 = r23.getListSchools()
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r5 = "networkProfile.listSchools[1]"
            kotlin.jvm.internal.j.f(r2, r5)
            java.lang.String r2 = (java.lang.String) r2
            java.util.List r5 = r23.getListDegrees()
            java.lang.Object r3 = r5.get(r3)
            java.lang.String r5 = "networkProfile.listDegrees[1]"
            kotlin.jvm.internal.j.f(r3, r5)
            java.lang.String r3 = (java.lang.String) r3
            r4.<init>(r2, r3)
        L_0x00d2:
            r20 = r4
            com.coffeemeetsbagel.models.ProfileDtoImplementation r2 = new com.coffeemeetsbagel.models.ProfileDtoImplementation
            java.lang.String r7 = r23.getId()
            java.lang.String r3 = "networkProfile.id"
            kotlin.jvm.internal.j.f(r7, r3)
            int r8 = r23.getAge()
            java.lang.String r3 = r23.getCity()
            java.lang.String r4 = ""
            java.lang.Object r3 = nc.c.a(r3, r4)
            java.lang.String r5 = "getValueOrDefault(networkProfile.city, \"\")"
            kotlin.jvm.internal.j.f(r3, r5)
            r9 = r3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r3 = r23.getCountry()
            java.lang.Object r3 = nc.c.a(r3, r4)
            java.lang.String r5 = "getValueOrDefault(networkProfile.country, \"\")"
            kotlin.jvm.internal.j.f(r3, r5)
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10
            java.lang.String r3 = r23.getEmployer()
            java.lang.Object r3 = nc.c.a(r3, r4)
            java.lang.String r5 = "getValueOrDefault(networkProfile.employer, \"\")"
            kotlin.jvm.internal.j.f(r3, r5)
            r12 = r3
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r3 = r23.getUserFirstName()
            java.lang.Object r3 = nc.c.a(r3, r4)
            java.lang.String r5 = "getValueOrDefault(networ…rofile.userFirstName, \"\")"
            kotlin.jvm.internal.j.f(r3, r5)
            r14 = r3
            java.lang.String r14 = (java.lang.String) r14
            com.coffeemeetsbagel.models.entities.GenderType$Companion r3 = com.coffeemeetsbagel.models.entities.GenderType.Companion
            java.lang.String r5 = r23.getGender()
            com.coffeemeetsbagel.models.entities.GenderType r15 = r3.fromApiKey(r5)
            java.lang.String r3 = r23.getUserLastName()
            java.lang.Object r3 = nc.c.a(r3, r4)
            java.lang.String r5 = "getValueOrDefault(networkProfile.userLastName, \"\")"
            kotlin.jvm.internal.j.f(r3, r5)
            r17 = r3
            java.lang.String r17 = (java.lang.String) r17
            java.lang.String r3 = r23.getOccupation()
            java.lang.Object r3 = nc.c.a(r3, r4)
            java.lang.String r5 = "getValueOrDefault(networkProfile.occupation, \"\")"
            kotlin.jvm.internal.j.f(r3, r5)
            r18 = r3
            java.lang.String r18 = (java.lang.String) r18
            com.coffeemeetsbagel.models.entities.ReligionType$Companion r3 = com.coffeemeetsbagel.models.entities.ReligionType.Companion
            java.lang.String r5 = r23.getReligionApiParam()
            com.coffeemeetsbagel.models.entities.ReligionType r19 = r3.fromApiKey(r5)
            java.lang.String r1 = r23.getState()
            java.lang.Object r1 = nc.c.a(r1, r4)
            java.lang.String r3 = "getValueOrDefault(networkProfile.state, \"\")"
            kotlin.jvm.internal.j.f(r1, r3)
            r21 = r1
            java.lang.String r21 = (java.lang.String) r21
            r6 = r2
            r16 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.d.b(com.coffeemeetsbagel.models.NetworkProfile):com.coffeemeetsbagel.models.ProfileDtoImplementation");
    }
}
