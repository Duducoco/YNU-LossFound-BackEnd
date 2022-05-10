package com.ynu.lossfound.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Found {
    private Integer foundID;
    private String foundName;
    private String foundLocation;
    private String foundTime;
    private String releaseTime;
    private String imageUrl;
    private String studentIDFeature;
    private String phoneFeature;
    private String emailFeature;
    private String otherFeature;
    private String author;
    private String foundNowLocation;
    private String authorTeleMethod;
    private boolean isReturn;
}
