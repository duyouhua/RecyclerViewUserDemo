package cn.zeffect.demo.recyclerviewuserdemo;

import java.util.Date;

/**
 * Created by zeffect on 2016/7/27.
 */
public class MainModelImp implements MainContract.MainModel {
    @Override
    public String returnOneMessage() {
        return new Date().toString();
    }
}
