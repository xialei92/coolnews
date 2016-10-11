package com.xianrou.zhihudaily.bean;

import java.util.List;

/**
 * Created by codeest on 16/8/24.
 */

public class ThemeChildListBean {


    /**
     * stories : [{"images":["http://pic2.zhimg.com/afecdc04983a8e261326386995150599_t.jpg"],"type":0,"id":7066097,"title":"家庭的生命周期：关于「离家」"},{"type":0,"id":7483384,"title":"更多日常心理学，都在读读日报里"},{"type":0,"id":7097426,"title":"人们在虚拟生活中投入的精力是否对现实生活的人际关系有积极意义？"},{"type":0,"id":7086807,"title":"职人介绍所 · 自闭儿童的解锁人"},{"images":["http://pic4.zhimg.com/1c4d1cd8edb7ed1e2045109c79870127_t.jpg"],"type":0,"id":7032789,"title":"艰难的孩子和孩子的艰难"},{"type":0,"id":7015707,"title":"家长该如何处理儿童的自慰行为？"},{"type":0,"id":7014561,"title":"从心理层面看，「婚外情」究竟是什么？"},{"type":0,"id":7014068,"title":"人类为什么需要仪式？"},{"type":0,"id":4856502,"title":"心理学从业者怎么看待近年来在国内心理咨询和治疗中十分流行的沙盘（箱庭）疗法？"},{"type":0,"id":4854969,"title":"为什么她总爱上同一类型的「渣」男？"},{"type":0,"id":4851024,"title":"国外幼教现状如何？"},{"images":["http://pic1.zhimg.com/c7cd4c64f429b79e6d269723bd7b10f0_t.jpg"],"type":0,"id":4827436,"title":"从日俄战争到神经科学的二次革命（多图）"},{"images":["http://pic1.zhimg.com/673f13f858f5fe6970104ba3319c33b8_t.jpg"],"type":0,"id":4820022,"title":"就这样面对爱人的糟糕情绪"},{"type":0,"id":4814564,"title":"意识、感知和注意力之间有怎样的关系？"},{"type":0,"id":4806764,"title":"小时候缺爱，成年后如何解决？"},{"type":0,"id":4802579,"title":"为什么得到了想要的，却不像想象中那样开心？"},{"type":0,"id":4738657,"title":"为什么很多老人都不喜欢使用家用电器？"},{"type":0,"id":4739134,"title":"心理咨询的时间为什么要控制在一小时左右？"},{"type":0,"id":4737612,"title":"我们应该如何正确对待特殊儿童？"}]
     * description : 了解自己和别人，了解彼此的欲望和局限。
     * background : http://pic2.zhimg.com/71c8bcd3d99958de45ed87b8fc213224.jpg
     * color : 15007
     * name : 日常心理学
     * image : http://pic4.zhimg.com/60b69ef145a472f2c6b5302453f95eaa.jpg
     * editors : [{"url":"http://www.zhihu.com/people/moheng-esther","bio":"树上的女爵","id":79,"avatar":"http://pic1.zhimg.com/0a6456810_m.jpg","name":"刘柯"}]
     * image_source :
     */

    public String description;
    public String background;
    public int color;
    public String name;
    public String image;
    public String image_source;
    /**
     * images : ["http://pic2.zhimg.com/afecdc04983a8e261326386995150599_t.jpg"]
     * type : 0
     * id : 7066097
     * title : 家庭的生命周期：关于「离家」
     */

    public List<StoriesBean> stories;
    /**
     * url : http://www.zhihu.com/people/moheng-esther
     * bio : 树上的女爵
     * id : 79
     * avatar : http://pic1.zhimg.com/0a6456810_m.jpg
     * name : 刘柯
     */

    public List<EditorsBean> editors;

}
