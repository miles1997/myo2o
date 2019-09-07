package cn.azzhu.myo2o.vo;

import cn.azzhu.myo2o.entity.Menu;
import lombok.Data;

@Data
public class MenuVo  extends Menu {
	/**
	 * 分页参数
	 */
	private Integer page;
	private Integer limit;

}
