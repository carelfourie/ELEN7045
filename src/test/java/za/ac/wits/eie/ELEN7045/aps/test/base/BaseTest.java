package za.ac.wits.eie.ELEN7045.aps.test.base;

import java.io.File;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;

import za.ac.wits.eie.ELEN7045.aps.concurrency.ScrapingSession;
import za.ac.wits.eie.ELEN7045.aps.dto.ScrapeResultDTO;
import za.ac.wits.eie.ELEN7045.aps.model.APSUser;
import za.ac.wits.eie.ELEN7045.aps.resource.Producer;
import za.ac.wits.eie.ELEN7045.aps.rest.JAXRSActivator;

public abstract class BaseTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml").importRuntimeAndTestDependencies();
		File[] libs = pom.resolve().withTransitivity().asFile();

		return ShrinkWrap.create(WebArchive.class, "jee_aps_app_test.war").addClasses(BaseTest.class).addClass(Producer.class).addPackages(true, ScrapingSession.class.getPackage())
				.addPackages(true, APSUser.class.getPackage()).addPackages(true, JAXRSActivator.class.getPackage()).addPackages(true, ScrapeResultDTO.class.getPackage())
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml").addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml").addAsWebInfResource("test-ds.xml")
				.addAsLibraries(libs);
	}
}
