package oracle.mau.main.home.other;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import java.util.ArrayList;
import java.util.List;

import oracle.mau.R;
import oracle.mau.base.BaseFragment;
import oracle.mau.entity.ArticleEntity;
import oracle.mau.entity.UserEntity;
import oracle.mau.entity.UserFriendArticleEntity;
import oracle.mau.http.bean.BeanData;
import oracle.mau.http.common.Callback;
import oracle.mau.http.common.HttpServer;
import oracle.mau.http.constants.URLConstants;
import oracle.mau.http.data.UserFriendArticleData;
import oracle.mau.http.parser.UserFriendArticleParser;
import oracle.mau.main.label.activity.ArticleDetailActivity;
import oracle.mau.main.label.adapter.RecommendDetailLVAdapter;
import oracle.mau.utils.GetTheUser;
import oracle.mau.utils.ImageUtils;

/**
 * Created by 田帅 on 2017/3/14.
 */

public class HomeNewFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener , AdapterView.OnItemClickListener{
    private HTextView htv_home_new_fragment_flag;

    private PullToRefreshListView ptr_home_new_fragment;
    private RecommendDetailLVAdapter mAdapter;
    private int updateDown = 0;

    private UserEntity mUser;
    private List<UserFriendArticleEntity> list;
    private List<ArticleEntity> articleList;
    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home_new;
    }

    @Override
    protected void initView() {
        htv_home_new_fragment_flag = (HTextView) rootView.findViewById(R.id.htv_home_new_fragment_flag);
        ptr_home_new_fragment = (PullToRefreshListView) rootView.findViewById(R.id.ptr_home_new_fragment);
        ptr_home_new_fragment.setOnRefreshListener(this);
        /**
         * 请求数据
         */
        requestData();
        htv_home_new_fragment_flag.setAnimateType(HTextViewType.LINE);
        htv_home_new_fragment_flag.animateText("我关注的好友文章");
    }

    private void requestData() {
        mUser = GetTheUser.getUser(getActivity());
        String url = URLConstants.BASE_URL + URLConstants.USER_FRIEND_ARTICLE_LIST + mUser.getUserid();
        HttpServer.sendPostRequest(HttpServer.HTTPSERVER_GET, null, new UserFriendArticleParser(), url, new Callback() {
            @Override
            public void success(BeanData beanData) {
                UserFriendArticleData data = (UserFriendArticleData) beanData;
                list = data.getUserFriendArticleEntityList();
                initArticleList();
                if (updateDown != 0){
                    //收起头部
                    ptr_home_new_fragment.onRefreshComplete();
                }
            }

            @Override
            public void failure(String error) {

            }
        });
    }

    private void initArticleList() {
        articleList = new ArrayList<>();
        for (UserFriendArticleEntity userFriendArticleEntity : list) {
            int userId = userFriendArticleEntity.getUserId();
            String userName = userFriendArticleEntity.getUserName();
            List<ArticleEntity> aList = userFriendArticleEntity.getArticleEntityList();
            for (ArticleEntity articleEntity : aList) {
                UserEntity u = new UserEntity();
                u.setUserid(userId);
                u.setUsername(userName);
                articleEntity.setArticleUser(u);
                articleList.add(articleEntity);
            }
        }
        initLV();
    }

    private void initLV() {
        mAdapter = new RecommendDetailLVAdapter(mContext,articleList);
        ptr_home_new_fragment.setAdapter(mAdapter);
        ptr_home_new_fragment.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        updateDown++;
        requestData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArticleDetailActivity.actionStart(mContext,articleList.get(position-1).getArticleId());
    }
}