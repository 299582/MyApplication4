package com.example.caixiao0504yk.Bean;

import java.util.List;

/**
 * Created by mac on 2018/5/4.
 */

public class NewsBean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2018-05-04 00:00","title":"重庆居民饮自配药酒发生中毒：15人送医 5人死亡","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/cms-bucket.nosdn.127.net/cbcdc76f2465478bb017d2816f4742db20180504022437.png?imageView&thumbnail=550x0","url":"http://news.ifeng.com/a/20180504/58088060_0.shtml"},{"ctime":"2018-05-04 00:00","title":"花费超千万无人机表演成\u201c乱码\u201d 专家：或因信号干扰","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/cms-bucket.nosdn.127.net/d1c14f268bef4da185aa22c52a20faf020180504023703.jpeg?imageView&thumbnail=550x0","url":"http://news.ifeng.com/a/20180504/58088288_0.shtml"},{"ctime":"2018-05-04 00:00","title":"\u201c儿医荒\u201d怎么破？广州出招了：儿童看病加价30%","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p2.ifengimg.com/a/2018_18/e435a72e26faa7f_size58_w550_h365.jpg","url":"http://news.ifeng.com/a/20180504/58089185_0.shtml"},{"ctime":"2018-05-04 00:00","title":"蹭网软件安全陷阱：WiFi主人、蹭网者均有风险","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0504/125A7BBB9C162786BD8455C4D8E11E75902EDFEE_size32_w750_h375.jpeg","url":"http://news.ifeng.com/a/20180504/58089328_0.shtml"},{"ctime":"2018-05-04 00:00","title":"遭短视频网站封杀，小猪佩奇\u201c犯了什么事儿\u201d？","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0504/DBE51B33DB65677B3F523F7A03DED6F5A5FD5A6D_size19_w543_h323.jpeg","url":"http://news.ifeng.com/a/20180504/58089335_0.shtml"},{"ctime":"2018-05-04 00:00","title":"进口抗癌药零关税，患者能省多少钱？","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0504/B3CA83B6A52D2447D043CDD4C72E3B0AEA3C0774_size57_w701_h344.jpeg","url":"http://news.ifeng.com/a/20180504/58089692_0.shtml"},{"ctime":"2018-05-04 00:00","title":"又一大学生太白山失联 未携带任何食品补给和帐篷","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0504/C48F6750E8F8C42594F6B7124465616F84DB7914_size426_w960_h4930.jpeg","url":"http://news.ifeng.com/a/20180504/58090586_0.shtml"},{"ctime":"2018-05-04 00:00","title":"2女生接连被流浪狗咬伤 湘潭大学：当初捕杀遭到反对","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p3.ifengimg.com/a/2018_18/1c64fd9ea8295bf_size78_w580_h330.jpg","url":"http://news.ifeng.com/a/20180504/58090597_0.shtml"},{"ctime":"2018-05-04 00:00","title":"两记者采访教师校外有偿补课 遭不明人员威胁拉扯","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/p0.ifengimg.com/pmop/2018/0504/5AEA17E12611D7D2DAC60EAAAE9FE9A608A69968_size149_w1080_h1630.jpeg","url":"http://news.ifeng.com/a/20180504/58090935_0.shtml"},{"ctime":"2018-05-04 00:00","title":"重庆璧山居民饮自配药酒中毒：15人送医 其中5人死亡","description":"凤凰社会","picUrl":"http://d.ifengimg.com/w150_h95/cms-bucket.nosdn.127.net/d1c14f268bef4da185aa22c52a20faf020180504023703.jpeg?imageView&thumbnail=550x0","url":"http://news.ifeng.com/a/20180504/58086828_0.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2018-05-04 00:00
         * title : 重庆居民饮自配药酒发生中毒：15人送医 5人死亡
         * description : 凤凰社会
         * picUrl : http://d.ifengimg.com/w150_h95/cms-bucket.nosdn.127.net/cbcdc76f2465478bb017d2816f4742db20180504022437.png?imageView&thumbnail=550x0
         * url : http://news.ifeng.com/a/20180504/58088060_0.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
