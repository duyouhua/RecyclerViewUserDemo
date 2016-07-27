package cn.zeffect.demo.recyclerviewuserdemo;

/**
 * Created by zeffect on 2016/7/27.
 */
public class MainPrestenerImp implements MainContract.MainPrestener {
   private MainContract.MainView mView;
    private MainModelImp mModel;

    public MainPrestenerImp(MainContract.MainView pView) {
        this.mView = pView;
        mModel = new MainModelImp();
    }

    @Override
    public void getOneMessage() {
        String data = mModel.returnOneMessage();
        mView.addOneMessage(data);
    }
}
