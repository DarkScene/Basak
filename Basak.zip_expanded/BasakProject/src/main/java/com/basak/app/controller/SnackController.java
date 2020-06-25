package com.basak.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.basak.app.model.MemberVO;
import com.basak.app.model.PagingVO;
import com.basak.app.model.SnackVO;
import com.basak.app.service.IReviewService;
import com.basak.app.service.ISnackService;

@Controller
public class SnackController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ISnackService snackService;
	@Autowired
	IReviewService reviewService;

	@RequestMapping(value={"/snack", "/snack/list"})
	public String getSnackID(HttpSession session, Model model
			,@RequestParam(value="category", required=false) String category
			,@RequestParam(value="company", required=false) String company) {
		logger.info("snack list");
		
		//�α��� ����
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null) {
			logger.info("snack list session false");
		} else {
			logger.info("snack list session true");
			model.addAttribute("member", member);
		}
		
		//����Ʈ �˻� �޴� (ȸ��, ����)
		List<SnackVO> snackCom = snackService.getCompanyInfo();
		List<SnackVO> snackCate = snackService.getCategoryInfo();
		model.addAttribute("snackCom", snackCom);
		model.addAttribute("snackCate", snackCate);
		
		//�Ϲ� ����Ʈ, ȸ�� �˻� ����Ʈ, ���� �˻� ����Ʈ
		if(category == null && company == null) {
			List<SnackVO> snackId = snackService.getSnackId();
			model.addAttribute("snackid", snackId);
		}else if(company != null) {
			List<SnackVO> snackId = snackService.getSnackCompany(company);
			model.addAttribute("snackid", snackId);
		}else if(category != null) {
			List<SnackVO> snackId = snackService.getSnackCategory(category);
			model.addAttribute("snackid", snackId);
		}
		return "snack/list";
	}
	
	@RequestMapping(value="/snack/info/{snackId}")
	public String getSnackInfo(@PathVariable int snackId, PagingVO vo, HttpSession session, Model model
			,@RequestParam(value="nowPage", required=false) String nowPage) {
		logger.info("snack info:"+snackId);
		
		// �α��� ����
		MemberVO member = (MemberVO) session.getAttribute("member");
		if(member == null) {
			logger.info("snack info session false");
		} else {
			logger.info("snack info session true");
			model.addAttribute("member", member);
		}
		
		//���� �ÿ� ���Ǵ� snackId ����
		SnackVO snack = snackService.getSnackInfo(snackId);
		model.addAttribute("snack", snack);
		
		//���
		double avg = reviewService.getSnackAvg(snackId);
		model.addAttribute("avg", avg*20);
		
		//���� ����¡
		int total = reviewService.countReview(snackId);
		if(nowPage == null) nowPage = "1";
		vo = new PagingVO(total, Integer.parseInt(nowPage), 5);
		model.addAttribute("paging", vo);
		model.addAttribute("viewAll", reviewService.selectReview(snackId, vo));		
		return "snack/info";
	}
	
	/* �̻�� : ������ ���ѿ��� �̷�� �����ϴ� ���� */
	@RequestMapping(value="/snack/insert", method=RequestMethod.POST)
	public String insertSnack(SnackVO snack, Model model) {
		logger.info("snack insert");
		snackService.insertSnack(snack);
		return "redirect:/snack";
	}
	
	/* �̻�� : ������ ���ѿ��� �̷�� �����ϴ� ���� */
	@RequestMapping(value="/snack/update", method=RequestMethod.POST)
	public String updateSnack(SnackVO snack, Model model) {
		logger.info("snack update");
		snackService.updateSnack(snack);
		return "redirect:/snack/"+snack.getSnackId();
	}
	
	/* �̻�� : ������ ���ѿ��� �̷�� �����ϴ� ���� */
	@RequestMapping(value="/snack/delete", method=RequestMethod.POST)
	public String deleteEmp(int snackID, Model model) {
		logger.info("snack delete post");
		snackService.deleteSnack(snackID);
		return "redirect:/snack";
	}
}