package oracle.mau.http.constants;

/**
 * 后台服务器接口
 * Created by 田帅 on 2017/1/3.
 */

public class URLConstants {


    /**
     * 基础url
     */
//    public static String BASE_URL = "http://192.168.1.105:8080/SchoolCircle/";
    public static String BASE_URL = "http://115.159.0.152/";
    /**
     * 用户注册
     */
    public static final String USERRESGISTER="user/register";
    /**
     * 用户登录
     */
    public static final String USERLOGIN ="user/login";
    /**
     * 发送消息
     */
    public static final String MSG_URL ="" ;
    /**
     * label热门用户
     */
    public static final String HOT_USER="user/hot";
    /**
     * label画廊标签
     */
    public static final String TAG_GALLERY="article/tag";
    /**
     * 发布文章内容
     */
    public static final String SEND_ARTICLE_CONTENT  = "article/";
    /**
     * 发布文章图片
     */
    public static final String SEND_ARTICLE_PIC  = "upload/";
    /**
     * label推荐文章
     */
    public static final String ARTICLE_RECOMMEND = "article/list/";
    /**
     * label search模块
     */
    public static final String SEARCH_CONTENT = "search/index/";
    /**
     * 文章详情
     */
    public static final String ARTICLE_DETAIL = "article/get/";
    /**
     * 发表评论
     */
    public static final String SEND_ARTICLE_COMMENT = "comment";
    /**
     * 获取专题列表
     */
    public static final String gET_SPECIAL_LIST = "special";
    /**
     * 获取专题详情
     */
    public static final String gET_SPECIAL_DETAIL = "special/index/";
    /**
     * 用户详情
     */
    public static final String USER_DETAIL = "user/index/";
    /**
     * 推荐详情
     */
    public static final String RECOMMEND_DETAIL = "article/getArticlesByTag/";
    /**
     * 用户好友文章列表
     */
    public static final String USER_FRIEND_ARTICLE_LIST = "user/rss/";
    /**
     * 用户关注好友id列表
     */
    public static final String USER_FOLLOWS = "user/followers/";
    /**
     * 关注
     */
    public static final String FOLLOW_USER = "user/follow";
    /**
     * 取消关注
     */
    public static final String CANCLE_FOLLOW_USER = "/user/unfollow";
    /**
     * 获取该用户关注的用户
     */
    public static final String ATTENTION_PEOPLE= "user/followers/";
}
