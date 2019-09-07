package cn.azzhu.myo2o.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class PersonInfo {

  @TableId(value = "user_id",type = IdType.AUTO)
  private Long userId;
  private String name;
  private Date birthday;
  private String gender;
  private String phone;
  private String email;
  private String profileImg;
  private Integer customerFlag;
  private Integer shopOwnerFlag;
  private Integer adminFlag;
  private Date createTime;
  private Date lastEditTime;
  private Integer enableStatus;
}
 
 
