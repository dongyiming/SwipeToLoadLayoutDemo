package com.example.sr_layout_ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.example.sr_layout_ui.R;
import com.example.sr_layout_ui.adapter.SwipeRefreshAdapter;
import com.example.http_manage_biz.vo.DecorationInfo;
import com.example.sr_layout_ui.controller.SwipeRefreshController;
import com.example.http_manage_biz.interaction.ICommonInvokeResult;
import com.example.http_manage_biz.manager.RecyclerViewBuilder;
import com.example.sr_layout_ui.view.LoadMoreFooter;
import com.example.sr_layout_ui.view.RefreshHeader;
import com.example.http_manage_biz.vo.MenuInfo;

import java.util.List;

/**
 * @version : 1.0
 * @Description :使用SwipeToLoadLayout框架，可以自己定制header和footer
 * @autho : dongyiming
 * @data : 2017/7/25 15:59
 */
public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    private RefreshHeader header;
    private LoadMoreFooter footer;
    private RecyclerView recyclerView;
    private SwipeToLoadLayout swipeView;
    private SwipeRefreshAdapter swipeRefreshAdapter;
    private SwipeRefreshController swipeRefreshController;

    private boolean isRefresh;

    private int startIndex = 0;
    private final int pageCount = 20;
    private final int type = 0;
    private int page = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiperefresh);
        initView();
        initCompant();
    }

    private void initView() {
        swipeView = (SwipeToLoadLayout) findViewById(R.id.swipeToLoad);
        recyclerView = (RecyclerView) findViewById(R.id.swipe_target);
        header = (RefreshHeader) findViewById(R.id.swipe_refresh_header);
        footer = (LoadMoreFooter) findViewById(R.id.swipe_load_more_footer);
        //设置底部布局
        swipeView.setRefreshHeaderView(header);
        swipeView.setLoadMoreFooterView(footer);

        int color = this.getResources().getColor(R.color.color_padding_chatlist);
        int diverHeight = (int) this.getResources().getDimension(R.dimen.common_lh_18);
        int diverPadding = (int) this.getResources().getDimension(R.dimen.common_lh_3);

        recyclerView = new RecyclerViewBuilder(this, recyclerView)
                .setDefultGridLayoutManager(2)
                .setItemDecoration(new DecorationInfo().setColorResource(color).setLeftDividerWidth(diverPadding).setBottomDividerHeight(diverHeight), true)
                .create();
    }

    private void initCompant() {

        swipeRefreshController = new SwipeRefreshController(SwipeRefreshLayoutActivity.this);
        swipeRefreshController.selectByType(type, startIndex, pageCount, commonInvokeResult);

        swipeView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(SwipeRefreshLayoutActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                swipeView.setRefreshing(false);//收头
            }
        });

        swipeView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                isRefresh = true;
                swipeRefreshController.selectByType(type, startIndex, pageCount, commonInvokeResult);
            }
        });

    }

    private ICommonInvokeResult<List<MenuInfo>, String> commonInvokeResult = new ICommonInvokeResult<List<MenuInfo>, String>() {
        @Override
        public void OnResult(List<MenuInfo> menuInfos) {

            if (menuInfos != null && menuInfos.size() != 0) {

                if (page == 0) {
                    swipeRefreshAdapter = new SwipeRefreshAdapter(SwipeRefreshLayoutActivity.this, menuInfos);
                    recyclerView.setAdapter(swipeRefreshAdapter);
                } else {
                    swipeRefreshAdapter.addData(menuInfos);
                }
                startIndex += pageCount;
                page++;
            } else {
                Toast.makeText(SwipeRefreshLayoutActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
            }
            if (isRefresh) {
                swipeView.setLoadingMore(false);
            }
        }

        @Override
        public void onFailure(String errorMsg) {
            if (page == 0) {
                recyclerView.setAdapter(null);
            }
            swipeView.setLoadingMore(false);
        }

        @Override
        public void onCompleted() {

        }
    };
}
