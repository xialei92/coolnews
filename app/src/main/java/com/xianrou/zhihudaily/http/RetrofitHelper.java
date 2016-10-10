package com.xianrou.zhihudaily.http;


import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.xianrou.zhihudaily.AppApplication;
import com.xianrou.zhihudaily.bean.DailyListBean;
import com.xianrou.zhihudaily.bean.ThemeListBean;
import com.xianrou.zhihudaily.http.apis.ZhihuApis;
import com.xianrou.zhihudaily.uitls.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by codeest on 2016/8/3.
 */
public class RetrofitHelper {

	private static OkHttpClient okHttpClient = null;
	private static ZhihuApis zhihuApiService = null;
//    private static GankApis gankApiService = null;
//    private static WeChatApis wechatApiService = null;

	private void init() {
		initOkHttp();
		zhihuApiService = getZhihuApiService();
//        gankApiService = getGankApiService();
//        wechatApiService = getWechatApiService();
	}

	public RetrofitHelper() {
		init();
	}

	private static void initOkHttp() {
		OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        if (BuildConfig.DEBUG) {
		// https://drakeet.me/retrofit-2-0-okhttp-3-0-config

//        }
		// http://www.jianshu.com/p/93153b34310e
		File cacheFile = new File(AppApplication.getInstance().getCacheDir().getAbsolutePath());
		Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
		Interceptor cacheInterceptor = new Interceptor() {
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request request = chain.request();
				if (!SystemUtil.isNetworkConnected()) {
					request = request.newBuilder()
							.cacheControl(CacheControl.FORCE_CACHE)
							.build();
				}
				Response response = chain.proceed(request);
				if (SystemUtil.isNetworkConnected()) {
					int maxAge = 0;
					// 有网络时, 不缓存, 最大保存时长为0
					response.newBuilder()
							.header("Cache-Control", "public, max-age=" + maxAge)
							.removeHeader("Pragma")
							.build();
				} else {
					// 无网络时，设置超时为4周
					int maxStale = 60 * 60 * 24 * 28;
					response.newBuilder()
							.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
							.removeHeader("Pragma")
							.build();
				}
				return response;
			}
		};
//        Interceptor apikey = new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                request = request.newBuilder()
//                        .addHeader("apikey",Constants.KEY_API)
//                        .build();
//                return chain.proceed(request);
//            }
//        };
//        builder.addInterceptor(apikey);
		//设置缓存
		builder.addNetworkInterceptor(cacheInterceptor);
		builder.addNetworkInterceptor(new StethoInterceptor());
		builder.addInterceptor(cacheInterceptor);
		builder.cache(cache);
		//设置超时
		builder.connectTimeout(10, TimeUnit.SECONDS);
		builder.readTimeout(20, TimeUnit.SECONDS);
		builder.writeTimeout(20, TimeUnit.SECONDS);
		//错误重连
		builder.retryOnConnectionFailure(true);
		okHttpClient = builder.build();
	}

	private static ZhihuApis getZhihuApiService() {
		Retrofit zhihuRetrofit = new Retrofit.Builder()
				.baseUrl(ZhihuApis.HOST)
				.client(okHttpClient)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return zhihuRetrofit.create(ZhihuApis.class);
	}

//    private static GankApis getGankApiService() {
//        Retrofit gankRetrofit = new Retrofit.Builder()
//                .baseUrl(GankApis.HOST)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        return gankRetrofit.create(GankApis.class);
//    }
//
//    private static WeChatApis getWechatApiService() {
//        Retrofit gankRetrofit = new Retrofit.Builder()
//                .baseUrl(WeChatApis.HOST)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        return gankRetrofit.create(WeChatApis.class);
//    }

	public Observable<DailyListBean> fetchDailyListInfo() {
		return zhihuApiService.getDailyList();
	}

//    public Observable<DailyBeforeListBean> fetchDailyBeforeListInfo(String date) {
//        return zhihuApiService.getDailyBeforeList(date);
//    }
//
    public Observable<ThemeListBean> fetchDailyThemeListInfo() {
        return zhihuApiService.getThemeList();
    }
//
//    public Observable<ThemeChildListBean> fetchThemeChildListInfo(int id) {
//        return zhihuApiService.getThemeChildList(id);
//    }
//
//    public Observable<SectionListBean> fetchSectionListInfo() {
//        return zhihuApiService.getSectionList();
//    }
//
//    public Observable<SectionChildListBean> fetchSectionChildListInfo(int id) {
//        return zhihuApiService.getSectionChildList(id);
//    }
//
//    public Observable<ZhihuDetailBean> fetchDetailInfo(int id) {
//        return zhihuApiService.getDetailInfo(id);
//    }
//
//    public Observable<DetailExtraBean> fetchDetailExtraInfo(int id) {
//        return zhihuApiService.getDetailExtraInfo(id);
//    }
//
//    public Observable<WelcomeBean> fetchWelcomeInfo(String res) {
//        return zhihuApiService.getWelcomeInfo(res);
//    }
//
//    public Observable<CommentBean> fetchLongCommentInfo(int id) {
//        return zhihuApiService.getLongCommentInfo(id);
//    }
//
//    public Observable<CommentBean> fetchShortCommentInfo(int id) {
//        return zhihuApiService.getShortCommentInfo(id);
//    }
//
//    public Observable<HotListBean> fetchHotListInfo() {
//        return zhihuApiService.getHotList();
//    }
//
//    public Observable<GankHttpResponse<List<GankItemBean>>> fetchTechList(String tech, int num, int page) {
//        return gankApiService.getTechList(tech, num, page);
//    }
//
//    public Observable<GankHttpResponse<List<GankItemBean>>> fetchGirlList(int num, int page) {
//        return gankApiService.getGirlList(num, page);
//    }
//
//    public Observable<GankHttpResponse<List<GankItemBean>>> fetchRandomGirl(int num) {
//        return gankApiService.getRandomGirl(num);
//    }
//
//    public Observable<GankHttpResponse<List<GankSearchItemBean>>> fetchGankSearchList(String query,String type,int num,int page) {
//        return gankApiService.getSearchList(query,type,num,page);
//    }
//
//    public Observable<WXHttpResponse<List<WXItemBean>>> fetchWechatListInfo(int num, int page) {
//        return wechatApiService.getWXHot(Constants.KEY_API, num, page);
//    }
//
//    public Observable<WXHttpResponse<List<WXItemBean>>> fetchWechatSearchListInfo(int num, int page, String word) {
//        return wechatApiService.getWXHotSearch(Constants.KEY_API, num, page, word);
//    }
}
