package script.db

databaseChangeLog(logicalFilePath: 'script/db/oauth_login_history.groovy') {
    changeSet(author: 'guokai.wu.work@gmail.com', id: '2018-04-11-oauth-login-history') {
        createTable(tableName: "oauth_login_history") {
            column(name: 'id', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1') {
                constraints(primaryKey: true)
            }
            column(name: 'user_id', type: 'BIGINT UNSIGNED', remarks: '用户id') {
                constraints(nullable: false, unique: true)
            }

            column(name: 'last_login_at', type: 'DATETIME', remarks: '用户最后一次登录的时间') {
                constraints(nullable: false)
            }

            column(name: "object_version_number", type: "BIGINT UNSIGNED", defaultValue: "1") {
                constraints(nullable: true)
            }
            column(name: "created_by", type: "BIGINT UNSIGNED", defaultValue: "0") {
                constraints(nullable: true)
            }
            column(name: "creation_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "last_updated_by", type: "BIGINT UNSIGNED", defaultValue: "0") {
                constraints(nullable: true)
            }
            column(name: "last_update_date", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
}