package com.ynu.lossfound.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loss {
    private Integer lossID;
    private String lossName;
    private String lossLocation;
    private String lossTime;
    private String releaseTime;
    private String imageUrl;
    private String studentIDFeature;
    private String phoneFeature;
    private String emailFeature;
    private String otherFeature;
    private String author;
    private String authorTeleMethod;
    private boolean isFound;
}
