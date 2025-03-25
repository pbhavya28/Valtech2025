package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.entities.WebSeries;
import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/webservices")
public class WebSeriesController {

	@Autowired
	private WebSeriesService webSeriesService;
	
	@PostMapping("/")
	public WebSeriesVO saveWebSeries(@RequestBody WebSeriesVO wsvo) {
		return webSeriesService.saveWebService(wsvo);
	}
	@GetMapping("/{id}")
	public WebSeriesVO getWebSeries(@PathVariable("id") int id) {
		return webSeriesService.getWebService(id);
	}
	@GetMapping("/")
	public List<WebSeriesVO> getAllWebSerieses() {
		return webSeriesService.getAllWebServices();
	}
}
