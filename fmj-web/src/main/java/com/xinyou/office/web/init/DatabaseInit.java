package com.xinyou.office.web.init;

import com.definesys.fnd.file.eo.FndFileEO;
import com.definesys.fnd.menu.eo.FndMenuEO;
import com.definesys.fnd.permission.eo.FndPermissionGroupEO;
import com.definesys.fnd.permission.eo.FndPermissionItemEO;
import com.definesys.fnd.rest.eo.FndRestApiEO;
import com.definesys.fnd.role.eo.FndRoleEO;
import com.definesys.fnd.role.eo.FndRoleUserEO;
import com.definesys.fnd.user.eo.FndUserEO;
import com.definesys.mpaas.generator.DBScriptExecutor;
import com.xinyou.office.web.doc.eo.AttachmentEO;
import com.xinyou.office.web.doc.eo.DocEO;
import com.xinyou.office.web.seal.eo.SealEO;
import com.xinyou.office.web.template.eo.TemplateEO;

/**
 * @Description:
 * @author: jianfeng.zheng
 * @since: 2021/10/21 1:20 上午
 * @history: 1.2021/10/21 created by jianfeng.zheng
 */
public class DatabaseInit {

    public static void main(String[] cmd) {
        DBScriptExecutor.build()
                .addEntity(FndUserEO.class)
                .addIndex("user_display_name_idx", "display_name")
                .addEntity(FndRoleEO.class)
                .addIndex("role_name_idx", "role_name")
                .addEntity(FndRoleUserEO.class)
                .addIndex("role_id_idx", "role_id")
                .addIndex("user_id_idx", "user_id")
                .addEntity(FndMenuEO.class)
                .addIndex("menu_name_idx", "node_name")
                .addIndex("menu_path_idx", "path")
                .addEntity(FndPermissionGroupEO.class)
                .addIndex("permission_name_idx", "name")
                .addEntity(FndPermissionItemEO.class)
                .addIndex("permission_item_pid_idx", "permission_id")
                .addEntity(FndRestApiEO.class)
                .addIndex("rest_path_idx", "path")
                .addIndex("rest_name_idx", "name")
                .addEntity(FndFileEO.class)
                .addIndex("file_name_idx", "file_name")
                .addIndex("file_tag_idx", "tag")
                .addIndex("file_uuid_idx", "uuid")
                .addEntity(SealEO.class)
                .addIndex("seal_name", "name")
                .addEntity(TemplateEO.class)
                .addIndex("template_name", "name")
                .addEntity(DocEO.class)
                .addIndex("doc_title", "title")
                .addIndex("doc_no", "doc_no")
                .addEntity(AttachmentEO.class)
                .addIndex("attach_doc_id", "doc_id")
                .addIndex("attach_file_id", "file_id")
                .mysql()
                //.oracle()
                .ignoreError()
                .printSQL()
                .execute();
    }
}
