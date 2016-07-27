package cn.zeffect.demo.recyclerviewuserdemo;

/**
 * Created by zeffect on 2016/7/27.
 */
public interface MainContract {
    interface MainView {
        /**
         * 添加一条消息
         **/
        void addOneMessage(String pMessage);
    }

    interface MainPrestener {
        void getOneMessage();
    }

    interface MainModel {
        String returnOneMessage();
    }
}
