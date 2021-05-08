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
@ApiModel(value="BaizhuScore对象", description="")
public class BaizhuScore implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer subjectsId;

    private String score;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
