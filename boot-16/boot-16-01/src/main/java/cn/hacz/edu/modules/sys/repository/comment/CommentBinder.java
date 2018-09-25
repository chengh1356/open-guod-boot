package cn.hacz.edu.modules.sys.repository.comment;


import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XProperty;
import org.hibernate.cfg.Ejb3Column;
import org.hibernate.mapping.PersistentClass;

public class CommentBinder {

    public static void bindTableComment(XClass clazzToProcess, PersistentClass persistentClass) {
        // System.out.println("处理表名注释！");
        if (clazzToProcess.isAnnotationPresent(Comment.class)) {
            String tableComment = clazzToProcess.getAnnotation(Comment.class).value();
            persistentClass.getTable().setComment(tableComment);

        }
    }

    public static void bindColumnComment(XProperty property, Ejb3Column[] columns) {
        // System.out.println("处理字段注释"+property+columns);
        if (null != columns)
            if (property.isAnnotationPresent(Comment.class)) {
                String comment = property.getAnnotation(Comment.class).value();
                for (Ejb3Column column : columns) {
                    column.getMappingColumn().setComment(comment);
                }

            }
    }

}