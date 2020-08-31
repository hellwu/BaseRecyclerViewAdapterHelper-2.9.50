package com.chad.baserecyclerviewadapterhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.baserecyclerviewadapterhelper.base.BaseActivity;
import com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter.CapabilityNode;
import com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter.CapabilityNoteNode;
import com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter.VoiceCapabilityAdapter;
import com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter.VoiceCmdSynonymNode;
import com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter.VoiceCommandNode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;

public class WOActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private VoiceCapabilityAdapter mDapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("WO Activity");
        setContentView(R.layout.activity_w_o);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);


        final ArrayList<MultiItemEntity> datas = new ArrayList<>();


        CapabilityNode node1 = new CapabilityNode("Turn on/off device, you can say:", true);
        VoiceCommandNode node11 = new VoiceCommandNode("Turn on/off the air purifier", true);


        VoiceCmdSynonymNode node110 = new VoiceCmdSynonymNode("Open/Close the air purifie", true);

        VoiceCmdSynonymNode node112 = new VoiceCmdSynonymNode("Open/Close this", true);
        node112.setEnd(true);
        node112.setEndCapability(true);

        node11.addSubItem(node110);
        node11.addSubItem(node112);
        node11.setEnd(true);
        node11.setExpanded(false);
        node1.addSubItem(node11);
        VoiceCommandNode node12 = new VoiceCommandNode("Open/Close the air purifier", true);
        node1.addSubItem(node12);

        CapabilityNode node2 = new CapabilityNode("Change the mode, you can say:", true);
        VoiceCommandNode node21 = new VoiceCommandNode("Set air purifier mode to auto", true);
        VoiceCommandNode node22 = new VoiceCommandNode("Set air purifier mode to manual", true);
        VoiceCommandNode node23 = new VoiceCommandNode("Set air purifier mode to sleep", true);
        node23.setEnd(true);
        node2.addSubItem(node21);
        node2.addSubItem(node22);
        node2.addSubItem(node23);


        CapabilityNoteNode node_note1 = new CapabilityNoteNode("Note: Turn on/off device");
        CapabilityNoteNode node_note2 = new CapabilityNoteNode("Note: the range supported 30%-80%");


        node1.setExpanded(true);
//        node1.addSubItem(node_note1);
//        node2.addSubItem(node_note2);

        datas.add(node1);
//        datas.add(node11);
//        datas.add(node12);
//        datas.add(node_note1);

        datas.add(node2);
        datas.add(node21);
        datas.add(node22);
        datas.add(node23);
//        datas.add(node_note2);


        mDapter = new VoiceCapabilityAdapter(datas);
        mDapter.expandAll();
//        View headerView = initHeaderView("Air Purifier", false);
//        mDapter.addHeaderView(headerView);

        mDapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
                if (datas.get(position) instanceof VoiceCommandNode) {
                    VoiceCommandNode node = (VoiceCommandNode) datas.get(position);
                    if(node.isExpanded()) {
                        int count = mDapter.collapse(position);
                        Log.i("tag", "collapse count = "+count);
                    }
                    else {
                        int count = mDapter.expand(position);
                        Log.i("tag", "expand count = "+count);
                    }
                }
            }
        });


        mRecyclerView.setAdapter(mDapter);
    }


    private View initHeaderView(String modelName, boolean isConnect) {
        View headerView = LayoutInflater.from(this).inflate(R.layout.item_voicedetail_header, null);
        final View rl_no_connect = headerView.findViewById(R.id.rl_no_connect);
        TextView tv_tips = (TextView)headerView.findViewById(R.id.tv_tips);
        Button bt_cancel = (Button)headerView.findViewById(R.id.bt_cancel_noconnect);

        String tips = String.format(getString(R.string.fm_platfrom_tips), modelName);
        tv_tips.setText(tips);
        if(!isConnect) {
            rl_no_connect.setVisibility(View.VISIBLE);
        }
        else {
            rl_no_connect.setVisibility(View.GONE);
        }

        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rl_no_connect.setVisibility(View.GONE);
            }
        });
        return headerView;
    }
}