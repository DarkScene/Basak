package com.basak.app.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.basak.app.model.PagingVO;
import com.basak.app.model.ReviewVO;

public interface IReviewService {
	//����¡�� ���� ��ü ī��Ʈ
	int countReview(int snackId);
	//����¡ ó�� �� �Խñ� ��ȸ
	List<ReviewVO> selectReview(@Param("snackId") int snackId, PagingVO vo);
	
	/* ���� ������ */
	//���� ������ ���� snackId �� ó��
	int getSnackId(int reviewId);
	//��� ����
	double getSnackAvg(int snackId);
	//���� ����
	void insertReview(ReviewVO review);
	//���� ����
	void deleteReview(ReviewVO review);

	/* �̻�� */
	//���� ����
	void updateReview(ReviewVO review);
}