package com.cetc.weiwen.mapper;

import com.cetc.weiwen.entity.ControlPerson;
import com.cetc.weiwen.vo.ControlPersonVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 重点人管控持久层接口
 * @author jhl
 * @date 2018年8月31日 下午4:03:49
 * @version 1.0 
 *
 */
@Mapper
public interface ControlPersonMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入重点人
     * @param record
     * @return
     */
    int insertControlPerson(ControlPerson record);

    int insertSelective(ControlPerson record);

    /**
     * 根据id获取重点人信息
     * @param id
     * @return
     */
    ControlPerson queryControlPersonById(Integer id);
    
    /**
     * 获取重点人信息
     * @param controlPerson
     * @return
     */
    ControlPersonVo queryControlPersonVoById(Integer id);

    /**
     * 更新重点人信息
     * @param controlPerson
     * @return
     */
    int updateControlPerson(ControlPerson controlPerson);

    int updateByPrimaryKey(ControlPerson record);
    
    /**
     * 获取管控人的信息列表
     * @param controlPerson
     * @return
     */
    List<ControlPerson> getControlPersonList(ControlPerson controlPerson);
    
    /**
     * 根据重点人信息获取重点人信息列表
     * @param controlPerson
     * @return
     */
    List<ControlPersonVo> queryControlPersonList(ControlPersonVo controlPersonVo);
}