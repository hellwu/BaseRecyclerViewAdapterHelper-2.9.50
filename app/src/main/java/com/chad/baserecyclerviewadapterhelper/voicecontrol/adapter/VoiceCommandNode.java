package com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

public class VoiceCommandNode extends AbstractExpandableItem<VoiceCmdSynonymNode> implements MultiItemEntity {
    private String title;
    private boolean isEnd;
    private boolean isHaveNote;

    public VoiceCommandNode(String title, boolean isHaveNote) {
        this.title = title;
        this.isHaveNote = isHaveNote;
        this.isEnd = false;
    }

    @Override
    public int getLevel() {
        return 2;
    }

    @Override
    public int getItemType() {
        return VoiceCapabilityAdapter.TYPE_LEVEL_1;
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

    public boolean isHaveNote() {
        return isHaveNote;
    }

    public void setHaveNote(boolean haveNote) {
        isHaveNote = haveNote;
    }
}
