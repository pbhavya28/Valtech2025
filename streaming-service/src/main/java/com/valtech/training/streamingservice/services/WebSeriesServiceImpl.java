package com.valtech.training.streamingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.streamingservice.repos.WebSeriesRepo;
import com.valtech.training.streamingservice.vos.WebSeriesVO;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class WebSeriesServiceImpl implements WebSeriesService {

	@Autowired
	private WebSeriesRepo wsRepo;
	
	@Override
	public WebSeriesVO saveWebService(WebSeriesVO wsvo) {
		return WebSeriesVO.from(wsRepo.save(wsvo.to()));
	}
	@Override
	public WebSeriesVO getWebService(int id) {
		return WebSeriesVO.from(wsRepo.getReferenceById(id));
	}
	@Override
	public List<WebSeriesVO> getAllWebServices(){
		return WebSeriesVO.from(wsRepo.findAll());
	}
	
	@Override
	public List<WebSeriesVO> findAllByEpisodeCount(int episodeCount){
		return WebSeriesVO.from(wsRepo.findAllByEpisodeCount(episodeCount));	
	}
	
	@Override
	public List<WebSeriesVO> findAllByEpisodeDuration(int duration){
		return WebSeriesVO.from(wsRepo.findAllByEpisodeDuration(duration));
	}
}
