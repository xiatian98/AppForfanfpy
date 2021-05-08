package top.fanfpy.app.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author znn
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BaizhuSubjects对象", description="")
public class BaizhuSubjects implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer userId;

    private String desc;

    private LocalDateTime updateDate;

    private LocalDateTime createDate;


}
