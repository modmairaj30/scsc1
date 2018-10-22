package com.valuedge.scsc.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.valuedge.scsc.entities.TrafficVoilations;
import com.valuedge.scsc.entities.User;
import com.valuedge.scsc.vo.TrafficVoilationsVO;
import com.valuedge.scsc.vo.UserVO;

public interface TVService {
	//TrafficVoilationsVO saveVoilation(TrafficVoilationsVO tvVO);
	
	String saveVoilation(TrafficVoilationsVO tvVO);

	List<TrafficVoilations> getVoilations();

	String deleteVoilation(TrafficVoilationsVO tvVO);

	//ResponseEntity<?> getVoilationsById(TrafficVoilationsVO tvVO);

}
