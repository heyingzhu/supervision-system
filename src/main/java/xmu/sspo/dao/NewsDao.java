package xmu.sspo.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import xmu.sspo.model.News;

@Repository
public interface NewsDao {
	
	/**
	 *  ˵��������id��ȡ����
	 * @param id
	 * @return News
	 */
	News get(Long id);
	
	/**
	 *   ˵������ȡ�����б�
	 * @return List<News>
	 */
	List<News> listNews(int page);
	
	/**
	 *  ˵��������id�б��ȡ����
	 * @param id
	 * @return News
	 */
	ArrayList<News> getNewsListByIdList(ArrayList<Integer> newsList);
	
	/**
	 *  ˵������ȡ����������
	 * @return Long
	 */
	BigInteger getNewsCount();
}
