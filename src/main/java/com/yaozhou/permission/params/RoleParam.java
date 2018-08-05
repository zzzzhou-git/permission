package com.yaozhou.permission.params;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Yao.Zhou
 * @since 2018/8/5 13:06
 */
@Getter
@Setter
@ToString
public class RoleParam {

    private Integer roleId;

    @NotBlank(message = "角色名称不能为空")
    @Length(min = 2, max = 20, message = "角色名称必须在2-20个字之间")
    private String name;

    @NotNull(message = "角色类型不能为空")
    @Min(value = 1, message = "角色类型不合法")
    @Max(value = 2, message = "角色类型不合法")
    private Short type = 1;

    @NotNull(message = "角色状态不能为空")
    @Min(value = 0, message = "角色状态不合法")
    @Max(value = 1, message = "角色状态不合法")
    private Short status;

    @NotNull(message = "seq不能为空")
    private String seq;

    @Length(min = 0, max = 200, message = "备注必须在0-200个字以内")
    private String remark;

}
