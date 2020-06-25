package com.basak.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.basak.app.model.SnackVO;

public interface ISnackRepository {
	/* �˻�â */
	//ȸ�纰
	List<SnackVO> getCompanyInfo();
	//������
	List<SnackVO> getCategoryInfo();
	
	/* ����Ʈ */
	//��ü ����Ʈ
	List<SnackVO> getSnackId();
	/* ȸ�纰, ������ �˻����� �����Ͽ����� return���� null�� ���� ���ذ� */
	/* ����� ȸ��, ����Ʈ�� ������ ���⶧���� ���� ó�� */
	// �̻�� : ȸ�纰 ����Ʈ
	List<SnackVO> getSnackCompany(@Param("company") String company);
	//�Ե�����
	List<SnackVO> getSnackCompanyLot();
	//����
	List<SnackVO> getSnackCompanyHae();
	//ũ���
	List<SnackVO> getSnackCompanyCrow();
	//û��
	List<SnackVO> getSnackCompanyChun();
	//������
	List<SnackVO> getSnackCompanyOri();
	
	// �̻�� : ������ ����Ʈ
	List<SnackVO> getSnackCategory(@Param("category") String category);
	//��Ŷ
	List<SnackVO> getSnackCategoryBis();
	//���ݸ�
	List<SnackVO> getSnackCategoryCho();
	//����ũ
	List<SnackVO> getSnackCategoryCake();
	
	/* ����ȸ */
	//ID�� ���� ���� ����
	SnackVO getSnackInfo(@Param("snackId") int snackId);
	
	/* �̻�� */
	//����
	void insertSnack(SnackVO snack);
	//����
	void updateSnack(SnackVO snack);
	//����
	void deleteSnack(@Param("snackID") int snackId);
}
