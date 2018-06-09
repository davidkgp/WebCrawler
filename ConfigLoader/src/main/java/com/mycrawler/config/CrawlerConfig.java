package com.mycrawler.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources(value={"crawl.conf"})
public interface CrawlerConfig extends Config {
	
	@Key("downloadDir")
	public String downloadDir();
	
	@Key("imageDimensionlowerlimit.mb")
	public double imageDimensionlowerlimitMB();
	
	@Key("imageExtensions.blacklist")
	@DefaultValue("exe,msi,bat,sh")
	public String imageExtensionsBlacklist();
	
	@Key("imageExtensions.whitelist")
	@DefaultValue("jpg,jpeg")
	public String imageExtensionsWhitelist();
	
	@Key("website")
	public String getWebsite();

}
