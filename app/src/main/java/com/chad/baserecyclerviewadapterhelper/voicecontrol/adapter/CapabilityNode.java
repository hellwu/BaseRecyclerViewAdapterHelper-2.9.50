package com.chad.baserecyclerviewadapterhelper.voicecontrol.adapter;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

public class CapabilityNode extends AbstractExpandableItem<VoiceCommandNode> implements MultiItemEntity {
    private String description;
    private boolean isHaveNote;

    public CapabilityNode(String description, boolean isHaveNote) {
        this.description = description;
        this.isHaveNote = isHaveNote;
        this.mExpandable = true;
    }

    @Override
    public int getItemType() {
        return VoiceCapabilityAdapter.TYPE_LEVEL_0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHaveNote() {
        return isHaveNote;
    }

    public void setHaveNote(boolean haveNote) {
        isHaveNote = haveNote;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
