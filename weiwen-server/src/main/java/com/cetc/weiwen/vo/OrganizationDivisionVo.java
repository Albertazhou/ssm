package com.cetc.weiwen.vo;

import java.util.List;

import com.cetc.weiwen.entity.Division;
import com.cetc.weiwen.entity.FunctionType;


/**
 * @author zhou
 *
 */
public class OrganizationDivisionVo {
	
	 private Integer id;
	 
	 private String uuid;

	  public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	private String name;//名字
	  
	  private String path;//路径
	  
	  private String parentId;//父id
	  
	  private String hasChild; //1:下面有子组织 0：下面无子组织
	  
	  private FunctionType functiontype; //职能部门表
	  
	  private Division division;//行政区划
	  
	  private Integer valid;//0为无效，1为有效
	  
	  private Integer type;
	  
	  private List<UserVo> children;
	  
	


	public List<UserVo> getChildren() {
		return children;
	}

	public void setChildren(List<UserVo> children) {
		this.children = children;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public FunctionType getFunctiontype() {
		return functiontype;
	}
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setFunctiontype(FunctionType functiontype) {
		this.functiontype = functiontype;
	}

	
	  

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	@Override
	public String toString() {
		return "OrganizationDivisionVo [id=" + id + ", name=" + name + ", divisionLevelVo=" + 
				 ", functiontype=" + functiontype + ", valid=" + valid + "]";
	}

	


	
	  
	  

}
