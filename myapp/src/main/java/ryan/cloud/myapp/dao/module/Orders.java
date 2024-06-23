package ryan.cloud.myapp.dao.module;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.id
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.goodId
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    private Integer goodid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.createTime
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.orderNo
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    private String orderno;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.orderStatus
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    private String orderstatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orders.updateTime
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.id
     *
     * @return the value of orders.id
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.id
     *
     * @param id the value for orders.id
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.goodId
     *
     * @return the value of orders.goodId
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public Integer getGoodid() {
        return goodid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.goodId
     *
     * @param goodid the value for orders.goodId
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.createTime
     *
     * @return the value of orders.createTime
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.createTime
     *
     * @param createtime the value for orders.createTime
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.orderNo
     *
     * @return the value of orders.orderNo
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public String getOrderno() {
        return orderno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.orderNo
     *
     * @param orderno the value for orders.orderNo
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.orderStatus
     *
     * @return the value of orders.orderStatus
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public String getOrderstatus() {
        return orderstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.orderStatus
     *
     * @param orderstatus the value for orders.orderStatus
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orders.updateTime
     *
     * @return the value of orders.updateTime
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orders.updateTime
     *
     * @param updatetime the value for orders.updateTime
     *
     * @mbg.generated Sun Jun 23 23:39:43 CST 2024
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}