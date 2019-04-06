package com.tourism.service;

import com.tourism.entity.business.Scenic;
import com.tourism.mapper.ScenicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScenicService {

	private ScenicMapper scenicMapper;

	@Autowired
	public ScenicService(ScenicMapper scenicMapper) {
		this.scenicMapper = scenicMapper;
	}
	@Transactional
	public List<Scenic> getScenicByKey(Integer page, Integer pageSize, String fuzzyKey,String sortKey) {
		return scenicMapper.selectBySelectiveAndPage(fuzzyKey,sortKey,page,pageSize);
	}
	@Transactional
	public Scenic getScenicById(Integer scenicId) {
		return scenicMapper.selectByPrimaryKey(scenicId);
	}
	@Transactional
	public Integer deleteScenic(Integer scenicId) {
		Scenic scenic = scenicMapper.selectByPrimaryKey(scenicId);
		if(scenic == null){
			return 1;
		}
		scenic.setClose(true);
		scenicMapper.updateByPrimaryKeySelective(scenic);
		return 0;
	}
	@Transactional
	public Scenic createOrUpdateScenic(Scenic scenic) {
		if(scenic.getId() == 0){
			scenicMapper.insertSelective(scenic);
		}else {
			scenicMapper.updateByPrimaryKeySelective(scenic);
		}
		return scenicMapper.selectByPrimaryKey(scenic.getId());
	}
}
