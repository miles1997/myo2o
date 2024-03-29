package cn.azzhu.myo2o.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ShopCategory {

  private Long shopCategoryId;
  private String shopCategoryName;
  private String shopCategoryDesc;
  private String shopCategoryImg;
  private Integer priority;
  private Date createTime;
  private Date lastEditTime;
  private Long parentId;
}
 
 
