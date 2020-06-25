package com.basak.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.basak.app.model.PagingVO;
import com.basak.app.model.ReviewVO;

public interface IReviewRepository {
	//����¡�� ���� ��ü ī��Ʈ
	int countReview(@Param("snackId") int snackId);
	//����¡ ó�� �� �Խñ� ��ȸ
	List<ReviewVO> selectReview(@Param("snackId") int snackId, @Param("vo") PagingVO vo);
	
	/* ���� ������ */
	//���� ������ ���� snackId �� ó��
	int getSnackId(int reviewId);
	//��� ����
	double getSnackAvg(int snackId);
	//���� ����
	void insertReview(ReviewVO rev);
	//���� ����
	void deleteReview(ReviewVO rev);
	
	/* �̻�� */
	//���� ����
	void updateReview(ReviewVO rev);
}