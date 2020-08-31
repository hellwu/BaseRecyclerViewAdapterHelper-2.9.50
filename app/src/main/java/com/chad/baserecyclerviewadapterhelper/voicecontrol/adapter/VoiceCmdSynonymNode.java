package com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class VoiceCmdSynonymNode implements MultiItemEntity {
    private String title;
    private boolean isEnd;  //VoiceCommandNode结束
    private boolean isEndCapability; //CapabilityNode结束
    private boolean isHaveNoet;

    public VoiceCmdSynonymNode(String title, boolean isHaveNoet) {
        this.title = title;
        this.isHaveNoet = isHaveNoet;
        this.isEnd = false;
    }

    @Override
    public int getItemType() {
        return VoiceCapabilityAdapter.TYPE_LEVEL_2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public boolean isEndCapability() {
        return isEndCapability;
    }

    public void setEndCapability(boolean endCapability) {
        isEndCapability = endCapability;
    }

    public boolean isHaveNoet() {
        return isHaveNoet;
    }

    public void setHaveNoet(boolean haveNoet) {
        isHaveNoet = haveNoet;
    }
}
