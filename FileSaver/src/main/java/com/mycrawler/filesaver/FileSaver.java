package com.mycrawler.filesaver;

import java.net.URL;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.aeonbits.owner.ConfigFactory;

import com.mycrawler.config.CrawlerConfig;

public class FileSaver {
	
    private Supplier<CrawlerConfig> getConfig = ()->ConfigFactory.create(CrawlerConfig.class);
    
    public Function<URL,Boolean> saveFile = (URL imageUrl)->{
    	
    };
    
    public Function<URL,Boolean> saveFileRetry = (URL imageUrl)->{
    	
    };
    
    private Function<URL,Optional> checkEligibilitySaving = (URL imageUrl)
    
    
}
