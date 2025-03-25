package com.valtech.training.streamingservice.services;

import java.util.List;

import com.valtech.training.streamingservice.vos.WebSeriesVO;

public interface WebSeriesService {

	WebSeriesVO saveWebService(WebSeriesVO wsvo);

	WebSeriesVO getWebService(int id);

	List<WebSeriesVO> getAllWebServices();

	List<WebSeriesVO> findAllByEpisodeCount(int episodeCount);

	List<WebSeriesVO> findAllByEpisodeDuration(int duration);

}