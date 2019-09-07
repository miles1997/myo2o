package cn.azzhu.myo2o.entity;

import lombok.Data;

@Data
public class Menu {
	private Integer id;

	private Integer pid;

	private String title;

	private String href;

	private Integer spread;

	private String target;

	private String icon;

	private Integer available;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(Integer id, Integer pid, String title, String href, Integer spread, String target, String icon,
			Integer available) {
		super();
		this.id = id;
		this.pid = pid;
		this.title = title;
		this.href = href;
		this.spread = spread;
		this.target = target;
		this.icon = icon;
		this.available = available;
	}
}