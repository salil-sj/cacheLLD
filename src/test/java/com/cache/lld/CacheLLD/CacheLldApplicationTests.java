package com.cache.lld.CacheLLD;

import com.cache.lld.CacheLLD.factory.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheLldApplicationTests {

	Cache<Integer,Integer> cache;

	@BeforeEach
	public void setUp(){
		cache= new CacheFactory<Integer,Integer>().defaultCache(5);
	}

	@Test
	void test() {
		cache.put(1,1);
		cache.put(2,2);
		cache.put(3,3);
		cache.put(4,4);
		cache.put(5,5);
		cache.put(1,1);
		cache.put(7,7);
		cache.put(8,8);
		System.out.printf("Testing executed.......");
	}

}
