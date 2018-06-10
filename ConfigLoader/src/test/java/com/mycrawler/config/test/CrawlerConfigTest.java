package com.mycrawler.config.test;

import static org.junit.Assert.*;

import org.aeonbits.owner.ConfigFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycrawler.config.CrawlerConfig;

public class CrawlerConfigTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		CrawlerConfig config = ConfigFactory.create(CrawlerConfig.class);
		assertNotNull(config.downloadDir());
		assertNotNull(config.getWebsite());
		assertNotNull(config.imageDimensionlowerlimitMB());
		assertNotNull(config.imageExtensionsBlacklist());
		assertNotNull(config.imageExtensionsWhitelist());
	}

}
