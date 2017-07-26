package com.example.sr_layout_ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.http_manage_biz.holder.BaseViewHolder;
import com.example.sr_layout_ui.R;
import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

/**
 * @version : 1.0
 * @Description :
 * @autho : dongyiming
 * @data : 2017/7/25 16:52
 */
public class SwipeRefreshAdapter extends MultiCommonAdapter<MenuInfo> {

    public static final int TYPE_HEADER = 999;
    public static final int TYPE_NORMAL = 998;
    private List<MenuInfo> datas;

    public SwipeRefreshAdapter(final Context mContext, List<MenuInfo> datas) {
        super(mContext, datas);
        this.datas = datas;
    }

    @Override
    public int getViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_NORMAL;
    }

    public void addData(List<MenuInfo> menuInfos) {

        datas.addAll(menuInfos);
        notifyDataSetChanged();
    }

    @Override
    public int getLayoutId(int viewType) {
        if (viewType == TYPE_HEADER) {
            return R.layout.fragment_list_header;
        } else if (viewType == TYPE_NORMAL) {
            return R.layout.adapter_chatlist_item;
        }
        return 0;
    }

    @Override
    public void convert(BaseViewHolder holder, MenuInfo menuInfo, int position, int itemViewType) {

        if (itemViewType == TYPE_NORMAL) {

            if (menuInfo != null) {
                holder.setText(R.id.btn_user, menuInfo.getAuthorName());
                holder.setText(R.id.txt_playcount, menuInfo.getPlaycount() + "");
                holder.setText(R.id.txt_item_desc, menuInfo.getMenuDesc());
                if (menuInfo.getMenuPicurl() != null) {

                    ImageView menuImage = (ImageView) holder.getWidget(R.id.img_chatlist_item);
                    Glide.with(mContext)
                            .load(menuInfo.getMenuPicurl())
                            .asBitmap()
                            .placeholder(R.drawable.img_chatlist_item_default)
                            .into(menuImage);
                }
            }

        }
    }

    @Override
    public int setSpanSize(int position, int itemViewType) {
        return getItemViewType(position) == TYPE_HEADER ? 2 : 1;
    }
}
