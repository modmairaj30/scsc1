package com.valuedge.scsc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valuedge.scsc.entities.Suggestions;
import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.service.SuggestionService;
import com.valuedge.scsc.service.TVService;
import com.valuedge.scsc.vo.StatusVo;
import com.valuedge.scsc.vo.SuggestionsVO;
import com.valuedge.scsc.vo.TrafficVoilationsVO;

@RestController
@RequestMapping
public class SuggestionController {
	@Autowired
	SuggestionService suggService;
	@Autowired
	TVService tvService;
	@GetMapping(value = "/getSuggestions")
    public List<Suggestions> getSuggstions() {
        return suggService.getSuggstions();
    }

    @PostMapping(value = "/saveSuggestions")
    public Suggestions saveSuggestions(@RequestBody final SuggestionsVO sgVO) {
    	return suggService.saveSuggestion(sgVO);
    }
    
    @GetMapping(value = "/getSuggestionsById")
    public List<Suggestions> getVoilationsById(SuggestionsVO sgVO) {
        return suggService.getSuggstionsById(sgVO);
    }
    
    @DeleteMapping(value="/deleteSuggestion")
    public ResponseEntity<StatusVo> deleteSuggestion(SuggestionsVO sgVO) {
    	String res = suggService.deleteSuggestion(sgVO);
    	StatusVo status=new StatusVo();
    	status.setStatus(res);
    	return ResponseEntity.ok(status);
    	
    }
}
