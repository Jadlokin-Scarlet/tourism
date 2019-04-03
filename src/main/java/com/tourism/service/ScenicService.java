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

	public List<Scenic> getScenicByKey(Integer page, Integer pageSize, String fuzzyKey,String sortKey) {
		return scenicMapper.selectBySelectiveAndPage(fuzzyKey,sortKey,page,pageSize);
	}

	public Scenic getScenicById(Integer scenicId) {
		return scenicMapper.selectByPrimaryKey(scenicId);
	}

	public Integer deleteScenic(Integer scenicId) {
		Scenic scenic = scenicMapper.selectByPrimaryKey(scenicId);
		if(scenic == null){
			return 1;
		}
		scenic.setClose(true);
		scenicMapper.updateByPrimaryKey(scenic);
		return 0;
	}
}
