package cn.azzhu.myo2o.utils;

import lombok.Data;

/**
 * @author azzhu
 * @create 2019-09-01 19:47:10
 */
@Data
public class ResultObj {
    private Integer code;
    private String msg;

    /**
     * 删除成功
     */
    public static final ResultObj DELETE_SUCCESS=new ResultObj(SysContants.CODE_FAILER, SysContants.DELETE_SUCCESS);
    /**
     * 删除失败
     */
    public static final ResultObj DELETE_ERROR=new ResultObj(SysContants.CODE_FAILER, SysContants.DELETE_ERROR);

    //添加成功
    public static final ResultObj ADD_SUCCESS = new ResultObj(SysContants.CODE_SUCCESS, SysContants.ADD_SUCCESS);

    //添加失败
    public static final ResultObj ADD_ERROR = new ResultObj(SysContants.CODE_FAILER, SysContants.ADD_ERROR);
    /*下架*/
    public static final ResultObj DOWN_ERROR=new ResultObj(SysContants.CODE_FAILER, SysContants.DOWN_ERROR);
    public static final ResultObj DOWN_SUCCESS=new ResultObj(SysContants.CODE_SUCCESS, SysContants.DOWN_SUCCESS);

    /*上架*/
    public static final ResultObj UP_ERROR=new ResultObj(SysContants.CODE_FAILER, SysContants.UP_ERROR);
    public static final ResultObj UP_SUCCESS=new ResultObj(SysContants.CODE_SUCCESS, SysContants.UP_SUCCESS);

    /*修改*/
    public static final ResultObj UPDATE_ERROR=new ResultObj(SysContants.CODE_FAILER, SysContants.UPDATE_ERROR);
    public static final ResultObj UPDATE_SUCCESS=new ResultObj(SysContants.CODE_SUCCESS, SysContants.UPDATE_SUCCESS);

    private ResultObj(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
    private ResultObj(Integer code) {
        super();
        this.code = code;
    }
}
