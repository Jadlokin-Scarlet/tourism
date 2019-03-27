package com.tourism.service;

import com.tourism.entity.business.Scenic;
import com.tourism.mapper.ScenicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicService {

	private ScenicMapper scenicMapper;

	@Autowired
	public ScenicService(ScenicMapper scenicMapper) {
		this.scenicMapper = scenicMapper;
	}

	public List<Scenic> getScenicByKey(Integer page, Integer pageSize, String fuzzyKey) {
		return scenicMapper.selectBySelectiveAndPage(fuzzyKey,page,pageSize);
	}

	public Scenic getScenicById(Integer scenicId) {
		return scenicMapper.selectByPrimaryKey(scenicId);
	}
}
