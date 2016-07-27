package cn.zeffect.demo.recyclerviewuserdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import cn.zeffect.demo.recyclerviewuserdemo.R;

/**
 * Created by zeffect on 2016/7/27.
 */
public class RVAdapter extends BaseQuickAdapter<String> {
    private SwipeLayout mLastSwipLayou;

    public RVAdapter(List<String> data) {
        super(R.layout.item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.item_tv, s);
        SwipeLayout swipeLayout = baseViewHolder.getView(R.id.swiproot);
//set show mode.
        swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
//add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
        //swipeLayout.addDrag(SwipeLayout.DragEdge.Left, baseViewHolder.getView(R.id.bottom));
        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView.
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                //you are swiping.
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {
                if (mLastSwipLayou != null) {
                    mLastSwipLayou.close();
                }
            }

            @Override
            public void onOpen(SwipeLayout layout) {
                //when the BottomView totally show.
                mLastSwipLayou = layout;
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hand released.
            }
        });
    }
}
