package com.basak.app.service;

import java.util.List;

import com.basak.app.model.SnackVO;

public interface ISnackService {
	/* �˻�â */
	//ȸ�纰
	List<SnackVO> getCompanyInfo();
	//������
	List<SnackVO> getCategoryInfo();
	
	/* ����Ʈ */
	//��ü ����Ʈ
	List<SnackVO> getSnackId();
	//ȸ�纰 ����Ʈ
	List<SnackVO> getSnackCompany(String company);
	//������ ����Ʈ
	List<SnackVO> getSnackCategory(String category);
	
	/* ����ȸ */
	//ID�� ���� ���� ����
	SnackVO getSnackInfo(int snackId);
	
	/* �̻�� */
	//����
	void insertSnack(SnackVO snack);
	//����
	void updateSnack(SnackVO snack);
	//����
	void deleteSnack(int snackID);
}