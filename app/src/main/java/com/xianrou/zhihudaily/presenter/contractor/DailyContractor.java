package com.xianrou.zhihudaily.presenter.contractor;

import com.xianrou.zhihudaily.base.BasePresenter;
import com.xianrou.zhihudaily.base.BaseView;
import com.xianrou.zhihudaily.bean.DailyListBean;
import com.xianrou.zhihudaily.bean.ReadBean;

/**
 * Created by android studio.
 * user 磊
 * Date 2016/9/27
 * Time 11:01
 * Desc
 */

public class DailyContractor {

	public interface View extends BaseView {

		void showContent(DailyListBean listBean);

		void showMoreContent(DailyListBean listBean);

		void updateReadUi(int position);

		void loadComplete();

		void hideRefresh();
	}

	public interface Presenter extends BasePresenter<View> {

		void getData();

		void getMoreData(String date);

		void insertRead(ReadBean bean, int position);
	}

}
