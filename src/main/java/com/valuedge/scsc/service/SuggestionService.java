package com.valuedge.scsc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.valuedge.scsc.entities.Suggestions;
import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.vo.SuggestionsVO;
import com.valuedge.scsc.vo.UserVO;

public interface SuggestionService {

	List<Suggestions> getSuggstions();

	Suggestions saveSuggestion(SuggestionsVO sgVO);

	List<Suggestions> getSuggstionsById(SuggestionsVO sgVO);

	String deleteSuggestion(SuggestionsVO sgVO);

}
