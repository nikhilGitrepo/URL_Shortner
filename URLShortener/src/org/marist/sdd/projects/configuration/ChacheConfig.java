/**
 * 
 */
package org.marist.sdd.projects.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.marist.sdd.projects.cache.RecentCreatedCacheManager;

@Configurable
@EnableCaching
@ComponentScan("org.marist.sdd.projects.configuration")
public class ChacheConfig {

	@Bean
	public RecentCreatedCacheManager getRecentAccessedCacheManager(){
		System.out.println("getRecentAccessedCacheManager()");
		return new RecentCreatedCacheManager();
	}
	
	@Bean
	public CacheManager getEhCacheManager(){
		System.out.println("getEhCacheManager()");
		return new EhCacheCacheManager( getEhCacheFactory().getObject() );
		
	}
	
	@Bean
	public EhCacheManagerFactoryBean getEhCacheFactory(){
		System.out.println("getEhCacheFactory()");
		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factoryBean.setShared(true);
		return factoryBean;
	}
}
