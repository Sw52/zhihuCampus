package edu.njupt.sw.dao;


import edu.njupt.sw.model.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

public class MysqlOperation {

    /**
     * @param name
     * @param password
     * @param salt
     * @param headUrl
     * @throws Exception
     * @see 插入用户信息
     */
    public void insertUser(String name, String password, String salt, String headUrl) throws Exception {
        Connection conn;
        Statement stmt;

        MysqlLink.loadDriver();
        conn = MysqlLink.getConnection();
        stmt = conn.createStatement();
        String sql = "insert into wenda.user (user_name, password, salt, head_url) values (\"" + name + "\",\"" + password + "\",\"" + salt + "\",\"" + headUrl + "\")";
        int i = stmt.executeUpdate(sql);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        MysqlLink.release(stmt, conn);
    }

    /**
     * @param name
     * @param password
     * @param salt
     * @param headUrl
     * @throws Exception
     * @see 插入问题信息
     */
    public void insertQuestion(String title, String content, int user_id, Date created_date, int comment_count) throws Exception {
        Connection conn;
        Statement stmt;

        MysqlLink.loadDriver();
        conn = MysqlLink.getConnection();
        stmt = conn.createStatement();
        String sql = "insert into wenda.question (title, content, user_id, created_date, comment_count) values (\"" + title + "\",\"" + content + "\",\"" + user_id + "\",\"" + created_date + "\",\"" + comment_count + "\")";
        int i = stmt.executeUpdate(sql);
        if (i > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        MysqlLink.release(stmt, conn);
    }

    /**
     * 从数据库中查找前n条问题奥
     * @param userId
     * @param offset
     * @param limit
     * @return
     * @throws Exception
     */
    public List<Question> selectLatestQuestions(int userId, int offset, int limit) throws Exception {


        List<Question> questionList = null;
        Question question = new Question();
        Connection conn;
        Statement stmt;
        ResultSet rs;

        MysqlLink.loadDriver();
        conn = MysqlLink.getConnection();
        String sql = "select from quesion where user_id=userId and between offset and offset+limit";
        stmt = conn.createStatement();
        int i = stmt.executeUpdate(sql);

        return questionList;

    }
}
