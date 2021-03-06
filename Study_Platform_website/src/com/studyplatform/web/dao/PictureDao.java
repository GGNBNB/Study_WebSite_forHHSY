package com.studyplatform.web.dao;

import java.math.BigDecimal;

import com.studyplatform.web.bean.PictureBean;

/**
 * PictureDao（图片数据处理层接口）
 * Title: PictureDao
 * @date 2018年3月7日
 * @author Freedom0013
 */
public interface PictureDao {
    /**
     * 添加图片
     * @param picture 图片Bean
     * @return 成功标识
     */
    int addPicture(PictureBean picture);
    
    /**
     * 根据id获取图片信息
     * @param picture_id 图片id
     * @return 图片信息
     */
    PictureBean getPictureById(BigDecimal picture_id);
    
    /**
     * 根据图片id获取图片地址
     * @param picture_id 图片id
     * @return 图片地址
     */
    String getPicrureAddressById(BigDecimal picture_id);
    
    /**
     * 更新图片信息
     * @param picture 图片Bean
     * @return 执行成功标识
     */
    int UpdataPicture(PictureBean picture);
    
    /**
     * 删除图片
     * @param picture_id 图片id
     * @return 执行成功标识
     */
    int DeletePicture(BigDecimal picture_id);
}
