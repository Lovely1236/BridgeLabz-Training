package com.fundooapp.dto;

import com.fundooapp.entity.NoteLabel;

public record LabelResponse(Integer id, String label) {
    public static LabelResponse from(NoteLabel label) { return new LabelResponse(label.getId(), label.getLabel()); }
}
