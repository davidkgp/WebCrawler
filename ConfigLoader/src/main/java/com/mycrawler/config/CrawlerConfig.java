package com.mycrawler.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources(value={"file:../crawl.conf"})
public interface CrawlerConfig extends Config {
	
	@Key("imagecrawler.downloadDir")
	public String downloadDir();
	
	@Key("imagecrawler.dimensionlowerlimit.mb")
	public double imageDimensionlowerlimitMB();
	
	@Key("imagecrawler.blacklist")
	@DefaultValue("exe,msi,bat,sh")
	public String imageExtensionsBlacklist();
	
	@Key("imagecrawler.whitelist")
	@DefaultValue("jpg,jpeg")
	public String imageExtensionsWhitelist();
	
	@Key("imagecrawler.website")
	public String getWebsite();

}
