package io.choerodon.iam.api.dto.payload;

import java.util.Set;

/**
 * @author flyleft
 * @date 2018/4/9
 */
public class ProjectEventPayload {

    public static final String EVENT_TYPE_CREATE_PROJECT = "createProject";

    public static final String EVENT_TYPE_UPDATE_PROJECT = "updateProject";

    private Long projectId;
    private String projectCode;
    private String projectName;
    private String organizationCode;
    private String organizationName;
    private String userName;
    private Long userId;

    private Set<String> roleLabels;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<String> getRoleLabels() {
        return roleLabels;
    }

    public void setRoleLabels(Set<String> roleLabels) {
        this.roleLabels = roleLabels;
    }
}
