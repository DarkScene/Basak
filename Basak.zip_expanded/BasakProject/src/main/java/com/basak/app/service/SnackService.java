package com.basak.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basak.app.dao.ISnackRepository;
import com.basak.app.model.SnackVO;

@Service
public class SnackService implements ISnackService {
	
	@Autowired
	@Qualifier("ISnackRepository")
	ISnackRepository snackRepository;

	/* �˻�â */
	//ȸ�纰
	@Override
	public List<SnackVO> getCompanyInfo() {
		return snackRepository.getCompanyInfo();
	}
	//������
	@Override
	public List<SnackVO> getCategoryInfo() {
		return snackRepository.getCategoryInfo();
	}

	/* ����Ʈ */
	//��ü ����Ʈ
	@Override
	public List<SnackVO> getSnackId() {
		return snackRepository.getSnackId();
	}
	/* ȸ�纰, ������ �˻����� �����Ͽ����� return���� null�� ���� ���ذ� */
	/* ����� ȸ��, ����Ʈ�� ������ ���⶧���� ���� ó�� */
	//ȸ�纰 ����Ʈ
	@Override
	public List<SnackVO> getSnackCompany(String company){
		if(company.equals("�Ե�����")) {			
			return snackRepository.getSnackCompanyLot();
		} else if(company.equals("����")) {
			return snackRepository.getSnackCompanyHae();
		} else if(company.equals("ũ���")) {
			return snackRepository.getSnackCompanyCrow();
		} else if(company.equals("û��")) {
			return snackRepository.getSnackCompanyChun();
		} else if(company.equals("������")) {
			return snackRepository.getSnackCompanyOri();
		}
		return snackRepository.getSnackId();
	}
	//������ ����Ʈ
	@Override
	public List<SnackVO> getSnackCategory(String category){
		if(category.equals("��Ŷ")) {			
			return snackRepository.getSnackCategoryBis();
		} else if(category.equals("���ݸ�")) {
			return snackRepository.getSnackCategoryCho();
		} else if(category.equals("����ũ")) {
			return snackRepository.getSnackCategoryCake();			
		}
		return snackRepository.getSnackId();
	}
	
	/* ����ȸ */
	//ID�� ���� ���� ����
	@Override
	public SnackVO getSnackInfo(int snackId) {
		return snackRepository.getSnackInfo(snackId);
	}
	
	/* �̻�� */
	//����
	@Override
	public void insertSnack(SnackVO snack) {
		snackRepository.insertSnack(snack);
	}
	//����
	@Override
	public void updateSnack(SnackVO snack) {
		snackRepository.updateSnack(snack);
	}
	//����
	@Override
	@Transactional
	public void deleteSnack(int snackID) {
		snackRepository.deleteSnack(snackID);
	}
}