package io.choerodon.iam.api.controller.v1;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.iam.api.dto.PasswordPolicyDTO;
import io.choerodon.iam.api.validator.PasswordPolicyValidator;
import io.choerodon.iam.app.service.PasswordPolicyService;
import io.choerodon.swagger.annotation.Permission;

/**
 * @author wuguokai
 */
@RestController
@RequestMapping("/v1/organizations/{organization_id}/password_policies")
public class PasswordPolicyController {

    private PasswordPolicyService passwordPolicyService;
    private PasswordPolicyValidator passwordPolicyValidator;

    public PasswordPolicyController(PasswordPolicyService passwordPolicyService, PasswordPolicyValidator passwordPolicyValidator) {
        this.passwordPolicyService = passwordPolicyService;
        this.passwordPolicyValidator = passwordPolicyValidator;
    }

    /**
     * 查询目标组织密码策略
     *
     * @return 目标组织密码策略
     */
    @Permission(level = ResourceLevel.ORGANIZATION, roles = {"organizationAdmin"})
    @ApiOperation(value = "查询目标组织密码策略")
    @GetMapping
    public ResponseEntity<PasswordPolicyDTO> queryByOrganizationId(@PathVariable("organization_id") Long organizationId) {
        return new ResponseEntity<>(passwordPolicyService.queryByOrgId(organizationId), HttpStatus.OK);
    }

    /**
     * 查询密码策略
     *
     * @return 密码策略
     */

    /**
     * 更新当前选择的组织密码策略
     *
     * @param passwordPolicyDTO 要更新的密码策略
     * @return 更新后的密码策略
     */
    @Permission(level = ResourceLevel.ORGANIZATION, roles = {"organizationAdmin"})
    @ApiOperation(value = "更新密码策略")
    @PostMapping("/{id}")
    public ResponseEntity<PasswordPolicyDTO> update(@PathVariable("organization_id") Long organizationId,
                                                    @PathVariable("id") Long id,
                                                    @RequestBody PasswordPolicyDTO passwordPolicyDTO) {
        passwordPolicyValidator.update(organizationId, id, passwordPolicyDTO);
        return new ResponseEntity<>(passwordPolicyService.update(organizationId, id, passwordPolicyDTO), HttpStatus.OK);
    }


    /**
     * 业务上暂时没有添加密码策略的需求
     *
     * 为目标组织添加密码策略
     *
     * @return 目标组织密码策略
     */
//    @Permission(level = ResourceLevel.ORGANIZATION, roles = {"organizationAdmin"})
//    @ApiOperation(value = "添加密码策略")
//    @PostMapping
//    public ResponseEntity<PasswordPolicyDTO> create(@PathVariable("organization_id") Long organizationId, @RequestBody @Valid PasswordPolicyDTO passwordPolicyDTO) {
//        passwordPolicyValidator.create(organizationId, passwordPolicyDTO);
//        return new ResponseEntity<>(passwordPolicyService.create(organizationId, passwordPolicyDTO), HttpStatus.OK);
//    }
}
