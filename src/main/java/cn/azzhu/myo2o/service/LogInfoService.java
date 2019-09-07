package cn.azzhu.myo2o.service;

import cn.azzhu.myo2o.entity.LogInfo;
import cn.azzhu.myo2o.utils.DataGridView;
import cn.azzhu.myo2o.vo.LogInfoVo;

/**
 * @author azzhu
 * @create 2019-09-03 22:20:56
 */
public interface LogInfoService {
    /**
     * 查询所有日志
     * @param logInfoVo
     * @return
     */
    public DataGridView queryAllLogInfo(LogInfoVo logInfoVo);
    /**
     * 添加日志
     * @param logInfo
     */
    public void addLogInfo(LogInfo logInfo);
    /**
     * 根据id删除日志
     * @param logInfoid
     */
    public void deleteLogInfo(Integer logInfoid);
    /**
     * 批量删除日志
     * @param ids
     */
    public void deleteBatchLogInfo(Integer [] ids);

}
