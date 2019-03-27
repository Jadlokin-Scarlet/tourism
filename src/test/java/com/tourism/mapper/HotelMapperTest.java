package com.tourism.mapper;

import com.tourism.StartApplication;
import com.tourism.entity.business.Hotel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
@EnableAutoConfiguration
public class HotelMapperTest {

	@Resource
	private HotelMapper hotelMapper;

	@Test
	public void test(){
		System.out.println(new Hotel().toString());
		System.out.println(hotelMapper);
	}

}