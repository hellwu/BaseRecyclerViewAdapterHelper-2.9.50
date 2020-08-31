package com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import com.chad.baserecyclerviewadapterhelper.R;

public class VoiceCapabilityAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_HEADER = 10;
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_LEVEL_2 = 2;
    public static final int TYPE_LEVEL_3 = 3;

    public static final int PLATFORM_GOOGLE_HOME = 1;
    public static final int PLATFORM_ALEXA = 2;

    public VoiceCapabilityAdapter(List<MultiItemEntity> data) {
        super(data);

        addItemType(TYPE_LEVEL_0, R.layout.item_voice_capability);
        addItemType(TYPE_LEVEL_1, R.layout.item_voice_cmd);
        addItemType(TYPE_LEVEL_2, R.layout.item_voice_cmd_childen);
        addItemType(TYPE_LEVEL_3, R.layout.item_voice_capability_note);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, MultiItemEntity item) {
        int type = baseViewHolder.getItemViewType();
        switch (type) {
            case TYPE_LEVEL_0:
                baseViewHolder.setText(R.id.tv_des, ((CapabilityNode) item).getDescription());
                break;
            case TYPE_LEVEL_1:
                VoiceCommandNode vcNode = ((VoiceCommandNode) item);

                //1.设置布局样式
                if(vcNode.getSubItems() != null && vcNode.getSubItems().size() != 0) {
                    baseViewHolder.setGone(R.id.bt_expand, true);

                    if(vcNode.isExpanded()) {
                            baseViewHolder.setGone(R.id.cl_item_cmd_end, false);
                            baseViewHolder.setGone(R.id.cl_item_cmd, false);
                            baseViewHolder.setGone(R.id.cl_item_cmd_head, true);

                            baseViewHolder.setText(R.id.tv_cmd_voice_head, vcNode.getTitle());
                            baseViewHolder.setBackgroundRes(R.id.cl_item_cmd_head, R.drawable.shape_voice_cmd_item_up);
                    }
                    else {
                        baseViewHolder.setGone(R.id.cl_item_cmd_end, true);
                        baseViewHolder.setGone(R.id.cl_item_cmd, false);
                        baseViewHolder.setGone(R.id.cl_item_cmd_head, false);

                        baseViewHolder.setText(R.id.tv_cmd_voice_end, vcNode.getTitle());
                        baseViewHolder.setBackgroundRes(R.id.cl_item_cmd_end, R.drawable.shape_voice_cmd_item);
                        if(vcNode.isHaveNote())
                            baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.color.white);
                        else
                            baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.drawable.shape_voicecontrol_item_bg_down);
                    }



                    baseViewHolder.addOnClickListener(R.id.cl_item_cmd_head);
                    baseViewHolder.addOnClickListener(R.id.cl_item_cmd);
                    baseViewHolder.addOnClickListener(R.id.cl_item_cmd_end);
                }
                else {
                    if(vcNode.isEnd() && (!vcNode.isHaveNote())) {
                        baseViewHolder.setGone(R.id.cl_item_cmd_end, true);
                        baseViewHolder.setGone(R.id.cl_item_cmd, false);
                        baseViewHolder.setGone(R.id.cl_item_cmd_head, false);
                        baseViewHolder.setGone(R.id.bt_expand_end, false);

                        baseViewHolder.setText(R.id.tv_cmd_voice_end, vcNode.getTitle());
                        baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.drawable.shape_voicecontrol_item_bg);
                        baseViewHolder.setBackgroundRes(R.id.cl_item_cmd_end, R.drawable.shape_voice_cmd_item);
                    }
                    else {
                        baseViewHolder.setGone(R.id.cl_item_cmd_end, false);
                        baseViewHolder.setGone(R.id.cl_item_cmd, true);
                        baseViewHolder.setGone(R.id.cl_item_cmd_head, false);
                        baseViewHolder.setGone(R.id.bt_expand, false);

                        baseViewHolder.setText(R.id.tv_cmd_voice, vcNode.getTitle());
                        baseViewHolder.setBackgroundRes(R.id.cl_item_cmd, R.drawable.shape_voice_cmd_item);
                        baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.color.white);
                    }

                }

                //设置展开标识
                if(vcNode.isExpanded()) {
                    baseViewHolder.setBackgroundRes(R.id.bt_expand, R.mipmap.icon_minus);
                    baseViewHolder.setBackgroundRes(R.id.bt_expand_end, R.mipmap.icon_minus);
                    baseViewHolder.setBackgroundRes(R.id.bt_expand_head, R.mipmap.icon_minus);
                }
                else {
                    baseViewHolder.setBackgroundRes(R.id.bt_expand, R.mipmap.icon_expand);
                    baseViewHolder.setBackgroundRes(R.id.bt_expand_end, R.mipmap.icon_expand);
                    baseViewHolder.setBackgroundRes(R.id.bt_expand_head, R.mipmap.icon_expand);
                }

                break;
            case TYPE_LEVEL_2:
                VoiceCmdSynonymNode vsNode = ((VoiceCmdSynonymNode) item);


                if(vsNode.isEnd()) {
                    baseViewHolder.setGone(R.id.cl_item_cmd_end, true);
                    baseViewHolder.setGone(R.id.cl_item_cmd, false);
                    baseViewHolder.setGone(R.id.bt_expand_end, false);

                    baseViewHolder.setText(R.id.tv_cmd_voice_end, vsNode.getTitle());
                    baseViewHolder.setBackgroundRes(R.id.cl_item_cmd_end, R.drawable.shape_voice_cmd_item_down);
                    baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.drawable.shape_voicecontrol_item_bg_down);

                    if(vsNode.isHaveNoet())
                        baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.color.white);
                    else
                        baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.drawable.shape_voicecontrol_item_bg_down);
                }
                else {
                    baseViewHolder.setGone(R.id.cl_item_cmd_end, false);
                    baseViewHolder.setGone(R.id.cl_item_cmd, true);
                    baseViewHolder.setGone(R.id.bt_expand, false);

                    baseViewHolder.setText(R.id.tv_cmd_voice, vsNode.getTitle());
                    baseViewHolder.setBackgroundRes(R.id.cl_item_cmd, R.color.color_f1);
                    baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd, R.color.white);
                }
                break;

            case TYPE_LEVEL_3:
                CapabilityNoteNode cnNode = (CapabilityNoteNode)item;
                baseViewHolder.setText(R.id.tv_cmd_voice_note, cnNode.getTitle());
                baseViewHolder.setBackgroundRes(R.id.ll_voice_cmd_note, R.drawable.shape_voicecontrol_item_bg_down);
                break;

            default:

                break;
        }
    }
}
