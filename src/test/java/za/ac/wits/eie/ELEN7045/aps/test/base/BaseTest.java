package za.ac.wits.eie.ELEN7045.aps.test.base;

import java.util.ArrayList;
import java.util.List;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.model.BillingCycle;
import za.ac.wits.eie.ELEN7045.aps.model.Company;
import za.ac.wits.eie.ELEN7045.aps.model.CompanyAccount;
import za.ac.wits.eie.ELEN7045.aps.model.Member;
import za.ac.wits.eie.ELEN7045.aps.model.ReturnCode;
import za.ac.wits.eie.ELEN7045.aps.model.ScrapingEvent;
import za.ac.wits.eie.ELEN7045.aps.model.Status;
import za.ac.wits.eie.ELEN7045.aps.model.base.BaseDomainEntity;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountCreationService;
import za.ac.wits.eie.ELEN7045.aps.service.APSUserAccountCreationServiceImpl;
import za.ac.wits.eie.ELEN7045.aps.service.MemberRegistration;
import za.ac.wits.eie.ELEN7045.aps.util.Resources;

public abstract class BaseTest {

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(WebArchive.class, "jee_aps_app_test.war").addClasses(getClasses())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource("test-ds.xml");
    }
    
    private static Class<?>[] getClasses() {
        try {
            List<Class<?>> classes = new ArrayList<Class<?>>();

            classes.add(BaseTest.class);
            classes.add(BaseDomainEntity.class);
            classes.add(Member.class);
            classes.add(MemberRegistration.class);
            classes.add(APSUser.class);
            classes.add(CompanyAccount.class);
            classes.add(Status.class);
            classes.add(Company.class);
            classes.add(BillingCycle.class);
            classes.add(ScrapingEvent.class);
            classes.add(ReturnCode.class);
            classes.add(APSUserAccountCreationService.class);
            classes.add(APSUserAccountCreationServiceImpl.class);
            classes.add(Resources.class);

            return classes.toArray(new Class<?>[classes.size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}




