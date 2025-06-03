package dbataev.model;

import java.util.Date;

public class Expense {
    private int id;
    private String title;
    private double amount;
    private Date date;
    private int user_id;
    private int category_id;

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public double getAmount() {
        return amount;
    }
    public Date getDate() {
        return date;
    }
    public int getUser_id() {
        return user_id;
    }
    public int getCategory_id() {
        return category_id;
    }
}
