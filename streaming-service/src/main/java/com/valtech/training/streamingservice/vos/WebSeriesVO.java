package com.valtech.training.streamingservice.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.streamingservice.entities.WebSeries;

public record WebSeriesVO(int id,String name, String genre, String language, int episodeCount, int episodeDuration) {

	public static WebSeriesVO from(WebSeries ws) {
		return new WebSeriesVO(ws.getId(), ws.getName(), ws.getGenre(), ws.getLanguage(), ws.getEpisodeCount(), ws.getEpisodeDuration());
	}
	public static List<WebSeriesVO> from (List<WebSeries> ws){
		return ws.stream().map(webS -> WebSeriesVO.from(webS)).collect(Collectors.toList());
	}
	public WebSeries to() {
		return new WebSeries(name,genre,language,episodeCount,episodeDuration);
	}
}
