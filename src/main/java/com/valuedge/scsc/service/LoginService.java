package com.valuedge.scsc.service;

import java.util.List;

import com.valuedge.scsc.entities.LoginDetails;
import com.valuedge.scsc.entities.UserDetails;
import com.valuedge.scsc.vo.LoginDetailReportVO;
import com.valuedge.scsc.vo.LoginDetailsVO;
import com.valuedge.scsc.vo.ReportVO;
import com.valuedge.scsc.vo.UserDetailReportVO;

public interface LoginService {
	String login(LoginDetailsVO loginIdVO);

	String logout(LoginDetailsVO logoutVO);

	String getLoginId(LoginDetailsVO loginIdVO);

	List<LoginDetails> getLoginDetails(LoginDetailsVO loginIdVO);

	List<LoginDetailReportVO> getLoginRepot(ReportVO reportVO);

	List<UserDetailReportVO> getLoginDetailRepot(ReportVO reportVO);

}
