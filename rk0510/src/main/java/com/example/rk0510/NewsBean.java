package com.example.rk0510;

import java.util.List;

public class NewsBean {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-03-06 14:11","title":"[Beautyleg] 美腿丝袜写真 No.1081 Celia","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_37ffa3110ab08d0b72a33dd851b36748-760x500.jpg","url":"http://m.xxxiao.com/62"},{"ctime":"2016-03-06 14:11","title":"美媛 米妮大萌萌 烟雨朦胧浴室诱人照","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_4987cbabe28da5e7dd65dcb7fb02481a-760x500.jpg","url":"http://m.xxxiao.com/1753"},{"ctime":"2016-03-06 14:11","title":"美女Taylor Swift(泰勒·斯威夫特)明星壁纸","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_01090867e9b6eea85fce4fe01d9b7b9b-760x500.jpg","url":"http://m.xxxiao.com/1818"},{"ctime":"2016-03-06 14:11","title":"肉感美女黛欣霓玉体写真","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_d6be3a27f3d42556266a2133372c98f6-709x500.jpg","url":"http://m.xxxiao.com/477"},{"ctime":"2016-03-06 14:11","title":"少女充气娃娃王依萌胴体诱惑","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_a8d2ec85eaf98407310b72eb73dda24712-760x500.jpg","url":"http://m.xxxiao.com/685"},{"ctime":"2016-03-06 14:11","title":"性感美女周维娜VerNa淡雅私拍","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/06/m.xxxiao.com_acd19c7b88f9cae25d3894bb7ba9f85c-760x500.jpg","url":"http://m.xxxiao.com/1881"},{"ctime":"2016-03-06 14:11","title":"美女金美辛NEMON妖媚生活自拍","description":"美女图片","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_985e2c5a7fe238b5ad6928b53de7b93b-760x500.jpg","url":"http://m.xxxiao.com/982"},{"ctime":"2016-03-06 14:11","title":"岩岩殷旭时尚大片?曝光 新一季优雅女神诞生","description":"24小时美女","picUrl":"http://img.027admin.com/uploads/allimg/150829/1440N3D25F-15A7.jpg","url":"http://www.024www.net/meinv/26403/"},{"ctime":"2016-03-06 14:11","title":"霞霞刘芊含拍写真 慵懒迷人上演白衬衫诱惑","description":"24小时美女","picUrl":"http://img.027admin.com/uploads/allimg/150826/14405C2H1F-115446.jpg","url":"http://www.024www.net/meinv/26382/"},{"ctime":"2016-03-06 14:11","title":"外国美女车模的异域风情","description":"24小时美女","picUrl":"http://img.027admin.com/uploads/allimg/150826/14405C02G30-aD0.jpg","url":"http://www.024www.net/meinv/26377/"}]
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
         * ctime : 2016-03-06 14:11
         * title : [Beautyleg] 美腿丝袜写真 No.1081 Celia
         * description : 美女图片
         * picUrl : http://m.xxxiao.com/wp-content/uploads/sites/3/2015/04/m.xxxiao.com_37ffa3110ab08d0b72a33dd851b36748-760x500.jpg
         * url : http://m.xxxiao.com/62
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
