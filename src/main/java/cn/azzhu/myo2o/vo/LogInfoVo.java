package cn.azzhu.myo2o.vo;

import cn.azzhu.myo2o.entity.LogInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author azzhu
 * @create 2019-09-03 22:17:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LogInfoVo extends LogInfo {
    /**
     * 分页参数
     */
    private Integer page;
    private Integer limit;

    /**
     * 时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    //接收多个id
    private Integer [] ids;
}
