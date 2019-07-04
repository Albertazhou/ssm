package com.cetc.weiwen.entity;

/**app同步删除表
 * 
 * @author liqiaofei
 * 2018年9月10日
 */
public class DictionaryDelete {
    private Integer id;

    private String tableName;

    private Integer tableId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }
}