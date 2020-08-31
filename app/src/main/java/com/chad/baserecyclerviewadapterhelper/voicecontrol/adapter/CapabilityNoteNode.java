package com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class CapabilityNoteNode implements MultiItemEntity {
    private String title;

    public CapabilityNoteNode(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getItemType() {
        return VoiceCapabilityAdapter.TYPE_LEVEL_3;
    }
}
